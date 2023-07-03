package com.itwill.post.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.post.model.User;
import com.itwill.post.repository.UserDao;

//  서비스 메서드는 다오를 사용함
public class UserService {
    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    
    private final UserDao userDao = UserDao.getInstance();
    
    // return instance; 까지 singleton 패턴
    private static UserService instance = null;
    
    private UserService() {
        
    }
    
    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }
    
    // sign-in: 로그인, sign-up: 회원가입
    // username과 password가 일치하면 null이 아닌 User 객체, 일치하지 않으면 null을 리턴하겠다는 메서드.
    public User signIn(String username, String password) {
        log.info("signIn(username={}, password={})", username, password);
        
        User test = new User(0, username, password, password, 0);
        User result = userDao.selectByUsernameAndPassword(test);
        
        return result;
    }

}
