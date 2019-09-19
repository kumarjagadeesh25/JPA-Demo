package com.zonray;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the EMPLOYEE database table.
 * 
 */
@Entity
@Table(name="EMPLOYEE")
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EMPLOYEE_ENO_GENERATOR", sequenceName="EMPLOYEE_ENO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EMPLOYEE_ENO_GENERATOR")
	@Column(unique=true, nullable=false, precision=19)
	private Long eno;

	@Column(length=255)
	private String ename;

	@Column(length=255)
	private Double salary;

	public Employee() {
	}

	public Long getEno() {
		return this.eno;
	}

	public void setEno(Long eno) {
		this.eno = eno;
	}

	public String getEname() {
		return this.ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Double getSalary() {
		return this.salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

}