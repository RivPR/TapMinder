<%@include file="/includes/header.jsp"%>
<header>
	<div class="header-content">
		<div class="header-content-inner">
	<div class="col-xs-offset-1 col-md-offset-4 col-xs-11 col-md-6">
			<form:form action="modifyBeer.do" modelAttribute="Beer">
			<form:input type="hidden" path="id" />
			
			<table>
				<tr>
				<td>Name</td>
				<td><form:input type="text" path="name" /></td>
				</tr>
				<tr>
				<td>ABV</td>
				<td><form:input type="number"  path="abv" /></td>
				</tr>
				<tr>
				<td>Hop Count</td>
				<td><form:input type="number"  path="hopCount" /></td>
				</tr>
				<tr>
				<td>Style</td>
				<td><form:input type="text"  path="beerStyle" /></td>
				</tr>
			
				<tr>
				<td>Description</td>
				<td><form:input type="text"  path="description" /></td>
				</tr>
			
				<tr>
				<td>Image Link</td>
				<td><form:input type="text"  path="imageLink" /></td>
				</tr>
			
				<tr>
				<td colspan="2"><br><button class="btn btn-warning" type="submit">Submit Changes to Beer</button></td>

				</tr>
			
			</table>


			</form:form>



</div>
		</div>
	</div>
</header>


<%@include file="/includes/footer.jsp"%>