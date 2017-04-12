/*
	
	"addMember_"+serial_no
	
	area
	
	
	
	
	
	

*/




$(document).ready(setup_bandEdit);

function setup_bandEdit(){
		var memTemplate=null;
		var vidTemplate=null;
		setup_listeners();
		setup_templates();
		
		
		function setup_templates(){
			memTemplate=$("#addMember");
			memTemplate.keyup(validateUserId);
			vidTemplate=$("#addVideo");
			
			function validateUserId(){
				//檢查帳號是否存在
				console.log("validating");
			}
		}
		function setup_listeners(){
			
			
			
			function sendEditReq(){
				var info={
		
				
				};
				band.editBand(info);
			}
			
			//template :要複製的模板，使用jquery物件
			//holder :　傳入要放入的id，字串
			//addOrRemove :增加或減少，boolean，true=增加
			function addRemoveFields(template,holder,addOrRemove){
				
				
			}
		}
	

}

		function getParameter(key){
			var url=window.location.search.substr(1);
			var queries=url.split("&");
			for(var i=0;i<queries.length;I++){
				var pairs=queries[i].split("=");
				if(pairs[0]===key){
					return pairs[1];
				}
			}
			
			
		}