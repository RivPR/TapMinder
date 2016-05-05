<%@include file="/includes/header.jsp"%>


<header>
	<div class="header-content">
		<div class="header-content-inner">
	<div class="container">
		<div class="row-centered">
			<div class="col-xs-1 col-md-3"> </div>
			<div class="col-xs-11 col-md-2">
			<form:form action="addBrewery.do" modelAttribute="Brewery">

				<form:input type="hidden" path="id" />
				<form:input type="hidden" path="state" value="CO" />
				<form:errors path="state" />


				<table>
					<tr>
						<td>Name</td>
						<td><form:input type="text" path="name" /></td>
						<td><form:errors path="name" /></td>
					</tr>
					<tr>
						<td>Address</td>
						<td><form:input type="text" path="streetAddress" /></td>
						<td><form:errors path="streetAddress" /></td>
					</tr>
					<tr>
						<td>City</td>
						<td><form:input type="text" path="city" /></td>
						<td><form:errors path="city" /></td>
					</tr>
					<tr>
						<td>Zip Code</td>
						<td><form:input type="text" path="zip" /></td>
						<td><form:errors path="zip" /></td>
					</tr>
					<tr>
						<td>Image Link</td>
						<td><form:input type="text" path="imageLink" /></td>
						<td><form:errors path="imageLink" /></td>
					</tr>
					<tr>
						<td>Brewery Link</td>
						<td><form:input type="text" path="breweryLink" /></td>
						<td><form:errors path="breweryLink" /></td>
					</tr>

					<tr>
						<td>Neighborhood</td>
						<td><select name="neighboorHoodId">

								<c:forEach var="hood" items="${neighborhoodList}">
									<option value="${hood.id}"
										<c:if test="${Brewery.neighborhood.id == hood.id}">
		selected
		</c:if>>${hood.name}</option>
								</c:forEach>

						</select></td>
						<td></td>
					</tr>

					<tr>

					<tr>
						<td colspan="2"><button class="btn btn-warning" type="submit">Add</button></td>
			</tr></tr>
					
		
	</table>
	
	

				</form:form>
				</div>

</div>

	
</div>
		</div>
	</div>
</header>

<%@include file="/includes/footer.jsp"%>
