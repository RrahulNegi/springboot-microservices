package com.empmanagment.service;

import java.util.List;

import com.empmanagment.bean.EmployeeBean;
public interface EmployeeService {

	public boolean addEmployee(EmployeeBean empBean);
	
	public List<EmployeeBean>getEmployee();

	public EmployeeBean getEmployeeByName(String name);
}
