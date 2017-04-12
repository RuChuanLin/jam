
$(document).ready(init_message);


function init_message(){
	stater.checkState(onLoggedIn,onLoggedOut);

	function onLoggedOut(){
		alert("you are not logged in");
		kie.cleanCookie(jam_cookie_key);
		sessionStorage.clear();
		localStorage.clear();
		window.location="index.html";
	}
	
	function onLoggedIn(){
		setup_nav();
		setup_msg();
		}
}


function setup_msg(){
	
	$("#send").on("click",sendMsg);
	$("#content").on("keyup",function(ev){
		msg.checkMsgLength(ev.target);
		console.log(msg.msgLng);
	});

}
	
	function sendMsg(){
		var msge={
			title : $("#title").val(),
			receiver : $("#receiver").val(),
			sender : 1,
			article : $("#content").val()
		};
		if(msg.chkMsgBody(msge)){
			msg.sendMessage(msge,function(resp){
			console.log("aaa"+resp);
			});
		}
	}
	

	
