<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>도서정보추가 ${STATE == 'UPDATE' ? '수정' : '추가' }</h1>
	<%
	/*
		**** form의 입력 메서드는 항상 post
		보통 값을 넣을떄는 input 의 value에 ${} 로 붙이겠지만 지금은 다른 방법으로 하겠단 
		
		spring form taglib
		html 코딩에서 만들 여러가지 속성을 자동으로 구성해주는 Spring 의 확정 form tag
		Controller 에서 생성한 ModelAttribute와 연계되고
		각 input box path 속성과 연계되어 상당히 많은 코드를 자동으로 생성해준다
		이 tag는 form의 method의 기본값을 POST로 지정한다.
		*/
	%>
	<f:form modelAttribute="BOOK">
		<c:if test="${STATE != 'UPDATE' }">
		<div>
			<label>도서코드</label><f:input path="b_code" />
		</div>
		</c:if>
		
		<div>
			<label>도서명</label><f:input path="b_name" />
		</div>
		<div>
			<label>저자</label><f:input path="b_auther" />
		</div>
		<div>
			<label>출판사</label><f:input path="b_comp" />
		</div>
		<div>
			<label>구입연도</label><f:input path="b_year" />
		</div>
		<div>
			<label>구입가격</label><f:input path="b_iprice" />
		</div>
		<div>
			<label>대여가격</label><f:input path="b_rprice" />
		</div>
		<div>
			<button type="button">리스트로 가기</button>
			<button>저장하기</button>
			<button type="reset">새로작성</button>
		</div>
	</f:form>
</body>
</html>