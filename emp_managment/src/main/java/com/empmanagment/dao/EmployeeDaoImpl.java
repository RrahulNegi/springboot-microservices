package com.empmanagment.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.empmanagment.bean.EmployeeBean;
import com.empmanagment.repository.EmployeeRepository;
@Component

public class EmployeeDaoImpl implements EmployeeDao{
	@Autowired
	EmployeeRepository employeeRepositor;

	@Override
	public EmployeeBean addEmployee(EmployeeBean empBean) {
			System.out.println("======"+empBean.getName());
		EmployeeBean savedBean= employeeRepositor.save(empBean);
		return savedBean;
		
	}

}
