package com.vm.tony.servicesubscription.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vm.tony.servicesubscription.dao.User;

@Controller
public class SubscriptionController {
	
	@RequestMapping("/subscription")
	public ModelAndView getMain(){
		ModelAndView modelView = new ModelAndView();
	/*	List<User> users = new ArrayList<User>();
		User user1 = new User();
		user1.setUserId(1234);
		user1.setUserName("Tony");
		User user2 = new User();
		user2.setUserId(456);
		user2.setUserName("Liao");
		users.add(user1);
		users.add(user2);
		modelView.addObject("Users", users);*/
		/*User user = new User();
		user.setUserId(456);
		user.setUserName("Liao");*/
		/*modelView.addObject("user", user2);
		modelView.setViewName("Main");*/
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user", "Tony");
		return new ModelAndView("Main", map);
		//return modelView;
	}
	@RequestMapping("/subscription/{userId}")
	public ModelAndView getUserSubscription(@PathVariable("userId") int userId){
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("UserSubscription");
		return modelView;
		
	}
}
