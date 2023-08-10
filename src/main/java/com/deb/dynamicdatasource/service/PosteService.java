package com.deb.dynamicdatasource.service;
import com.deb.dynamicdatasource.entity.Poste;

public interface PosteService {

	//modif du 24/05/2022
	Iterable<Poste> showpostefull();
	
	Iterable<Poste> listAllPostes();

    Poste getPosteById(String id);

    Poste savePoste(Poste poste);

    void deletePoste(String id);
	
	//Iterable<Poste> Postesociete(String lecodsoc);
	long showmaxidposte();
	
	String deverouilleid(String numpos,String action);
}
