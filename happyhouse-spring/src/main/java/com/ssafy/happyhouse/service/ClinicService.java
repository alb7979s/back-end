package com.ssafy.happyhouse.service;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.dto.Clinic;
import com.ssafy.happyhouse.dto.Page;

public interface ClinicService {
	public List<Clinic> clinicList() throws Exception;

	public Map<String, Object> listclinicPage(Page page);

	Map<String, Object> searchClinicPage(Page page, Map<String, Object> param);
}
