<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>JSP</title>
	</head>
    
	<body>
        <h2>Form 제출 페이지</h2>
        <form action="form2-result.jsp" method="get">
            <div>
                <input type="text" name="username" placeholder="아이디 입력" autofocus />   
            </div>
            
            <div>
            <!-- select name 속성을 작성하지 않으면 서버로 전송되지 않음 -->
                <select name="color">
                    <option value="r">빨강</option>
                    <option value="g">초록</option>
                    <option value="b">파랑</option>
                </select>
            </div>
            
            <div>
                <input type="submit" value="보내기" />
            </div>
        </form>
		
	</body>
</html>