package com.rays.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.dto.UserDTO;

@Repository
public class UserDAOHibImpl implements UserDAOInt {

	@Autowired
	private SessionFactory sessionFactory = null;

	public long add(UserDTO dto) {
		Session session = sessionFactory.getCurrentSession();
		long pk = (Long) session.save(dto);
		return pk;
	}

	public void update(UserDTO dto) {
		Session session = sessionFactory.getCurrentSession();
		session.update(dto);
	}

	public void delete(UserDTO dto) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(dto);	
	}

	public UserDTO findByPk(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserDTO findByLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserDTO authenticate(String login, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
