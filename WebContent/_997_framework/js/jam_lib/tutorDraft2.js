
/*
assumptions{
	jqueryExist : true,
	jam_lib_Exist : partial
}

holder : id="crsHolder"<<deprecated


parameter		id(nx)/class(nxx)

area		nx_area/nxx_area
cate		nx_cate/nxx_cate
charge		nx_charge/nxx_charge
userId		nx_tutor/nxx_tutor
instrument		nx_instrument/nxx_instrument
dur		nx_dur/nxx_dur
experience		nx_experience/nxx_experience
ifOpen		-/-
courseId		nx_crsId/nxx_crsId
intro		nx_intro/-
pic			nx_pic/nxx_pic
audience	nx_audience/nxx_audience
alias		nx_name/nxx_name


*/


(

window.tutor=function(){
	var methods={
		queryCourse : queryCourse,
		getCourse : getCourse,
		getCoursePage :getCoursePage,
		createCourse : createCourse,
		modiCourse :editCourse,
		cahngeCourse : changeCourse, //改變課程開啟/關閉狀態
		deleteCourse :deleteCourse,
		replyReserve : replyReserve,
		reserveCourse: reserveCourse,
		getReserveRecord : getReserveRecord,
		translate : translate,
		library : lib,
		page : 0,
		srh_str : ""//搜尋字串，從外部讀入
	}
	
	function createCourse(info){
		console.log(JSON.stringify(info));
		var xhr=new XMLHttpRequest();
		xhr.onreadystatechange=function(resp){
			switch(xhr.readyState){
				case 1: xhr.send(JSON.stringify(info));break;
				case 4: 
				var respond=JSON.parse(xhr.responseText);
				if(xhr.status==200){
						window.location="http://127.0.0.1:8080/Jam/index.html"
					}else{
					alert("some problem occured please retry later");
				}
			}
		}
			xhr.open("POST","/Jam/createCourse",true);
	}
	
	function queryCourse(onQueryCourse){
		var info ={
			page : tutor.page,
			search : tutor.srh_str
		};
		console.log(onQueryCourse);
		var xhr=new XMLHttpRequest();
		xhr.onreadystatechange=function(resp){
			switch(xhr.readyState){
				case 1 : 
					//xhr.setRequestHeader("Content-Type","application/json");
					xhr.send(JSON.stringify(info));
					break;
				case 4 :				
				if(xhr.status==200){
					var result=JSON.parse(xhr.responseText);
					console.log("aaa"+result);
					onQueryCourse(result);
				}	else{
						console.log(xhr.status);
					}break;
				}
			}
			
			xhr.open("POST","http://127.0.0.1:8080/Jam/queryCourse",true);
			
			
			
		}
	


	//取得課程資訊並塞入內容中
	function getCourse(crsId,callback){
		var info ={
			courseId: crsId
		};
		var xhr= new XMLHttpRequest();
		xhr.onreadystatechange=function(resp){
			switch(xhr.readyState){
				case 1 :
					//xhr.setRequestHeader("Content-Type","application/json");
					xhr.send(JSON.stringify(info));
					break;
				case 4 : 
					if(xhr.status==200){
						callback(JSON.parse(xhr.responseText));
					}else{
						alert("some problem occured");
					}break;
			}
		}
		xhr.open("POST","http://127.0.0.1:8080/Jam/getCourse",true);

		
	}
	
	function getCoursePage(crsId){
		window.location="http://127.0.0.1:8080/Jam/getCoursePage?crsId="+crsId;
	}
	
	//送出刪除請求後，回到課程首頁。
	function deleteCourse(crsId){
		//記得寫sendRedirect
		window.location="127.0.0.1:8080/Jam/deleteCourse?crsId="+crsId;
		
	}
	
	function editCourse(info,cbf){
		var xhr= new XMLHttpRequest();
		xhr.onreadystatechange=function(resp){
			switch(xhr.readyState){
				case 1 :
					xhr.setRequestHeader("Content-Type","application/json");
					xhr.send(JSON.stringify(info));
					break;
				case 4 : 
					if(xhr.status==200){
						var result=JSON.parse(xhr.responseText);
						cbf(result);
					}else{
						alert("some problem occured");
					}break;
			}
		}
		xhr.open("POST","http://127.0.0.1:8080/Jam/modiCourse",true);
	}
	
	function changeCourse(info){
		var xhr= new XMLHttpRequest();
		xhr.onreadystatechange=function(resp){
			switch(xhr.readyState){
				case 1 :
					xhr.setRequestHeader("Content-Type","application/json");
					xhr.send(JSON.stringify(info));
					break;
				case 4 : 
					var result=JSON.parse(xhr.responseText);
					if(xhr.status==200 && result.changeSuccess){
						tutor.getCoursePage(info.courseId);
					}else{
						alert("some problem occured");
					}break;
			}
		};
		xhr.open("POST","127.0.0.1:8080/Jam/changeCourse",true);
	}
	
	function getReserveRecord(crsId,cbf){
		var xhr= new XMLHttpRequest();
		xhr.onreadystatechange=function(resp){
			switch(xhr.readyState){
				case 1 :
					xhr.setRequestHeader("Content-Type","application/json");
					xhr.send(JSON.stringify({courseId:crsId}));
					break;
				case 4 : 
					var result=JSON.parse(xhr.responseText);
					if(xhr.status==200){
						cbf(result);
					}else{
						alert("some problem occured");
					}break;
			}
		};
		xhr.open("POST","127.0.0.1:8080/Jam/getReserveRecord",true);
		
		
	}
	
	function reserveCourse(crsId,cbf){
		var xhr= new XMLHttpRequest();
		xhr.onreadystatechange=function(resp){
			switch(xhr.readyState){
				case 1 :
					xhr.setRequestHeader("Content-Type","application/json");
					xhr.send(JSON.stringify({courseId:crsId}));
					break;
				case 4 : 
					var result=JSON.parse(xhr.responseText);
					if(xhr.status==200){
						cbf(result);
					}else{
						alert("some problem occured");
					}break;
			}
		};									
		xhr.open("POST","127.0.0.1:8080/Jam/courseReservation",true);
		
			
		
		
		
	}
	
	
	function replyReserve(id,acceptance,cbf){
		var info={
			rvsId : id,
			accept: acceptance
		}
		var xhr= new XMLHttpRequest();
			xhr.onreadystatechange=function(resp){
				switch(xhr.readyState){
					case 1 :
						xhr.setRequestHeader("Content-Type","application/json");
						xhr.send(JSON.stringify(info));
						break;
					case 4 : 
						var result=JSON.parse(xhr.responseText);
						if(xhr.status==200){
							cbf(result);
						}else{
							alert("some problem occured");
						}break;
				}
			};
			xhr.open("POST","127.0.0.1:8080/Jam/replyReservation",true);
			
			
	}
	
	//作為字典使用的物件
	var lib={
		"dur" : { 
			"0" : "30分鐘",
			"1"	: "60分鐘"
			},
			
		"experience" :{
			"0" : "一年以下",
			"1"	: "一年至三年",
			"2" : "三年以上"
		},
		
		"area" :{
			"north"	: "北部",
			"mid"	: "中部",
			"south" : "南部",
			"east" 	: "東部"
		}
		
		
	};
	
	function translate(key,value){
		return lib[key][value];
	}
	

			

	
	
	return methods;
}()



)

