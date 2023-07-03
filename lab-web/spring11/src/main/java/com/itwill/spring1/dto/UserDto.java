package com.itwill.spring1.dto;

import lombok.Data;

// DTO(Data Transfer Object): 각 계층 간의 데이터 전달을 위한 객체.
// DispatcherServlet <=== Data ===> Controller
// Controller <=== Data ===> Service

// VO(Value Object): 값을 저장하기 위한 객체.
// 데이터베이스의 테이블 구조를 자바 클래스로 표현한 객체.
// VO는 DTO와 모양이 같을 수 있음 같으면 안 만들어도 됨.

@Data
public class UserDto {
    // 폼에서 전달한 요청 파라미터 값들을 저장하기 위한 클래스.
    
    private String username;
    private int age;   
}
