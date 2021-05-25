package com.ssafy.happyhouse.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Repository;

@Repository
public class FileUtil {
	public File makeDir(String loc) {
		String uploadRoot = "c:/happyhouse/upload";
		String path = loc + new SimpleDateFormat("/yyyy/MM/dd").format(new Date());
		File file = new File(uploadRoot + path);
		if(!file.exists()) file.mkdirs();
		return file;
	}
	public String getType(String name) {
		int index = name.lastIndexOf(".");
		if (index != -1) {
			return name.substring(index);
		}
		return "";
	}
	public File makeName(String name, File file) {
		String ext = getType(name);
		File f = new File(file.getPath(), UUID.randomUUID() + ext);
		return f;
	}
	
}
