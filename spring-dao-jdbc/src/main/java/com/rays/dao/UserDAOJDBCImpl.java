package com.rays.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.rays.dto.UserDTO;

@Repository
public class UserDAOJDBCImpl implements UserDAOInt {

	private JdbcTemplate jdbcTemplate;

	private DataSource dataSource = null;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public long add(UserDTO dto) {

		String sql = "insert into st_user values(?,?,?,?,?)";

		int pk = jdbcTemplate.update(sql, dto.getId(), dto.getFirstName(), dto.getLastName(), dto.getLogin(),
				dto.getPassword());
		return pk;
	}

	public void update(UserDTO dto) {

		String sql = "update st_user set firstName=?,lastName=?,login=?,password=? where id =?";

		jdbcTemplate.update(sql, dto.getFirstName(), dto.getLastName(), dto.getLogin(), dto.getPassword(), dto.getId());
	}

	public void delete(long id) {
		String sql = "delete from st_user where id =?";

		jdbcTemplate.update(sql, id);

	}

	public UserDTO findByLogin(String login) {
		try {
			String sql = "select * from st_user where login = ?";

			Object[] params = { login };

			UserDTO user = jdbcTemplate.queryForObject(sql, params, new UserMapper());
			return user;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public UserDTO authenticate(String login, String password) {

		try {
			String sql = "select * from st_user where login=? and password=?";

			Object[] params = { login, password };
			return jdbcTemplate.queryForObject(sql, params, new UserMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public List<UserDTO> search(UserDTO dto) {

		StringBuffer sql = new StringBuffer("select * from st_user where 1=1");

//		String sql ="select * from st_user"; 

		if (dto != null) {
			if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
				sql.append(" and firstName like '" + dto.getFirstName() + "%'");
			}
			
			if (dto.getLastName() != null && dto.getLastName().length() > 0) {
				sql.append(" and lastName like '" + dto.getLastName() + "%'");
			}
			
			if (dto.getLogin() != null && dto.getLogin().length() > 0) {
				sql.append(" and login like '" + dto.getLogin() + "%'");
			}
		}
		List list = jdbcTemplate.query(sql.toString(), new UserMapper());
		return list;

	}

}
