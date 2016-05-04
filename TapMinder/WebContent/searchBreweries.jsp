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
<title>Search brews</title>
</head>
<body> --%>

<%@include file="/includes/header.jsp"%>

	Search brews Settings: ${searchSetting}
	<c:if test="${searchSetting == ''}">
		<form name="searchBy" action="searchBreweriesPage.do" method="GET">
			<select name="findBy">
				<option value="">SELECT ONE</option>
				<option value="name">Name</option>
				<option value="street">Street</option>
				<option value="city">city</option>
				<!-- <option value="state">state</option> -->
				<option value="zip">Zip</option>
				<option value="neighborhood">Neighborhood</option>
			</select>

			<button style="background-color: #F99420" type="submit">GO SEARCH</button>

		</form>
	</c:if>


	<form:form action="searchBreweries.do"
		modelAttribute="BreweryParameters">
		<c:choose>

			<c:when test="${searchSetting == 'name' }">
				Brewery name <form:input style="color:black" type="text" path="name" placeholder="Type name here" /><form:errors path="name" /> 
			</c:when>
			<c:when test="${searchSetting == 'street' }">
				Street Address <form:input style="color:black" type="text" path="streetAddress" /><form:errors path="streetAddress" /> 
			</c:when>
			<c:when test="${searchSetting == 'city' }">
				City<form:input style="color:black" type="text" path="city" /><form:errors path="city" /> 
			</c:when>
			
<%-- 			<c:when test="${searchSetting == 'state' }">
				<form:select path="state">
					<c:forEach var="s" items="${stateEnumList }">
						<option value="${s}">${s}</option>
					</c:forEach>
				
				</form:select>
				
			</c:when> --%>
			<c:when test="${searchSetting ==  'zipcode'}">
				Zip <form:input style="color:black" type="text" path="zipcode" placeholder="Number 1-5" /><form:errors path="zipcode" /> 
			</c:when>
			<c:when test="${searchSetting ==  'neighborhood'}">
				Neigborhood<select name="neighboorHoodId"><option value="">Pick one</option>
					<c:forEach var="hood" items="${neighborhoodList}">
						<option value="${hood.id}"
							<c:if test="${Brewery.neighborhood.id == hood.id}">
								Selected
							</c:if>>${hood.name}</option>
					</c:forEach>
					</select>
			</c:when>


		</c:choose>
		
		<c:if test="${!empty(errorMessage)}">
		${errorMessage}
		</c:if>
		
		<c:if test="${searchSetting != '' }">
			<button style="background-color: #F99420" type="submit">search</button>
		</c:if>
	</form:form>

	<c:if test="${!empty(breweryList)}">
		<c:forEach var="b" items="${breweryList}">
	
			Name: ${b.name} <br>
			Address: ${b.streetAddress} <br>
			${b.city} <br>
			${b.state} <br>
			${b.zip} <br>
			${b.neighborhood.name}" <br>
	
	<c:if test="${ currentUser.usertype.accessLevel > 0}">

			<form action="addBeerPage.do">
				<input type="hidden" name="breweryId" value="${b.id}" />
				<button style="background-color: #F99420" type="submit">Add Beer to this brewery</button>
			</form>
	</c:if>

	<c:if test="${ currentUser.usertype.accessLevel > 1}">

			<form action="modifyBreweryPage.do">
				<input type="hidden" name="breweryId" value="${b.id}" />
				<button style="background-color: #F99420" type="submit">Modify</button>
			</form>
			<form action="deleteBrewery.do">
				<input type="hidden" name="breweryId" value="${b.id}" />
				<button style="background-color: #F99420" type="submit">Delete</button>
			</form>
	</c:if>						
			<br>
			<br>

		</c:forEach>
	</c:if>

<%@include file="/includes/footer.jsp"%>

<!-- 
</body>
</html> 
-->