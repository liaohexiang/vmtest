package com.vm.tony.ssb.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class ServiceDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public List getAll(){
		Query query  =this.entityManager.createQuery("select c from Service c");
		return query.getResultList();
	}
}
