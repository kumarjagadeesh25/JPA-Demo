package com.zonray;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the STUDENT database table.
 * 
 */
@Entity
@Table(name="STUDENT")
@NamedQuery(name="StudentISequence.findAll", query="SELECT s FROM StudentISequence s")
public class StudentISequence implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="STUDENT_SNO_GENERATOR", sequenceName="STUDENT_SNO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="STUDENT_SNO_GENERATOR")
	private long sno;

	private BigDecimal smarks;

	private String sname;

	public StudentISequence() {
	}

	public long getSno() {
		return this.sno;
	}

	public void setSno(long sno) {
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