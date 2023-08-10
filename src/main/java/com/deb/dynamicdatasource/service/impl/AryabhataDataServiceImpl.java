package com.deb.dynamicdatasource.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deb.dynamicdatasource.entity.AryabhataData;
import com.deb.dynamicdatasource.repo.AryabhataDataRepo;
import com.deb.dynamicdatasource.service.AryabhataDataService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class AryabhataDataServiceImpl implements AryabhataDataService{

	
	@Autowired
	private AryabhataDataRepo aryabhatDataRepo;
	@Override
	public String getFtpPath() {
		
		List<AryabhataData>  list = (List) aryabhatDataRepo.findAll();
		return list.get(0).getFtpPath();
	}

}
