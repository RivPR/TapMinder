<%@include file="/includes/header.jsp"%>

<div class="container individual-rating">

<div class="col-xs-0 col-md-2"></div>
<div class="col-xs-12 col-md-8">
<h1>Rate this Beer</h1>
<h3>Your fellow TapMinders value your opinion</h3>

Name: ${beer.name} <br>
ABV: ${beer.abv} <br>
HopCount: ${beer.hopCount} <br>
Style: ${beer.beerStyle} <br>
Brewery: ${beer.brewery.name} <br>
<img  class="med-beer" src="${beer.imageLink}" /> <br>
<input type="hidden" name="beerId" value="${beer.id}" />

	<form action="saveRateABeer.do" required>
		<textarea class="comment-box" name="comments" placeholder="Comments:"></textarea><br/>
		
		<div class="row">
		<div class="col-xs-1 col-md-1"></div>
		<div class="col-xs-10 col-md-6">
		<fieldset  class="rating">
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
		</div>
		
		</div>
		
		
		
		<input type="hidden" name="beerId" value="${beer.id}"><i></i>
		<!-- <input type="submit" value="Submit"> -->
		<button class="btn btn-warning" value="Submit" type="submit">Submit</button>
	</form>

</div>


</div>



<%@include file="/includes/footer.jsp"%>