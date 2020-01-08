package com.eurekaservice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EmployeeEurekaServerApplication {

    public static void main(String[] args) {
    	System.out.println("In Eurekaaa.......");
    	Map<String, String> map=new HashMap<>();
    	map.put("key", "value");
    	
    	System.out.println("value-=="+map.put("key", "value a"));
    	//map.put("key", "value a");
    	map.put(null, "value");
    	map.put(null, "value a");
    	System.out.println(map.get(null));
        SpringApplication.run(EmployeeEurekaServerApplication.class, args);
    }
    
    
}
