package com.empmanagment.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * @author rnegi
 *
 */
@Entity(name="employee")
//@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class EmployeeBean {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "EMPLOYER_ID")
	private Integer id;
	private String name;
	private Integer salary;
	private Integer department;
	@OneToMany(mappedBy="employeeBean", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<CertificateBean> certificateList;
	public EmployeeBean(){
		
	}
	public EmployeeBean(Integer id, String name, Integer salary, Integer department,
			List<CertificateBean> certificateList) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.department = department;
		this.certificateList = certificateList;
	}
	public List<CertificateBean> getCertificateList() {
		return certificateList;
	}
	public void setCertificateList(List<CertificateBean> certificateList) {
		this.certificateList = certificateList;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public Integer getDepartment() {
		return department;
	}
	public void setDepartment(Integer department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "EmployeeBean [id=" + id + ", name=" + name + ", salary=" + salary + ", department=" + department
				+ ", certificateList=" + certificateList + "]";
	}
 } 