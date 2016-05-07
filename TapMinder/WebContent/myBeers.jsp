
<%@include file="/includes/header.jsp"%>


<div class="container user-beer-list">

<div class="row">
<div class="col-xs-12">
<h2>${currentUser.firstname}'s Beers:</h2>
</div>
</div>


<c:forEach items="${currentUser.ratings}" var="r">
	
	<div class="row-fluid">
	
	<div class="col-xs-12 col-md-3 user-rating">
		Beer Name: ${r.beer.name}<br/>
		Rating: ${r.rating}<br/>
		Comments: ${r.comments}<br/>
		
		<form action="changeARating.do">
			<input type="hidden" name="ratingID" value="${r.id}" />
			<button class="btn btn-warning" type="submit">Edit</button>
		</form>
		<form action="deleteRating.do">
			<input type="hidden" name="ratingId" value="${r.id}" />
			<button class="btn btn-warning" type="submit">Delete</button>
		</form>
	</div>
	</div>
	
	

</c:forEach>


</div>



<%@include file="/includes/footer.jsp"%>
