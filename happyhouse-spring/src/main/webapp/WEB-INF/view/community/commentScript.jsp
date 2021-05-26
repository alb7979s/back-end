<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<script>
var boardno = '${detail.boardno}'; //게시글 번호
 
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
                a += '<div class="commentInfo'+value.no+'">'+'댓글번호 : '+value.no+' / 작성자 : '+value.userid;
                a += '<a onclick="commentUpdate('+value.no+',\''+value.content+'\');"> 수정 </a>';
                a += '<a onclick="commentDelete('+value.no+');"> 삭제 </a> </div>';
                a += '<div class="commentContent'+value.no+'"> <p> 내용 : '+value.content +'</p>';
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
