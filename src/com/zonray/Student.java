package com.zonray;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the STUDENT database table.
 * 
 */
@Entity
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="STUDENT_SNO_GENERATOR", sequenceName="STUDENT_SNO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="STUDENT_SNO_GENERATOR")
	private Long sno;

	private BigDecimal smarks;

	private String sname;

	public Student() {
		super();
	}

	public Long getSno() {
		return this.sno;
	}

	public void setSno(Long sno) {
		this.sno = sno;
	}

	public BigDecimal getSmarks() {
		return this.smarks;
	}

	public void setSmarks(BigDecimal smarks) {
		this.smarks = smarks;
	}

	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

}