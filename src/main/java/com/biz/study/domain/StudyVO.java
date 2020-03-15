package com.biz.study.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class StudyVO {

	private long s_seq;				//	number			
	private String s_auth;			//	nvarchar2(30)			PRIMARY KEY
	private String s_subject;		//	nvarchar2(125)		NOT NULL	
	private String s_content;		//	nvarchar2(1000)		NOT NULL	
	private String s_cate;			//	nvarchar2(20)			
	private String s_s_time;		//	nvarchar2(20)		NOT NULL	
	private String s_f_time;		//	nvarchar2(20)			
	private String s_r_time;		//	nvarchar2(20)			

}
