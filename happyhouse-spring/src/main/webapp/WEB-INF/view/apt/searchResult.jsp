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
		  
<title>HappyHouse</title>
<link rel="stylesheet" href="${root}/css/main.css">

<script type="text/javascript">

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


<script>
let map, seoul;
let minx=1000,miny=1000, maxx =-1, maxy=-1;
let contentString = '<div class="aptInfo" style="width:350px;height:200px;"><h2>';
let contentString2 = '<div style="width:100px;height:50px;">ssssssssss</div>';

		function initMap(){
			var latitude = 37.566536;
			var longtitude = 126.97797;
			
			var seoul = {lat:latitude, lng:longtitude};
			var marker;
			map = new google.maps.Map(document.getElementById("map"), {
				//마커가 없으면 보이는 지도 화면
		        zoom: 15,
		        center: seoul,
		        position:seoul,
			});
			
			var infowindow = new google.maps.InfoWindow({
				content: contentString,
				size: new google.maps.Size(200,100)
			});
			
			var image = '../images/icons/home.png'; 
		    $('.aptPanel').each((index, item) => {
		    	const latitude = parseFloat(item.childNodes[1].value); 
		    	const longtitude = parseFloat(item.childNodes[3].value);
		    	const param = item.childNodes[5].value;
		 
		    	const aptName = item.childNodes[7].innerText;
		    	const aptinfo = item.childNodes[9].innerText;

		    	var info = aptinfo.split('\n');
		        /* for ( var i in info ) {
		          console.log(i+" "+info[i]);
		        } */
		    	
		    	var str = contentString+aptName+"</h2> ";
		    	str += "<p>"+info[0]+"</p>"; 
		    	str += "<p>"+info[2]+"</p>"; 
		    	str += "<p>"+info[4]+"</p>"; 
		    	str += "</div>";
		    	
		    	//좌표들의 중심점을 구하기 위한 코드
		    	if(miny>latitude) miny=latitude;
		    	if(minx>longtitude) minx=longtitude;
		    	if(maxy<latitude) maxy=latitude;
		    	if(maxx<longtitude) maxx=longtitude;
		    	
		       	var loc={lat:latitude, lng:longtitude};
		       	
		    	marker = new google.maps.Marker({
		    		position:loc,
					title:aptName,
					center: loc,
					map:map,
					zoom:15,
					icon:image
				});
		    	google.maps.event.addListener(marker, 'mouseover', (function(marker, index) {
                    return function() { 
                        //html로 표시될 인포 윈도우의 내용
                        infowindow.setContent(str);
                        
                        //인포윈도우가 표시될 위치
                        infowindow.open(map, marker);
                    }
                })(marker, index));
		    	google.maps.event.addListener(marker, 'mouseout', (function(marker, index) {
                    return function() {
                        infowindow.close();
                    }
                })(marker, index));
		    	google.maps.event.addListener(marker, 'click', (function(marker, index) {
                    return function() {
                    	console.log(param);
                    	showDetail(param);
                    }
                })(marker, index));
		   	})
		   	
		   	if(marker !=null){ //마커가 있을 경우
			   	//좌표들의 중심점이 되는 위도, 경도 계산
		    	latitude = (maxy-miny)/2+miny;
			    longtitude = (maxx-minx)/2+minx;
			    loc={lat:latitude, lng:longtitude};
			    //console.log(loc);
			    
		    	map.setCenter(loc);
		   	}
		    
	    	google.maps.event.addDomListener(window, 'load', initMap);
		}
		
		function showLocation(latitude,longtitude){
			var loc={lat:parseFloat(latitude), lng:parseFloat(longtitude)};
			map.setCenter(loc);
	    	map.setZoom(18);
		}
</script>


</head>
<body style="height: 100%;">

    <%@include file="../main/header.jsp" %>

	
	<div style="height:80px">
	</div>
<!-- 	<div class="jumbotron text-center">
      <h1>Happy House</h1> 
    </div> -->
    
	<div class="container" style="width:100%; max-height: 100%;">
		<div class="row">
			<div class="col-md-3">
			  <p style="font-size: 130%;">실거래가를 검색해보세요!</p>
		      <div style="margin-left:10px; display: inline-block; text-align:center; width:100%;">
		        <form id="searchform" method="get" action="">
		            <div class="input-group">
		                <select class="form-control" name="key" id="key" style="width:100px;">
		                    <option value="dong"  <c:if test="${result.key =='dong'}">selected</c:if>>동</option>
					    	<option value="AptName"  <c:if test="${result.key =='AptName'}">selected</c:if>>아파트</option>
		                </select>
		            	<input type="text" class="form-control" id="word" name="word" size="50" value="${result.word}" placeholder="검색어를 입력해주세요" style="width:300px;">
		            	<button onclick="searchCity();" type="button" class="btn btn-warning"><span class="glyphicon glyphicon-search"></span></button>
		            </div>
		        </form>
		      </div>
		      
		      <div class = "my-custom-scrollbar my-custom-scrollbar-primary" style="overflow-y:auto; position:absolute; text-align:center; width:100%; max-height: 700px;">
		      <div>
		      <!-- 아파트 리스트 출력하는 부분 -->
		      <c:if test="${empty result.aptinfo and empty result.first}">
		      	<h3>검색 결과가 없습니다.</h3>
		      </c:if>
		      
		      <c:if test="${not empty result.aptinfo }">
		      	<c:forEach var="apt" items="${result.aptinfo}">
		      	 <!-- <div class="col-sm-6"> -->
		            <div  class="aptPanel panel panel-default text-center" 
		            onclick="showDetail(`${apt.dong}/${apt.aptName}/${apt.dealAmount}/${apt.dealYear}.${apt.dealMonth}.${apt.dealDay}/${apt.area}/${apt.floor}/${apt.jibun}/${apt.lat}/${apt.lng}`)">
		            
	                <input type="hidden" value="${apt.lat}">
	                <input type="hidden" value="${apt.lng}">
	                
	                <input type="hidden" value="${apt.dong}/${apt.aptName}/${apt.dealAmount}/${apt.dealYear}.${apt.dealMonth}.${apt.dealDay}/${apt.area}/${apt.floor}/${apt.jibun}/${apt.lat}/${apt.lng}">
	                
		              <div class="panel-heading">
		                <p>${apt.aptName}</p>
		              </div>
		              <div class="panel-body" style="margin-top:5px;">
		                <p><strong> 거래금액 </strong> ${apt.dealAmount} </p>
		                <p><strong> 면적 </strong> ${apt.area} </p>
		                <p><strong><span class="glyphicon glyphicon-calendar"></span></strong> ${apt.dealYear}.${apt.dealMonth}.${apt.dealDay} </p>
		              </div>
		            </div>
		            <!-- </div> -->
				</c:forEach>
		      </c:if>
		      </div>
		      </div>
			</div>
			
			<div class="col-md-5">
				<div>
				<div id="map" style="width:100%; height:800px;">
				</div>
				</div>
			</div>
			<div class="col-md-4" id="aptDetail">
				div 3
				<!-- 아파트 상세 정보를 띄울 부분 -->
			</div>
		</div>
	</div>
	
	
<!-- 구글 지도 -->
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB85YwpkRQ0wsKpmlijWPoSs7ENVtJdkfg&callback=initMap" async defer></script>

<script>

function showDetail(aptinfo){
	$("#aptDetail").empty();
	
	
	//console.log(aptinfo);
	var info = aptinfo.split('/');
   /*  for ( var i in info ) {
      console.log(info[i]);
    } */
	//지도 변경
	showLocation(info[7],info[8]);

	details=''
    details+='<img></img>'
    details='<h2>['+info[0]+'] <strong>' +info[1]+'</strong></h2>'
    details+='<table class="table">'
    details+='<tr><th>거래금액</th><td>'+info[2]+'</td><th>거래일</th><td>'+info[3]+'</td></tr>'
    details+='<tr><th>평수</th><td>'+info[4]+'</td><th>층</th><td>'+info[5]+'</td></tr>'
    //details+='<tr><th>건설년도</th><td>'+info[6]+'</td><th><td></td></th></tr>'
   	details+='</table>'
    
    //details+=
    $("#aptDetail").append(details);
}
</script>

</body>
</html>