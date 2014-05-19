package com.vm.tony.ssb.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="service")
public class Service {

	
	private int serviceId;
	
	
	private String serviceName;
	
	
	private String description;
	
	@Id
	@Column(name="service_id")
	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	@Column(name="service_name")
	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	@Column(name="service_desc")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean equals(Object obj) {
		if(obj.getClass() == this.getClass()){
			return ((Service)obj).getServiceId() == this.getServiceId();
		}else
			return false;
	}
}
