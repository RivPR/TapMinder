<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="lower-menu">

<form action="menu.do">
hi admin
		<!-- admin and up only -->
		<button type="submit" name="menuChoice" value="modifyUsers">Manager Users</button>
<button style="color: black;" type="submit" name="menuChoice"
					value="addBreweries">add brewrss</button>
</form>
</div>