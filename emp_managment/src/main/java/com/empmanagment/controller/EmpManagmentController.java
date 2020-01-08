package com.empmanagment.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import com.empmanagment.bean.EmployeeBean;
import com.empmanagment.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
//Swagger api
@Api(value="Language API", description="Operations pertaining to Employee")
public class EmpManagmentController {
	
	@Autowired
	EmployeeService employeeService;
	
	  @Autowired
	    private RestTemplate restTemplate;
	    @Autowired
	    private EurekaClient eurekaClient;
	    @Value("${service.mailService.serviceId}")
	    private String employeeSearchServiceId;
	    
	    
//	@PostMapping(value="/addEmployee")
	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	
	//Swagger ApiResponse
	  @ApiOperation(value = "Add Employee", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully Add Employee"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
	public String addEmployee(@RequestBody EmployeeBean empBean){
		System.out.println("IN POST");
		 Application application = eurekaClient.getApplication(employeeSearchServiceId);
	        InstanceInfo instanceInfo = application.getInstances().get(0);
	        String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" + "sendMail";
	        System.out.println("URL" + url);
		if(employeeService.addEmployee(empBean)){
			RestTemplate restTemplate = new RestTemplate();
			/*String resourceUrl
			  = "http://MailService/sendMail";*/
			HttpHeaders headers = new HttpHeaders();
		      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		      HttpEntity<EmployeeBean> entity = new HttpEntity<EmployeeBean>(empBean,headers);
		      
		       restTemplate.exchange(
		    		   url, HttpMethod.POST, entity, String.class).getBody();
		       return "success";
		   

			
		}else{
		return "fail";	
		}
		
	}
	RequestCallback requestCallback(final EmployeeBean empBean) {
	    return clientHttpRequest -> {
	        ObjectMapper mapper = new ObjectMapper();
	        mapper.writeValue(clientHttpRequest.getBody(), empBean);
	        clientHttpRequest.getHeaders().add(
	          HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
	       /* clientHttpRequest.getHeaders().add(
	          HttpHeaders.AUTHORIZATION, "Basic " + getBase64EncodedLogPass());*/
	    };
	}
	@RequestMapping(value = "/getEmployee", method = RequestMethod.GET)
	public String getEmployee(){
		System.out.println("IN GET");
		return "suceess";
	}
}
