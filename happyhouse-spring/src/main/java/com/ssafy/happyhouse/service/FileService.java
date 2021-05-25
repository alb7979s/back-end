package com.ssafy.happyhouse.service;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.web.multipart.MultipartFile;

import com.ssafy.happyhouse.dto.Member;

public interface FileService {

	Member setThumbnail(Member member, MultipartFile mf) throws IOException;

	void setFiles(MultipartFile[] files, int boardNo) throws IOException, SQLException;

}