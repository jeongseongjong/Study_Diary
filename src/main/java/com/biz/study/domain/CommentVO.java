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
public class CommentVO {
	
	private long c_seq; // 번호
	private long c_s_id; // s_seq와 fk된 자식 테이블
	private String c_date; // 댓글 작성 시간
	private String c_auth;
	private String c_content; // 댓글 내용
}
