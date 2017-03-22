
$(document).ready(setup_member);


function setup_member(){
	
	stater.checkState(function(){setup_nav();loggedin();},function(){setup_nav();loggedout();});
	
	function loggedin(){
		setup_nav();
		
		if(sessionStorage.getItem("requestUser")!="isMySelf"){
				mem.getMemberData(sessionStorage.getItem("requestUser"),insertData);
		}else{mem.getMemberData("isMySelf",insertData);}
	}
	function loggedout(){
		setup_nav();
		
		mem.getMemberData(sessionStorage.getItem("requestUser"),insertData);
	}

	
	
	function insertData(data){
		console.log("data :  "+data);
		//insert data into tags
		if(data.myself){
			fetchTag(showForm);
			fetchTag(editForm);
			}
		else{
			$("#edit-member-btn").remove();
			fetchTag(showForm);
		}
		
			function fetchTag(formRoot){
				//在這裡把資料塞進去，接受一個Jquery物件。
				fromRoot.find(".xxxx").attr("src",data.pic);
				fromRoot.find(".xxxx").html(data.intro);
				fromRoot.find(".xxxx").html(data.alias);
				fromRoot.find(".xxxx").html(data.instrument);
				
				
			}
		
		
		
	}

	
	
	
	
	
}