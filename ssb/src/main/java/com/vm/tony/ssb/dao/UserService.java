package com.vm.tony.ssb.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="user_service")
public class UserService {

	private int userServiceId;
	private int userId;
	private int serviceId;
	
	@Id
	@Column(name="user_service_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getUserServiceId() {
		return userServiceId;
	}
	public void setUserServiceId(int userServiceId) {
		this.userServiceId = userServiceId;
	}
	@Column(name="user_id")
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Column(name="service_id")
	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	
	
}
