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
<form action="saveARating.do">
Comments: <br/><textarea name="comments">${br.comments}</textarea><br/>
		<input type="hidden" name="ratingID" value="${br.id}" />
		<button type="submit" value="1" name="rating" >1</button>
		<button type="submit" value="2" name="rating" >2</button>
		<button type="submit" value="3" name="rating" >3</button>
		<button type="submit" value="4" name="rating" >4</button>
		<button type="submit" value="5" name="rating" >5</button>
</form>
</div>



</body>
</html>