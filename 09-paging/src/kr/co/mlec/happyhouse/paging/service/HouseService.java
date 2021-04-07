package kr.co.mlec.happyhouse.paging.service;

import java.util.List;
import java.util.Map;

import kr.co.mlec.happyhouse.repository.dto.HouseDto;
import kr.co.mlec.happyhouse.repository.dto.PageDto;

public interface HouseService {

	List<HouseDto> listPageHouse1() throws Exception;
	Map<String, Object> listPageHouse2(PageDto pageDto) throws Exception;
	Map<String, Object> listPageHouse3(PageDto pageDto) throws Exception;
	
}