package com.mailService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mailService.bean.Employee;
import org.springframework.cloud.client.discovery.DiscoveryClient;

@RestController
public class MailServiceController {
	
	 @Autowired
	  private DiscoveryClient discoveryClient;
	
//	@PostMapping(value="/sendMail")
	@RequestMapping(value = "/sendMail", method = RequestMethod.POST)
	public String sendMail(@RequestBody Employee emp){
		System.out.println("Send Mail......"+emp.getName());
		return null;
	}
	
//	@PostMapping(value="/sendMail")
	@RequestMapping(value = "/sendMail1", method = RequestMethod.POST)
	public String sendMail1(){
		System.out.println("Send Mail......");
		return null;
	}
	
	@RequestMapping("/service-instances/{applicationName}")
	  public List<ServiceInstance> serviceInstancesByApplicationName(
	      @PathVariable String applicationName) {
	    return this.discoveryClient.getInstances(applicationName);
	  }
}
