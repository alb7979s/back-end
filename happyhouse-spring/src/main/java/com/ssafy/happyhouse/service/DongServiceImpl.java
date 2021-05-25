package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.Dong;
import com.ssafy.happyhouse.mapper.DongMapper;

@Service
public class DongServiceImpl implements DongService{

	@Autowired
	private DongMapper dongMapper;
	
	public List<Dong> getDongInfo(String dong) {
		return dongMapper.getDongInfo(dong);
	}

}
