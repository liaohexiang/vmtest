package com.vm.tony.ssb.dao;

import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vm.tony.ssb.dao.ServiceDao;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/vm/tony/ssb/dao/context.xml")
public class ServiceDaoTest {

	@Autowired
	ServiceDao tested;
	@Test
	public void test() {
		List list = tested.getAll();	
		System.out.println(list.size());
	}
}
