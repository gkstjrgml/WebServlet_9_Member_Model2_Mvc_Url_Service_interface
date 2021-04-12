<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>연습 : 회원가입</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/Registerok.do" method="post">
		ID <input type="text" name="id" placeholder="ID 입력"><br>
		PWD <input type="password" name="pwd" placeholder="PASSWORD 입력"><br>
		EMAIL <input type="text" name="email" placeholder="EMAIL 입력"><br>
		<input type="submit" value="가입하기">
	</form>
</body>
</html>