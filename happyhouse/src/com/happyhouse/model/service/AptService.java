package com.happyhouse.model.service;

import java.util.List;

import com.happyhouse.model.AptDto;

public interface AptService {
	public List<AptDto> aptSearch(String key, String word) throws Exception;
}
