package com.rays.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.dao.UserDAOInt;
import com.rays.dto.UserDTO;

@Service
public class UserServiceHibImpl implements UserServiceInt {

	@Autowired
	private UserDAOInt userDAO;

	@Transactional(propagation = Propagation.REQUIRED)
	public long add(UserDTO dto) {
		return userDAO.add(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void update(UserDTO dto) {
		userDAO.update(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(UserDTO dto) {
		userDAO.delete(dto);
	}

	@Transactional(readOnly = true)
	public UserDTO findByPk(long id) {
		return userDAO.findByPk(id);
	}

	@Transactional(readOnly = true)
	public UserDTO findByLogin(String login) {
		return userDAO.findByLogin(login);
	}

	@Transactional(readOnly = true)
	public UserDTO authenticate(String login, String password) {
		return userDAO.authenticate(login, password);
	}

}
