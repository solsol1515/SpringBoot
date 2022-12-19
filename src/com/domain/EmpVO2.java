package com.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data					// lombok : setter, getter, tostring

@Entity    				// 테이블 만들어지기 전의 개념
@Table(name="EMP_Z")		
public class EmpVO2 {

	@Id
	// 오라클 
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	// 마리아DB / mysql
	// @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int empno;
	
	@Column(length=30)
	private String ename;
	
	@Column(length=30, nullable=true)		// null값이 들어올 수 있도록 처리(nullable)
	private String job;
	
	// 실제 DB의 컬럼명과 다른 경우
	@Column(name="hire_date")
	private Date hiredate;
	
	//@Column(precision=5)					// 숫자 입력 값 (precision)
	private int sal;
	
	//@Column(columnDefinition="int check(deptno in(87, 88, 89))")
	private int deptno;
}
