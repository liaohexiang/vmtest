package com.vm.tony.ssb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;


@Repository
public class UserDao {

	@PersistenceContext
	private EntityManager entityManager;

	public User getUser(int userId){
		return this.entityManager.find(User.class, userId);
	}
	
	public List getAll(){
		Query query = this.entityManager.createQuery("select c from User c");
		return query.getResultList();
	}
	public void createSubscription(String userName){
		User user  = new User();
		user.setUserName(userName);
		this.entityManager.persist(user);
	}
}
