package com.deb.dynamicdatasource.service;
import com.deb.dynamicdatasource.entity.Acteur;

public interface ActeurService {

	//modif du 24/05/2022
	Iterable<Acteur> showacteurfull();
	
	Iterable<Acteur> listAllActeurs();

    Acteur getActeurById(Long id);

    Acteur saveActeur(Acteur acteur);

    void deleteActeur(Long id);
	
	//Iterable<Acteur> Acteursociete(Long lecodsoc);
	Long showmaxidacteur();
	
	/* Iterable<Acteur> showacteursau();
	
	Iterable<Acteur> showacteursactif();
	
	Iterable<Acteur> showacteursclose();
	
	Iterable<Acteur> showacteursbycustomer(Long nomcustomer); */
}
