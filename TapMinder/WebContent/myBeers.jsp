
<%@include file="/includes/header.jsp"%>


<div class="container user-beer-list">

<div class="row">
<div class="col-xs-12">
<h3>${currentUser.firstname}'s Beers:</h3>
</div>
</div>


<c:forEach items="${currentUser.ratings}" var="r">
	
	
	<div class="col-xs-12 col-md-3 user-rating">
	<div>
		Beer Name: ${r.beer.name}<br/>
		Rating: ${r.rating}<br/>
		Comments: ${r.comments}<br/>
		
		<form action="changeARating.do">
			<input type="hidden" name="ratingID" value="${r.id}" />
			<button class="btn btn-warning" type="submit">Edit</button>
		</form>
	</div>
	</div>
	
	

</c:forEach>


</div>



<%@include file="/includes/footer.jsp"%>
