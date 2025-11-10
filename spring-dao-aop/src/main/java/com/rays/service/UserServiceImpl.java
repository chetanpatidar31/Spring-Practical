package com.rays.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rays.dao.UserDAOInt;
import com.rays.dto.UserDTO;

@Service
public class UserServiceImpl implements UserServiceInt {

	@Autowired
	private UserDAOInt dao;

	public long add(UserDTO dto) {
		return dao.add(dto);
	}

	public void update(UserDTO dto) {
		dao.update(dto);

	}

	public void delete(UserDTO dto) {
		dao.delete(dto);

	}

	public UserDTO findByPk(long pk) {
		return dao.findByPk(pk);
	}

	public UserDTO findByLogin(String login) {
		return dao.findByLogin(login);
	}

	public UserDTO authenticate(String login, String password) {
		return dao.authenticate(login, password);
	}

	public List search() {
		
		return dao.search();
	}

	public List search(UserDTO dto, int pageno, int pageSize) {
		return dao.search(dto, pageno, pageSize);
	}

}
