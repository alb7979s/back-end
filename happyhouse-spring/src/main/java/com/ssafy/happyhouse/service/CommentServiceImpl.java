package com.ssafy.happyhouse.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.dto.Comment;
import com.ssafy.happyhouse.dto.Community;
import com.ssafy.happyhouse.dto.Hospital;
import com.ssafy.happyhouse.dto.Page;
import com.ssafy.happyhouse.dto.PageResult;
import com.ssafy.happyhouse.mapper.CommentMapper;
import com.ssafy.happyhouse.mapper.CommunityMapper;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private CommentMapper commentMapper;

	@Override
	public List<Comment> commentListService() throws Exception {
		return commentMapper.commentList();
	}

	@Override
	public int commentInsertService(Comment comment) throws Exception {
		return commentMapper.commentInsert(comment);
	}

	@Override
	public int commentUpdateService(Comment comment) throws Exception {
		return commentMapper.commentUpdate(comment);
	}

	@Override
	public int commentDeleteService(int no) throws Exception {
		return commentMapper.commentDelete(no);
	}
}
