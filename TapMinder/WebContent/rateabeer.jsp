<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rate the beer!</title>
</head>
<body>
<div> --%>

 <%@include file="/includes/header.jsp"%>

	<h1>Rate this Beer</h1>
	<h3>Your fellow TapMinders value your opinion</h3>

	Name: ${beer.name} <br>
	ABV: ${beer.abv} <br>
	HopCount: ${beer.hopCount} <br>
	Style: ${beer.beerStyle} <br>
	Brewery: ${beer.brewery.name} <br>
	<img src="${beer.imageLink}" />
	<br>
	<input type="hidden" name="beerId" value="${beer.id}" />
<%-- 	<div>
	<form action="saveRateABeer.do">
	<textarea name="comments" placeholder="Comments:"></textarea><br/>
	<button type="submit" value="1" name="rating" >1</button>
	<button type="submit" value="2" name="rating" >2</button>
	<button type="submit" value="3" name="rating" >3</button>
	<button type="submit" value="4" name="rating" >4</button>
	<button type="submit" value="5" name="rating" >5</button>
	<input type="hidden" name="beerId" value="${beer.id}" />
	</form>
	</div> --%>

		<div>
			<form action="saveRateABeer.do">
			<textarea style="color:black" name="comments" placeholder="Comments:"></textarea><br/>
				<span class="star-rating"> 
				<input type="radio" name="rating" value="1"><i></i> 
				<input type="radio" name="rating" value="2"><i></i> 
				<input type="radio" name="rating" value="3"><i></i> 
				<input type="radio" name="rating" value="4"><i></i> 
				<input type="radio" name="rating" value="5"><i></i>
				<input type="hidden" name="beerId" value="${beer.id}"><i></i>
				</span><strong class="choice"><p>Choose a rating</p></strong> 
				<input type="submit" value="Submit">
			</form>
		</div>

<%@include file="/includes/footer.jsp"%>



<!-- 

	</div>
</body>
</html> -->