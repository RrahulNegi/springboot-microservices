package com.empmanagment.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.empmanagment.bean.EmployeeBean;
import com.empmanagment.repository.EmployeeRepository;
public interface EmployeeDao {

	
	public EmployeeBean addEmployee(EmployeeBean empBean);

	public List<EmployeeBean> getAllEmployee();

	public EmployeeBean getEmployeeByName(String name);
	
}
