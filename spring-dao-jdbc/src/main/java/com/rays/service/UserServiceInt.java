package com.rays.service;

import java.util.List;

import com.rays.dto.UserDTO;

public interface UserServiceInt {

	public long add(UserDTO dto) throws Exception;
	
	public void update(UserDTO dto);
	
	public void delete(long id);
	
	public UserDTO findByLogin(String login);

	public UserDTO authenticate(String login, String password);
	
	public List<UserDTO> search(UserDTO dto);

}
