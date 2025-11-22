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
		entityManager.persist(dto); // add
		return dto.getId();
	}

	@Override
	public void update(RoleDTO dto) {
		entityManager.merge(dto); // update

	}

	@Override
	public void delete(long id) {
		RoleDTO managed = entityManager.find(RoleDTO.class, id);
		if (managed != null) {
			entityManager.remove(managed);
		}

		/*
		 * #Alternate way
		 * RoleDTO merged = entityManager.merge(dto);
		 * entityManager.remove(merged);
		 */
	}

	@Override
	public RoleDTO findByPk(long pk) {
		return entityManager.find(RoleDTO.class, pk); // get
	}

}
