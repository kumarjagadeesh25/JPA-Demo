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
@NamedQuery(name="StudentIdentity.findAll", query="SELECT s FROM StudentIdentity s")
public class StudentIdentity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long sno;

	private BigDecimal smarks;

	private String sname;

	public StudentIdentity() {
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