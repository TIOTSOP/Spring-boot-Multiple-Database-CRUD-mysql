package com.deb.dynamicdatasource.service;
import com.deb.dynamicdatasource.entity.Projet;

public interface ProjetService {

	//modif du 24/05/2022
	Iterable<Projet> showprojetfull();
	
	Iterable<Projet> listAllProjets();

    Projet getProjetById(long id);

    Projet saveProjet(Projet projet);

    void deleteProjet(long id);
	
	//Iterable<Projet> Projetsociete(String lecodsoc);
	long showmaxidprojet();
	
	/* Iterable<Projet> showprojetfromtick(long id); */

/* 	Iterable<Projet> showprojetsau();
	
	Iterable<Projet> showprojetsactif();
	
	Iterable<Projet> showprojetsclose(); */
}
