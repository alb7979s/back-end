package com.ssafy.happyhouse.service;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.dto.Hospital;
import com.ssafy.happyhouse.dto.Page;

public interface HospitalService {
	public List<Hospital> hospitalList() throws Exception;

	public Map<String, Object> listhospitalPage(Page page);
}
