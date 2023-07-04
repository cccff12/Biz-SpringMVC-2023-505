<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<c:set value="20230704-05" var="version" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 주소록</title>
<link href="${rootPath}/static/css/main.css?${version}" rel="stylesheet">
<link href="${rootPath}/static/css/nav.css?${version}" rel="stylesheet">
<link href="${rootPath}/static/css/table.css?${version}"
	rel="stylesheet">
<link href="${rootPath}/static/css/button.css?${version}"
	rel="stylesheet">
<link href="${rootPath}/static/css/form.css?${version}" rel="stylesheet">
<link href="${rootPath}/static/css/list.css?${version}" rel="stylesheet">
<link href="${rootPath}/static/css/detail.css?${version}"
	rel="stylesheet" />
<link href="${rootPath}/static/css/user/login.css?${version}"
	rel="stylesheet" />


<script>
	//jsp에서 사용하는 rootpath 변수를
	// js코드에서 사용하기 위한 rootpath변수로 재 설정
	var rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/js/main_nav.js?${version}"></script>
<script src="${rootPath}/static/js/input.js?${version}"></script>
<script src="${rootPath}/static/js/list.js?${version}"></script>
<script src="${rootPath}/static/js/detail.js?${version}"></script>
</head>
<body>
	<header>
		<h1>주소록 프로젝트 2023</h1>
		<p>Spring MVC 패턴 기반 주소록 프로젝트</p>
	</header>
	<%@include file="/WEB-INF/views/nav.jsp"%>
	<section class="main">
		<c:if test="${empty BODY}">
			<%@include file="/WEB-INF/views/addr/list.jsp"%>
			<!-- list.jsp 를 여기에 끼워넣은 거다 -->
		</c:if>
		<c:if test="${BODY=='INPUT'}">
			<%@include file="/WEB-INF/views/addr/input.jsp"%>
		</c:if>
		<%
		// usercontroller의 메서드 중 login get 메서드가 있다 거기에
		// BODY에 DETAIL 이 있다면 detail.jsp에 보여라
		%>
		<c:if test="${BODY=='DETAIL'}">
			<%@include file="/WEB-INF/views/addr/detail.jsp"%>
		</c:if>
		<c:if test="${BODY=='UPDATE'}">
			<%@include file="/WEB-INF/views/addr/update.jsp"%>
		</c:if>
		<c:if test="${BODY=='LOGIN'}">
			<%@include file="/WEB-INF/views/user/login.jsp"%>
		</c:if>


	</section>
	<footer>
		<address>CopyRight &copy; callor@callor.com</address>
	</footer>


</body>

<c:if test="${MSG == 'LOGOUT' }">
	<script>
		alert("로그아웃 되었습니다.")
	</script>
</c:if>

</html>