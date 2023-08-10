package com.deb.dynamicdatasource.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deb.dynamicdatasource.entity.Proclist;
import com.deb.dynamicdatasource.repo.ProclistRepo;
import com.deb.dynamicdatasource.service.ProclistService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ProclistServiceImpl implements ProclistService{
	
	
	@Autowired
	private ProclistRepo proclistRepo;
	
	//modif du 24/05/2022
	@Override
    public Iterable<Proclist> showprocesslistfull() {
        return proclistRepo.showprocesslistfull();
    }
	@Override
    public Iterable<Proclist> showprocesslistrep() {
        return proclistRepo.showprocesslistrep();
    }
	
	@Override
    public Iterable<Proclist> showprocesslistrepcli() {
        return proclistRepo.showprocesslistrepcli();
    }

    @Override
    public List <String>  showlastsav() {
        return proclistRepo.showlastsav();
    }



}
