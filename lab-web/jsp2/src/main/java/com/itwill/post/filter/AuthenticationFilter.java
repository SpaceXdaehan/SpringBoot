package com.itwill.post.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */

// urlPatterns에 설정된 요청 주소들에 대해서,
// 로그인이 되어 있으면 요청을 계속해서 처리하고(컨트롤러에게 요청을 전달)
// 로그인이 되어 있지 않으면 로그인 페이지로 redirect 한다.
@WebFilter(
        filterName = "authenticationFilter",
        urlPatterns = {
                "/post/create", "/post/detail",
                "/post/modify", "/post/update", "/post/delete"
        } // 로그인이 필요한 기능(요청 주소)들.
)
public class AuthenticationFilter extends HttpFilter implements Filter {
    private static final Logger log = LoggerFactory.getLogger(AuthenticationFilter.class);
    
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
    @Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	        throws IOException, ServletException {
        log.info("doFilter");
        // 로그인이 되어 있는 지를 체크:
        // (1) request(요청 객체)에서 session을 찾음.
        HttpSession session = ((HttpServletRequest) request).getSession();
        
        // (2) session에 로그인 정보(signedInUser)가 있는 지를 확인.
		String username = (String) session.getAttribute("signedInUser");   // getAttribute()는 무조건 Object를 리턴 
		log.info("로그인 정보: {}", username);

		if (username != null) {   // 로그인 정보가 세션에 저장된 경우,
		    // 요청을 필터 체인 순서대로 전달한다. - 전달하다보면 요청이 해당 컨트롤러로 전달이됨.
		    chain.doFilter(request, response);		
		    return;
		}
		
		// 필터가 리턴되지 않고 밑으로 내려오면 로그인 정보가 없다는 뜻.
		// 로그인 정보가 없으면, 로그인 페이지로 redirect
		((HttpServletResponse) response).sendRedirect("/post/user/signin");
	}

	

}
