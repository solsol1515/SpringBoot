package com.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="board")
public class BoardVO {
	
	@Id
	@GeneratedValue
	private Integer seq;
	private String writer;
	private String title;
	private String content;
	// 입력 불가하게 insertable=false / 수정 불가하게 updatable=false
	// @Column(insertable = false, updatable = false, columnDefinition = "date default sysdate") 
	private String regdate;
	// @Column(columnDefinition="number default 0")
	private Integer cnt;

}
