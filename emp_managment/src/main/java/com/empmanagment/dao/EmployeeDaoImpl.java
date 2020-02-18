package com.empmanagment.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.empmanagment.bean.EmployeeBean;
import com.empmanagment.exception.RecordNotFoundException;
import com.empmanagment.repository.EmployeeRepository;
@Component

public class EmployeeDaoImpl implements EmployeeDao{
	@Autowired
	EmployeeRepository employeeRepositor;

	@Override
	public EmployeeBean addEmployee(EmployeeBean empBean) {
			System.out.println("======"+empBean.getName());
			System.out.println("EmployeeData ==>> "+empBean);
		
		EmployeeBean savedBean= employeeRepositor.save(empBean);
		return savedBean;
		
	}

	@Override
	 @Cacheable("employee")
	public List<EmployeeBean> getAllEmployee() {
		
		return (List<EmployeeBean>) employeeRepositor.findAll();
		
	}
	@Override
	 @Cacheable("employeeName")
	public EmployeeBean getEmployeeByName(String name){
		return employeeRepositor.getEmployeeBeanByName(name).orElseThrow(() -> new RecordNotFoundException("Employee name '" + name + "' does no exist"));
	}
	

}
