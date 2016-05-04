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
<title>Insert title here</title>
</head>
<body>
 --%>
 <%@include file="/includes/header.jsp"%>
 
		<c:if test="${searchSetting == ''}">
			<form name="searchBy" action="findBeersPage.do" method="GET">
				<select name="findBy">
					<option value="">SELECT ONE</option>
					<option value="name">Name</option>
					<option value="abv">ABV</option>
					<option value="hop">Hop Count</option>
					<option value="style">Style</option>
					<option value="rating">Rating</option>
					<option value="brewery">brewery</option>
				</select>

				<button type="submit">GO SEARCH</button>

			</form>
		</c:if>

		<form:form action="searchBeers.do" modelAttribute="BeerParameters">
	<c:choose>
		
		<c:when test="${searchSetting == 'name' }">
			BEER NAME <form:input style="color:black" type="text" path="name" placeholder="Beer name"/>
		</c:when>
		<c:when test="${searchSetting == 'abv' }">
ABV from <form:input style="color:black" type="text" path="abvLow" /> to <form:input type="text" path="abvHigh" />
		</c:when>
		<c:when test="${searchSetting == 'hop' }">
Hop count from <form:input style="color:black" type="text" path="hopCountLow" /> to <form:input type="text" path="hopCountHigh" />
		</c:when>
		<c:when test="${searchSetting == 'style' }">
Style <form:input style="color:black" type="text" path="style" placeholder="style"/>

		</c:when>
		<c:when test="${searchSetting ==  'rating'}">
			Rating Low<form:input style="color:black" type="text" path="ratingLow" placeholder="Number 1-5" />
			Rating High <form:input style="color:black" type="text" path="ratingHigh" placeholder="Number 1-5" />
		</c:when>
		

	</c:choose>
	<c:choose>
		<c:when test="${searchSetting ==  'brewery'}">
		<select name="breweryId">
			<c:forEach var="b" items="${Breweries}">
				<option value="${b.id}">${b.name}</option>
			</c:forEach>
		</select>
		</c:when>
		<c:otherwise>
			<!-- set to zero as a deafult -->
			<input type="hidden" name="breweryId" value="0" />
		</c:otherwise>
		
	
	
	</c:choose>
	<c:if test="${searchSetting != '' }">
	<button type="submit">search</button>	
	</c:if>	
		</form:form>

<%@include file="/includes/footer.jsp"%>

<!-- 		
</body>
</html> -->