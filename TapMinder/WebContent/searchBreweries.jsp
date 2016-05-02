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
<title>Search brews</title>
</head>
<body>
Search brews
Settings: ${searchSetting}
		<c:if test="${searchSetting == ''}">
			<form name="searchBy" action="searchBreweriesPage.do" method="GET">
				<select name="findBy">
					<option value="">SELECT ONE</option>
					<option value="name">Name</option>
					<option value="streetAddress">Street</option>
					<option value="city">city</option>
					<option value="state">Style</option>
					<option value="zip">Rating</option>
					<option value="neighborhood">Rating</option>
				</select>

				<button type="submit">GO SEARCH</button>

			</form>
		</c:if>
wtf
		<form:form action="searchBreweries.do" modelAttribute="BreweryParameters">
	<c:choose>
		
		<c:when test="${searchSetting == 'name' }">
			Brewery name <form:input type="text" path="name" placeholder="Beer name"/>
		</c:when>
		<c:when test="${searchSetting == 'street' }">
sa <form:input type="text" path="streetAddress" /> to <form:input type="text" path="abvHigh" />
		</c:when>
		<c:when test="${searchSetting == 'city' }">
city<form:input type="text" path="city" /> to <form:input type="text" path="hopCountHigh" />
		</c:when>
		<c:when test="${searchSetting == 'state' }">
state <form:input type="text" path="state" placeholder="style"/>

		</c:when>
		<c:when test="${searchSetting ==  'zipcode'}">
zip <form:input type="text" path="zipcode" placeholder="Number 1-5" />
		</c:when>
		<c:when test="${searchSetting ==  'neighborhood'}">
neigborhood <form:input type="text" path="neighborhood" placeholder="Number 1-5" />
		</c:when>


	</c:choose>
	<c:if test="${searchSetting != '' }">
	<button type="submit">search</button>	
	</c:if>	
		</form:form>

	<c:if test="${!empty(breweryList)}">
	<c:forEach var="b" items="${breweryList}">
	Name: ${b.name} <br>
	Addr: ${b.streetAddress} <br>
	${b.city} <br>
	${b.state} <br>
	${b.zip} <br>
	${b.neighborhood.name}"
	<br>
	
	<br>
	
	<br>
	
</c:forEach>
	</c:if>



</body>
</html>