
<%
// home.jsp에 보낼 input이니 나머지 다 삭제함
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<%
// action을 지정하면 해당 페이지로 보낼 수 있음 즉 콘트롤러
%>
<form class="main" method="POST" action="${rootPath}/input">
	<%
	// name에 빈칸있으면 안됨
	%>
	<div class="input">
		<input name="c_carnum" placeholder="차량번호" value="${CAR.c_carnum}" />
		<div class="error c_carnum"></div>
	</div>
	<div class="input">
		<input name="c_qty" placeholder="업무구분" value="${CAR.c_qty}" />
		<div class="error c_qty"></div>
	</div>
	<div class="input">
		<input name="c_username" placeholder="사용자" value="${CAR.c_username}" />
		<div class="error c_username"></div>
	</div>
	<div class="input">
		<input name="c_sdate" placeholder="시작일자" value="${CAR.c_sdate}" />
		<div class="error c_sdate"></div>
	</div>
	<div class="input">
		<input name="c_stime" placeholder="시작시간" value="${CAR.c_stime}" />
		<div class="error c_stime"></div>
	</div>
	<div class="input">
		<input name="c_skm" placeholder="출발 km" value="${CAR.c_skm}" />
		<div class="error c_skm"></div>
	</div>
</form>