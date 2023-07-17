<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
div.image_list {
	width: 60%;
	margin: 10px auto;
	display: flex;
}

div.image {
	position: relative;
}

div.image span {
	color: white;
	text-shadow: 1px 1px 1px black;
	font-weight: bold;
	position: absolute;
	top: 0;
	right: 0;
	cursor: pointer;
	opacity: 0;
	transition: 0.7s;
}

div.image:hover span {
	opacity: 1;
}

/*호버하면 이미지 적용되는 효과*/
div.image:hover img {
	opacity: 0.7;
}


</style>
<script >
var rootPath="${rootPath}"
</script>

<script src="${rootPath}/static/js/detail.js?20230719"></script>

</head>
<body>
	<p>${BBS.b_seq}
	<p>${BBS.b_date}
	<p>${BBS.b_time}
	<p>${BBS.b_username}
	<p>${BBS.nickname}
	<p>${BBS.b_subject}
	<p>${BBS.b_content}
		<c:if test="${empty BBS.b_image}">
			<div>
				<img src="${rootPath}/static/no_image.png" width="200px" />

			</div>
		</c:if>
		<c:if test="${not empty BBS.b_image}">
			<img src="${rootPath}/files/${BBS.b_image}" width="200px" />
		</c:if>

		<c:if test="${not empty FILES }">
			<div class="image_list">
				<c:forEach items="${FILES}" var="FILE">
					<div class="image">
						<img src="${rootPath}/files/${FILE.i_uploadName}" width="100px" />
						<span data-seq="${FILE.i_seq}" 
						data-filename="${FILE.i_originalName }">
						&times;
						</span>
					</div>
				</c:forEach>
			</div>
		</c:if>
</body>
</html>