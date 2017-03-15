$(document).ready(setup);


var msgModel=null;

function setup(){
	msgModel=$("#msgModel");
	msgModel.find(".nxx_msgSelected").change(onSelectOne);
	msgModel.click(showMsgContent);
	
	$("#selectAll").on("click",onSelectAll);
	$("#lastPage").on("click",lastPage);
	$("#nextPage").on("click",nextPage);
	$("#deleteMsg").on("click",deleteMsg);
	$("#msgArea").on("keyup",checkLength);
	$("#send_msg" ).on("click",sendMessage);
	stater.checkState(doLoggedIn,doLoggedOut);
	
	function doLoggedIn(){
		console.log("ininin");
		msg.checkNewMessage(function(resp){
			if(resp.result>0){
				msg.getMessage(showNewMessage);}
		});
		
		
		var bgt=[checkNewMsg];
		bgts.activateBgt(30000,bgt);
		
		function checkNewMsg(){
				msg.checkNewMessage(function(resp){
					console.log("新信： "+resp.result);
				});
		}
		
	}
	
	function doLoggedOut(){
		alert("You are not logged in");
		window.location="index.html";
	}
	
	function showMsgContent(){
		var panel=$("#msgContent");
		var title=$(this).find(".nxx_msgTitle").html();
		var sender=$(this).find(".nxx_msgSender").html();
		panet.find(".nxx_msgTitle").html(title);
		panet.find(".nxx_msgSender").html(sender);
		panet.find(".nxx_msgBody").html($(this).find(".nxx_msgBody").html());
		$("#mailto").html(sender);
		$("#mesTitle").html("Re : "+title);		
	}
	
	function msgOnScreen(){
		var onScr=$(".nxx_msg[value=onDisplay]").length;
		var onHid=$(".nxx_msg[value=onHidden]").toArray();
		var count=10-onScr;
		var page=0;
			//把抓回來，需要顯示出來的訊息設成可見
		if(onScr==0 || onScr<10){
			for(var p=0;p<count;p++){
				console.log("asvs");
				$(onHid[p]).css("display","block");
				$(onHid[p]).attr("value","onPage");
				$(onHid[p]).attr("value","onDisplay");
			}		
		}
	}
	

	
	function deleteMsg(){
		var amtSelected=msg.msgSelected.length;
		if(msg.msgSelected.length==0){
			return null;
		}
		if(confirm("確定刪除所選訊息?")){
				msg.deleteMsg();
				for(var r=0;r<amtSelected;r++){
				var msgId="#"+msg.idStr+msg.msgSelected[r];
				$(msgId).remove();
				msg.msgSelected.splice(r,1);
			}
			
		}
		msgOnScreen();
		
	}

	
	function onSelectAll(event){
		var selection=$("[id^='msgId_']").find(".nxx_msgId").html();
		if(event.target.checked){
				for(var i=0;i<selection.length;i++){
					selection[i].checked=false;
				}
				msg.msgSelected=[];
		}
		else{
			for(var i=0;i<selection.length;i++){
					msg.msgSelected.push(selection[i].innerHTML);
					selection[i].checked=true;
				}
			}

			
		
	}
	
	function onSelectOne(event){
		var tgt=$(this).siblings(".nxx_msgId").html();
		if(!event.target.checked){
			msg.msgSelected.splice(msg.msgSelected.indexOf(tgt),1);
			console.log("del : "+msg.msgSelected);
		}
		else{
		msg.msgSelected.push($(this).siblings(".nxx_msgId").html());
		console.log("add : "+msg.msgSelected);
		}
		
	}
	


    function showNewMessage(message){
		var messages=message.msgs;
		msg.totalInbox=message.result;
		for(var i=0;i<messages.length;i++){
			if(msg.msgRng[0]>messages[i].msgId){msg.msgRng[0]=messages[i].msgId;}
			if(msg.msgRng[1]<messages[i].msgId){msg.msgRng[1]=messages[i].msgId;}
			msg.msgAll.push(messages[i].msgId);
			r=msgModel.clone(true);
			msg.msgLocal+=1;
			r.find(checkbox).attr("checked",false);
			r.find(".nxx_msgTitle").html(messages[i].msgTitle);
			r.find(".nxx_msgBody").html(messages[i].msgBody);
			r.find(".nxx_msgId").html(messages[i].msgId);
			r.find(".nxx_msgSender").html(messages[i].sendId);
			r.find(".nxx_msgSenderNk").html(messages[i].sendNk);
			r.find(".nxx_msgDate").html(messages[i].msgDate);
			r.find(".nxx_msgRead").html(messages[i].msgState);
			r.css("display","none");
			r.addClass("nxx_msg");
			r.attr("value","onHidden");
			$(".nxx_pages").html(Math.ceil(i/10));
			r.prop("id",msg.idStr+messages[i].msgId.toString());
			r.appendTo("#msgBox");
			
		}
		msgOnScreen();
		
		

			
	
}




	function deleteMsg(){
		//刪除訊息
		for(var i=0;i<msg.msgSelected;i++){
			var id="#"+"#"+msg.idStr+msg.msgSelected[i];
			$(id).remove();
			var tgt=msg.msgAll.indexOf(msg.msgSelected[i])
			msg.msgAll.splice(tgt,1);
			mag.totalInbox-1;
		}
		msgOnScreen();
		
		
		
	}

	function checkLength(){
		msg.checkMsgLength(this);
		$("#msg_length").html("訊息長度 : "+msg.msgLng+" /3000 ");

	}

	function sendMessage(){
		var data=mem.extractCookie(mem.cookieKey);

		var message={
		sender: data.user_id,//寄件者id
		toUser :$("#mailto").html() ,//傳送對象
		title : $("#mesTitle").html() ,//訊息標題
		msg : $("#msgArea").val() ,//訊息本體
			
		};
			if(msg.chkMsgBody(message)){
				msg.sendMessage(message)
			}else{console.log("blank in neccesary field");}
		console.log(message);
			msg.sendMessage(message);
		
	}


	function chkMsg(){
		msg.checkNewMessage();
	}

	function getMail(){
		msg.getMessage();
	}


	
	function nextPage(){
		var onScr=$(".nxx_msg[value=onDisplay]").toArray();
		var seek=parseInt($(onScr[onScr.length-1]).find(".nxx_msgId").html());
		var start=msg.msgAll.indexOf(seek);
		console.log("ss "+start);
		var limit=msg.msgAll.length-start-1;
		if(limit>10){limit=10;}
		if(limit==0){
			if(msg.msgLocal<msg.totalInbox){
				console.log("getNewMessage");
				msg.getMessage(showNewMessage);
			}else{
				console.log("nomore on server");
				return;
			}
			
		}
		
		for(var g=0;g<onScr.length;g++){
			$(onScr[g]).css("display","none");
			$(onScr[g]).css("display","none");
			$(onScr[g]).attr("checked","false");
			$(onScr[g]).attr("value","onHidden");			
		}
		var st=start+limit;
		for(var i=start;i<=st;i++){
				var msgId="#"+msg.idStr+msg.msgAll[i];
				$(msgId).css("display","block");
				$(msgId).attr("value","onDisplay");
		}
	}
		
		
		
	function lastPage(){
		var onScr=$(".nxx_msg[value=onDisplay]").toArray();
		var seek=parseInt($(onScr[0]).find(".nxx_msgId").html());
		var start=msg.msgAll.indexOf(seek);
		var stop=0;
		if(start==0){ return;}
		if(start-10>0){
			stop=start-10;
		}else{
			stop=-1;
		}
		
		
		for(var g=0;g<onScr.length;g++){
			$(onScr[g]).attr("checked","false");
			$(onScr[g]).css("display","none");
			$(onScr[g]).attr("value","onHidden");			
		}
		for(var q=start;q>stop;q--){
			var msgId="#"+msg.idStr+msg.msgAll[q];
			$(msgId).css("display","block");
			$(msgId).attr("value","onDisplay");
		}
		
	}
	
	
}




