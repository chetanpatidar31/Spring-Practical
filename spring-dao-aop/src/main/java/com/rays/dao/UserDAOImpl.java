package com.rays.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.dto.UserDTO;

@Repository
public class UserDAOImpl implements UserDAOInt {

	@Autowired
	private SessionFactory sessionFactory;

	public long add(UserDTO dto) {
		return (Long) sessionFactory.getCurrentSession().save(dto);
	}

	public void update(UserDTO dto) {
		sessionFactory.getCurrentSession().update(dto);
	}

	public void delete(UserDTO dto) {
		sessionFactory.getCurrentSession().delete(dto);

	}

	public UserDTO findByPk(long pk) {
		return sessionFactory.getCurrentSession().get(UserDTO.class, pk);

	}

	public UserDTO findByLogin(String login) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserDTO.class);
		return (UserDTO) criteria.add(Restrictions.eq("login", login));
	}

	public UserDTO authenticate(String login, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	public List search() {
		// TODO Auto-generated method stub
		return null;
	}

	public List search(UserDTO dto, int pageno, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

}
