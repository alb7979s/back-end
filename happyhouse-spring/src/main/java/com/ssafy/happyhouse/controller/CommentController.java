package com.ssafy.happyhouse.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.Comment;
import com.ssafy.happyhouse.dto.Member;
import com.ssafy.happyhouse.service.CommentService;

@RestController
@RequestMapping("/comment")
public class CommentController {
 
    @Autowired
    CommentService commentService;
    
    @GetMapping
    private List<Comment> commentServiceList(Model model, @RequestParam("boardno") Integer boardno) throws Exception{
    	System.out.println(boardno);
        return commentService.commentListService(boardno);
    }
    
    @PostMapping 
    private int commentServiceInsert(@RequestParam("no") int boardNo, @RequestParam String content, HttpSession session) throws Exception{
        Comment comment = new Comment();
        comment.setBoardno(boardNo);
        comment.setContent(content);
        comment.setUserid(((Member)session.getAttribute("userinfo")).getId());  
        return commentService.commentInsertService(comment);
    }
    
    @PutMapping  
    private int commentServiceUpdateProc(@RequestParam int no, @RequestParam String content) throws Exception{
        Comment comment = new Comment();
        comment.setNo(no);
        comment.setContent(content);
        return commentService.commentUpdateService(comment);
    }
    
    @DeleteMapping("{no}")
    private int commentServiceDelete(@PathVariable int no) throws Exception{
        return commentService.commentDeleteService(no);
    }
    
}
