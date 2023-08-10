package com.deb.dynamicdatasource.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deb.dynamicdatasource.entity.Client;
import com.deb.dynamicdatasource.repo.ClientRepo;
import com.deb.dynamicdatasource.service.ClientService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ClientServiceImpl implements ClientService{
	
	
	@Autowired
	private ClientRepo clientRepo;
	
	//modif du 24/05/2022
	@Override
    public Iterable<Client> showclientfull() {
        return clientRepo.showclientfull();
    }
	
	
/* 	@Override
    public Iterable<Client> showclientfromtick(long id) {
        return clientRepo.showclientfromtick(id);
    } */
	

    @Autowired
    public void setClientRepo(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    @Override
    public Iterable<Client> listAllClients() {
        return clientRepo.findAll();
    }

    @Override
    public Client getClientById(long id) {
        Client client=clientRepo.findById(id).orElse(null);
		return client;
    }

    @Override
    public Client saveClient(Client client) {
        return clientRepo.save(client);
    }

    @Override
    public void deleteClient(long id) {
        clientRepo.deleteById(id);
    }
	
// 
	 @Override
     public long showmaxidclient() {
      return  clientRepo.showmaxidclient();
    }
	
	
	
	/* @Override
    public Iterable<Client> showclientsau() {
        return clientRepo.showclientsau();
    }
	
	@Override
    public Iterable<Client> showclientsactif() {
        return clientRepo.showclientsactif();
    }
	
	@Override
    public Iterable<Client> showclientsclose() {
        return clientRepo.showclientsclose();
    } */
	// @Override
    // public Iterable<Client> Clientsociete(String lecodsoc) {
        // return clientRepo.Clientsociete(lecodsoc);
    // }
	
}
