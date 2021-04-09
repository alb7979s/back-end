package com.happyhouse.model.service;

import java.util.List;

import com.happyhouse.model.ClinicDto;

public interface ClinicService {
	public List<ClinicDto> clinicList() throws Exception;
}
