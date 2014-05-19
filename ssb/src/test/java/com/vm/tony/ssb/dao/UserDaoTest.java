package com.vm.tony.ssb.dao;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vm.tony.ssb.dao.Service;
import com.vm.tony.ssb.dao.User;
import com.vm.tony.ssb.dao.UserDao;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/vm/tony/ssb/dao/context.xml")
public class UserDaoTest {

	@Autowired
	UserDao tested;
	@Test
	public void testGetUser() {
		User user = tested.getUser(10001);
		System.out.println(user.getUserId());
		List<Service> services = user.getServices();
		System.out.println(services.size());
	}
	
	@Test
	public void testGetAll(){
		List list = tested.getAll();
		System.out.println(list.size());
	}
	@Test
	public void testAddUser()
	{
		tested.createSubscription("luck");
	}

}
