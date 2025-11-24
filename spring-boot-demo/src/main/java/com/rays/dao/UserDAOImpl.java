package com.rays.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.dto.RoleDTO;
import com.rays.dto.UserDTO;

@Repository
public class UserDAOImpl implements UserDAOInt {

	@PersistenceContext
	public EntityManager entityManager;

	@Autowired
	public RoleDAOInt roleDao;

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
		populateDTO(dto);
		entityManager.merge(dto);
	}

	@Override
	public void delete(UserDTO dto) {
		entityManager.remove(dto);
	}

	@Override
	public UserDTO findByPk(long pk) {
		return entityManager.find(UserDTO.class, pk);
	}

}
