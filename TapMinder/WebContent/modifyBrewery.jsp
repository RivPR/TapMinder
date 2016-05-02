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

<form:form action="modifyBrewery.do" modelAttribute="Brewery">
	<form:input type="hidden" path="id"/>
	<form:input type="text" path="name" />
	<form:input type="text" path="streetAddress" />
	<form:input type="text" path="city" />
	<form:input type="text" path="state" />
	<form:input type="text" path="zip" />
	<form:input type="text" path="imageLink" />
	<form:input type="text" path="breweryLink" />
	<form:input type="text" path="neighborhood" />
		
	<button type="submit">Change</button>
</form:form>

</body>
</html>