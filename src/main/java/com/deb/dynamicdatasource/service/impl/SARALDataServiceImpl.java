package com.deb.dynamicdatasource.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deb.dynamicdatasource.entity.SARALData;
import com.deb.dynamicdatasource.repo.SARALDataRepo;
import com.deb.dynamicdatasource.service.SARALDataService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class SARALDataServiceImpl implements SARALDataService{
	
	
	@Autowired
	private SARALDataRepo saralDataRepo;
	
	@Override
	public String getFtpPath() {
		List<SARALData>  list = (List<SARALData>) saralDataRepo.findAll();
		return list.get(0).getFtpPath();
	}

}
