package com.ssafy.happyhouse.service;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.happyhouse.dto.Member;
import com.ssafy.happyhouse.dto.MyFile;
import com.ssafy.happyhouse.mapper.FileMapper;
import com.ssafy.happyhouse.util.FileUtil;

import net.coobird.thumbnailator.Thumbnails;

@Service
public class FileServiceImpl implements FileService {
	@Autowired
	private FileUtil fileUtil;
	@Autowired
	private FileMapper fileMapper;
	
	@Override
	@Transactional
	public Member setThumbnail(Member member, MultipartFile mf) throws IOException {
		File file = fileUtil.makeDir("/member");
		File f = fileUtil.makeName(mf.getOriginalFilename(), file);
		mf.transferTo(f);	//파일 저장
		// 썸네일 저장
		Thumbnails.of(f)
			.size(300, 200)
			.toFile(new File(f.getParent(), "thumb_" + f.getName()));
		member.setProfilepath(f.getParent());
		member.setProfilename("thumb_" + f.getName());
		return member;
	}
	@Override
	@Transactional
	public void setFiles(MultipartFile[] files, int boardNo) throws IOException, SQLException {
		File file = fileUtil.makeDir("/file");
		for(MultipartFile mf: files) {
			// file 생성
			String orgName = mf.getOriginalFilename();
			File f = fileUtil.makeName(orgName, file);
			mf.transferTo(f);
			// db 저장
			String contentType = fileUtil.getType(orgName);
			MyFile myFile = new MyFile(boardNo, mf.getSize(), f.getParent(), orgName, f.getName(), contentType);
			fileMapper.insertFile(myFile);
		}
		return;
	}
	@Override
	public List<MyFile> getFiles(int boardNo) {
		return fileMapper.getFile(boardNo);
	}
}
