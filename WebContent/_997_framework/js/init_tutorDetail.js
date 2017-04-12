


$(document).ready(setup_tDetail);


function setup_tDetail(){
	
	tutor.getCourse(getParameter("crsId"),stuffingTeacher);
	setup_listeners();
	
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
	
function setup_listeners(){
	setup_messageModal();

		$("#mailtoUser").click(openMailModal);
		$("#reserveClass").click(reserveClass);
		$("#mailto_return").click(closeMailModal);
		$("#mailto_send").click(mailToTeacher);

		function openMailModal(){
		
			$("#courseInfo").children("[id!='mailModal']").hide();
			$("#courseInfo").children("#mailModal").show();
			$("#receiverInfo").html($("#nx_name").html());
		
		}
		
		function closeMailModal(){
			$("#courseInfo").children("[id!='mailModal']").show();
			$("#courseInfo").children("#mailModal").hide();
		}
		
		function mailToTeacher(ev){
			console.log("mailto teacher");
			var message={
					sender: 3,
					receiver : $("#nx_tutor").html(),
					title : $("#titlePart_A").val()+$("#titlePartB").val(),
					article: $("replyMessage").html()					
			};
			msg.sendMessage(message,function(resp){
				if(resp.sendSuccess){
					alert("訊息成功送出");
					closeMailModal();
				}else{
					alert("寄送失敗，請稍後再試");
				}
			});
						
		}
		
		function reserveClass(){
			var mem=sessionStorage.getItem("Member");
			
			if(mem!=null ||mem!=undefined){
				alert("您尚未登入，請登入後繼續");
			}else{
				tutor.reserveCourse($(".nxx_courseId").html(),function(resp){
				if(resp.reserved){
					alert("已預約課程，請靜待教師回覆");
				}else{
					alert("預約失敗，請稍後再試");
					}
				});
			
			}
		}
		
		function setup_messageModal(){
			$("#messageModal").find("#sendMail").on("click",function(){
				
			})
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
