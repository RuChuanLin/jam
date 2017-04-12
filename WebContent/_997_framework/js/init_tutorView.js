

$(document).ready(setup_tutorEdit);

function setup_listeners(){
	$("#opencourse").click(function(){window.location="tutor_X_create.html"});
	$("#courseTemplate").click(getCourseData);
	
	function getCourseData(ev){
		tutor.getCoursePage($(this).find(".nxx_courseId").html());
		}
	}

function stuffing_courses(data){
	var template=$("#courseTemplate");
	if(data.crs!=null){
		
		
		for(var i=0;i<data.crs.length;i++){
			console.log(data.crs[i]);
			var tmp=template.clone(true);
			tmp.find(".nxx_area_str").html(data.crs[i].area.split("|")[1]);
			tmp.find(".nxx_instrument").html(data.crs[i].cate.split("|")[1]);
			tmp.find(".nxx_name").html(data.crs[i].userAlias);
			tmp.find(".nxx_courseId").html(data.crs[i].crsId);
			tmp.find(".nxx_pic").html(data.crs[i].pic);
			tmp.removeAttr("id");
			tmp.show();
			tmp.appendTo("#courseHolder");
			console.log("append")
		}
	}
}


function setup_tutorEdit(){
	setup_listeners();
	tutor.queryCourse(stuffing_courses);

}









