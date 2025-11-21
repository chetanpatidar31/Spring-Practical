package com.rays.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.rays.dto.RoleDTO;

@Repository
public class RoleDAOImpl implements RoleDAOInt {

	@PersistenceContext
	public EntityManager entityManager;

	@Override
	public long add(RoleDTO dto) {
		entityManager.persist(dto);		//add
		return dto.getId();
	}

	@Override
	public void update(RoleDTO dto) {
		entityManager.merge(dto);		//update

	}

	@Override
	public void delete(RoleDTO dto) {
		entityManager.remove(dto);		//delete

	}

	@Override
	public RoleDTO findByPk(long pk) {
		return entityManager.find(RoleDTO.class, pk);	//get
	}

}
