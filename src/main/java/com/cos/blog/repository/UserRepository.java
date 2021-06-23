package com.cos.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.blog.model.User;

//JSP로 치면 DAO이다
//자동으로 bean등록이 된다
//@Repository 생략 가능하다 
//User를 관리하는 레파지토리, 그것의 Pk는 Integer(숫자)이다 
public interface UserRepository extends JpaRepository<User,Integer>{

}
