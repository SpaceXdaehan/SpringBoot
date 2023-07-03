<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>JSP</title>
        <style>
        .header {
            background-color: black;
            color: white;
            padding: 100px;
            text-align: center;
        }
        
        .footer {
            background-color: lightgray; 
            padding: 8px;
            font-size: 80%;
        }
        </style>
	</head>
	<body>
    <%@ include file="header.jsp"%>
    
    
    
    <%-- include 지시문을 사용한 jsp 파일 삽입 
        include 지시문이 사용된 위치에 jsp, jspf, html 파일의 내용을 삽입하고,
        하나의 자바 클래스 파일로 변환되고 컴파일됨.
    --%>
    
        <main>
		  <h1>메인 페이지</h1>
            <a href="./">인덱스 페이지</a>
        </main>
        
    <%@ include file="footer.jspf"%>
        
	</body>
</html>