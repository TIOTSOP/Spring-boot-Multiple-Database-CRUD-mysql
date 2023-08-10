package com.deb.dynamicdatasource.controller;

import com.deb.dynamicdatasource.entity.Poste;
import com.deb.dynamicdatasource.repo.PosteRepo;
import com.deb.dynamicdatasource.service.PosteService;
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
 * Poste controller.
 */
@Controller
public class PosteController {

    private PosteService posteService;
/* 	private LocalisationService localisationService; */
	
    @Autowired
    public void setPosteService(PosteService posteService) {
        this.posteService = posteService;
    }

	/* @Autowired
    public void setLocalisationService(LocalisationService LocalisationService) {
        this.LocalisationService = LocalisationService;
    } */
	
    /**
     * List all postes.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/postes", method = RequestMethod.GET)
    public String list(Model model) {
		System.out.println("Returning rpoducts: before chnaging database");
		DataBaseContextHolder.setCurrentDb(DatabaseContext.MASTER);
		System.out.println("After changing database " + DataBaseContextHolder.getCurrentDb());
        model.addAttribute("postes", posteService.listAllPostes());
        System.out.println("Returning postes rpoducts:");
        return "postes";
    }
	
	/*   @RequestMapping(value = "/localisations", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("localisations", localisationService.listAllLocalisations());
        System.out.println("Returning localisation:");
        return "localisations";
    }
 */
	
    /**
     * View a specific poste by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("poste/{id}")
    public String showPoste(@PathVariable String id, Model model) {
		DataBaseContextHolder.setCurrentDb(DatabaseContext.MASTER);
        model.addAttribute("poste", posteService.getPosteById(id));
        return "posteshow";
    }

    // Afficher le formulaire de modification du Poste
    @RequestMapping("poste/edit/{id}")
    public String edit(@PathVariable String id, Model model) {
		DataBaseContextHolder.setCurrentDb(DatabaseContext.MASTER);
        model.addAttribute("poste", posteService.getPosteById(id));
        return "posteform";
    }

    /**
     * New poste.
     *
     * @param model
     * @return
     */
    @RequestMapping("poste/new")
    public String newPoste(Model model) {
		Poste monposte =new Poste();
		DataBaseContextHolder.setCurrentDb(DatabaseContext.MASTER);
		monposte.setId(Long.toString(posteService.showmaxidposte()));
        model.addAttribute("poste", monposte);
        return "posteform";
    }

    /**
     * Save poste to database.
     *
     * @param poste
     * @return
     */
    @RequestMapping(value = "poste", method = RequestMethod.POST)
    public String savePoste(Poste poste) {
		DataBaseContextHolder.setCurrentDb(DatabaseContext.MASTER);
        posteService.savePoste(poste);
        return "redirect:/poste/" + poste.getId();
    }

    /**
     * Delete poste by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("poste/delete/{id}")
    public String delete(@PathVariable String id) {
		DataBaseContextHolder.setCurrentDb(DatabaseContext.MASTER);
        posteService.deletePoste(id);
        return "redirect:/postes";
    }
	
	 @RequestMapping("poste/deverouiller/{id}")
    public String deverouiller(@PathVariable String id) {
		DataBaseContextHolder.setCurrentDb(DatabaseContext.MASTER);
		
		String action="A";
        String test=posteService.deverouilleid(id,action);
		System.out.println("Deverouillage postes:"+test+id+action);
        return "redirect:/postes";
    }
	
	 @RequestMapping("poste/verouiller/{id}")
    public String verouiller(@PathVariable String id) {
		DataBaseContextHolder.setCurrentDb(DatabaseContext.MASTER);
		
		String action="V";
        String test=posteService.deverouilleid(id,action);
			System.out.println("Verouillage postes:"+test+id+action);
        return "redirect:/postes";
    }
}
