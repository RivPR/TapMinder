//this goes in the header
console.log("THE FACEBOOK SCRIPT HAS BEEN CALLED.")

window.fbAsyncInit = function() {
	FB.init({
		appId : '1259928390703236',
		xfbml : true,
		version : 'v2.6'
	});
};

(function(d, s, id) {
	var js, fjs = d.getElementsByTagName(s)[0];
	if (d.getElementById(id)) {
		return;
	}
	js = d.createElement(s);
	js.id = id;
	js.src = "//connect.facebook.net/en_US/sdk.js";
	fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));
