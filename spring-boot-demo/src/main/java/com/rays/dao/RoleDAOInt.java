package com.rays.dao;

import com.rays.dto.RoleDTO;

public interface RoleDAOInt {
	
	public long add(RoleDTO dto);
	
	public void update(RoleDTO dto);
	
	public void delete(RoleDTO dto);
	
	public RoleDTO findByPk(long pk);

}
