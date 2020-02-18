package com.empmanagment.bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="certificate")
public class CertificateBean {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer certificateId;
	private String certificateName;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="EMPLOYER_ID")
	private EmployeeBean employeeBean;
	public Integer getCertificateId() {
		return certificateId;
	}
	public void setCertificateId(Integer certificateId) {
		this.certificateId = certificateId;
	}
	public String getCertificateName() {
		return certificateName;
	}
	public void setCertificateName(String certificateName) {
		this.certificateName = certificateName;
	}
	public CertificateBean(){
		
	}
	public CertificateBean(Integer certificateId, String certificateName, EmployeeBean employeeBean) {
		super();
		this.certificateId = certificateId;
		this.certificateName = certificateName;
		this.employeeBean = employeeBean;
	}
	@Override
	public String toString() {
		return "CertificateBean [certificateId=" + certificateId + ", certificateName=" + certificateName
				+ ", employeeBean=" + employeeBean + "]";
	}
	
	 
	
}
