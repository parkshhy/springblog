package com.cos.blog.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder //빌더 패턴
public class Board{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //auto_increment
	private int id;
	
	@Column(nullable=false,length=100)
	private String title;
	
	@Lob //대용량 데이터
	private String content; //섬머노트 라이브러리<html>테그가 섞여서 디자인이 됨
	
	@ColumnDefault("0")
	private int count;// 조회수
	
	@ManyToOne(fetch=FetchType.EAGER) //Many = Board, User = One 
	@JoinColumn(name="userId")
	private User user; //DB는 오브젝트를 저장할수 없다. FK, 자바는 오브젝트를 저장할수 있다.
	
	//(mappedBy="board")의 "board"는 Reply클래스에서 private Board board <<를 적어준다
	@OneToMany(mappedBy="board",fetch=FetchType.EAGER) //mappedBy 연관관계의 주인이 아니다 (즉 나는 FK가 아니라는것)DB에 컬럼을 만들지 않아도 된다.
	private List<Reply> reply;
	
	@CreationTimestamp
	private Timestamp createDate;
	
	
}
