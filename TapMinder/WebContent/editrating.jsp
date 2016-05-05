<%@include file="/includes/header.jsp"%>


<header>
	<div class="header-content">
		<div class="header-content-inner">


	<div class="col-xs-0 col-md-3"> </div>
	<div class="col-xs-12 col-md-6">

<h3>${br.beer.name}</h3>
Rating: ${br.rating}<br>
<img class="med-beer" src="${br.beer.imageLink}" />


	<br><span>Rate and comment:</span>
	<form action="saveARating.do">
		<textarea class="comment-box" name="comments">${br.comments}</textarea>

			<div class="row">
		<div class="col-xs-1 col-md-1"></div>
		<div class="col-xs-10 col-md-6">
		
		<fieldset class="rating">
			<input type="radio" id="star5" name="rating" value="5" <c:if test="${br.rating==5}">checked="checked"</c:if>/><label
				class="full" for="star5" title="Awesome - 5 stars"></label>
			<input type="radio" id="star4" name="rating" value="4" <c:if test="${br.rating==4}">checked="checked"</c:if>/><label
				class="full" for="star4" title="Pretty good - 4 stars"></label>
			<input type="radio" id="star3" name="rating" value="3" <c:if test="${br.rating==3}">checked="checked"</c:if>/><label
				class="full" for="star3" title="Meh - 3 stars"></label> 
			<input type="radio" id="star2" name="rating" value="2" <c:if test="${br.rating==2}">checked="checked"</c:if>/><label
				class="full" for="star2" title="Kinda bad - 2 stars"></label> 
			<input type="radio" id="star1" name="rating" value="1" <c:if test="${br.rating==1}">checked="checked"</c:if>/><label
				class="full" for="star1" title="Sucks big time - 1 star"></label> 
			<input type="hidden" name="beerId" value="${br.id}"><i></i>
		</fieldset>
				</div>
		
		</div>
<input class="btn btn-warning" type="submit" value="Submit" />

	</form>



</div>
</div>
</div>

</header>


<%@include file="/includes/footer.jsp"%>