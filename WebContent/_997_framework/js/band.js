

(
	window.band=functino(){
	var methods={
		openCourse=openCourse,
		queryCourse=queryCourse,
		editCourse=editCourse,
		saveCourse=saveCourse,
		deleteCourse=delegeCourse,
		getCourse=getCourse,
		currentCourse=-1,
		
	
	}
	
	function openCourse(courseData,cbf){
		/*
				{
					userId
					userAlias
					cate
					area
					experience
					trial
					charge
					audience
					info
					
				}
		*/
		
		
		
	}
	
	function queryCourse(amt,cbf){

	}
	
	function getCourse(courseId,cbf){
		
	}
	
	function deleteCourse(courseId,cbf){
		
	}
	
	function saveCourse(courseId,cbf){
		
	}
	
	function editCourse(courseId,cbf){
		
	}
	
	
	function modifyCourse(data,cbf){
		var xhr=new XMLHttpRequest();
		xhr.onreadystatechange=function(resp){
			switch(xhr.readyState){
				case 1: xhr.send(data);breal;
				case 4:if(xhr.readyState==200){
					cbf(JSON.parse(resp.respnseText));
				}break;
				
			}
			
		};
		
		xhr.open("POST",base_url+"/courses",true);
		
	}
	
	
	
	
	
	
	}()

)