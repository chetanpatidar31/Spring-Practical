package com.rays.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.dao.RoleDAOInt;
import com.rays.dto.RoleDTO;

@Service
@Transactional
public class RoleService {

	@Autowired
	public RoleDAOInt roleDao;

	@Transactional(propagation = Propagation.REQUIRED)
	public long add(RoleDTO dto) {
		return roleDao.add(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void update(RoleDTO dto) {
		roleDao.update(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(long id) {
		RoleDTO dto = findByPk(id);
		roleDao.delete(dto);
	}

	@Transactional(readOnly = true)
	public RoleDTO findByPk(long pk) {
		return roleDao.findByPk(pk);
	}

	@Transactional(readOnly = true)
	public List<RoleDTO> search(RoleDTO dto, int pageNo, int pageSize) {
		return roleDao.search(dto, pageNo, pageSize);
	}
}
