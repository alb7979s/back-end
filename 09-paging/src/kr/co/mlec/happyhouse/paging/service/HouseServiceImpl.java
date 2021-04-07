package kr.co.mlec.happyhouse.paging.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.co.mlec.happyhouse.repository.dao.HouseDao;
import kr.co.mlec.happyhouse.repository.dao.HouseDaoImpl;
import kr.co.mlec.happyhouse.repository.dto.HouseDto;
import kr.co.mlec.happyhouse.repository.dto.PageDto;
import kr.co.mlec.happyhouse.repository.dto.PageResultDto;

public class HouseServiceImpl implements HouseService {
	private HouseDao dao;
	public HouseServiceImpl() {
		dao = new HouseDaoImpl();
	}
	
	/*
	 * 페이징 없이 사용
	 */
	@Override
	public List<HouseDto> listPageHouse1() throws Exception {
		// 게시물 목록 데이터 조회
		List<HouseDto> list = dao.selectHouse();
		return list;
	}
	/*
	 *  페이징 사용 - 1
	 */
	@Override
	public Map<String, Object> listPageHouse2(PageDto pageDto) throws Exception {
		// 게시물 목록 데이터 조회
		List<HouseDto> list = dao.selectHouse(pageDto);
		// 페이징을 위해서 게시물 전체 갯수, service나 controller에서 할 수 있는데 화면에 필요한 모든 데이터 구하는거 service가 좋대유
		int count = dao.selectHouseCount();
		Map<String, Object>	result = new HashMap<>();//List도 받아야하고 int도 받아야하니 Object를 줌
		result.put("list", list);
		result.put("count", count);
		return result;
	}
	
	/*
	 *  페이징 사용 - 2 : 페이징 모듈화
	 */
	@Override
	public Map<String, Object> listPageHouse3(PageDto pageDto) throws Exception {
		// 게시물 목록 데이터 조회
		List<HouseDto> list = dao.selectHouse(pageDto);
		// 페이징을 위해서 게시물 전체 갯수, service나 controller에서 할 수 있는데 화면에 필요한 모든 데이터 구하는거 service가 좋대유
		int count = dao.selectHouseCount();
		
		// 아래 같은 계산 service에서 하는게 좋대(자신의 철학을 갖고 짜야 일관됨)
		PageResultDto prd = new PageResultDto(pageDto.getPageNo(), count);
		Map<String, Object>	result = new HashMap<>();//List도 받아야하고 int도 받아야하니 Object를 줌
		result.put("list", list);
		result.put("pageResult", prd);
		return result;
	}
}
