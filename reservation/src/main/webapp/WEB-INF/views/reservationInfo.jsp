<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ReservationInfo</title>
</head>
<body>

	<c:forEach items="${list }" var="reservationInfo">
	
		${reservationInfo.id } <br>
		${reservationInfo.productId}<br>
		${reservationInfo.displayInfoId}<br>
		${reservationInfo.reservationName}<br>
		${reservationInfo.reservationTel}<br>
		${reservationInfo.reservationEmail}<br>
		${reservationInfo.reservationDate}<br>
		${reservationInfo.cancelFlag}<br>
		${reservationInfo.createDate}<br>
		${reservationInfo.modifyDate}<br><br>
		<hr>
	
	</c:forEach>
</body>
</html>