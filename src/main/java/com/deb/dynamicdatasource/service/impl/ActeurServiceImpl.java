package com.deb.dynamicdatasource.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deb.dynamicdatasource.entity.Acteur;
import com.deb.dynamicdatasource.repo.ActeurRepo;
import com.deb.dynamicdatasource.service.ActeurService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ActeurServiceImpl implements ActeurService{
	
	
	@Autowired
	private ActeurRepo acteurRepo;
	
	//modif du 24/05/2022
	@Override
    public Iterable<Acteur> showacteurfull() {
        return acteurRepo.showacteurfull();
    }
	
	

    @Autowired
    public void setActeurRepo(ActeurRepo acteurRepo) {
        this.acteurRepo = acteurRepo;
    }

    @Override
    public Iterable<Acteur> listAllActeurs() {
        return acteurRepo.findAll();
    }

    @Override
    public Acteur getActeurById(Long id) {
        Acteur acteur=acteurRepo.findById(id).orElse(null);
		return acteur;
    }

    @Override
    public Acteur saveActeur(Acteur acteur) {
        return acteurRepo.save(acteur);
    }

    @Override
    public void deleteActeur(Long id) {
        acteurRepo.deleteById(id);
    }
	

	 @Override
    public Long showmaxidacteur() {
      return  acteurRepo.showmaxidacteur();
    }

	/* @Override
    public Iterable<Acteur> showacteursau() {
        return acteurRepo.showacteursau();
    }
	
	@Override
    public Iterable<Acteur> showacteursactif() {
        return acteurRepo.showacteursactif();
    }
	
	@Override
    public Iterable<Acteur> showacteursclose() {
        return acteurRepo.showacteursclose();
    }
	
	
	@Override
    public Iterable<Acteur> showacteursbycustomer(Long nomcustomer) {
        return acteurRepo.showacteursbycustomer(nomcustomer);
     } */
	
	
	// @Override
    // public Iterable<Acteur> Acteursociete(Long lecodsoc) {
        // return acteurRepo.Acteursociete(lecodsoc);
    // }
	
}
