package com.itwill.post.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.post.datasource.HikariDataSourceUtil;
import com.itwill.post.model.Post;
import com.zaxxer.hikari.HikariDataSource;
// Dao는 DB에서 셀렉트하면 결과는 
// Repository(Persistence) Layer(저장소/영속성 계층)
// DB CRUD(Create=Insert, Read=Select, Update, Delete) 작업을 수행하는 계층.
// 다오는 서비스로 리턴해주는 기능
public class PostDao {
    // slf4j 로깅 기능 사용:
    private static final Logger log = LoggerFactory.getLogger(PostDao.class);
    
    // 싱글턴 패턴 사용
    private static PostDao instance = null;
    
    // 데이터소스 이용
    private HikariDataSource ds;
    
    private PostDao() {
        ds = HikariDataSourceUtil.getInstance().getDataSource();
    }
    
    public static PostDao getInstance() {
        if(instance == null) {
            instance = new PostDao();           
        }
        return instance;
    }
    
    // POSTS 테이블에서 전체 레코드를 id 내림차순으로 정렬(최근 작성 포스트 먼저)해서 검색.
    private static final String SQL_SELECT_ALL =
            "select * from POSTS order by ID desc";
    
    public List<Post> select() {
        List<Post> list = new ArrayList<>();
        
        log.info(SQL_SELECT_ALL);
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = ds.getConnection(); // Pool에서 Connection 객체를 빌려옴.
            stmt = conn.prepareStatement(SQL_SELECT_ALL);
            rs = stmt.executeQuery();
            while (rs.next()) {
                // 테이블 컬럼 내용을 Post 타입 객체로 변환하고 리스트에 추가:
                Post post = recordToPost(rs);
                list.add(post);
            }
            log.info("# of rows = {}", list.size());
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();   // 물리적인 접속 해제가 아니라, 풀에 반환.
            } catch (Exception e) {
                // TODO Auto-generated catch blocDDk
                e.printStackTrace();
            }
        } 
        return list;
    }

    private Post recordToPost(ResultSet rs) throws SQLException {
        long id = rs.getLong("ID");
        String title = rs.getString("TITLE");
        String content = rs.getString("CONTENT");
        String author = rs.getString("AUTHOR");
        LocalDateTime created = rs.getTimestamp("CREATED_TIME").toLocalDateTime();
        LocalDateTime modified = rs.getTimestamp("MODIFIED_TIME").toLocalDateTime();
        
        Post post = new Post(id, title, content, author, created, modified);
        
        return post;
        
    }
    
    // 새 포스트 작성하기 위해서 만듬
    private static final String SQL_INSERT =
            "insert into POSTS (TITLE, CONTENT, AUTHOR) values (?, ?, ?)";

    public int insert(Post post) {
        log.info("insert({})", post);
        log.info(SQL_INSERT);
        
        int result = 0; // executeUpdate() 결과(insert 변수)를 저장할 변수
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = ds.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, post.getTitle());
            stmt.setString(2, post.getContent());
            stmt.setString(3, post.getAuthor());
            
            result = stmt.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }  
        return result;
    }   
    
    // 포스트 번호로 검색하는 기능 만들기
    private static final String SQL_SELECT_BY_ID = 
           "select * from POSTS where ID = ?";
    
    public Post select(long id) {
        log.info("select(id={})", id);
        log.info(SQL_SELECT_BY_ID);
        
        Post post = null;
        Connection conn =null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = ds.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setLong(1, id);
            rs = stmt.executeQuery(); // select 문장이어서 쿼리
            if (rs.next()) {
                post = recordToPost(rs);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }       
        
        return post;
    }
    
    // 포스트 아이디(PK)로 삭제하기:
    private static final String SQL_DELETE_BY_ID =
            "delete from POSTS where ID = ?";
    
    public int delete(long id) {
        log.info("delete(id={})", id);
        log.info(SQL_SELECT_BY_ID);
        
        int result = 0; // (int변수를 선언한 이유)SQL 실행 결과를 저장할 변수
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = ds.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE_BY_ID);
            stmt.setLong(1, id);
            result = stmt.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return result;
    }
    
    private static final String SQL_UPDATE =
            "update POSTS set TITLE = ?, CONTENT = ?, MODIFIED_TIME = SYSDATE WHERE ID = ?";

    // 해당 아이디의 포스트 제목, 내용, 수정시간을 업데이트:
    public int update(Post post) {
        log.info("update({})", post);
        log.info(SQL_UPDATE);
        
        int result = 0;
        
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = ds.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, post.getTitle());
            stmt.setString(2, post.getContent());
            stmt.setLong(3, post.getId());
            result = stmt.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {          
            try {
                stmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return result;
    }
    
    // TODO:
    // 4가지 sql문장
  //Content로 찾는 SQL
    private static final String SQL_READ_BY_CONTENT = "SELECT * FROM POST WHERE LOWER(content) LIKE LOWER(?) ORDER BY ID DESC";
    // title로 찾는 SQL
    private static final String SQL_READ_BY_TITLE = "SELECT * FROM POST WHERE LOWER(title) LIKE LOWER(?) ORDER BY ID DESC";
    // title or Content SQL
    private static final String SQL_READ_BY_TITLEORCONTENT = "SELECT * FROM POST WHERE LOWER(title) LIKE LOWER(?) OR LOWER(content) LIKE LOWER(?) ORDER BY ID DESC";
    // Author로 찾는 SQL
    private static final String SQL_READ_BY_AUTHOR = "SELECT * FROM POST WHERE LOWER(author) LIKE LOWER(?) ORDER BY ID DESC";
    
    //SQL 고르기
    public String searchSQL(int caseNum) {
        String answer = "";
        switch(caseNum){
        case 1:
            answer = SQL_READ_BY_TITLE;
            break;
        case 2:
            answer = SQL_READ_BY_CONTENT;
            break;
        case 3:
            answer = SQL_READ_BY_AUTHOR;
            break;
        case 4:
            answer = SQL_READ_BY_TITLEORCONTENT;
            break;
        
            
        }
        log.info("selectSQL = {}",answer);
        return answer;
    }
    
    private List<Post> search(String word, int caseNum) {
        // TODO Auto-generated method stub
        String keyword = "%" + word + "%";
        log.info("keyword = {}",keyword);
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = ds.getConnection();
            stmt = conn.prepareStatement(searchSQL(caseNum));
            stmt.setString(1, keyword);
            if(caseNum<=3) {
                
            } else {
                stmt.setString(2, keyword);
            }
            rs = stmt.executeQuery();
            while(rs.next()) {
                
                Post post = recordToPost(rs);
                
                list.add(post);
                
                
            }
            log.info("{}",list);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }
               
        
        
        return list;
    }
    
}
