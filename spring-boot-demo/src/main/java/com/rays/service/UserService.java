package com.rays.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.dao.UserDAOInt;
import com.rays.dto.UserDTO;

@Service
@Transactional
public class UserService {

	@Autowired
	public UserDAOInt userDao;

	@Transactional(propagation = Propagation.REQUIRED)
	public long add(UserDTO dto) {
		return userDao.add(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void update(UserDTO dto) {
		userDao.update(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(long id) {
		UserDTO dto = findByPk(id);
		userDao.delete(dto);
	}

	@Transactional(readOnly = true)
	public UserDTO findByPk(long pk) {
		return userDao.findByPk(pk);
	}

}
