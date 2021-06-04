<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>todoForm</title>
	<style>
	body {
		margin: 2% 5%;
		padding: 3%;
		border: solid 3px green;
	}
	header  {
		1padding: 3%;
		text-align: center;
	}
	section {
		padding: 30px;
		border: solid 1px yellow;
	}
	footer {
		padding: 30px;
	}
	div {
		margin: 30px 0px;
	}
	</style>
</head>
<body>
<header>
	<span><h1>할일 등록</h1></span>
</header>

<section>
	<form action="/todo/todoAdd" method="post">
	
		<div id="what">
			어떤 일인가요? <br>
			<input type="text" value="" name="title"/>
		</div>
		
		<div id="who">
			누가 할 일인가요? <br>
			<input type="text" value="" name="name"/>
		</div>
		
		<div id="rank">
			우선 순위를 선택하세요 <br>
			<input type="radio" name="sequence" value=1 checked > 1순위
			<input type="radio" name="sequence" value=2 > 2순위
			<input type="radio" name="sequence" value=3 > 3순위
		</div>
		
		<input type="submit" value="제출"/>
		
		<button style="float: right;" class="hover" type="button" onClick="location.href='main'"> 이전 </button>
		<input style="float: right;" type='reset' value="초기화"/>

	</form>
</section>

</body>
</html>