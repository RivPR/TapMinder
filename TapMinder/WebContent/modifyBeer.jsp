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
			<form:form action="modifyBeer.do" modelAttribute="Beer">
			
					<form:input type="hidden" path="id" />
					Name<form:input type="text" path="name" />
					ABV<form:input type="text"  path="abv" />
					Hop Count<form:input type="text"  path="hopCount" />
					Style<form:input type="text"  path="beerStyle" />
					desc<form:input type="text"  path="description" />
					im link<form:input type="text"  path="imageLink" />

				<button type="submit">Mod Beer</button>

			</form:form>



</body>
</html>