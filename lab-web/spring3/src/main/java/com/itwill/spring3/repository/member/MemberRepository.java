package com.itwill.spring3.repository.member;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> { // 엔터티 클래스, 프라이머리키의 타입
    
    Member findByUsername(String username);

}
