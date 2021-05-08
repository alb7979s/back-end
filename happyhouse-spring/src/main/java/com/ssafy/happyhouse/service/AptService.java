package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.Apt;

public interface AptService {
	public List<Apt> aptSearch(String key, String word) throws Exception;
}
