package com.rays.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
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
		UserDTO dto = null;
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(UserDTO.class);
		criteria.add(Restrictions.eq("login", login));
		List list = criteria.list();
		if (list.size() == 1) {
			dto = (UserDTO) list.get(0);
		}
		return dto;
	}

	public UserDTO authenticate(String login, String password) {
		UserDTO dto = null;
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(UserDTO.class);
		criteria.add(Restrictions.eq("login", login));
		criteria.add(Restrictions.eq("password", password));
		List list = criteria.list();
		if (list.size() == 1) {
			dto = (UserDTO) list.get(0);
		}
		return dto;
	}

	public List search(UserDTO dto, int pageNo, int pageSize) {

		List list = null;

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(UserDTO.class);

		if (dto != null) {
			if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
				criteria.add(Restrictions.ilike("firstName", dto.getFirstName()));
			}
			if (dto.getLastName() != null && dto.getLastName().length() > 0) {
				criteria.add(Restrictions.ilike("lastName", dto.getLastName()));
			}
			if (dto.getLogin() != null && dto.getLogin().length() > 0) {
				criteria.add(Restrictions.ilike("login", dto.getLogin()));
			}

		}

		list = criteria.list();

		return list;
	}

	public List search() {
		return search(null, 0, 0);
	}

}
