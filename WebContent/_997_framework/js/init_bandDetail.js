/*
	
	"addMember_"+serial_no
	
	area
	
	
	
	
	
	

*/




$(document).ready(setup_bandEdit);

function setup_bandEdit(){
		band.getBand(getParameter("bandId"),stuffing_bandDetail);
	
		function stuffing_bandDetail(data){
			$("#nx_title").html(data.title);
			
			
			$("#nx_wanted").html(data.wanted.replace("|","/"));
			$("#nx_area").html(data.area.split("|")[1]);
			$("#nx_style").html(data.style);
			$("#nx_isGrouped").html(data.isGrouped);
			$("nx_pic").attr("src",data.authorPic);
			var mateModel=$("#mateModel");
			for(var i=0; i<data.matePic.length;i++){
				var tmp=mateModel.clone(false);
				tmp.attr(href,"http://127.0.0.1:8080/Jam/memberPage.html?userId="+data.mateLinks);
				tmp.find("img").attr("src",matePic[i]);
				tmp.removeAttr("id");
				tmp.show();
				tmp.appendTo("#nx_mate");
			}
			
			$("nx_intro").html(data.intro);
			var mediaTemplate=$("#video_template");
			for(var i=0;i<data.vids.length;i++){
				var tmp=mediaTemplate.clone();
				tmp.attr("src",data.vids[i]);
				tmp.removeAttr("id");
				tmp.appendTo("#nx_mediaHolder");
			}
			
			
		}

}

function getParameter(key){
	var url=window.location.search.substr(1);
	var queries=url.split("&");
	for(var i=0;i<queries.length;i++){
		var pairs=queries[i].split("=");
		if(pairs[0]===key){
			console.log(pairs[1]);
			return pairs[1];
		}
	}
	
	
}

