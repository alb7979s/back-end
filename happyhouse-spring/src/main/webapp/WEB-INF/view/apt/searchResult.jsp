<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>

<!-- 카카오톡 -->
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<meta property="og:image" content="../images/apt.jpg">
<!--실제 지도를 그리는 javascript API를 불러오기-->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=67a19357a9e3b8adf36e200722572e65&libraries=services"></script> 
<!--주소-좌표 변환을 할수 있응 services 라이브러리 불러오기--> 
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=67a19357a9e3b8adf36e200722572e65"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=67a19357a9e3b8adf36e200722572e65"></script>


<!-- 차트 -->
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>


<title>HappyHouse</title>
<link rel="stylesheet" href="${root}/css/main.css">

<script type="text/javascript">
/* function sendLinkCustom() {
    Kakao.init("67a19357a9e3b8adf36e200722572e65");
    Kakao.Link.sendCustom({
        templateId: 'happyhouse_info'
    });
} */

Kakao.init('67a19357a9e3b8adf36e200722572e65');


function searchCity() {
	if (document.getElementById("word").value == "") {
		alert("검색어를 입력해주세요.");
		return;
	} else {
		console.log("ok");
		document.getElementById("searchform").action = "${root}/apt";
		document.getElementById("searchform").submit();
	}
}
</script>

<style>
.map_wrap, .map_wrap * {margin:0; padding:0;font-family:'Malgun Gothic',dotum,'돋움',sans-serif;font-size:12px;}
.map_wrap {position:relative;width:100%;height:350px;}
#category {position:absolute;top:10px;left:10px;border-radius: 5px; border:1px solid #909090;box-shadow: 0 1px 1px rgba(0, 0, 0, 0.4);background: #fff;overflow: hidden;z-index: 2;}
#category li {float:left;list-style: none;width:50px;px;border-right:1px solid #acacac;padding:6px 0;text-align: center; cursor: pointer;}
#category li.on {background: #eee;}
#category li:hover {background: #ffe6e6;border-left:1px solid #acacac;margin-left: -1px;}
#category li:last-child{margin-right:0;border-right:0;}
#category li span {display: block;margin:0 auto 3px;width:27px;height: 28px;}
#category li .category_bg {background:url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/places_category.png) no-repeat;}
#category li .bank {background-position: -10px 0;}
#category li .mart {background-position: -10px -36px;}
#category li .pharmacy {background-position: -10px -72px;}
#category li .oil {background-position: -10px -108px;}
#category li .cafe {background-position: -10px -144px;}
#category li .store {background-position: -10px -180px;}
#category li.on .category_bg {background-position-x:-46px;}
.placeinfo_wrap {position:absolute;bottom:28px;left:-150px;width:300px;}
.placeinfo {position:relative;width:100%;border-radius:6px;border: 1px solid #ccc;border-bottom:2px solid #ddd;padding-bottom: 10px;background: #fff;}
.placeinfo:nth-of-type(n) {border:0; box-shadow:0px 1px 2px #888;}
.placeinfo_wrap .after {content:'';position:relative;margin-left:-12px;left:50%;width:22px;height:12px;background:url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png')}
.placeinfo a, .placeinfo a:hover, .placeinfo a:active{color:#fff;text-decoration: none;}
.placeinfo a, .placeinfo span {display: block;text-overflow: ellipsis;overflow: hidden;white-space: nowrap;}
.placeinfo span {margin:5px 5px 0 5px;cursor: default;font-size:13px;}
.placeinfo .title {font-weight: bold; font-size:14px;border-radius: 6px 6px 0 0;margin: -1px -1px 0 -1px;padding:10px; color: #fff;background: #d95050;background: #d95050 url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/arrow_white.png) no-repeat right 14px center;}
.placeinfo .tel {color:#0f7833;}
.placeinfo .jibun {color:#999;font-size:11px;margin-top:0;}

</style>

</head>
<body style="height:100%; margin-top:60px">

    <%@include file="../main/header.jsp" %>

	<div class="container" style="width:100%; max-height: 100%; ">
		<div class="row">
			<div class="col-md-3" style="height:70%">
			  <p style="font-size: 130%;">실거래가를 검색해보세요!</p>
		      <div style="margin-left:5px; display: inline-block; text-align:center; width:100%; height:30%;" >
		        <form id="searchform" method="get" action="">
		            <div class="input-group">
		                <select class="form-control" name="key" id="key" style="width:100px;">
		                    <option value="dong"  <c:if test="${result.key =='dong'}">selected</c:if>>동</option>
					    	<option value="AptName"  <c:if test="${result.key =='AptName'}">selected</c:if>>아파트</option>
		                </select>
		            	<input type="text" class="form-control" id="word" name="word" size="50" value="${result.word}" placeholder="검색어를 입력해주세요" style="width:200px;">
		            	<button onclick="searchCity();" type="button" class="btn btn-warning"><span class="glyphicon glyphicon-search"></span></button>
		            </div>
		        </form>
		      </div>
		      
		      <div class = "my-custom-scrollbar my-custom-scrollbar-primary" style="overflow-y:auto; position:absolute; text-align:center; width:100%; height:600px;">
		      <div>
		      <!-- 아파트 리스트 출력하는 부분 -->
		      <c:if test="${empty result.aptinfo and empty result.first}">
		      	<h3>검색 결과가 없습니다.</h3>
		      </c:if>
		       
		      <c:if test="${not empty result.aptinfo }">
		     
		      	<c:forEach var="apt" items="${result.aptinfo}">
		      	
		      	<div class="aptPanel round" 
		            onclick="showDetail(`${apt.dong}/${apt.aptName}/${apt.lat}/${apt.lng}`);">
		            <input type="hidden" value="${apt.lat}">
	                <input type="hidden" value="${apt.lng}">
	                <input type="hidden" value="${apt.dong}/${apt.aptName}">
	                <div class="panel-heading" style="display:none;">
		                <p>${apt.aptName}</p>
		            </div>
		            
		            <div class="aptPanelSub">
				      	<div  style="width:30%; height:100px; float:left;">
							<img src="../images/apt.jpg" style="height:100%; width:80%;"></img>
						</div>
						<div  style="width:70%; height:100px; float:left;">
							<p class="p1">${apt.dong}</p>
							<p class="p2">${apt.aptName}</p>
						</div>
					</div>
					
				</div>
		      	 
				</c:forEach>
		      </c:if>
		      </div>
		      </div>
			</div>
			
			<div class="col-md-6">
			
				<div id="map" style="width:100%; height:700px;">
					<ul id="category">
				        <li id="BK9" data-order="0"> 
				            <span class="category_bg bank"></span>
				            은행
				        </li>       
				        <li id="MT1" data-order="1"> 
				            <span class="category_bg mart"></span>
				            마트
				        </li>  
				        <li id="PM9" data-order="2"> 
				            <span class="category_bg pharmacy"></span>
				            약국
				        </li>  
				        <li id="OL7" data-order="3"> 
				            <span class="category_bg oil"></span>
				            주유소
				        </li>  
				        <li id="CE7" data-order="4"> 
				            <span class="category_bg cafe"></span>
				            카페
				        </li>  
				        <li id="CS2" data-order="5"> 
				            <span class="category_bg store"></span>
				            편의점
				        </li>      
				    </ul>
				</div>
			</div>
			
			<div class="col-md-3" id="details" style="display:none; overflow-y:auto; height:700px" >
				<!-- <div class = "my-custom-scrollbar my-custom-scrollbar-primary" style="overflow-y:auto; position:absolute; text-align:center; height:600px;"> -->
					<!-- 아파트 상세 정보를 띄울 부분 -->
					<div id="aptName"></div>
					<div id="aptDetail"></div>
					
					<div class="card-body"  style="height:120;"> 
						<canvas id="aptChart"></canvas>
					</div>
					
					<div id="aptSearchCnt" style="margin:auto;"></div>
					<div id="compareBtn">
					  <div style="width:100%; margin:10px auto; border-bottom:1px solid black"><h3>거래내역 상세 조회하기▼</h3></div>
					  <div id="slideTogglebox" style="display:none;"></div>
					</div>
					
					<div style="text-align:center; margin-top:40px"><p>동네 인구 정보</p></div>
					<div id="card-body" style="width: 100%; border-bottom:1px solid black">
						<canvas id="chartContainer_population_info"></canvas>
						<div id="people" style="text-align:center; margin-top:20px;"></div>
						<div id="over65" style="margin-top:10px"></div>
						<div id="percentLabel" style="text-align:center; margin-top:40px"></div>
						<canvas id="chartContainer_population" style="margin-bottom:40px;"></canvas>
					</div>
					<div style="text-align:center; margin-top:40px"><p>동네 상권 정보</p></div>
					<div id="card-body" style="height: 270px; width: 100%;">
						<canvas id="chartContainer"></canvas>
					</div>
					
					<div class="card-body" style="width:100%; margin:auto; margin-bottom:50px;"> 
					<button type="button" class="form-select" style="width:100%; margin:auto;" 
						data-toggle="modal" data-target="#myModal"> 다른 동네와 비교하기 </button>
					</div>
					
					</div>
				<!-- </div> -->
			
			</div> 
			</div>
			</div>
		</div>
	</div>
	
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">동네 비교하기</h4>
	      </div>
	      <div class="modal-body">
	        <div  style="width:100%; margin:auto;">
				      <select style="width:30%" class="form-select" name="gugun" id="gugun" onchange="getDongList(this.value)" aria-label="Default select example">
						  <option value="" name='gugun'>시/구/군</option>
					  </select>
				      <select style="width:30%" class="form-select" name="dong" id="dong" aria-label="Default select example">
						  <option value="" name='dong'>동</option>
					  </select>
					  
					  <button class="form-select" style="width:30%;" onclick="compare();">비교하기</button>
			</div>
			
			<div class="card-body" id="comparediv" style="margin:auto;"> 
			
	      </div>
	      
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
	      </div>
	    </div>
	  </div>
	  </div>

<!-- <script type="text/javascript">
    function sendLinkCustom() {
        Kakao.init("67a19357a9e3b8adf36e200722572e65");
        Kakao.Link.sendCustom({
            templateId: [templete id]
        });
    }
</script> -->

<script>
let label=[];
let d=[];
let curdongData=[], searchdongData=[];
let curdongPopData=[], searchdongPopData=[];

$('#myModal').on('hide.bs.modal', function () {
	  //console.log("dsfdsfd");
	  $("#comparediv").empty();
		$('#comparediv').empty();
		$("#dong").empty().append( "<option value=''> 동 </option>" );
		$("#gugun").empty().append( "<option value=''> 시/구/군 </option>" );
		makeGugun();
});
function compare(){
	gugun = $('#gugun option:selected').val();
	dong = $('#dong option:selected').val();

	if(gugun=='' || dong=='') {
		alert("비교할 동네를 선택해주세요");
		return;
	}
	curdong = $('#aptName').text();
	curdong = curdong.replace("[","");
	curdong = curdong.replace(']', "");
	curdong=curdong.split(" ");
	
	console.log(curdong[1]);
	
	 var datas = {
			"dong":curdong[1],
	 		"compare":dong
	 };
	 
	 $.ajax({
		 url:"/compare",
		 data: JSON.stringify(datas),
		 method:"post",
		 dataType: "json",
		 contentType:"application/json; charset=UTF-8",
		 success:function(data){
			
			//console.log(data);
			 $("#comparediv").empty();
			 info=""
			 info+='<table class="table justify-content-center " style="width:100%; margin-top:10px; text-align: center; ">'
			 info+='<tr><th class="text-center">'+curdong[1]+'</th><th></th><th class="text-center">'+dong+'</th></tr>'
			 info+='<tr><td>'+data.dongcnt+'건</td><td>거래수</td><td>'+data.comparecnt+'건</td></tr>'
			 info+='<tr><td>'+data.dongamount+'</td><td>평균거래가</td><td>'+data.compareamount+'</td></tr>'
			 info+='<tr><td>'+data.dongmax+'</td><td>최고거래가</td><td>'+data.comparemax+'</td></tr>'
			 info+='<tr><td>'+data.dongmin+'</td><td>최저거래가</td><td>'+data.comparemin+'</td></tr>'
			 info+='</table>'
			 
			 info+='<div class="row">'
			 info+='<div style="text-align:center"><h3>인구수 비교</h3></div>'
			 info+='<div><canvas id="percentChart0" ></canvas></div>'
			 info+='<div id="people_modal" style="text-align:center; margin-top:5px;"></div>'
			 
			 info+='<div id="dong1" style="text-align:center; margin-top:20px; width:50%; float:left"></div>'
			 info+='<div id="dong2" style="text-align:center; margin-top:20px; width:50%; float:left"></div>'
			
			 info+='<div style="width:50%; float:left;"><canvas id="percentChart" ></canvas></div>'
			 info+='<div style="width:50%; float:left;"><canvas id="percentChart2" style="width:50%"></canvas></div>'
			 info+='</div>'
			 
			
			 info+='<div style="text-align:center"><h3>상권 비교</h3></div>'
			 info+='<canvas id="storeChart"></canvas>'
			 
			$("#comparediv").append(info);
			 
				 $.ajax({
						url:'/dongInfo',
						data: dong,
						method:'post',	    			
						dataType: "json",
						async:false,
						contentType:"application/json; charset=UTF-8",
						success:function(data){
							data.sort(function (a, b) {
							    let x = a.big_classify_name;
							    let y = b.big_classify_name;
							    if (x < y) {
							        return -1;
							    }
							    if (x > y) {
							        return 1;
							    }
							    return 0;
							});
							
							searchdongData=data;
						}
					});
				 
				 $.ajax({
					 url:'/populationInfo',
						data: dong,
						method:'post',	    			
						dataType: "json",
						contentType:"application/json; charset=UTF-8",
						success:function(d){
							console.log("서치한 값 출력");
							console.log(d);	
							searchdongPopData=d;
							
							console.log(searchdongPopData);
							console.log(curdongPopData);
							
							family = parseInt(searchdongPopData.family);
							population = parseInt(searchdongPopData.population);
							//console.log(data1);
							family2 = parseInt(curdongPopData.family);
							population2 = parseInt(curdongPopData.population);
							//console.log(data2);
							
							data1 = [family, population];
							data2 = [family2, population2];
							
							maxLabel = searchdongPopData.dong;
							minLabel = curdongPopData.dong;
							var ctx = document.getElementById('percentChart0').getContext('2d');
							var chart = new Chart(ctx, { 
								// type : 'bar' = 막대차트를 의미합니다. 
								type: 'bar', 
								data: { 
									labels: ['세대수', '인구수'], // 큰 분류(하단 데이터 이름) 
									datasets: [ 
										{ label: maxLabel, //작은 분류 
											backgroundColor: [ '#fd999a',  '#fd999a'], 
											//borderColor: 'rgb(255, 99, 132)', 
											data: data1
										}, 
										{ label: minLabel, //작은 분류 
											backgroundColor: [ '#fec8c9',  '#fec8c9'],  
											//borderColor: 'rgb(255, 99, 132)', 
											data: data2
										} 
									] },

							});

							 //console.log(d);
							 str = '<i class="glyphicon glyphicon-home"></i>'+searchdongPopData.dong+' 세대당 인구: '+searchdongPopData.family_population;
							 str += '</br><i class="glyphicon glyphicon-home"></i>'+curdongPopData.dong+' 세대당 인구: '+curdongPopData.family_population;
							 $('#people_modal').append(str);
							 
							 $('#dong1').append(searchdongPopData.dong+" 외국인 비율(%)");
							 $('#dong2').append(curdongPopData.dong+" 외국인 비율(%)");
							 
							 
							console.log(searchdongPopData);
							console.log(curdongPopData);
							
							
							var pictx_percent = document.getElementById('percentChart').getContext('2d');
							
							 var data={
									labels:['한국인','외국인'],
									datasets:[{
										data:[searchdongPopData.percentage_k, searchdongPopData.percentage_f],
										backgroundColor: [
										      '#fd999a',
										      '#fec8c9',
										    ],
									}]
							}; 
							var PChart_percent = new Chart(pictx_percent,{
								type:'pie',
								data:data,
							}); 
							
							var pictx_percent2 = document.getElementById('percentChart2').getContext('2d');
							
							 var data={
									labels:['한국인','외국인'],
									datasets:[{
										data:[curdongPopData.percentage_k, curdongPopData.percentage_f],
										backgroundColor: [
										      '#fd999a',
										      '#fec8c9',
										    ],
									}]
							}; 
							var PChart_percent2 = new Chart(pictx_percent2,{
								type:'pie',
								data:data,
							}); 
						}
				 });
					
			
			 
			 console.log(curdongData);
			
			 curdongData.sort(function (a, b) {
			    let x = a.big_classify_name;
			    let y = b.big_classify_name;
			    if (x < y) {
			        return -1;
			    }
			    if (x > y) {
			        return 1;
			    }
			    return 0;
			});
			console.log(searchdongData);
			
			maxData = curdongData;
			minData = searchdongData;
			
			maxLabel = curdong[1];
			minLabel = dong;
			if(maxData.length<minData.length){
				temp=minData;
				minData=maxData;
				maxData=temp;
				
				temps = minLabel;
				minLabel = maxLabel;
				maxLabel=temps;
			}
			
			var index=0,k=0;
			let label =[];
			let maxdatas=[];
			let mindatas=[];
			let storedata=[];
			for(var key in maxData) {
				var key1 = maxData[key].big_classify_name;
				var key2 = minData[index].big_classify_name;
				
				label[k]=key1;
			
				if(key1 == key2){
					maxdatas[k] = maxData[k].count;
					mindatas[k] = minData[index].count;
					index++;
				}
				else{
					maxdatas[k] = maxData[k].count;
					mindatas[k] = 0;
				}
				k++;
			}
			
			console.log(maxdatas);
			console.log(mindatas);
			
			var ctx = document.getElementById('storeChart').getContext('2d');
			var chart = new Chart(ctx, { 
				// type : 'bar' = 막대차트를 의미합니다. 
				type: 'bar', 
				data: { 
					labels: label, // 큰 분류(하단 데이터 이름) 
					datasets: [ 
						{ label: maxLabel, //작은 분류 
							backgroundColor: [ '#99bbad','#99bbad','#99bbad','#99bbad','#99bbad','#99bbad','#99bbad','#99bbad','#99bbad' ], 
							//borderColor: 'rgb(255, 99, 132)', 
							data: maxdatas
						}, 
						{ label: minLabel, //작은 분류 
							backgroundColor: [ '#c6a9a3','#c6a9a3','#c6a9a3','#c6a9a3','#c6a9a3','#c6a9a3','#c6a9a3','#c6a9a3','#c6a9a3' ], 
							//borderColor: 'rgb(255, 99, 132)', 
							data: mindatas 
						} 
					] },

			});
			
			
			
		 }
	 });
}

	 function getDongList(gugun){
		 $.ajax({
			 url:"/dong",
			 data: gugun,
			 method:"post",
	   		 dataType: "json",
	   		 contentType:"application/json; charset=UTF-8",
			 success:function(dongList){
				
				 $("#dong").empty().append( "<option value=''> 동 </option>" )
				 
				 for(dong of dongList){
				 	$("#dong").append( "<option value='"+dong+"' name='dong' >"+ dong+" </option>" )
				 }
				 
			 }
		 	})
	 }

$(document).ready(function(){
	  $('#compareBtn').click(function(){
	    $('#slideTogglebox').slideToggle();
	  });
	  
});
	
$( document ).ready(function(){
	var result = get_query();
	console.log(result); 
});

function get_query(){
    var url = document.location.href;
    var qs = url.substring(url.indexOf('?') + 1).split('&');
    for(var i = 0, result = {}; i < qs.length; i++){
        qs[i] = qs[i].split('=');
        result[qs[i][0]] = decodeURIComponent(qs[i][1]);
    }
    return result;
}

let details='';
let dctx, ctx, pctx, pictx;
let DChart, chart, PChart, PIChart;

function makeGugun(){
	  $.ajax({
			 url:"/gugun",
			 data: "11",
			 method:"post",
			 dataType: "json",
			 contentType:"application/json; charset=UTF-8",
			 success:function(gugunList){
				
				 $("#gugun").empty().append( "<option value=''> 시/구/군 </option>" )
				 
				 //console.dir(sidoList)
				 for(gugun of gugunList){
					//console.log(gugun.code + ","+ gugun.name);
					$("#gugun").append( "<option value='"+gugun+"' name='gugun' >"+ gugun+" </option>" )
				 }
				 
			 }
		 	});
}
function showDetail(aptinfo){
	$("#details").css("display", "block");
	$("#aptDetail").empty();
	
	makeGugun(); //모달창에서 쓸 select box 만들어줌
	
	var info = aptinfo.split('/');
    /*  for ( var i in info ) {
      console.log(info[i]);
    } */
    
	//지도 변경
	panTo(new kakao.maps.LatLng(info[2], info[3]));
    map.setLevel(2);
	
    clickUp(info[0], info[1]);

	let details=''
    
    $("#aptName").empty();
    details=' <h2>['+info[0]+'] <strong>' +info[1]+'</strong></h2>'
    $("#aptName").append(details);
    //details+='<button id="shareButton" style="font-size:24px" ><i class="fas fa-share-square"></i>공유하기</button>'
    //details+='<button class="btn" style="font-size:24px"><i class="fa fa-heart" style="font-size:30px;color:pink;"></i>찜하기</button>'
  
	/* details+='<div id="roadview" style="width:100%;height:300px;"></div>'
	makeView(info[2],info[3]); */

	$("#slideTogglebox").empty();
	
		var datas = {
			 "dong":info[0],
			 "aptName":info[1]
	 	};
		let j=0;
		$.ajax({
			url:'/aptDealInfo',
			data: JSON.stringify(datas),
			method:'post',	    			
			dataType: "json",
			contentType:"application/json; charset=UTF-8",
			success:function(d){
				makeTable(d); //거래내역 테이블
			}  
		}); 
		$.ajax({
			url:'/populationInfo',
			data: info[0],
			method:'post',	    			
			dataType: "json",
			contentType:"application/json; charset=UTF-8",
			success:function(d){
				//console.log(d);
				curdongPopData = d;
				makePopulationInfoChart(d);
				makePopulationChart(d); //인구정보 차트
				
				str = '<i class="glyphicon glyphicon-home"></i> 세대당 인구: '+d.family_population;
				$('#people').append(str);
				
				/* p = d.
				str='<i class="glyphicon glyphicon-user"></i>65세 고령 인구 비율: '
				$('#over65').append(str); */
			}
		}); 
		$.ajax({
			url:'/dongInfo',
			data: info[0],
			method:'post',	    			
			dataType: "json",
			contentType:"application/json; charset=UTF-8",
			success:function(d){
				//console.log(d);
				curdongData = d;
				makeChart(d); //상권정보 차트	
			}
		}); 
		
		
		let shareinfo = info[0]+" "+info[1];
	    console.log( window.location.href);
	    
/* 		shareButton.addEventListener("click", async () => {
	    	  // 카카오링크 버튼 생성
	    	  Kakao.Link.createDefaultButton({
	    	    container: '#shareButton', // 카카오공유버튼ID
	    	    objectType: 'feed',
	    	    content: {
	    	    //templateId : 54030,
	    	      title: shareinfo, // 보여질 제목
	    	      description: "아파트 조회 정보를 공유합니다", // 보여질 설명
	    	      //imageUrl: document.images[0].src, // 콘텐츠 URL
	    	      imageUrl: $( 'meta[property="og:image"]' ).attr( 'content' ),
	    	      link: {
	    	         mobileWebUrl: window.location.href,
	    	         webUrl: window.location.href
	    	      }
	    	    },
	    	    buttons: [
	  	          {
	  	            title: '웹에서 보기',
	  	            link: {
	  	              mobileWebUrl:window.location.href,
	  	              webUrl:window.location.href
	  	            }
	  	          }
	  	        ],
	    	  }); 
		});*/	
}

function makePopulationInfoChart(infos){
	$('#percentLabel').append("<p>"+infos.dong+"외국인 비율(%)</p>");
	family = parseInt(infos.family.replace(",",""));
	population = parseInt(infos.population.replace(",",""));
	
	pictx = document.getElementById('chartContainer_population_info').getContext('2d');
	var data_info={
			labels:[infos.dong],
			datasets:[{
				label: "세대수",
				data: [family],
				backgroundColor: [
				      '#fd999a',
				    ],
			},{
				label: "인구수",
				data: [population],
				backgroundColor: [
				      '#fec8c9',
				    ],
			}]
	};
	
	
	if(PIChart!=null){
		PIChart.destroy();
	}
	PIChart = new Chart(pictx,{
		type:'bar',
		data:data_info,
	}); 
	PIChart.render();	
}

function makePopulationChart(infos){
	
	
	pctx = document.getElementById('chartContainer_population').getContext('2d');
	
	 var data={
			labels:['한국인','외국인'],
			datasets:[{
				data:[infos.percentage_k, infos.percentage_f],
				backgroundColor: [
				      '#fd999a',
				      '#fec8c9',
				    ],
			}]
	}; 
	
	if(PChart!=null){
		//console.log("not null");
		DChart.destroy();
	}
	
	PChart = new Chart(pctx,{
		type:'pie',
		data:data,
	}); 
	PChart.render();	
}

function makeChart(infos){
	label=[];
	d=[];
	console.log(label + " "+d)
	i=0;
	for(info of infos){
		label[i]=info.big_classify_name;
		d[i]=info.count;
		i++;
	}

	dctx = document.getElementById('chartContainer').getContext('2d');
	
	 var data={
			label: '상권정보',
			labels:label,
			datasets:[{
				data:d,
				backgroundColor: [
				      'rgb(119, 191, 163)',
				      'rgb(152, 201, 163)',
				      'rgb(197, 222, 221)',
				      'rgb(191, 216, 189)',
				      'rgb(221, 231, 199)',
				      'rgb(237, 238, 201)',
				      'rgb(214, 226, 233)'
				    ],
			}]
	}; 
	
	
	if(DChart!=null){
		//console.log("not null");
		DChart.destroy();
	}
	
	DChart = new Chart(dctx,{
		type:'pie',
		data:data,
	}); 
	DChart.render();	
}

function makeTable(data){
	$("#aptSearchCnt").empty();
	$("#aptSearchCnt").append("조회된 실거래 수: " + data.length+"건");
	
	let dealDay=[];
	let dealAmount=[];
	let j=0;
	details='<table class="table">'
	details+='<tr><th>거래금액</th><th>거래일</th><th>평수</th><th>층수</th></tr>'
	for(apt of data){
		details+='<tr>'
		details+='<td>'+apt.dealAmount+'</td>'
		details+='<td>'+apt.dealYear+'.'+apt.dealMonth+'.'+apt.dealDay+'</td>'
		details+='<td>'+apt.area+'</td>'
		details+='<td>'+apt.floor+'</td></tr>'
		
		dealDay[j]=apt.dealYear+'.'+apt.dealMonth+'.'+apt.dealDay;
		dealAmount[j]=apt.price;
		j++;
	}
	details+='</table>'
	
	$("#slideTogglebox").append(details);
	
	var ctx = document.getElementById('aptChart').getContext('2d'); 
	
	if(chart!=null){
		console.log("not null");
		chart.destroy();
	}
	
	chart = new Chart(ctx, { 
		// 챠트 종류를 선택 
		type: 'line', 
		// 챠트를 그릴 데이타 
		data: { 
			labels: dealDay, 
			datasets: [{ label: '실거래가', 
			fill: true,
		    borderColor: 'rgb(211,211, 211)',
		    tension: 0.1,
			data: dealAmount
		}] }, 
		// 옵션 
		options: {} 
	});
}

function clickUp(dong, aptName){
	var datas = {
			 "dong":dong,
			 "aptName":aptName
	 	};
		
	$.ajax({
		url:'/clickUp',
		data: JSON.stringify(datas),
		method:'put',	    			
		dataType: "json",
		contentType:"application/json; charset=UTF-8",
		success:function(data){
			//console.log(data+" 뷰 카운트 증가 성공")
		}  
	}); 
}
</script>


<!-- 카카오지도 -->

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=67a19357a9e3b8adf36e200722572e65&libraries=services"></script>
<script>

var placeOverlay = new kakao.maps.CustomOverlay({zIndex:1}), 
contentNode = document.createElement('div'), // 커스텀 오버레이의 컨텐츠 엘리먼트 입니다 
markers = [], // 마커를 담을 배열입니다
currCategory = ''; // 현재 선택된 카테고리를 가지고 있을 변수입니다

var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(37.566536, 126.97797), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
var map = new kakao.maps.Map(mapContainer, mapOption); 

// 마커 이미지의 이미지 주소입니다
var imageSrc = "../images/icons/home.png"; 
var positions=[];
var i=0;

$('.aptPanel').each((index, item) => {
	const latitude = parseFloat(item.childNodes[1].value);
	const longtitude = parseFloat(item.childNodes[3].value);
	const param = item.childNodes[5].value;

	const aptName = item.childNodes[7].innerText;
	
	// 마커 이미지의 이미지 크기 입니다
	imageSize = new kakao.maps.Size(30, 45); 
	
	// 마커 이미지를 생성합니다    
    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
	
	positions[i++]={
			title: aptName,
    		latlng: new kakao.maps.LatLng(latitude, longtitude),
    		content: '<div>'+aptName+'</div>',
    		text : param
	}
});

//지도를 재설정할 범위정보를 가지고 있을 LatLngBounds 객체를 생성합니다
var bounds = new kakao.maps.LatLngBounds(); 
var marker;
for (var i = 0; i < positions.length; i ++) {

    // 마커 이미지의 이미지 크기 입니다
    var imageSize = new kakao.maps.Size(27, 40); 
    
    // 마커 이미지를 생성합니다    
    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
    
    // 마커를 생성합니다
    marker = new kakao.maps.Marker({
        map: map, // 마커를 표시할 지도
        position: positions[i].latlng, // 마커를 표시할 위치
        title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
        image : markerImage // 마커 이미지 
    });
    var infowindow = new kakao.maps.InfoWindow({
        content: positions[i].content // 인포윈도우에 표시할 내용
    });
    kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
    kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
    kakao.maps.event.addListener(marker, 'click', makeClickListener(positions[i].text, positions[i].latlng));
    
    bounds.extend(positions[i].latlng);
    panTo(positions[i].latlng)
}
function panTo(location) {
	map.setCenter(location);
    map.panTo(location);            
}

//장소 검색 객체를 생성합니다
var ps = new kakao.maps.services.Places(map); 

// 지도에 idle 이벤트를 등록합니다
kakao.maps.event.addListener(map, 'idle', searchPlaces);

// 커스텀 오버레이의 컨텐츠 노드에 css class를 추가합니다 
contentNode.className = 'placeinfo_wrap';

// 커스텀 오버레이의 컨텐츠 노드에 mousedown, touchstart 이벤트가 발생했을때
// 지도 객체에 이벤트가 전달되지 않도록 이벤트 핸들러로 kakao.maps.event.preventMap 메소드를 등록합니다 
addEventHandle(contentNode, 'mousedown', kakao.maps.event.preventMap);
addEventHandle(contentNode, 'touchstart', kakao.maps.event.preventMap);

// 커스텀 오버레이 컨텐츠를 설정합니다
placeOverlay.setContent(contentNode);  

// 각 카테고리에 클릭 이벤트를 등록합니다
addCategoryClickEvent();

// 엘리먼트에 이벤트 핸들러를 등록하는 함수입니다
function addEventHandle(target, type, callback) {
    if (target.addEventListener) {
        target.addEventListener(type, callback);
    } else {
        target.attachEvent('on' + type, callback);
    }
}

// 카테고리 검색을 요청하는 함수입니다
function searchPlaces() {
    if (!currCategory) {
        return;
    }
    
    // 커스텀 오버레이를 숨깁니다 
    placeOverlay.setMap(null);

    // 지도에 표시되고 있는 마커를 제거합니다
    removeMarker();
    
    ps.categorySearch(currCategory, placesSearchCB, {useMapBounds:true}); 
}

// 장소검색이 완료됐을 때 호출되는 콜백함수 입니다
function placesSearchCB(data, status, pagination) {
    if (status === kakao.maps.services.Status.OK) {

        // 정상적으로 검색이 완료됐으면 지도에 마커를 표출합니다
        displayPlaces(data);
    } else if (status === kakao.maps.services.Status.ZERO_RESULT) {
        // 검색결과가 없는경우 해야할 처리가 있다면 이곳에 작성해 주세요

    } else if (status === kakao.maps.services.Status.ERROR) {
        // 에러로 인해 검색결과가 나오지 않은 경우 해야할 처리가 있다면 이곳에 작성해 주세요
        
    }
}

// 지도에 마커를 표출하는 함수입니다
function displayPlaces(places) {

    // 몇번째 카테고리가 선택되어 있는지 얻어옵니다
    // 이 순서는 스프라이트 이미지에서의 위치를 계산하는데 사용됩니다
    var order = document.getElementById(currCategory).getAttribute('data-order');

    for ( var i=0; i<places.length; i++ ) {

            // 마커를 생성하고 지도에 표시합니다
            var marker = addMarker(new kakao.maps.LatLng(places[i].y, places[i].x), order);

            // 마커와 검색결과 항목을 클릭 했을 때
            // 장소정보를 표출하도록 클릭 이벤트를 등록합니다
            (function(marker, place) {
                kakao.maps.event.addListener(marker, 'click', function() {
                    displayPlaceInfo(place);
                });
            })(marker, places[i]);
    }
}

// 마커를 생성하고 지도 위에 마커를 표시하는 함수입니다
function addMarker(position, order) {
    var imageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/places_category.png', // 마커 이미지 url, 스프라이트 이미지를 씁니다
        imageSize = new kakao.maps.Size(27, 28),  // 마커 이미지의 크기
        imgOptions =  {
            spriteSize : new kakao.maps.Size(72, 208), // 스프라이트 이미지의 크기
            spriteOrigin : new kakao.maps.Point(46, (order*36)), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
            offset: new kakao.maps.Point(11, 28) // 마커 좌표에 일치시킬 이미지 내에서의 좌표
        },
        markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imgOptions),
            marker = new kakao.maps.Marker({
            position: position, // 마커의 위치
            image: markerImage 
        });

    marker.setMap(map); // 지도 위에 마커를 표출합니다
    markers.push(marker);  // 배열에 생성된 마커를 추가합니다

    return marker;
}

// 지도 위에 표시되고 있는 마커를 모두 제거합니다
function removeMarker() {
    for ( var i = 0; i < markers.length; i++ ) {
        markers[i].setMap(null);
    }   
    markers = [];
}

// 클릭한 마커에 대한 장소 상세정보를 커스텀 오버레이로 표시하는 함수입니다
function displayPlaceInfo (place) {
    var content = '<div class="placeinfo">' +
                    '   <a class="title" href="' + place.place_url + '" target="_blank" title="' + place.place_name + '">' + place.place_name + '</a>';   

    if (place.road_address_name) {
        content += '    <span title="' + place.road_address_name + '">' + place.road_address_name + '</span>' +
                    '  <span class="jibun" title="' + place.address_name + '">(지번 : ' + place.address_name + ')</span>';
    }  else {
        content += '    <span title="' + place.address_name + '">' + place.address_name + '</span>';
    }                
   
    content += '    <span class="tel">' + place.phone + '</span>' + 
                '</div>' + 
                '<div class="after"></div>';

    contentNode.innerHTML = content;
    placeOverlay.setPosition(new kakao.maps.LatLng(place.y, place.x));
    placeOverlay.setMap(map);  
}


// 각 카테고리에 클릭 이벤트를 등록합니다
function addCategoryClickEvent() {
    var category = document.getElementById('category'),
        children = category.children;

    for (var i=0; i<children.length; i++) {
        children[i].onclick = onClickCategory;
    }
}

// 카테고리를 클릭했을 때 호출되는 함수입니다
function onClickCategory() {
    var id = this.id,
        className = this.className;

    placeOverlay.setMap(null);

    if (className === 'on') {
        currCategory = '';
        changeCategoryClass();
        removeMarker();
    } else {
        currCategory = id;
        changeCategoryClass(this);
        searchPlaces();
    }
}

// 클릭된 카테고리에만 클릭된 스타일을 적용하는 함수입니다
function changeCategoryClass(el) {
    var category = document.getElementById('category'),
        children = category.children,
        i;

    for ( i=0; i<children.length; i++ ) {
        children[i].className = '';
    }

    if (el) {
        el.className = 'on';
    } 
} 

//인포윈도우를 표시하는 클로저를 만드는 함수입니다 
function makeOverListener(map, marker, infowindow) {
    return function() {
        infowindow.open(map, marker);
    };
}

// 인포윈도우를 닫는 클로저를 만드는 함수입니다 
function makeOutListener(infowindow) {
    return function() {
        infowindow.close();
    };
}

function makeClickListener(aptinfo, location) {
	return function() {
		showDetail(aptinfo+"/"+location.Ma+"/"+location.La);
	};
}

function makeView(loc1, loc2){
	var roadviewContainer = document.getElementById('roadview'); //로드뷰를 표시할 div
	var roadview = new kakao.maps.Roadview(roadviewContainer); //로드뷰 객체
	var roadviewClient = new kakao.maps.RoadviewClient(); //좌표로부터 로드뷰 파노ID를 가져올 로드뷰 helper객체
	
	console.log(loc1+" "+loc2);
	/* var position = location;
	
	// 특정 위치의 좌표와 가까운 로드뷰의 panoId를 추출하여 로드뷰를 띄운다.
	roadviewClient.getNearestPanoId(position, 50, function(panoId) {
	    roadview.setPanoId(panoId, position); //panoId와 중심좌표를 통해 로드뷰 실행
	}); */
}
</script>
</body>
</html>