


$(document).ready(setup_tDetail);


function setup_tDetail(){
	setup_listeners();
	tutor.getCourse(getParameter("crsId"),stuffingTeacher);
	tutor.getReserveRecord(getParameter("crsId"),stuffingRSR);
	function stuffingTeacher(data){
		console.log(data);
		$("#nx_instrument").html(data.instrument.split("|")[1]);
		$("#nx_area").html(data.area.split("|")[1]);
		$("#nx_experience").html(data.experience);
		$("#nx_audience").html(data.audience);
		$("#nx_dur").html(data.dur);
		$("#nx_charge").html(data.charge);
		$("#nx_name").html(data.alias);
		$("#nx_pic").attr("src",data.pic);
		$("#nx_intro").html(data.intro);
		$("#nx_charge").html(data.charge);
		$("#nx_tutor").html(data.author);
		$("#nx_crsId").html(data.courseId);
	
		if(data.vids!=null){
			var vidTemplate=$("#videoModel");
			var videoLink=data.vids.split("|");
			for(var s=0;s<videoLing.length;s++){
				var tmp=vidTemplate.clone(true);
				tmp.attr("src",videoLink[s]);
				tmp.appendTo("#media_zone");
				tmp.show();
			}
		}
	}
}	
	
	function stuffingRSR(data){
		var rsrModel=$("#reserveModel");
		for(var i=0;i<data.reserves.length;i++){
			var tmp=rsrModel.clone(true);
			tmp.attr("id","rsr_"+data.reserves[i].rsrId);
			tmp.find("nxx_rsrPic").attr("src",data.reserves[i].userPic);
			tmp.find("nxx_rsrAlias").html(data.reserves[i].userAlias);
			tmp.find("nxx_rsrUID").html(data.reserves[i].userId);
			tmp.find("nxx_rsrId").html(data.reserves[i].rsrId);
			tmp.find("nxx_rsrTime").html(data.reserves[i].time);
			tmp.appendTo("#rsrHoder");
			}
	
		}
	
	
	
	
function setup_listeners(){
	var rsrModel=$("#reserveModel");
	$("#gotoEdit").click(function(){
		window.location="http://127.0.0.1:8080/Jam/tutor_edit.html?crsId="+$("#nx_crsId").html();
});
	rsrModel.find(".nxx_confirm").click(confReserve);
	rsrModel.find(".nxx_refuse").click(refReserve);
	$("#reserveClass").click(reserveClass);
	


	function reserveClass(){
		console.log("123456y7");
	}


	
	function confReserve(ev){
		var rvsId=$(ev.target).siblings(".nxx_rsrId").html();
		tutor.replyReserve($(ev.target).siblings(".nxx_rsrId").html(),true,function(resp){
			switch(resp.result){
				case 0: $("#rsr_"+rvsId).style("background:yellow;");break;
				case 1: $("#rsr_"+rvsId).remove();break;
				case -1 : alert("伺服器好像出了點問題，請稍後再試");break;
			}
		});
	
	}

	
	function refReserve(ev){
		var rvsId=$(ev.target).siblings(".nxx_rsrId").html();
		tutor.replyReserve($(ev.target).siblings(".nxx_rsrId").html(),false,function(resp){
			switch(resp.result){
				case 0: $("#rsr_"+rvsId).style("background:yellow;");break;
				case 1: $("#rsr_"+rvsId).remove();break;
				case -1 : alert("伺服器好像出了點問題，請稍後再試");break;
			}
		});
		
	}
	

	
	
	
}

function getParameter(key){
	var url=window.location.search.substr(1);
	var queries=url.split("&");
	for(var i=0;i<queries.length;i++){
		var pairs=queries[i].split("=");
		if(pairs[0]===key){
			return pairs[1];
		}
	}
	
	
}




