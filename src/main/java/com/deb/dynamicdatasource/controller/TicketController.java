package com.deb.dynamicdatasource.controller;

import com.deb.dynamicdatasource.entity.Ticket;
import com.deb.dynamicdatasource.entity.MySeachZone;

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
 * Ticket controller.
 */
@Controller
public class TicketController {

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
     * List all tickets.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/tickets", method = RequestMethod.GET)
    public String list(Model model) {
		System.out.println("Returning rpoducts: before chnaging database");
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
		System.out.println("After changing database " + DataBaseContextHolder.getCurrentDb());
        model.addAttribute("tickets", ticketService.listAllTickets());
        System.out.println("Returning tickets rpoducts:");
        return "tickets";
    }
	
	
	  @RequestMapping(value = "/tickets/customer/", method = RequestMethod.POST)
    public String listcustomer(Model model,MySeachZone zonesearch) {
		System.out.println("nOM DE LA RECHERCHE :" +zonesearch.getZonetexte());
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
		System.out.println("After changing database " + DataBaseContextHolder.getCurrentDb());
        model.addAttribute("tickets", ticketService.showticketsbycustomer(zonesearch.getZonetexte()));
        System.out.println("Returning tickets rpoducts:");
        return "tickets";
    }
	
	
	
	
	
	  @RequestMapping(value = "/ticketsau", method = RequestMethod.GET)
    public String listau(Model model) {
		System.out.println("Returning rpoducts: before chnaging database");
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
		System.out.println("After changing database " + DataBaseContextHolder.getCurrentDb());
        model.addAttribute("tickets", ticketService.showticketsau());
        System.out.println("Returning tickets actifs par prioriytes:");
        return "tickets";
    }
	
	
	
	
	@RequestMapping(value = "/ticketsactif", method = RequestMethod.GET)
    public String listactif(Model model) {
		System.out.println("Returning rpoducts: before chnaging database");
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
		System.out.println("After changing database " + DataBaseContextHolder.getCurrentDb());
        model.addAttribute("tickets", ticketService.showticketsactif());
        System.out.println("Returning tickets actifs par prioriytes:");
        return "tickets";
    }
	
		 @RequestMapping(value = "/showticketsstarts", method = RequestMethod.GET)
    public String showticketsstarts(Model model) {
		System.out.println("Returning rpoducts: before chnaging database");
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
		System.out.println("After changing database " + DataBaseContextHolder.getCurrentDb());
        model.addAttribute("tickets", ticketService.showticketsstarts());
        System.out.println("Returning tickets showticketsstarts");
        return "tickets";
    }
	
			  @RequestMapping(value = "/ticketsclose", method = RequestMethod.GET)
    public String listclose(Model model) {
		System.out.println("Returning rpoducts: before chnaging database");
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
		System.out.println("After changing database " + DataBaseContextHolder.getCurrentDb());
        model.addAttribute("tickets", ticketService.showticketsclose());
        System.out.println("Returning tickets actifs par prioriytes:");
        return "tickets";
    }
	
	/*   @RequestMapping(value = "/localisations", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("localisations", localisationService.listAllLocalisations());
        System.out.println("Returning localisation:");
        return "localisations";
    }
 */
	
    /**
     * View a specific ticket by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("ticket/{id}")
    public String showTicket(@PathVariable long id, Model model) {
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
        model.addAttribute("ticket", ticketService.getTicketById(id));
        return "ticketshow";
    }

    // Afficher le formulaire de modification du Ticket
    @RequestMapping("ticket/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
        model.addAttribute("ticket", ticketService.getTicketById(id));
        return "ticketform";
    }

    /**
     * New ticket.
     *
     * @param model
     * @return
     */
    @RequestMapping("ticket/new")
    public String newTicket(Model model) {
		Ticket monticket =new Ticket();
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
		monticket.setId(ticketService.showmaxidticket());
        model.addAttribute("ticket", monticket);
        return "ticketform";
    }

    /**
     * Save ticket to database.
     *
     * @param ticket
     * @return
     */
    @RequestMapping(value = "ticket", method = RequestMethod.POST)
    public String saveTicket(Ticket ticket) {
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
        ticketService.saveTicket(ticket);
        return "redirect:/ticket/" + ticket.getId();
    }

    /**
     * Delete ticket by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("ticket/delete/{id}")
    public String delete(@PathVariable long id) {
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
        ticketService.deleteTicket(id);
        return "redirect:/tickets";
    }

}
