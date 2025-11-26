package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.dto.AttachmentDTO;
import com.rays.dto.RoleDTO;
import com.rays.dto.UserDTO;
import com.rays.service.AttachmentService;

@Repository
public class UserDAOImpl implements UserDAOInt {

	@PersistenceContext
	public EntityManager entityManager;

	@Autowired
	public RoleDAOInt roleDao;

	@Autowired
	public AttachmentService attachService;

	public void populateDTO(UserDTO dto) {
		RoleDTO roleDTO = roleDao.findByPk(dto.getRoleId());
		dto.setRoleName(roleDTO.getName());
	}

	@Override
	public long add(UserDTO dto) {
		populateDTO(dto);
		entityManager.persist(dto); // add
		return dto.getId();
	}

	@Override
	public void update(UserDTO dto) {
		populateDTO(dto); // update
		entityManager.merge(dto);
	}

	@Override
	public void delete(UserDTO dto) {

		AttachmentDTO attachDto = attachService.findByPk(dto.getImageId());

		if (attachDto != null) {
			attachService.delete(attachDto.getId());
		}

		entityManager.remove(dto); // delete
	}

	@Override
	public UserDTO findByPk(long pk) {
		return entityManager.find(UserDTO.class, pk);
	}

	public List<UserDTO> search(UserDTO dto, int pageNo, int pageSize) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<UserDTO> cq = builder.createQuery(UserDTO.class);

		Root<UserDTO> qRoot = cq.from(UserDTO.class);

		List<Predicate> predicateList = new ArrayList<Predicate>();

		if (dto != null) {

			if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
				predicateList.add(builder.like(qRoot.get("firstName"), dto.getFirstName() + "%"));
			}

			if (dto.getRoleId() != null && dto.getRoleId() > 0) {
				predicateList.add(builder.equal(qRoot.get("roleId"), dto.getRoleId()));
			}

			if (dto.getDob() != null && dto.getDob().getTime() > 0) {
				predicateList.add(builder.equal(qRoot.get("dob"), dto.getDob()));
			}

		}

		cq.where(predicateList.toArray(new Predicate[predicateList.size()]));

		System.out.println("cq--------> : " + cq.toString());

		TypedQuery<UserDTO> tq = entityManager.createQuery(cq);

		if (pageSize > 0) {
			tq.setFirstResult(pageNo * pageSize);
			tq.setMaxResults(pageSize);
		}

		List<UserDTO> list = tq.getResultList();

		return list;
	}

	public UserDTO findByUniqueKey(String attribute, String value) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<UserDTO> cq = builder.createQuery(UserDTO.class);

		Root<UserDTO> qRoot = cq.from(UserDTO.class);

		Predicate condition = builder.equal(qRoot.get(attribute), value);

		cq.where(condition);

		TypedQuery<UserDTO> tq = entityManager.createQuery(cq);

		List<UserDTO> list = tq.getResultList();

		UserDTO dto = null;

		if (list.size() > 0) {

			dto = list.get(0);

		}

		return dto;
	}

}
