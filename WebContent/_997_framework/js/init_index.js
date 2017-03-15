

$(document).ready(setup_index);


function setup_index(){
	
	stater.checkState(onLoggedIn,onLoggedOut);
	
	function onLoggedIn(){
		$(".element_li").css("display","inline-block");
		$(".element_lt").css("display","none");
		$("#fb-loggin-name").html(kie.getCookieJson(jam_cookie_key));
	}
	
	function onLoggedOut(){
		$(".element_lt").css("display","inline-block");
		$(".element_li").css("display","none");
		stater.state=stater.state_lt;
		console.log("you are not logged in");
	}
	
	
	
	
}