<%@page import="com.itwill.model.Contact"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>JSP</title>
	</head>
	<body>
		<h1>EL(Expression Language)</h1>
        <%-- EL
          JSP expression 태그 (<%= %>)를 대체하는 문법.
          ${ 식 }
          * 지시문(<%@ %>) 안에서는 사용할 수 없음.
          * 선언문(<%! %>) 안에서는 사용할 수 없음.
          * 스크립트릿(<% %>) 안에서는 사용할 수 없음.
          * 식(<%= %>) 안에서는 사용할 수 없음.
          * 그 이외의 JSP 안에서는 언제든지 사용 가능.
            - HTML 태그에 컨텐트
            - HTML 태그에 속성 값
            - CSS 프로퍼티 값
            - JavaScript 코드의 일부.
        --%>
        
        <p><%= 1 + 2 %></p>
        <p>${ 1 + 2 }</p>
        
        <%-- 상태 정보 유지: 
        JSP에서 상태 정보들을 유지하기 위해서 사용하는 객체들:
          * pageContext: JSP 페이지가 유지되는 동안 
          * request: 요청 객체가 유지되는 동안 
          * session: 세션이 유지되는 동안
          * application: 웹 애플리케이션이 동작하는 동안
          * 사용 범위: pageContext < request < session < application
          
        EL에서 상태 정보들을 유지하기 위해서 사용하는 객체(변수 이름)들:
          * pageScope1
          * requestScope2
          * sessionScope3
          * applicationScope4
        
        EL에서 상태 변수를 찾는 순서: ${ var }
            ${ pageScope.var } <= 여기서 찾지 못하면 request로
            ==> ${ requestScope.var } <= 여기서 찾지 못하면 session으로
            ==> ${ sessionScope.var } <= 여기서 찾지 못하면 application으로
            ==> ${ applicationScope.var } 마지막에도 못찾으면 null
        --%>
        
        <%-- 상태 저장 변수에 상태 저장 --%>
        <%
        pageContext.setAttribute("var1", 1);
        request.setAttribute("var2", 2);
        
        Contact c = new Contact(1, "a", "02", "aaa@");
        session.setAttribute("var3", c);    // session에 정보를 저장
        
        application.setAttribute("var4", "Hello");
        %>
        <h2>JSP Expression 태그를 사용한 상태 정보 읽기</h2>
        <p>
            var1: <%= pageContext.getAttribute("var1") %> <br />
            request.var2: <%= request.getAttribute("var2") %> <br />
            session.var3: <%= session.getAttribute("var2") %> <br />
            application.var4: <%= application.getAttribute("var4") %> 
        </p>
        <hr />
        
        <h2>EL을 사용한 상태 정보 읽기</h2>
        <p>
            va1: ${ var1 } <br /> <%-- ${pageScope.var1}과 동일 --%>
            request.var2: $ { var2 } <br /> <%-- ${requestScope.var2}과 동일 --%>
            session.var2: $ { sessionScope2.var2 } <br />
        </p>
	</body>
</html>