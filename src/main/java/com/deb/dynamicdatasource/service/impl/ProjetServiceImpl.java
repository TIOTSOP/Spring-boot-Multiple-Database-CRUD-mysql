package com.deb.dynamicdatasource.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deb.dynamicdatasource.entity.Projet;
import com.deb.dynamicdatasource.repo.ProjetRepo;
import com.deb.dynamicdatasource.service.ProjetService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ProjetServiceImpl implements ProjetService{
	
	
	@Autowired
	private ProjetRepo projetRepo;
	
	//modif du 24/05/2022
	@Override
    public Iterable<Projet> showprojetfull() {
        return projetRepo.showprojetfull();
    }
	
	
/* 	@Override
    public Iterable<Projet> showprojetfromtick(long id) {
        return projetRepo.showprojetfromtick(id);
    } */
	

    @Autowired
    public void setProjetRepo(ProjetRepo projetRepo) {
        this.projetRepo = projetRepo;
    }

    @Override
    public Iterable<Projet> listAllProjets() {
        return projetRepo.findAll();
    }

    @Override
    public Projet getProjetById(long id) {
        Projet projet=projetRepo.findById(id).orElse(null);
		return projet;
    }

    @Override
    public Projet saveProjet(Projet projet) {
        return projetRepo.save(projet);
    }

    @Override
    public void deleteProjet(long id) {
        projetRepo.deleteById(id);
    }
	
// 
	 @Override
     public long showmaxidprojet() {
      return  projetRepo.showmaxidprojet();
    }
	
	
	
	/* @Override
    public Iterable<Projet> showprojetsau() {
        return projetRepo.showprojetsau();
    }
	
	@Override
    public Iterable<Projet> showprojetsactif() {
        return projetRepo.showprojetsactif();
    }
	
	@Override
    public Iterable<Projet> showprojetsclose() {
        return projetRepo.showprojetsclose();
    } */
	// @Override
    // public Iterable<Projet> Projetsociete(String lecodsoc) {
        // return projetRepo.Projetsociete(lecodsoc);
    // }
	
}
