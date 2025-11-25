package com.rays.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

}
