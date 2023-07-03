package com.itwill.post.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.post.model.Post;
import com.itwill.post.repository.PostDao;

// Service(Business) layer(서비스/비즈니스 계층)
// Repository 계층의 메서드들을 사용해서 서비스를 만들어내는 역할.
public class PostService {
    // slf4j 로깅 기능 사용:
    private static final Logger log = LoggerFactory.getLogger(PostService.class);
    
    private static PostService Instance = null;
    
    // Service 계층에서는 Repository 계층의 메서드 사용:
    private final PostDao postDao = PostDao.getInstance();
    
    private PostService() {
        
    }
    
   public static PostService getInstance() {
       if (Instance == null) {
           Instance = new PostService();                   
       }
       return Instance;      
   }
   
   public List<Post> read() {
       log.info("read()");
       return postDao.select();
   }

   public int create(Post post) {
       log.info("create({})", post);
       return postDao.insert(post);
   }
   
   public Post read(long id) {
       log.info("read(id={})", id);       
       return postDao.select(id);
   }
   
   public int delete (long id) {
       log.info("delete(id={})", id);      
       return postDao.delete(id);
   }
   
   public int update(Post post) {
       log.info("update({})", post);
       return postDao.update(post);
   }
   
   public List<Post> read(String category, String word) {
       // TODO Auto-generated method stub
       log.info("read({})",category,word);
       
       return postDao.read(category, word);
   }

}
