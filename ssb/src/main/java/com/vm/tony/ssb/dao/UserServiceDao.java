package com.vm.tony.ssb.dao;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

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
