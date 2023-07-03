package com.itwill.spring3.repository.post;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.spring3.dto.PostUpdateDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class PostRepositoryTest {
    
    @Autowired 
    private PostRepository postRepository;
    
    
//    @Test
    public void testFindAll() {
        List<Post> list = postRepository.findByOrderByIdDesc();
        for (Post p : list) {
            log.info(p.toString());
        }
    }
    
    
//    @Test
    public void testSave() {
        // DB테이블에 insert할 레코드(엔터티)를 생성:
        Post entity = Post.builder()
                .title("JPA 테스트")
                .content("JPA 라이브러리를 사용한 INSERT")
                .author("admin")
                .build();
        log.info("insert 전: {}", entity);
        log.info("created: {}, modified: {}",
                entity.getCreatedTime(), entity.getModifiedTime());
        
        // DB 테이블에 insert한다:
        postRepository.save(entity);
        // => save 메서드는 테이블에 삽입할 엔터티를 파라미터에 전달하면,
        // 테이블에 저장된 엔터티 객체를 리턴한다.
        // => 파라미터에 전달된 엔터티 값을 변경해서 리턴. 
        
        log.info("insert 후: {}", entity);
        log.info("created: {}, modified: {}",
                entity.getCreatedTime(), entity.getModifiedTime());
    }
    
    
//    @Test
    public void update() {
        // 업데이트 하기 전의 엔터티를 검색:
        Post entity = postRepository.findById(1L).orElseThrow();
        log.info("update 전: {}", entity);
        log.info("update 전 수정시간: {}", entity.getModifiedTime());
        
        // 엔터티의 변경 내용을 가지고 있는 객체 생성:
        PostUpdateDto dto = new PostUpdateDto();
        dto.setTitle("JPA update 테스트");
        dto.setContent("JPA Hibernate를 사용한 DB 테이블 업데이트");
        
        // 엔터티를 수정한다:
        entity.update(dto);
        
        // DB 테이블 업데이트:
        // JPA에서는 insert와 update 메서드가 구분되어 있지 않음.
        // save() 메서드의 아규먼트가 DB에 없는 엔터티이면 insert, DB에 없는 엔터티이면 update를 수행한다.
        // save와 savaAndFlush의 차이점은 바로 커밋이 일어난다
        postRepository.saveAndFlush(entity);
        
    }
    
    
    @Test
    public void testDelete() {
        long count = postRepository.count();  // DB 테이블의 행의 개수(엔터티 개수)
        log.info("삭제전 count = {}", count);
        
        postRepository.deleteById(4L);
        
        count = postRepository.count();
        log.info("삭제후 count = {}", count);
    }
   
}
