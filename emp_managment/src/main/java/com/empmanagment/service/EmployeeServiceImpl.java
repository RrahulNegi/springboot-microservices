package com.empmanagment.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import com.empmanagment.bean.EmployeeBean;
import com.empmanagment.dao.EmployeeDao;
@Service("EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeDao employeeDao;
	
	@Override
	public boolean addEmployee(EmployeeBean empBean) {
		EmployeeBean savedEmp=employeeDao.addEmployee(empBean);
		if(savedEmp!=null)
		return true;
		else{
			return false;
		}
	}

}
