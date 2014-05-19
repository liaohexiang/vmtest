package com.vm.tony.ssb.dao;

import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;

public class UserServiceDao {

	private JdbcTemplate jdbcTemplate;

	public UserServiceDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void createSubscription(UserService userService) {

		this.jdbcTemplate.update(
				"insert into user_service(user_id,service_id)values(?,?)",
				userService.getUserId(), userService.getServiceId());
	}

	public void unSubscribe(int userId,int userServiceId) {

		this.jdbcTemplate.update(
				"delete from user_service where user_id=? and service_id=?",
				userId, userServiceId);
	}
}
