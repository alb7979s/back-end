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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> <!-- 아이콘 라이브러리 -->
<title>HappyHouse</title>
<link rel="stylesheet" href="${root}/css/main.css">

</head>
<body>
    <%@include file="../main/header.jsp" %>

	<div class="jumbotron text-center">
      <h1>Happy House</h1>
    </div>
    
    <div class="fluid" style="margin:30px 20px 0px; ">
	  <div class="row">
	    <div class="col-md-4">
	      <h2>나의 관심지역</h2>
	      <button class="btn-for-fav" onclick="getCityList();" data-toggle="modal" data-target="#exampleModal"><i class="fa fa-plus"></i></button>
	      </br></b2>
	      <!-- 관심지역 리스트로 뿌려주기 -->
	      <div>
	      <c:if test="${empty favoriteList}">
	      <h2>관심 지역을 추가해보세요!</h2>
	      </c:if>
	      <c:if test="${not empty favoriteList}">
	      <table class="table" style="font-size: 20px">
			  <thead>
			    <tr>
			      <th scope="col">#</th>
			      <th scope="col">시도</th>
			      <th scope="col">구군</th>
			      <th scope="col">동</th>
			    </tr>
			  </thead>
			  <tbody>
			  	<c:forEach var="list" items="${favoriteList}" varStatus="loop">
			    <tr>
			    <input type="hidden" value="${list.city}">
			    <input type="hidden" value="${list.gugun}">
			    <input type="hidden" value="${list.dong}">
			      <th scope="row">${loop.index+1 }</th>
			      <td>${list.city }</td>
			      <td>${list.gugun }</td>
			      <td>${list.dong }</td>
			    </tr>
			  	</c:forEach>
			  </tbody>
			</table>
	      </c:if>
	      </div>
	    </div>
	    
	    <div class="col-md-8" id="favDetail">
	     
	    </div>
	  </div>
	</div>
    
    
    <!-- 모달 -->
    <div class="modal modal-center fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog modal-dialog-fav" role="document">
	    <div class="modal-content modal-content-fav">
	      <div class="modal-header">
	        <h3 class="modal-title" id="exampleModalLabel">관심지역 추가하기</h3>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        
	      <select class="form-select" name="city" id="city" onchange="getGugunList(this.value)" aria-label="Default select example">
			  <option value="" name="city">도/광역시</option>
		  </select>
	      <select class="form-select" name="gugun" id="gugun" onchange="getDongList(this.value)" aria-label="Default select example">
			  <option value="" name='gugun'>시/구/군</option>
		  </select>
	      <select class="form-select" name="dong" id="dong" aria-label="Default select example">
			  <option value="" name='dong'>동</option>
		  </select>
	        
	      </div>
	      <div class="modal-footer">
	        <button type="button" onclick="save();" class="btn btn-primary">저장하기</button>
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">취소하기</button>
	      </div>
	    </div>
	  </div>
	</div>


    <script>
    	let msg = "${msg}"
    	if(msg){
    		console.log(msg);
    		alert(msg);
    		location.href="${root}/member/moveLogin";
    	}
    	
    	function getCityList(){
    	 $.ajax({
    		 url:"/sido",
    		 method:"post",
    		 dataType: "json",
    		 contentType:"application/json; charset=UTF-8",
    		 success:function(sido){
    			 console.dir(sido)
    			 $("#dong").empty().append( "<option value=''> 동 </option>" )

    			 list = sido.sidoName;
    			 list2 = sido.sidoCode;
    			 
    			 for(let i =0; i<list.length; i++){
    				 //console.log(list[i]+" "+list2[i]);
    				 $("#city").append( "<option value='"+list2[i]+"' name='city'> "+ list[i]+" </option>" )
    			 }
    			 
    		 }
    	 })
    	}
    	
    	 function getGugunList(sidoCode){
    		 console.log(sidoCode);
    		 $.ajax({
    		 url:"/gugun",
    		 data: sidoCode,
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
    	 	})
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
    	 
    	 function save(){
 
    		 var datas = {
    				 "city":$('#city option:selected').val(),
    				 "gugun":$('#gugun option:selected').val(),
    				 "dong":$('#dong option:selected').val()
    		 };
    		 //정보 디비에 저장하고
    		 $.ajax({
    			 url:"/save",
    			 data: JSON.stringify(datas),
    			 method:"post",
        		 contentType:"application/json; charset=UTF-8",
    			 success:function(data){
    		 		//console.log("관심 지역 저장 "+data);
    		 		location.reload();
    			 }
    		 })
    	 }
    	 
    	 const tbody = document.querySelector("tbody");
    		tbody.addEventListener('click',function(e){
    			if(e.target.nodeName === "TD"){
    		//		console.log("${root}");
    				const city = e.target.parentNode.children[0].value;
    				const gugun =e.target.parentNode.children[1].value;
    				const dong = e.target.parentNode.children[2].value;
    				
    				 $.ajax({
    	    			 url:"/favorite",
    	    			 method:"post",
    	        		 contentType:"application/json; charset=UTF-8",
    	    			 success:function(data){
    	    		 		//console.log("관심지역 상세 조회하기");
    	    		 		makeDetail(city, gugun,dong);
    	    			 }
    	    		 })
    				
    			}else{
    				//location.href="${root}/main?act=detail&number=" + e.target.children[0].value;			
    			}
    			
    	},true);
    		
    	function makeDetail(city, gugun,dong){
    		$("#favDetail").empty();
    		//console.log(city+" "+gugun+" "+dong);
    		details = ''
    		
    		details+='<h2>'+city+' '+gugun+' '+dong+'의 정보입니다.</h2>'
    		details+='<button onclick="moveClinic(`'+city+'`,`'+gugun+'`);" style="margin-right:30px;" type="button" class="btn btn-lg btn-primary">선별 진료소 보러가기</button>'
    		details+='<button onclick="moveHospital(`'+city+'`,`'+gugun+'`);" style="margin-right:30px;" type="button" class="btn btn-lg btn-primary">안심병원 보러가기</button>'
    		//details+='<button type="button" class="btn btn-lg btn-primary">선별 진료소 보러가기</button>'
    		details+='</br><h2>금주의 인기매물 TOP 3</h2>'
    		
    		$("#favDetail").append(details);
    	}
    	function moveClinic(city,gugun){
    		//console.log(city+" "+gugun);
    		location.href="${root}/clinic/search?city="+city+"&gugun="+gugun;
    	}
    	function moveHospital(city,gugun){
    		//console.log(city+" "+gugun);
    		location.href="${root}/hospital/search?city="+city+"&gugun="+gugun;
    	}
    </script>
</body>
</html>