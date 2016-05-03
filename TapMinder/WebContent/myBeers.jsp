<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rated beers</title>
</head>
<body>

Beers:<br/>





<c:forEach items="${currentUser.ratings}" var="r">
<div>
Beer Name: ${r.beer.name}<br/>
Rating: ${r.rating}<br/>
Comments: ${r.comments}<br/>
<form action="changeARating.do">
		<input type="hidden" name="ratingID" value="${r.id}" />
		<button type="submit">Edit</button>
</form>
</div><br/>
</c:forEach>



</body>
</html>