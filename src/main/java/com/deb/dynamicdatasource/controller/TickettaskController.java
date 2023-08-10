package com.deb.dynamicdatasource.controller;

import com.deb.dynamicdatasource.entity.Tickettask;
import com.deb.dynamicdatasource.repo.TickettaskRepo;
import com.deb.dynamicdatasource.service.TickettaskService;
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
 * Tickettask controller.
 */
@Controller
public class TickettaskController {

    private TickettaskService tickettaskService;
/* 	private LocalisationService localisationService; */
	
    @Autowired
    public void setTickettaskService(TickettaskService tickettaskService) {
        this.tickettaskService = tickettaskService;
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
     * List all tickettasks.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/tickettasks", method = RequestMethod.GET)
    public String list(Model model) {
		System.out.println("Returning rpoducts: before chnaging database");
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
		System.out.println("After changing database " + DataBaseContextHolder.getCurrentDb());
        model.addAttribute("tickettasks", tickettaskService.showtickettaskfull());
        System.out.println("Returning tickettasks rpoducts:");
        return "tickettasks";
    }
	
	
/* 	  @RequestMapping(value = "/tickettasksau", method = RequestMethod.GET)
    public String listau(Model model) {
		System.out.println("Returning rpoducts: before chnaging database");
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
		System.out.println("After changing database " + DataBaseContextHolder.getCurrentDb());
        model.addAttribute("tickettasks", tickettaskService.showtickettasksau());
        System.out.println("Returning tickettasks actifs par prioriytes:");
        return "tickettasks";
    }
	
	
		  @RequestMapping(value = "/tickettasksactif", method = RequestMethod.GET)
    public String listactif(Model model) {
		System.out.println("Returning rpoducts: before chnaging database");
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
		System.out.println("After changing database " + DataBaseContextHolder.getCurrentDb());
        model.addAttribute("tickettasks", tickettaskService.showtickettasksactif());
        System.out.println("Returning tickettasks actifs par prioriytes:");
        return "tickettasks";
    }
	
			  @RequestMapping(value = "/tickettasksclose", method = RequestMethod.GET)
    public String listclose(Model model) {
		System.out.println("Returning rpoducts: before chnaging database");
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
		System.out.println("After changing database " + DataBaseContextHolder.getCurrentDb());
        model.addAttribute("tickettasks", tickettaskService.showtickettasksclose());
        System.out.println("Returning tickettasks actifs par prioriytes:");
        return "tickettasks";
    } */
	
	/*   @RequestMapping(value = "/localisations", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("localisations", localisationService.listAllLocalisations());
        System.out.println("Returning localisation:");
        return "localisations";
    }
 */
	
    /**
     * View a specific tickettask by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("tickettask/{id}")
    public String showTickettask(@PathVariable long id, Model model) {
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
        model.addAttribute("tickettask", tickettaskService.getTickettaskById(id));
        return "tickettaskshow";
    }

    // Afficher le formulaire de modification du Tickettask
    @RequestMapping("tickettask/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
        model.addAttribute("tickettask", tickettaskService.getTickettaskById(id));
        return "tickettaskform";
    }
	
	
	
/* 	//prendre aussi le status et l'acteur
	  // Afficher le formulaire de modification du Tickettask
    @RequestMapping("tickettask/addwithtick/{id}")
    public String creretickettaskfromtick(@PathVariable long id, Model model) {
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
		Tickettask montickettask =new Tickettask();
		montickettask.setId(tickettaskService.showmaxidtickettask());
		montickettask.setIdtick(id);
		montickettask.setActeurtickettask(ticketService.getTicketById(id).getActeurtick());
		montickettask.setStatustickettask(ticketService.getTicketById(id).getStatustick());
		montickettask.setDatetickettask(ticketService.getTicketById(id).getDatupdtick());
        model.addAttribute("tickettask", montickettask);
        return "tickettaskform";
    }
	
	  @RequestMapping("tickettask/showwithtick/{id}")
    public String showtickettaskfromtick(@PathVariable long id, Model model) {
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
		System.out.println("After changing database " + DataBaseContextHolder.getCurrentDb());
        model.addAttribute("tickettasks", tickettaskService.showtickettaskfromtick(id));
        System.out.println("Returning tickettasks rpoducts:");
        return "tickettasks";
    } */
	
    /**
     * New tickettask.
     *
     * @param model
     * @return
     */
    @RequestMapping("tickettask/new")
    public String newTickettask(Model model) {
		Tickettask montickettask =new Tickettask();
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
		montickettask.setId(tickettaskService.showmaxidtickettask());
        model.addAttribute("tickettask", montickettask);
        return "tickettaskform";
    }

    /**
     * Save tickettask to database.
     *
     * @param tickettask
     * @return
     */
    @RequestMapping(value = "tickettask", method = RequestMethod.POST)
    public String saveTickettask(Tickettask tickettask) {
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
        tickettaskService.saveTickettask(tickettask);
        return "redirect:/tickettask/" + tickettask.getId();
    }

    /**
     * Delete tickettask by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("tickettask/delete/{id}")
    public String delete(@PathVariable long id) {
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
        tickettaskService.deleteTickettask(id);
        return "redirect:/tickettasks";
    }

}
