package com.deb.dynamicdatasource.controller;

import com.deb.dynamicdatasource.entity.Projet;
import com.deb.dynamicdatasource.repo.ProjetRepo;
import com.deb.dynamicdatasource.service.ProjetService;
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
 * Projet controller.
 */
@Controller
public class ProjetController {

    private ProjetService projetService;
/* 	private LocalisationService localisationService; */
	
    @Autowired
    public void setProjetService(ProjetService projetService) {
        this.projetService = projetService;
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
     * List all projets.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/projets", method = RequestMethod.GET)
    public String list(Model model) {
		System.out.println("Returning rpoducts: before chnaging database");
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
		System.out.println("After changing database " + DataBaseContextHolder.getCurrentDb());
        model.addAttribute("projets", projetService.listAllProjets());
        System.out.println("Returning projets rpoducts:");
        return "projets";
    }
	
	
/* 	  @RequestMapping(value = "/projetsau", method = RequestMethod.GET)
    public String listau(Model model) {
		System.out.println("Returning rpoducts: before chnaging database");
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
		System.out.println("After changing database " + DataBaseContextHolder.getCurrentDb());
        model.addAttribute("projets", projetService.showprojetsau());
        System.out.println("Returning projets actifs par prioriytes:");
        return "projets";
    }
	
	
		  @RequestMapping(value = "/projetsactif", method = RequestMethod.GET)
    public String listactif(Model model) {
		System.out.println("Returning rpoducts: before chnaging database");
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
		System.out.println("After changing database " + DataBaseContextHolder.getCurrentDb());
        model.addAttribute("projets", projetService.showprojetsactif());
        System.out.println("Returning projets actifs par prioriytes:");
        return "projets";
    }
	
			  @RequestMapping(value = "/projetsclose", method = RequestMethod.GET)
    public String listclose(Model model) {
		System.out.println("Returning rpoducts: before chnaging database");
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
		System.out.println("After changing database " + DataBaseContextHolder.getCurrentDb());
        model.addAttribute("projets", projetService.showprojetsclose());
        System.out.println("Returning projets actifs par prioriytes:");
        return "projets";
    } */
	
	/*   @RequestMapping(value = "/localisations", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("localisations", localisationService.listAllLocalisations());
        System.out.println("Returning localisation:");
        return "localisations";
    }
 */
	
    /**
     * View a specific projet by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("projet/{id}")
    public String showProjet(@PathVariable long id, Model model) {
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
        model.addAttribute("projet", projetService.getProjetById(id));
        return "projetshow";
    }

    // Afficher le formulaire de modification du Projet
    @RequestMapping("projet/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
        model.addAttribute("projet", projetService.getProjetById(id));
        return "projetform";
    }
	
	
	
	//prendre aussi le status et l'acteur
	  // Afficher le formulaire de modification du Projet
/*     @RequestMapping("projet/addwithtick/{id}")
    public String crereprojetfromtick(@PathVariable long id, Model model) {
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
		Projet monprojet =new Projet();
		monprojet.setId(projetService.showmaxidprojet());
		monprojet.setIdtick(id);
		monprojet.setActeurprojet(ticketService.getTicketById(id).getActeurtick());
		monprojet.setStatusprojet(ticketService.getTicketById(id).getStatustick());
		monprojet.setDateprojet(ticketService.getTicketById(id).getDatupdtick());
        model.addAttribute("projet", monprojet);
        return "projetform";
    }
	
	  @RequestMapping("projet/showwithtick/{id}")
    public String showprojetfromtick(@PathVariable long id, Model model) {
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
		System.out.println("After changing database " + DataBaseContextHolder.getCurrentDb());
        model.addAttribute("projets", projetService.showprojetfromtick(id));
        System.out.println("Returning projets rpoducts:");
        return "projets";
    } */
	
    /**
     * New projet.
     *
     * @param model
     * @return
     */
    @RequestMapping("projet/new")
    public String newProjet(Model model) {
		Projet monprojet =new Projet();
		monprojet.setProjetnbposte(1);
		monprojet.setStatusprojet(1);
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
		monprojet.setId(projetService.showmaxidprojet());
        model.addAttribute("projet", monprojet);
        return "projetform";
    }

    /**
     * Save projet to database.
     *
     * @param projet
     * @return
     */
    @RequestMapping(value = "projet", method = RequestMethod.POST)
    public String saveProjet(Projet projet) {
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
        projetService.saveProjet(projet);
        return "redirect:/projet/" + projet.getId();
    }

    /**
     * Delete projet by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("projet/delete/{id}")
    public String delete(@PathVariable long id) {
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
        projetService.deleteProjet(id);
        return "redirect:/projets";
    }

}
