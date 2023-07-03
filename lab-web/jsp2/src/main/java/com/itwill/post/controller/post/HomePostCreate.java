package com.itwill.post.controller.post;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.post.model.Post;
import com.itwill.post.service.PostService;

/**
 * Servlet implementation class HomePostCreate
 */
@WebServlet(name = "homePostCreate", urlPatterns = "/post/create")
public class HomePostCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger log = LoggerFactory.getLogger(HomePostCreate.class);
	
	private final PostService postService = PostService.getInstance();
	
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    // System.out.println("homePostCreate.doGet()");
	    log.info("doGet()");
	    
	    request.getRequestDispatcher("/WEB-INF/post/create.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    log.info("doPost()");
	    // TODO: 요청에 포함된 요청 파라미터 정보들을 추출(클라이언트가 보내준 제목, 내용, 작성자 아이디)를 추출.
	    
	    // getParameter()의 아규먼트는 form의 input(textarea)의 name 속성 값.
	    String title = req.getParameter("title");
	    String content = req.getParameter("content");
	    String author = req.getParameter("author");
	    
	    Post post = new Post(0, title, content, author, null, null);
	    
	    // TODO: 서비스 계층의 메서드를 호출해서 DB에 포스트를 저장
	    int result = postService.create(post);
	    log.info("create result = {}", result);
	    
	    // 포스트 목록 페이지로 이동(redirect 주소가 바뀜) 
	    resp.sendRedirect("/post/post"); // 요청주소: /contextRoot/path
	    
	    // PRG(Post-Redirect-Get) 패턴.
	
	}

}
