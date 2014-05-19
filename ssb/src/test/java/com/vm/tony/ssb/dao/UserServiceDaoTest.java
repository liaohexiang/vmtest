package com.vm.tony.ssb.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/vm/tony/ssb/dao/context.xml")
public class UserServiceDaoTest {

	@Autowired
	UserServiceDao tested;
	@Test
	public void test() {
		UserService us = new UserService();
		us.setUserId(10002);
		us.setServiceId(1002);
		tested.createSubscription(us);
	}

}
