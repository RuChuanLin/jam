

$(document).ready(setup_tutorEdit);


function setup_tutorEdit(){
	tutor.getCourse(getParameter("crsId"),stuffingTutorEdit);
	setup_listeners();
	
}

function setup_listeners(){
	$("#sendEdit").on("click",editCourse_server);
	
	function editCourse_server(){
		console.log("aaasd");
		var info={
			area:$("#tutor-region").val()+"|"+$("#nx_area_str").val(),
			cate:$("tutor-class1").val()+"|"+$("#nx_instrument").val(),
			charge:$("#nx_charge").val(),
			intro:$("#secondhand-edit-description").html(),
			audience:$("#nx_audience").val(),
			dur:$("#tutor-trial-time").val(),
			experience:$("#tutor_experience").val(),
			crsId:getParameter("crsId")
			
			
		};
		
		tutor.modiCourse(info,function(data){
			console.log(data);
			if(data.updateSuccess){
				tutor.getCoursePage(data.courseId);
			}else{
				alert("似乎出了一些問題，請稍後再試");
			}
		});
		
		
	}
	
}
	
function stuffingTutorEdit(data){
	console.log("stuffingTeacherEdit :  "+data);
	var category=data.cate.split("|");
	var areaParams=data.area.split("|");
	$("#tutor-class1").val(category[0]);
	$("#nx_category").val(category[1]);
	$("#tutor-region").val(areaParams[0]);
	$("#nx_area_str").val(areaParams[1]);
	$("#tutor-experience").val(data.experience);
	$("#tutor-trial-length").val(data.dur);
	$("#nx_audience").val(data.audience);
	$("#nx_pic").attr("src",data.pic);
	$("#secondhand-edit-description").html(data.intro);
	$("#nx_charge").html(data.charge);
	$("#nx_crsId").html(data.courseId);

	
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



