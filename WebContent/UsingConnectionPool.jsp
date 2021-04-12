<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Tomcat Connection Pool 사용하기</title>
</head>
<body>
<%
	Connection conn = null;

	//JNDI(Java Naming and Directory Interface)
	Context context = new InitialContext(); //현재 프로젝트에서 특정 이름을 가진 녀석을 검색(이름 기반 검색)
	DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle"); //java:comp/env/ (정해진 약속) + jdbc/oracle (이름 : context.xml에 name)

	//pool 안에서 connection 가지고 오기
	conn = ds.getConnection();
	
	out.print("db 연결여부 : " +conn.isClosed() +"<br>");
	
	//POINT 반드시 반환해야한다
	conn.close(); //연결 끊는것x >> 반환(pool)

	out.print("db 연결여부 : " +conn.isClosed() +"<br>"); //true
%>
</body>
</html>