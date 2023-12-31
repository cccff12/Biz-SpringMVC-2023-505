<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글쓰기</title>
<link href="${rootPath}/static/css/input.css?20230712-007" rel="stylesheet">
</head>
<body>

	<form class="main" method="POST" enctype="multipart/form-data">
<!--value 값에 콘트롤러 input get 의 model 을 가져와 넣는다  -->
		<div><label>작성일자</label><input name="b_date"   value="${BBS.b_date}" /></div>
		<div><label>작성시각</label><input name="b_time" value="${BBS.b_time}"/></div>
		<div><label>작성자</label><input name="b_username" value="${BBS.b_username}"/></div>
		<div><label>제목</label><input name="b_subject"/></div>
		<div><label>내용</label><input name="b_content" /></div>
		<div>
		<label>대표이미지</label>
		<input name="b_file" type="file" 
			accept="image/*,audio/*,video/*" />
		</div>
		<div>
		<label>이미지 리스트</label>
		<!-- multiple 이라는 속성을 넣으면 파일을 여러개 넣을 수 있다. -->
		<input name="b_images" type="file"
			multiple="multiple" 
			accept="image/*" />
		</div>
		
		
		
		<div class ="button-box"><button>저장하기</button></div>
	</form>
<div>
<img src="${rootPath}/files/${FILE_NAME}" width="100px"/>
</div>


</body>
</html>