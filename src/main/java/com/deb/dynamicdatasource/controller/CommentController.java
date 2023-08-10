package com.deb.dynamicdatasource.controller;

import com.deb.dynamicdatasource.entity.Comment;
import com.deb.dynamicdatasource.repo.CommentRepo;
import com.deb.dynamicdatasource.service.CommentService;
//modif du 11/07/2022
import com.deb.dynamicdatasource.entity.Ticket;
import com.deb.dynamicdatasource.repo.TicketRepo;
import com.deb.dynamicdatasource.service.TicketService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
 * Comment controller.
 */
import com.deb.dynamicdatasource.entity.MySeachZone;

@Controller
public class CommentController {

    private CommentService commentService;
/* 	private LocalisationService localisationService; */
	
    @Autowired
    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
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
     * List all comments.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/comments", method = RequestMethod.GET)
    public String list(Model model) {
		System.out.println("Returning rpoducts: before chnaging database");
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
		System.out.println("After changing database " + DataBaseContextHolder.getCurrentDb());
        model.addAttribute("comments", commentService.listAllComments());
        System.out.println("Returning comments rpoducts:");
        return "comments";
    }
	
	//modif du 13/04/2023
 /*    @RequestMapping(value = "/tickets/customer/", method = RequestMethod.POST)
    public String listcustomer(Model model,MySeachZone zonesearch) {
		System.out.println("nOM DE LA RECHERCHE :" +zonesearch.getZonetexte());
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
		System.out.println("After changing database " + DataBaseContextHolder.getCurrentDb());
        model.addAttribute("tickets", ticketService.showticketsbycustomer(zonesearch.getZonetexte()));
        System.out.println("Returning tickets rpoducts:");
        return "tickets";
    } */

    @RequestMapping(value = "/comments/ladate/", method = RequestMethod.POST)
    public String commentperdate(Model model,MySeachZone zonesearch) {
		System.out.println("nOM DE LA RECHERCHE :" +zonesearch.getZonetexte());
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
		System.out.println("After changing database " + DataBaseContextHolder.getCurrentDb());
       // model.addAttribute("tickets", ticketService.showticketsbycustomer(zonesearch.getZonetexte()));
        model.addAttribute("comments", commentService.showcommentperdate(zonesearch.getZonetexte()));
        System.out.println("Returning tickets rpoducts:");
        return "comments";
    }

    @RequestMapping(value = "/comments/lecustomer/", method = RequestMethod.POST)
    public String commentpercustomer(Model model,MySeachZone zonesearch) {
		System.out.println("nOM DE LA RECHERCHE :" +zonesearch.getZonetexte());
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
		System.out.println("After changing database " + DataBaseContextHolder.getCurrentDb());
       // model.addAttribute("tickets", ticketService.showticketsbycustomer(zonesearch.getZonetexte()));
        model.addAttribute("comments", commentService.showcommentpercustomer(zonesearch.getZonetexte()));
        System.out.println("Returning tickets rpoducts:");
        return "comments";
    }


/* 	  @RequestMapping(value = "/commentsau", method = RequestMethod.GET)
    public String listau(Model model) {
		System.out.println("Returning rpoducts: before chnaging database");
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
		System.out.println("After changing database " + DataBaseContextHolder.getCurrentDb());
        model.addAttribute("comments", commentService.showcommentsau());
        System.out.println("Returning comments actifs par prioriytes:");
        return "comments";
    }
	
	
		  @RequestMapping(value = "/commentsactif", method = RequestMethod.GET)
    public String listactif(Model model) {
		System.out.println("Returning rpoducts: before chnaging database");
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
		System.out.println("After changing database " + DataBaseContextHolder.getCurrentDb());
        model.addAttribute("comments", commentService.showcommentsactif());
        System.out.println("Returning comments actifs par prioriytes:");
        return "comments";
    }
	
			  @RequestMapping(value = "/commentsclose", method = RequestMethod.GET)
    public String listclose(Model model) {
		System.out.println("Returning rpoducts: before chnaging database");
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
		System.out.println("After changing database " + DataBaseContextHolder.getCurrentDb());
        model.addAttribute("comments", commentService.showcommentsclose());
        System.out.println("Returning comments actifs par prioriytes:");
        return "comments";
    } */
	
	/*   @RequestMapping(value = "/localisations", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("localisations", localisationService.listAllLocalisations());
        System.out.println("Returning localisation:");
        return "localisations";
    }
 */
	
    /**
     * View a specific comment by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("comment/{id}")
    public String showComment(@PathVariable long id, Model model) {
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
        model.addAttribute("comment", commentService.getCommentById(id));
        return "commentshow";
    }

    // Afficher le formulaire de modification du Comment
    @RequestMapping("comment/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
        model.addAttribute("comment", commentService.getCommentById(id));
        return "commentform";
    }
	
    @RequestMapping("task/addcomment/{id}")
    public String AddCommentontask(@PathVariable long id, Model model) {
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
        Comment moncomment =new Comment();
		//moncomment.setCommentnbposte(1);
		//moncomment.setStatuscomment(1);
		moncomment.setId(commentService.showmaxidcomment());
        moncomment.setIdtask(id);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        String ladate=dtf.format(now);  
        moncomment.setDatecom(ladate);
        model.addAttribute("comment", moncomment);
        model.addAttribute("comments", commentService.showcommentoftask(id));
        return "commentformtask";
    }

	
	
	//prendre aussi le status et l'acteur
	  // Afficher le formulaire de modification du Comment
/*     @RequestMapping("comment/addwithtick/{id}")
    public String crerecommentfromtick(@PathVariable long id, Model model) {
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
		Comment moncomment =new Comment();
		moncomment.setId(commentService.showmaxidcomment());
		moncomment.setIdtick(id);
		moncomment.setActeurcomment(ticketService.getTicketById(id).getActeurtick());
		moncomment.setStatuscomment(ticketService.getTicketById(id).getStatustick());
		moncomment.setDatecomment(ticketService.getTicketById(id).getDatupdtick());
        model.addAttribute("comment", moncomment);
        return "commentform";
    }
	
	  @RequestMapping("comment/showwithtick/{id}")
    public String showcommentfromtick(@PathVariable long id, Model model) {
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
		System.out.println("After changing database " + DataBaseContextHolder.getCurrentDb());
        model.addAttribute("comments", commentService.showcommentfromtick(id));
        System.out.println("Returning comments rpoducts:");
        return "comments";
    } */
	
    /**
     * New comment.
     *
     * @param model
     * @return
     */
    @RequestMapping("comment/new")
    public String newComment(Model model) {
		Comment moncomment =new Comment();
		//moncomment.setCommentnbposte(1);
		//moncomment.setStatuscomment(1);
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
		moncomment.setId(commentService.showmaxidcomment());
        model.addAttribute("comment", moncomment);
        return "commentform";
    }

    /**
     * Save comment to database.
     *
     * @param comment
     * @return
     */
    @RequestMapping(value = "comment", method = RequestMethod.POST)
    public String saveComment(Comment comment) {
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
        commentService.saveComment(comment);
        return "redirect:/comment/" + comment.getId();
    }

    @RequestMapping(value = "commenttask", method = RequestMethod.POST)
    public String saveCommenttask(Comment comment) {
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
        commentService.saveComment(comment);

         return "redirect:/task/addwithtick/" + commentService.showidtickfromtask(comment.getIdtask());
    }

    @RequestMapping("comment/showtasks/{idtask}")
    public String showtaskfromcommanet(@PathVariable long idtask) {
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
        return "redirect:/task/addwithtick/" + commentService.showidtickfromtask(idtask);
    }
   

    /**
     * Delete comment by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("comment/delete/{id}")
    public String delete(@PathVariable long id) {
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
        commentService.deleteComment(id);
        return "redirect:/comments";
    }

}
