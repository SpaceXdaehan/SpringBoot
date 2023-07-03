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
 * Servlet implementation class TitleRead
 */
@WebServlet(name = "postDetailController", urlPatterns = { "/post/detail" })
public class PostDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger log = LoggerFactory.getLogger(PostDetailController.class);
	
	private final PostService postService = PostService.getInstance();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    log.info("doGet()");
	    
	    // 여기서 할 일! = 요청 URL에 쿼리스트링에 포함된 요청 파라미터 id(포스트 번호, PK) 값을 찾는다.
	    // getParameter() 메서드는 무조건 String을 리턴함 숫자로 보고싶으면parsInt사용.
	    String param = request.getParameter("id"); // getParamter는 문자열만 리턴함!
	    Long id = Long.parseLong(param);   // id는 숫자 타입이어야 하기 때문에 문자열을 숫자로 변환하기 위한 문장.
	    log.info("id = {}", id);
	    
	    // DB에서 화면에 보여줄 포스트 내용을 검색해서
	    Post post =  postService.read(id);
	    
	    // 뷰(JSP)에 전달한다.
	    request.setAttribute("post", post);

	    // View로 forward
	    request.getRequestDispatcher("/WEB-INF/post/detail.jsp").forward(request, response);
	}

}
