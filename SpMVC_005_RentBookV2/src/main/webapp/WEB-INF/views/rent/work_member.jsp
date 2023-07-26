<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${rootPath}/static/css/input.css" rel="stylesheet">
<script >
<%/*var rootPath= "${rootPath}" 이걸 넣어줘야 js에서 ${rootPath}" 사용 가능 그리고 js 파일보다 위에 있어야 함*/%>
var rootPath= "${rootPath}"
</script>
<script src="${rootPath}/static/js/main.js"></script>
<script src="${rootPath}/static/js/member.js"></script>
</head>
<body>
	<h1>회원검색</h1>
	<div>
		<p>도서코드:${RENT_WORK.rent_bcode}, 
		도서명 : ${RENT_WORK.b_name}, 
		도서코드 :${RENT_WORK.b_comp}</p>
	</div>
	<%
		/*${rootPath}/rent/go/complete 로 보내겠다*/%>
	<form:form action="${rootPath}/rent/go/complete" modelAttribute="RENT_WORK">

		<%
		/*
		보통은
		첫 화면에서 입력된 도서정보를 
		이 화면에서 입력하는 회원정보와 함께 묶어서 다음 화면으로
		전달하기 위해서는 감춰진 또는 다른 위치에 있는 
		input tag를 생성하고 그 input tag에 데이터를 담아 놔야 한다.
		<div>
		<input hidden="hiddin" name="rent_bcode" value="${RENT_WORK.rent_b_code}" /> 
		<input hidden="hiddin" name="b_name"  value="${RENT_WORK.rent_b_code}"/> 
		<input hidden="hiddin" name="b_comp"  value="${RENT_WORK.rent_b_code}"/>
		</div>
	
		하지만 modelattribute 와 sessionattribute 그리고 Spring form tag를
		사용해서 이렇게 번거롭게 적을 필요가 없다. 
		
		*/
		%>

		<div>
			<label>회원명</label>
			<div class="search container">
			<form:input path="m_name" />
			<div class="search list"></div>
			</div>
		</div>
		<div>
			<label>회원코드</label>
			<form:input path="rent_mcode" />
		</div>
		<div>
			<label>전화번호</label>
			<form:input path="m_tel" />
		</div>
		<div>
			<button>다음>></button>
		</div>
	</form:form>
</body>
</html>