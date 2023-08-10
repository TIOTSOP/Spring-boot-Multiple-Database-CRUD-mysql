package com.deb.dynamicdatasource.controller;

import com.deb.dynamicdatasource.entity.Acteur;
import com.deb.dynamicdatasource.entity.MySeachZone;

import com.deb.dynamicdatasource.repo.ActeurRepo;
import com.deb.dynamicdatasource.service.ActeurService;
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
 * Acteur controller.
 */
@Controller
public class ActeurController {

    private ActeurService acteurService;
/* 	private LocalisationService localisationService; */
	
    @Autowired
    public void setActeurService(ActeurService acteurService) {
        this.acteurService = acteurService;
    }

	/* @Autowired
    public void setLocalisationService(LocalisationService LocalisationService) {
        this.LocalisationService = LocalisationService;
    } */
	
    /**
     * List all acteurs.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/acteurs", method = RequestMethod.GET)
    public String list(Model model) {
		System.out.println("Returning rpoducts: before chnaging database");
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
		System.out.println("After changing database " + DataBaseContextHolder.getCurrentDb());
        model.addAttribute("acteurs", acteurService.listAllActeurs());
        System.out.println("Returning acteurs rpoducts:");
        return "acteurs";
    }
	
	
	/*   @RequestMapping(value = "/acteurs/customer/", method = RequestMethod.POST)
    public String listcustomer(Model model,MySeachZone zonesearch) {
		System.out.println("nOM DE LA RECHERCHE :" +zonesearch.getZonetexte());
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
		System.out.println("After changing database " + DataBaseContextHolder.getCurrentDb());
        model.addAttribute("acteurs", acteurService.showacteursbycustomer(zonesearch.getZonetexte()));
        System.out.println("Returning acteurs rpoducts:");
        return "acteurs";
    } */
	
	
	
	
	
	/*   @RequestMapping(value = "/acteursau", method = RequestMethod.GET)
    public String listau(Model model) {
		System.out.println("Returning rpoducts: before chnaging database");
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
		System.out.println("After changing database " + DataBaseContextHolder.getCurrentDb());
        model.addAttribute("acteurs", acteurService.showacteursau());
        System.out.println("Returning acteurs actifs par prioriytes:");
        return "acteurs";
    }
	
	
		  @RequestMapping(value = "/acteursactif", method = RequestMethod.GET)
    public String listactif(Model model) {
		System.out.println("Returning rpoducts: before chnaging database");
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
		System.out.println("After changing database " + DataBaseContextHolder.getCurrentDb());
        model.addAttribute("acteurs", acteurService.showacteursactif());
        System.out.println("Returning acteurs actifs par prioriytes:");
        return "acteurs";
    }
	
			  @RequestMapping(value = "/acteursclose", method = RequestMethod.GET)
    public String listclose(Model model) {
		System.out.println("Returning rpoducts: before chnaging database");
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
		System.out.println("After changing database " + DataBaseContextHolder.getCurrentDb());
        model.addAttribute("acteurs", acteurService.showacteursclose());
        System.out.println("Returning acteurs actifs par prioriytes:");
        return "acteurs";
    } */
	
	/*   @RequestMapping(value = "/localisations", method = RequestMethod.GET)
    public Long list(Model model) {
        model.addAttribute("localisations", localisationService.listAllLocalisations());
        System.out.println("Returning localisation:");
        return "localisations";
    }
 */
	
    /**
     * View a specific acteur by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("acteur/{id}")
    public String showActeur(@PathVariable Long id, Model model) {
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
        model.addAttribute("acteur", acteurService.getActeurById(id));
        return "acteurshow";
    }

    // Afficher le formulaire de modification du Acteur
    @RequestMapping("acteur/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
        model.addAttribute("acteur", acteurService.getActeurById(id));
        return "acteurform";
    }

    /**
     * New acteur.
     *
     * @param model
     * @return
     */
    @RequestMapping("acteur/new")
    public String newActeur(Model model) {
		Acteur monacteur =new Acteur();
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
		monacteur.setId(acteurService.showmaxidacteur());
        model.addAttribute("acteur", monacteur);
        return "acteurform";
    }

    /**
     * Save acteur to database.
     *
     * @param acteur
     * @return
     */
    @RequestMapping(value = "acteur", method = RequestMethod.POST)
    public String saveActeur(Acteur acteur) {
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
        acteurService.saveActeur(acteur);
        return "redirect:/acteur/" + acteur.getId();
    }

    /**
     * Delete acteur by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("acteur/delete/{id}")
    public String delete(@PathVariable Long id) {
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
        acteurService.deleteActeur(id);
        return "redirect:/acteurs";
    }

}
