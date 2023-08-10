package com.deb.dynamicdatasource.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deb.dynamicdatasource.entity.Poste;
import com.deb.dynamicdatasource.repo.PosteRepo;
import com.deb.dynamicdatasource.service.PosteService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class PosteServiceImpl implements PosteService{
	
	
	@Autowired
	private PosteRepo posteRepo;
	
	//modif du 24/05/2022
	@Override
    public Iterable<Poste> showpostefull() {
        return posteRepo.showpostefull();
    }
	
	

    @Autowired
    public void setPosteRepo(PosteRepo posteRepo) {
        this.posteRepo = posteRepo;
    }

    @Override
    public Iterable<Poste> listAllPostes() {
        return posteRepo.findAll();
    }

    @Override
    public Poste getPosteById(String id) {
        Poste poste=posteRepo.findById(id).orElse(null);
		return poste;
    }

    @Override
    public Poste savePoste(Poste poste) {
        return posteRepo.save(poste);
    }

    @Override
    public void deletePoste(String id) {
        posteRepo.deleteById(id);
    }
	

	 @Override
    public long showmaxidposte() {
      return  posteRepo.showmaxidposte();
    }
	
	 @Override
    public String deverouilleid(String numpos,String action){
        return posteRepo.deverouilleid(numpos,action);
    }
	// @Override
    // public Iterable<Poste> Postesociete(String lecodsoc) {
        // return posteRepo.Postesociete(lecodsoc);
    // }
	
}
