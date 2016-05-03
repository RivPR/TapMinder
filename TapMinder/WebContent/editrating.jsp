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
<title>Edit your rating</title>
</head>
<body>


<div>
Beer Name: <h3>${br.beer.name}</h3><br/>
Rating: <h3>${br.rating}</h3><br/>
Comments: <textarea name="comments">${br.comments}</textarea><br/>


<form action="changeARating.do">
		<input type="hidden" name="ratingID" value="${br.id}" />
		<button type="submit">Save Edit</button>
</form>
</div><br/><br/>


</body>
</html>