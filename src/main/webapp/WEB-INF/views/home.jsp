<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> test </title>
<link type="text/css" rel="stylesheet" href="${cpath }/resources/css/style.css">
<script>
	const cpath = '${cpath}' 
</script>
<script src="${cpath }/resources/js/function.js"></script>
</head>
<body>

<p>응시자 : 정영규</p>

<hr>

<h2> 이번주 베스트셀러 </h2>

	<nav>
		<ul>
			<li>YES24</li>
			<li>인터넷 교보문고</li>
			<li>알라딘</li>
			<li>인터파크 도서</li>
			<li>영풍 문고</li>
			<li>도서11번가</li>
			<li>커넥츠북</li>
		</ul>
	</nav>
	<nav>
		<ul>
			<li>종합</li>
			<li>소설</li>
			<li>시/에세이</li>
			<li>비즈니스의 경제</li>
			<li>자기관리</li>
			<li>어린이</li>
			<li>유아</li>
			<li>인문</li>
			<li>역사와 문화</li>
			<li>국어와 외국어</li>
			<li>가정과 생활</li>
		</ul>
	</nav>
		<div class="last">
			YES24 업데이트:매주 화요일,집계기간:2021.12.27~01.02
		</div>
		<br>
		<br>
<div id="upload">
	<form>
		<p><input type="file" name="file" accept="image/*" required></p>
		<p><input type="text" name="bookname" placeholder="책이름" required></p>
		<p><input type="text" name="writer" placeholder="저자" required></p>
		<p><input type="date" name="pdate" required></p>
		<p><input type="number" name="price" placeholder="가격" required></p>
		<p><input type="submit">
	</form>
</div>

<div id="root">

</div>

<div id="modal" class="hidden">
	<div class="content"></div>
	<div class="overlay"></div>
</div>

<div> 이건 이클립스에서 만든 div입니다 !</div>

<script>

	const form = document.forms[0]
	const overlay = document.querySelector('.overlay')
	const content = document.querySelector('.content')
	
	form.addEventListener('submit', submitHandler)
	window.addEventListener('load', selectAll)
	overlay.addEventListener('click', closeModal)
	content.addEventListener('click', closeModal)
</script>


</body>
</html>