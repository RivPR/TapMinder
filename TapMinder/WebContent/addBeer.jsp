<%@include file="/includes/header.jsp"%>


<header>
	<div class="header-content">
		<div class="header-content-inner">
	<div class="col-xs-1 col-md-4"> </div>
	<div class="col-xs-11 col-md-6">
	<form:form action="addBeer.do" modelAttribute="Beer">
	
		<input type="hidden" name="breweryId" value="${Brewery.id}" />
	<table>
		<tr>
			<td>Name</td>
			<td><form:input type="text" path="name" /></td>
			<td><form:errors path="name" /></td>
		</tr>
		<tr>
			<td>ABV</td>
			<td><form:input type="text" path="abv" /></td>
			<td><form:errors path="abv" /></td>
		</tr>
		<tr>
			<td>Hop Count</td>
			<td><form:input type="text" path="hopCount" /></td>
			<td></td>
		</tr>
		<tr>
			<td>Style</td>
			<td><form:input type="text" path="beerStyle" /></td>
			<td></td>
		</tr>
		<tr>
			<td>Description</td>
			<td><form:input type="text" path="description" /></td>
			<td></td>
		</tr>
		<tr>
			<td>Image Link</td>
			<td><form:input type="text" path="imageLink" /></td>
			<td></td>
		</tr>
		<tr>
		<td colspan="2"><c:if test="${currentUser.usertype.accessLevel > 0}">
			<br><button class="btn btn-warning" type="submit">Add Beer</button>
		</c:if></td>
		</tr>
		
	
	</table>

	</form:form>

	<c:if test="${!empty(aerrorMessage) }">		
			${aerrorMessage}
			</c:if>
			</div>
</div>
</div>

</header>


<%@include file="/includes/footer.jsp"%>