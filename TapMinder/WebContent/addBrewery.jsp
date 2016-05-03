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
<title>Mod Brewery</title>
</head>
<body>

<form:form action="addBrewery.do" modelAttribute="Brewery">
<form:input type="hidden" path="id"/>
	name	<form:input type="text" path="name" />
	addr<form:input type="text" path="streetAddress" />
	city<form:input type="text" path="city" />
	state<form:input type="text" path="state" />
	zip<form:input type="text" path="zip" />
	im link<form:input type="text" path="imageLink" />
	b link<form:input type="text" path="breweryLink" />
	ngbh<select name="neighboorHoodId">
	
		<option value="">pick one</option>
		<c:forEach var="hood" items="${neighborhoodList}">
				<option value="${hood.id}"
				
				<c:if test="${Brewery.neighborhood.id == hood.id}">
		selected
		</c:if>
				
				
				>${hood.name}</option>

		
		
		</c:forEach>
		
	</select>
	<%-- <form:input type="text" path="neighborhood" /> --%>
		
	<button type="submit">Add</button>
</form:form>

</body>
</html>