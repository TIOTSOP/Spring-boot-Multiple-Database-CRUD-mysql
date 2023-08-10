package com.deb.dynamicdatasource.service;
import com.deb.dynamicdatasource.entity.Client;

public interface ClientService {

	//modif du 24/05/2022
	Iterable<Client> showclientfull();
	
	Iterable<Client> listAllClients();

    Client getClientById(long id);

    Client saveClient(Client client);

    void deleteClient(long id);
	
	//Iterable<Client> Clientsociete(String lecodsoc);
	long showmaxidclient();
	
	/* Iterable<Client> showclientfromtick(long id); */

/* 	Iterable<Client> showclientsau();
	
	Iterable<Client> showclientsactif();
	
	Iterable<Client> showclientsclose(); */
}
