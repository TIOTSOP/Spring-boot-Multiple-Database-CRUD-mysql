package com.deb.dynamicdatasource.controller;

import com.deb.dynamicdatasource.entity.Client;
import com.deb.dynamicdatasource.repo.ClientRepo;
import com.deb.dynamicdatasource.service.ClientService;
//modif du 11/07/2022
import com.deb.dynamicdatasource.entity.Ticket;
import com.deb.dynamicdatasource.repo.TicketRepo;
import com.deb.dynamicdatasource.service.TicketService;


/* import com.ensat.services.LocalisationService; */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//modif du 06/07/2022 importation du holder
import com.deb.dynamicdatasource.config.DataBaseContextHolder;
import com.deb.dynamicdatasource.enums.DatabaseContext;
import com.deb.dynamicdatasource.enums.Satelites;

/**
 * Client controller.
 */
@Controller
public class ClientController {

    private ClientService clientService;
/* 	private LocalisationService localisationService; */
	
    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }
	
	  private TicketService ticketService;
/* 	private LocalisationService localisationService; */
	
    @Autowired
    public void setTicketService(TicketService ticketService) {
        this.ticketService = ticketService;
    }
	

    
	/* @Autowired
    public void setLocalisationService(LocalisationService LocalisationService) {
        this.LocalisationService = LocalisationService;
    } */
	
    /**
     * List all clients.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public String list(Model model) {
		System.out.println("Returning rpoducts: before chnaging database");
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
		System.out.println("After changing database " + DataBaseContextHolder.getCurrentDb());
        model.addAttribute("clients", clientService.listAllClients());
        System.out.println("Returning clients rpoducts:");
        return "clients";
    }
	
	
/* 	  @RequestMapping(value = "/clientsau", method = RequestMethod.GET)
    public String listau(Model model) {
		System.out.println("Returning rpoducts: before chnaging database");
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
		System.out.println("After changing database " + DataBaseContextHolder.getCurrentDb());
        model.addAttribute("clients", clientService.showclientsau());
        System.out.println("Returning clients actifs par prioriytes:");
        return "clients";
    }
	
	
		  @RequestMapping(value = "/clientsactif", method = RequestMethod.GET)
    public String listactif(Model model) {
		System.out.println("Returning rpoducts: before chnaging database");
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
		System.out.println("After changing database " + DataBaseContextHolder.getCurrentDb());
        model.addAttribute("clients", clientService.showclientsactif());
        System.out.println("Returning clients actifs par prioriytes:");
        return "clients";
    }
	
			  @RequestMapping(value = "/clientsclose", method = RequestMethod.GET)
    public String listclose(Model model) {
		System.out.println("Returning rpoducts: before chnaging database");
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
		System.out.println("After changing database " + DataBaseContextHolder.getCurrentDb());
        model.addAttribute("clients", clientService.showclientsclose());
        System.out.println("Returning clients actifs par prioriytes:");
        return "clients";
    } */
	
	/*   @RequestMapping(value = "/localisations", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("localisations", localisationService.listAllLocalisations());
        System.out.println("Returning localisation:");
        return "localisations";
    }
 */
	
    /**
     * View a specific client by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("client/{id}")
    public String showClient(@PathVariable long id, Model model) {
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
        model.addAttribute("client", clientService.getClientById(id));
        return "clientshow";
    }

    // Afficher le formulaire de modification du Client
    @RequestMapping("client/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
        model.addAttribute("client", clientService.getClientById(id));
        return "clientform";
    }
	
	
	
	//prendre aussi le status et l'acteur
	  // Afficher le formulaire de modification du Client
/*     @RequestMapping("client/addwithtick/{id}")
    public String crereclientfromtick(@PathVariable long id, Model model) {
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
		Client monclient =new Client();
		monclient.setId(clientService.showmaxidclient());
		monclient.setIdtick(id);
		monclient.setActeurclient(ticketService.getTicketById(id).getActeurtick());
		monclient.setStatusclient(ticketService.getTicketById(id).getStatustick());
		monclient.setDateclient(ticketService.getTicketById(id).getDatupdtick());
        model.addAttribute("client", monclient);
        return "clientform";
    }
	
	  @RequestMapping("client/showwithtick/{id}")
    public String showclientfromtick(@PathVariable long id, Model model) {
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
		System.out.println("After changing database " + DataBaseContextHolder.getCurrentDb());
        model.addAttribute("clients", clientService.showclientfromtick(id));
        System.out.println("Returning clients rpoducts:");
        return "clients";
    } */
	
    /**
     * New client.
     *
     * @param model
     * @return
     */
    @RequestMapping("client/new")
    public String newClient(Model model) {
		Client monclient =new Client();
		monclient.setClientnbposte(1);
		monclient.setStatusclient(1);
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
		monclient.setId(clientService.showmaxidclient());
        model.addAttribute("client", monclient);
        return "clientform";
    }

    /**
     * Save client to database.
     *
     * @param client
     * @return
     */
    @RequestMapping(value = "client", method = RequestMethod.POST)
    public String saveClient(Client client) {
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
        clientService.saveClient(client);
        return "redirect:/client/" + client.getId();
    }

    /**
     * Delete client by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("client/delete/{id}")
    public String delete(@PathVariable long id) {
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
        clientService.deleteClient(id);
        return "redirect:/clients";
    }

}
