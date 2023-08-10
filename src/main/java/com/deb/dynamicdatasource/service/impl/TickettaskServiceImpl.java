package com.deb.dynamicdatasource.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deb.dynamicdatasource.entity.Tickettask;
import com.deb.dynamicdatasource.repo.TickettaskRepo;
import com.deb.dynamicdatasource.service.TickettaskService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class TickettaskServiceImpl implements TickettaskService{
	
	
	@Autowired
	private TickettaskRepo tickettaskRepo;
	
	
    @Autowired
    public void setTickettaskRepo(TickettaskRepo tickettaskRepo) {
        this.tickettaskRepo = tickettaskRepo;
    }
	
	//modif du 24/05/2022
	@Override
    public Iterable<Tickettask> showtickettaskfull() {
        return tickettaskRepo.showtickettaskfull();
    }
	
	
/* 	@Override
    public Iterable<Tickettask> showtickettaskfromtick(long id) {
        return tickettaskRepo.showtickettaskfromtick(id);
    } */
	


    @Override
    public Iterable<Tickettask> listAllTickettasks() {
        return tickettaskRepo.findAll();
    }

    @Override
    public Tickettask getTickettaskById(long id) {
        Tickettask tickettask=tickettaskRepo.findById(id).orElse(null);
		return tickettask;
    }

    @Override
    public Tickettask saveTickettask(Tickettask tickettask) {
        return tickettaskRepo.save(tickettask);
    }

    @Override
    public void deleteTickettask(long id) {
        tickettaskRepo.deleteById(id);
    }
	

	 @Override
    public long showmaxidtickettask() {
      return  tickettaskRepo.showmaxidtickettask();
    }
	
	
	
	/* @Override
    public Iterable<Tickettask> showtickettasksau() {
        return tickettaskRepo.showtickettasksau();
    }
	
	@Override
    public Iterable<Tickettask> showtickettasksactif() {
        return tickettaskRepo.showtickettasksactif();
    }
	
	@Override
    public Iterable<Tickettask> showtickettasksclose() {
        return tickettaskRepo.showtickettasksclose();
    } */
	// @Override
    // public Iterable<Tickettask> Tickettasksociete(String lecodsoc) {
        // return tickettaskRepo.Tickettasksociete(lecodsoc);
    // }
	
}
