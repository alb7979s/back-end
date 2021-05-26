package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.Comment;

@Service
public interface CommentService {
	List<Comment> commentListService() throws Exception;
    int commentInsertService(Comment comment) throws Exception;
    int commentUpdateService(Comment comment) throws Exception;
    int commentDeleteService(int no) throws Exception;
}
