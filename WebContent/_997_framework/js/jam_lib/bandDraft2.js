

(
window.band=function(){
	var methods={
		queryBand : queryBand,
		getBand : getBand,
		gotoBandPage : gotoBandPage,
		editBand : editBand,
		deleteBand :deleteBand,
		createBand :createBand,
		translate :translator,
		bndPage : 0
		
	}
	
	var original=new Object();
	
	function queryBand(cbf){
		var xhr=new XMLHttpRequest();
			xhr.onreadystatechange=function(resp){
				switch(xhr.readyState){
					case 1 : xhr.setRequestHeader("Content-type","application/json; multipart/mixed");
							xhr.send(JSON.stringify({page : band.page}));
							break;
					case 4 : 
					var data=JSON.parse(resp.responseText);
						if(xhr.state==200){
							band.bndPage=data.page;
							cbf(data);
					}else{
						console.log("something wrong");
					}
					break;
					
				}	
			}
			xhr.open("POST","http://127.0.0.1:8080/Jam/queryBand",true);
	}
	
	function getBand(bandId,cbf){
		var xhr=new XMLHttpRequest();
			xhr.onreadystatechange=function(resp){
				switch(xhr.readyState){
					case 1 :// xhr.setRequestHeader("Content-Type","application/json");
							xhr.send(JSON.stringify({bndId : bandId}));
							break;
					case 4 : 
					var data=JSON.parse(resp.responseText);
						if(xhr.state==200){
							cbf(data);
					}else{
						console.log("something wrong");
					}
					break;
					
				}	
			}
			xhr.open("POST","http://127.0.0.1:8080/Jam/getBand",true);
	}
		
	
	
	
	function gotoBandPage(bandId){
		window.location="http://127.0.0.1:8080/Jam/band_detail.html?bandId="+bandId;
		
	}
	
	function createBand(info){
		var xhr=new XMLHttpRequest();
			xhr.onreadystatechange=function(resp){
				switch(xhr.readyState){
					case 1 : xhr.setRequestHeader("Content-type","application/json; multipart/mixed");
							xhr.send(JSON.stringify(info));
							break;
					case 4 : 
					var data=JSON.parse(resp.responseText);
						if(xhr.state==200){
							if(data.createSuccess){
								gotoBandPage(data.bandId);
							}
					}else{
						console.log("something wrong");
					}
					break;
					
				}	
			}
			xhr.open("POST","http://127.0.0.1:8080/Jam/createBand",true);
		
	}
	
	function editBand(info){
		var xhr=new XMLHttpRequest();
			xhr.onreadystatechange=function(resp){
				switch(xhr.readyState){
					case 1 : xhr.setRequestHeader("Content-type","application/json; multipart/mixed");
							xhr.send(JSON.stringify({fuc: "1"}));
							break;
					case 4 : 
					var data=JSON.parse(resp.responseText);
						if(xhr.state==200){
							if(data.createSuccess){
								gotoBandPage(data.bandId);
							}
					}else{
						console.log("something wrong");
					}
					break;
					
				}	
			}
			xhr.open("POST","http://127.0.0.1:8080/Jam/editBand",true);
		
	}
	var lib={
		"key1" : {
					"key1_1" :"a",
					"key1_2" :"b",
				
					}
		
	}
	
	function translator(key,value){
		return lib[key][value];
	}
	
	function deleteBand(){
		
	}
	

	
	
	
	return methods;
}()




)