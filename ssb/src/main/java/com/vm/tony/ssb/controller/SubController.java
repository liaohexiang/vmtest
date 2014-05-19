package com.vm.tony.ssb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.vm.tony.ssb.dao.Service;
import com.vm.tony.ssb.dao.ServiceDao;
import com.vm.tony.ssb.dao.User;
import com.vm.tony.ssb.dao.UserDao;
import com.vm.tony.ssb.dao.UserService;
import com.vm.tony.ssb.dao.UserServiceDao;
 
@Controller
public class SubController {
 
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private ServiceDao serviceDao;
	@Autowired
	private UserServiceDao userServiceDao;
	
	@RequestMapping("/")
	public String home(Model model){
		
		List users = this.userDao.getAll();
		model.addAttribute("Users", users);
		return "Home";
	}
	@RequestMapping("/{userId}")
	public String getUserSubscription(@PathVariable("userId") int userId,Model model){
		
		User user = this.userDao.getUser(userId);
		model.addAttribute("Services", user.getServices());
		return "UserSubscription";
		
	}
	@RequestMapping(method={RequestMethod.GET},value="/available/{userId}")
	public String getNonSubscribedServices(@PathVariable("userId") int userId,Model model){
		User user = this.userDao.getUser(userId);
		List<Service> services = (List<Service>)this.serviceDao.getAll();
		List<Service> userServices = user.getServices();
		List<Service> unsubscribedServices = new ArrayList<Service>();
		for(Service servcie : services){
			if(userServices.contains(servcie))
				continue;
			else
				unsubscribedServices.add(servcie);
		}
		model.addAttribute("Services", unsubscribedServices);
		return "Subscribe";
	}
	@RequestMapping(method={RequestMethod.POST},value="/subscribe/{userId}")
	public void subscribe(@PathVariable("userId") int userId,@RequestParam("Services") String services, Model model){
		
		String service = services;
		String[] ss =  service.split("-");
		for(String s : ss){
			UserService userService = new UserService();
			userService.setUserId(userId);
			userService.setServiceId(Integer.valueOf(s));
			this.userServiceDao.createSubscription(userService);
		}
		
	}
	@RequestMapping(method={RequestMethod.POST},value="/unsubscribe/{userId}")
	public void unSubscribe(@PathVariable("userId") int userId,@RequestParam("ServiceId") int serviceId, Model model){
		
		this.userServiceDao.unSubscribe(userId,serviceId);
	}
 
}