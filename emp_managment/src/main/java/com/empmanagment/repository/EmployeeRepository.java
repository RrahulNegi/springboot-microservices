package com.empmanagment.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.empmanagment.bean.EmployeeBean;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeBean, Integer> {
Optional<EmployeeBean> getEmployeeBeanByName(String name);
}
