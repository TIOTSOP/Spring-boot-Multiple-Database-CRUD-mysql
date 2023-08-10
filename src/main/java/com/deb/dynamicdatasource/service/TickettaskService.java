package com.deb.dynamicdatasource.service;
import com.deb.dynamicdatasource.entity.Tickettask;

public interface TickettaskService {

	//modif du 24/05/2022
	Iterable<Tickettask> showtickettaskfull();
	
	Iterable<Tickettask> listAllTickettasks();

    Tickettask getTickettaskById(long id);

    Tickettask saveTickettask(Tickettask tickettask);

    void deleteTickettask(long id);
	
	//Iterable<Tickettask> Tickettasksociete(String lecodsoc);
	long showmaxidtickettask();
	
/* 	Iterable<Tickettask> showtickettaskfromtick(long id);
 */
/* 	Iterable<Tickettask> showtickettasksau();
	
	Iterable<Tickettask> showtickettasksactif();
	
	Iterable<Tickettask> showtickettasksclose(); */
}
