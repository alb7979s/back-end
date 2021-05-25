package com.ssafy.happyhouse.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ssafy.happyhouse.dto.Member;
import com.ssafy.happyhouse.dto.MyFile;

public interface FileService {

	Member setThumbnail(Member member, MultipartFile mf) throws IOException;

	void setFiles(MultipartFile[] files, int boardNo) throws IOException, SQLException;

	List<MyFile> getFiles(int boardNo);

}