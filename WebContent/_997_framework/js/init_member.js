
$(document).ready(init_member);


function init_member(){
	setup_nav();
	setup_member();
	
}

function setup_member(){
	if(localStorage.getItem("request_user")=="isMySelf"){
		$("#edit-member-btn").on("click",function(){
			setup_member_edit(data);
		});
	}else{
		$("#edit-member-btn").remove();
	}
	
	
}

function setup_member_edit(data){
	
}