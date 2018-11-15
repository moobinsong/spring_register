<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--세션 없는 경우 -->
<c:if test="${empty info}">
	<h3><a href="login">로그인</a></h3>
	<h3><a href="step1">회원가입</a></h3>
</c:if>
<!--세션 있는 경우  (로그아웃, 비밀번호 변경)-->
<c:if test="${! empty info}">
	<h3><a href="logout">로그아웃</a></h3>
	<h3><a href="changePwd">비밀번호수정</a></h3>
</c:if>
</body>
</html>