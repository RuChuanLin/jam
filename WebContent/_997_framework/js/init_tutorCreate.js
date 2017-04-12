

$(document).ready(setup_tutorCreate);


function setup_tutorCreate(){
	setup_listeners();
	
	
	function setup_listeners(){
		$("#sendCreate").on("click",sendCourse);
		
		
		function sendCourse(){
			console.log("uio");
			var info={
				area:$("#tutor-region").val()+"|"+$("#nx_area_str").val(),
				cate:$("tutor-class1").val()+"|"+$("#nx_instrument").val(),
				charge:$("#nx_charge").val(),
				intro:$("#secondhand-edit-description").html(),
				audience:$("#nx_audience").val(),
				dur:$("#tutor-trial-time").val(),
				experience:$("#tutor-experience").val(),
				ifOpen : true
				
			};
			tutor.createCourse(info);
		}
		
		
	}
	
	
	
	
	
}

