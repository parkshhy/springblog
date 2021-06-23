package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//ORM-> User 클래스가 MySQL에 테이블이 생성이 된다.
@Entity //User클래스가 MySql에 테이블이 생성된다.
//@DynamicInsert insert시에 null인 필드를 제외시켜준다.
public class User {

	@Id //pk
	@GeneratedValue(strategy=GenerationType.IDENTITY) //프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
	private int id;//시퀀스,auto_increment
									//아이디 중복 X
	@Column(nullable=false,length=30,unique=true)
	private String username; //아이디 
	
	@Column(nullable=false,length=100) //123456=>해쉬(비밀번호 암호화)
	private String password;
	
	@Column(nullable=false,length=50)
	private String email;
	
	//@ColumnDefault("'user'") //문자가 들어가므로 ' '을 넣는다.
	//private String role; //Enum을 쓰는게 좋다.(도메인을 만들어 준다.) //admin,user,manager
	
	//DB는 RoleType이라는게 없다.
	@Enumerated(EnumType.STRING)
	private RoleType role;//Enum을 쓰는게 좋다. //ADMIN,USER 
	
	
	@CreationTimestamp //시간이 자동 입력
	private Timestamp createDate;
	
}
