<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
            crossorigin="anonymous">
		<title>Spring 2</title>
	</head>
    
	<body>
    <div class="container-fluid">
		<header>
            <h1>포스트 목록 페이지<span class="badge bg-secondary">찬희</span></h1>
        </header>
        
        <nav class="navbar p-2">
            <ul>
                <li class="nav-item">
                    <c:url var="mainPage" value="/"/>
                    <a href="${ mainPage }" class="link-danger" class="nav-link">메인 페이지</a>
                </li>
                <li class="nav-item">
                    <c:url var="postCreatePage" value="/post/create"/>
                    <a class="link-danger" class="nav-link" href="${ postCreatePage }">새 포스트 작성</a>
                </li>
            </ul>
        </nav>
        
        <main class="my-2">
            <div class="card">
                <table class="table table-dark table-hover">
                    <thead>
                        <tr>
                            <th class="table-danger">번호</th>
                            <th class="table-danger">제목</th>
                            <th class="table-danger">작성자</th>
                            <th class="table-danger">작성 시간</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${ posts }" var="post"> <!-- PostController에 모델 파라미터 -->
                            <tr>
                                <td>${ post.id }</td>
                                <td>
                                    <c:url var="PostDetailPage" value="/post/detail">
                                        <c:param name="id" value="${ post.id }" />
                                    </c:url>
                                    <a href="${ PostDetailPage }">${ post.title }</a>
                                    <span class="text-danger">[${ post.rcnt }]</span>
                                </td>
                                <td>${ post.author }</td>
                                <td>
                                    <fmt:formatDate value="${ post.created_time }"
                                        pattern="yyyy-MM-dd HH:mm" />
                                </td>
                            </tr>  
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </main>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                    integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
                    crossorigin="anonymous">
        </script>
    </div>
	</body>
</html>