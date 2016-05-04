<%@include file="/includes/header.jsp"%>


<div class="container">
<div class="row">
<div class="col-sm-4 col-lg-8">
Beer Name: <h3>${br.beer.name}</h3><br/>
Rating: <h3>${br.rating}</h3><br/>
<img src="${br.beer.imageLink}" />
</div>
</div>
	<div class="row">
	<div class="col-sm-4 col-lg-8">
	<h3>Rate the beer:</h3>
	<form action="saveARating.do">
		<textarea style="color: black" name="comments">${br.comments}</textarea>
		<br />
		<fieldset class="rating">
			<input type="radio" id="star5" name="rating" value="5" /><label
				class="full" for="star5" title="Awesome - 5 stars"></label>
			<input type="radio" id="star4" name="rating" value="4" /><label
				class="full" for="star4" title="Pretty good - 4 stars"></label>
			<input type="radio" id="star3" name="rating" value="3" /><label
				class="full" for="star3" title="Meh - 3 stars"></label> 
			<input type="radio" id="star2" name="rating" value="2" /><label
				class="full" for="star2" title="Kinda bad - 2 stars"></label> 
			<input type="radio" id="star1" name="rating" value="1" /><label
				class="full" for="star1" title="Sucks big time - 1 star"></label> 
		</fieldset>
		<input type="hidden" name="beerId" value="${br.id}"><i></i>
		<input type="submit" value="Submit">
	</form>
		</div>
		</div>
</div>

<%@include file="/includes/footer.jsp"%>
</html>