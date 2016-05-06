<%@include file="/includes/header.jsp"%>



<header>
	<div class="header-content">
		<div class="header-content-inner">
		
		<!-- pics -->
		<div class="row">
		<form action="menu.do" method="POST">
				<div class="col-md-4 col-sm-6 main-menu-choice">
					<a href="#" class="porfolio-box"> <input type="image"
						name="menuChoice" value="findBeers" class="img-responsive"
						src="img/portfolio/1.jpg" alt="" /> 
						<div class="portfolio-box-caption">
							<div class="portfolio-box-caption-content"><br>
					
								<button class="btn btn-primary btn-xl page-scroll" name="menuChoice" value="findBeers" type="submit">Find Brews</button>
							</div>
						</div>
					</a>
				</div>

				<div class="col-md-4 col-sm-6 main-menu-choice">
					<a href="#" class="porfolio-box"> 
					<input type="image" name="menuChoice" value="findBreweries" class="img-responsive"
						src="img/portfolio/2.jpg" alt="" /> 
					
 
						<div class="portfolio-box-caption">
							<div class="portfolio-box-caption-content"><br>
                                
								<button class="btn btn-primary btn-xl page-scroll" name="menuChoice" value="findBreweries" type="submit">Find Breweries</button>
								</div>
						</div>
					</a>
				</div>

				<div class="col-md-4 col-sm-6 main-menu-choice">
					<a href="#" class="porfolio-box"> 
					<input type="image" name="menuChoice" value="viewUserBeers" class="img-responsive"
						src="img/portfolio/3.jpg" alt="" /> 
						

						<div class="portfolio-box-caption">
							<div class="portfolio-box-caption-content"><br>
							
								<button class="btn btn-primary btn-xl page-scroll" name="menuChoice" value="viewUserBeers" type="submit">View your Brews</button>
								
							</div>
						</div>
					</a>
					
					</div>
				
			</form>
		</div>
		<!-- pics -->




</div>
		</div>
</header>

	<aside class="bg-dark">
	<div class="container text-center">
		<div class="call-to-action">
			<h2>Connect with us on Facebook!</h2>
			<a href="https://www.facebook.com/TapMinder" target="_blank" style="background-color:#334c8b;color:rgb(200,200,200)" class="btn btn-default btn-xl wow tada">Yes!</a>
		</div>
	</div>
	</aside>



<section id="contact">
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2 text-center">
				<h2 class="section-heading">Get In Touch!</h2>
				<hr class="primary">
				<p>Let us help you find craft beer today</p>
			</div>
			<div class="col-lg-4 col-lg-offset-2 text-center">
				<i class="fa fa-phone fa-3x wow bounceIn"></i>
				<p>702-867-5309</p>
			</div>
			<div class="col-lg-4 text-center">
				<i class="fa fa-envelope-o fa-3x wow bounceIn" data-wow-delay=".1s"></i>
				<p>
					<a href="mailto:support@TapMinder.com">support@TapMinder.com</a>
				</p>
			</div>
		</div>
	</div>
	</section>


<%@include file="/includes/footer.jsp"%>