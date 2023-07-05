<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="20230705-51" var="version" />
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${rootPath}/static/css/home.css?${version}" rel="stylesheet">
</head>
<body>
	<h1>TO DO List 2023</h1>

	<div class="inputbox">
		<input class="input1" placeholder="작성일자" /> <input class="input2" placeholder="작성시각" /> <input
			class="input3" placeholder="할일" />
	</div>
	
<table class="tablebody">
	<tr class="trbox">
		<th>No.</th>
		<th>할일</th>
		<th>완료여부</th>
	</tr>
	
	
	<c:forEach begin="1" end="2" var="INDEX">
	<tr>
	<td class="td">${INDEX}.</td>
	</tr>
	</c:forEach>
	
	
</table>


</body>
</html>