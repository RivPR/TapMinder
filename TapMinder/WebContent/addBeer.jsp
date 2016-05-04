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



	<form:form action="addBeer.do" modelAttribute="Beer">

		<input type="hidden" name="breweryId" value="${Brewery.id}" />
					Name<form:input type="text" path="name" />

		<form:errors path="name" />
				<br>	ABV<form:input type="text" path="abv" />
		<form:errors path="abv" />
				<br>	Hop Count<form:input type="text" path="hopCount" />
					<br>Style<form:input type="text" path="beerStyle" />
					<br>desc<form:input type="text" path="description" />
					<br>im link<form:input type="text" path="imageLink" />

		<c:if test="${currentUser.usertype.accessLevel > 0}">
			<br><button type="submit">Add Beer</button>
		</c:if>

<%-- TESTING STUFF:		<c:forEach var="attribute" items="${requestScope}">
			<tr>
				<td>${attribute.value}</td>
			</tr>
		</c:forEach> --%>

	</form:form>

	<br><c:if test="${!empty(aerrorMessage) }">
			
			${aerrorMessage}
			</c:if>


</body>
</html>