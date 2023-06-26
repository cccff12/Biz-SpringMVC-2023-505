<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
// var rootPath= pageContext.request.contextPath
// core tag를 사용해 현재 page에서 사용할 변수 선언하기
%>
<c:set value="${pageContext.request.contextPath}" var= "rootPath"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>안녕하세요</h1>
	<%
	//UserController 에서 설정한 USERS Attribute를 table 을 사용해 화면에 Rendiering 하기
	%>

	<table>
		<tr>
			<th>user name</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>나이</th>
			<th>주소</th>
		</tr>
		<c:forEach items="${USERS }" var="USER">
			<tr>
				<td>${USER.username}</td>
				<td>${USER.name}</td>
				<td>${USER.tel}</td>
				<td>${USER.age}</td>
				<td>${USER.addr}</td>
			</tr>
		</c:forEach>
	</table>
		<a href="${rootPath}/user/input">추가하기 </a>




</body>
</html>