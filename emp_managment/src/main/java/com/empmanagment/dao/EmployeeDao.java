package com.empmanagment.dao;

import org.springframework.stereotype.Component;

import com.empmanagment.bean.EmployeeBean;
import com.empmanagment.repository.EmployeeRepository;
public interface EmployeeDao {

	
	public EmployeeBean addEmployee(EmployeeBean empBean);
	
}
