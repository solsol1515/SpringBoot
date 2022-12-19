package com.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

import lombok.Data;

@Data

// *************db와 매칭하는 (javax.persistence)
@Entity
@Table(name="EMP_A")
public class EmpVO {
	
	@Id
	private int empno;
	
	private String name;
	private String job;
	private int mgr;
	private Date hiredate;
	
	private int sal;
	private int comm;
	private int deptno;
	
}
