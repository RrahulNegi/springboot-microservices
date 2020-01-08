package com.empmanagment.service;

import org.springframework.stereotype.Service;

import com.empmanagment.bean.EmployeeBean;
public interface EmployeeService {

	public boolean addEmployee(EmployeeBean empBean);
}
