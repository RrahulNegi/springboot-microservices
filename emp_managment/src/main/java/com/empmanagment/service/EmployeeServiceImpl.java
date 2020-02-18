package com.empmanagment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import com.empmanagment.bean.CertificateBean;
import com.empmanagment.bean.EmployeeBean;
import com.empmanagment.dao.EmployeeDao;

import net.sf.ehcache.CacheManager;
@Service("EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeDao employeeDao;
	
	@Override
	public boolean addEmployee(EmployeeBean empBean) {
		EmployeeBean empBeanVal= new EmployeeBean();
		empBeanVal.setName(empBean.getName());
		empBeanVal.setSalary(empBean.getSalary());
		List<CertificateBean> list=new ArrayList<CertificateBean>();
		//CertificateBean bean=new CertificateBean();
		empBean.getCertificateList().stream().forEach(x->{
			CertificateBean bean=new CertificateBean();
			bean.setCertificateName(x.getCertificateName());
			list.add(bean);
		});
		empBeanVal.setCertificateList(list);
		
		System.out.println("final===??"+empBeanVal);
		
		EmployeeBean savedEmp=employeeDao.addEmployee(empBeanVal);
		if(savedEmp!=null)
		return true;
		else{
			return false;
		}
	}

	@Override
	public List<EmployeeBean> getEmployee() {
		/*int size = CacheManager.ALL_CACHE_MANAGERS.get(0)
				  .getCache("com.empmanagment.bean.EmployeeBean").getSize();
		System.out.println("Size=="+size);*/
		return employeeDao.getAllEmployee();
	}

	@Override
	public EmployeeBean getEmployeeByName(String name) {
		
		return employeeDao.getEmployeeByName(name);
	}

}
