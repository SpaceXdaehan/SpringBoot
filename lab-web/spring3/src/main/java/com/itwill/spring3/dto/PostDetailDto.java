package com.itwill.spring3.dto;

import java.time.LocalDateTime;

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
public class PostDetailDto {

    private long id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime createdTime;
    private LocalDateTime modifiedTime;
    
    public static PostDetailDto fromEntity(Post post) {
        
        return PostDetailDto.builder().author(post.getAuthor())
                .content(post.getContent())
                .title(post.getTitle())
                .id(post.getId())
                .createdTime(post.getCreatedTime())
                .modifiedTime(post.getModifiedTime())
                .build();
    }
    
    public Post toEntity() {
        
        return Post.builder().id(id).author(author).content(content).title(title).build();
        
    }
    
}