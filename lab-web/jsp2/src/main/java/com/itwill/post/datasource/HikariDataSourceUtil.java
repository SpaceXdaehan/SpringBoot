package com.itwill.post.datasource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariDataSourceUtil {
    // Singleton Design Pattern:
    private static HikariDataSourceUtil instance = null;
    
    private HikariDataSource ds;
    
    // 다른 클래스에서 생성자 호출하면 호출 못함
    private HikariDataSourceUtil() {
        // HikariCP를 사용하기 위한 환경 설정 객체
        HikariConfig config = new HikariConfig();
        
        // CP(Data Source)을 생성하기 위한 설정들:
        config.setDriverClassName("oracle.jdbc.OracleDriver");
        config.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
        config.setUsername("scott");
        config.setPassword("tiger");
        
        // CP(Data Source) 객체 생성:
        ds = new HikariDataSource(config);
        
    }
    
    public static HikariDataSourceUtil getInstance() {
        if (instance == null) {
            instance = new HikariDataSourceUtil();            
        }
        return instance;
    }
    
    public HikariDataSource getDataSource() {
        return ds;
        // null을 리턴할 수가 없음
    }

    
}
