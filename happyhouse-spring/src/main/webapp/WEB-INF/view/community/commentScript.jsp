<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<script>
var boardno = '${community.no}'; //게시글 번호
 
$('[name=commentInsertBtn]').click(function(){ //댓글 등록 버튼 클릭시 
    var insertData = $('[name=commentInsertForm]').serialize(); //commentInsertForm의 내용을 가져옴
    console.log(insertData);
    commentInsert(insertData); //Insert 함수호출
});
 
 
 
//댓글 목록 
function commentList(){
    $.ajax({
        url : '/comment',
        type : 'GET',
        data : {'boardno':boardno},
        success : function(data){
            var a =''; 
            $.each(data, function(key, value){ 
                a += '<div class="commentArea" style="border-bottom:1px solid darkgray; margin-bottom: 15px;">';
                a += '<div class="commentInfo'+value.no+'">'+ '작성자 : ';
                if(value.userid == '${community.userid}'){ a += '익명(글쓴이)';}
                else { a += '익명';}
                if(value.userid == '${userinfo.id}'){
	                a += '<span class="float-right"><a onclick="commentUpdate('+value.no+',\''+value.content+'\');"> 수정 </a>';
	                a += '<a onclick="commentDelete('+value.no+');"> &nbsp;삭제 </a></span>';
                }
                a += '</div><div class="commentContent'+value.no+'"> <p> 내용 : '+value.content +'</p>';
                a += '</div></div>';
            });
            
            $(".commentList").html(a);
        }
    });
}
 
//댓글 등록
function commentInsert(insertData){
    $.ajax({
        url : '/comment',
        type : 'POST',
        data : insertData,
        success : function(data){
            if(data == 1) {
                commentList(); //댓글 작성 후 댓글 목록 reload
                $('[name=content]').val('');
            }
        }
    });
}
 
//댓글 수정 - 댓글 내용 출력을 input 폼으로 변경 
function commentUpdate(no, content){
    var a ='';
    
    a += '<div class="input-group">';
    a += '<input type="text" class="form-control" name="content_'+no+'" value="'+content+'"/>';
    a += '<span class="input-group-btn"><button class="btn btn-default" type="button" onclick="commentUpdateProc('+no+');">수정</button> </span>';
    a += '</div>';
    
    $('.commentContent'+no).html(a);
    
}
 
//댓글 수정
function commentUpdateProc(no){
    var updateContent = $('[name=content_'+no+']').val();
    
    $.ajax({
        url : '/comment',
        type : 'PUT',
        data : {'content' : updateContent, 'no' : no},
        success : function(data){
            if(data == 1) commentList(boardno); //댓글 수정후 목록 출력 
        }
    });
}
 
//댓글 삭제 
function commentDelete(no){
    $.ajax({
        url : '/comment/'+no,
        type : 'DELETE',
        success : function(data){
            if(data == 1) commentList(boardno); //댓글 삭제후 목록 출력 
        }
    });
}
 
 
$(document).ready(function(){
    commentList(); //페이지 로딩시 댓글 목록 출력 
});
 
 
 
</script>
