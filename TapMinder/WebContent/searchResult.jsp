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
<title>Insert title here</title>
</head>
<body>
<c:forEach var="beer" items="${beerList}">
	Name: ${beer.name} <br>
	ABV: ${beer.abv} <br>
	HopCount: ${beer.hopCount} <br>
	Style: ${beer.beerStyle} <br>
	Brewery: ${beer.brewery.name} <br>
	Rating: ${beer.averageRating}<br/>
	<img src="${beer.imageLink}" />
	<br>
</c:forEach>


</body>
</html>