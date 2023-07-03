package com.itwill.spring3.dto;

import com.itwill.spring3.repository.post.Post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PostUpdateDto {
    
    private Long id;
    private String title;
    private String content;
}
