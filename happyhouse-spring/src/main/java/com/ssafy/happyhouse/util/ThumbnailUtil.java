package com.ssafy.happyhouse.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.happyhouse.dto.Member;

import net.coobird.thumbnailator.Thumbnails;

@Repository
public class ThumbnailUtil {
	public Member setThumbnail(Member member, MultipartFile files) throws IOException {
		// 썸네일 저장
		String uploadRoot = "c:/happyhouse/upload";
		String path = "/member" + new SimpleDateFormat("/yyyy/MM/dd").format(new Date());
		File file = new File(uploadRoot + path);
		if(!file.exists()) file.mkdirs();
		// 원래 파일명에서 확장자 떼어와서 유니크한 이름 생성
		String name = files.getOriginalFilename();
		String ext = "";
 		int index = name.lastIndexOf(".");
		if (index != -1) {
			ext = name.substring(index);
		}
		File f = new File(file.getPath(), UUID.randomUUID() + ext);
		files.transferTo(f);
		Thumbnails.of(f)
			.size(300, 200)
			.toFile(new File(f.getParent(), "thumb_" + f.getName()));
		member.setProfilepath(f.getParent());
		member.setProfilename("thumb_" + f.getName());
		return member;
	}
}
