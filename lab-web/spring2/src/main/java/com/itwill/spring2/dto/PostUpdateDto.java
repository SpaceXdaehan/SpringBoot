package com.itwill.spring2.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.itwill.spring2.domain.Post;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class PostUpdateDto {
    // 업데이트 요청에서 전송되는 요청 파라미터를 저장하기 위한 객체.
    // field 이름을 선언할 때는 요청 파라미터 이름(name 속성의 값)과 같게.
    private long id;
    private String title;
    private String content; 
    
    // PostUpdateDto 객체를 Post 타입 객체로 변환.
    
    public Post toEntity() {        
        return Post.builder()            
                .id(id)
                .title(title)
                .content(content)
                .build();       
    }
}