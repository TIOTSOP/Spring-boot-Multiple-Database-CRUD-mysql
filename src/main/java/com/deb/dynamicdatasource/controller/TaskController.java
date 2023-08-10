package com.deb.dynamicdatasource.controller;

import com.deb.dynamicdatasource.entity.Task;
import com.deb.dynamicdatasource.repo.TaskRepo;
import com.deb.dynamicdatasource.service.TaskService;
//modif du 11/07/2022
import com.deb.dynamicdatasource.entity.Ticket;
import com.deb.dynamicdatasource.repo.TicketRepo;
import com.deb.dynamicdatasource.service.TicketService;

import ch.qos.logback.core.joran.conditional.ElseAction;

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
//modif du 18/07/2022
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  
//modif du 13/08/2022
import com.deb.dynamicdatasource.entity.Comment;
import com.deb.dynamicdatasource.repo.CommentRepo;
import com.deb.dynamicdatasource.service.CommentService;

/**
 * Task controller.
 */
@Controller
public class TaskController {

    private TaskService taskService;
/* 	private LocalisationService localisationService; */
	
    @Autowired
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }
	
	  private TicketService ticketService;
/* 	private LocalisationService localisationService; */
	
    @Autowired
    public void setTicketService(TicketService ticketService) {
        this.ticketService = ticketService;
    }
	
    private CommentService commentService;
    /* 	private LocalisationService localisationService; */
        
        @Autowired
        public void setCommentService(CommentService commentService) {
            this.commentService = commentService;
        }

	/* @Autowired
    public void setLocalisationService(LocalisationService LocalisationService) {
        this.LocalisationService = LocalisationService;
    } */
	
    /**
     * List all tasks.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public String list(Model model) {
		System.out.println("Returning rpoducts: before chnaging database");
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
		System.out.println("After changing database " + DataBaseContextHolder.getCurrentDb());
        model.addAttribute("tasks", taskService.listAllTasks());
        System.out.println("Returning tasks rpoducts:");
        return "tasks";
    }
	
	
/* 	  @RequestMapping(value = "/tasksau", method = RequestMethod.GET)
    public String listau(Model model) {
		System.out.println("Returning rpoducts: before chnaging database");
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
		System.out.println("After changing database " + DataBaseContextHolder.getCurrentDb());
        model.addAttribute("tasks", taskService.showtasksau());
        System.out.println("Returning tasks actifs par prioriytes:");
        return "tasks";
    }
	
	
		  @RequestMapping(value = "/tasksactif", method = RequestMethod.GET)
    public String listactif(Model model) {
		System.out.println("Returning rpoducts: before chnaging database");
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
		System.out.println("After changing database " + DataBaseContextHolder.getCurrentDb());
        model.addAttribute("tasks", taskService.showtasksactif());
        System.out.println("Returning tasks actifs par prioriytes:");
        return "tasks";
    }
	
			  @RequestMapping(value = "/tasksclose", method = RequestMethod.GET)
    public String listclose(Model model) {
		System.out.println("Returning rpoducts: before chnaging database");
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
		System.out.println("After changing database " + DataBaseContextHolder.getCurrentDb());
        model.addAttribute("tasks", taskService.showtasksclose());
        System.out.println("Returning tasks actifs par prioriytes:");
        return "tasks";
    } */
	
	/*   @RequestMapping(value = "/localisations", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("localisations", localisationService.listAllLocalisations());
        System.out.println("Returning localisation:");
        return "localisations";
    }
 */
	
    /**
     * View a specific task by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("task/{id}")
    public String showTask(@PathVariable long id, Model model) {
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
        model.addAttribute("task", taskService.getTaskById(id));
        return "taskshow";
    }

    // Afficher le formulaire de modification du Task
    @RequestMapping("task/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
        String chaineReturn;

        if (taskService.getTaskById(id).getStatustask()==9){
        chaineReturn= "redirect:/task/addwithtick/" + taskService.getTaskById(id).getIdtick();
        }
        else {
            model.addAttribute("task", taskService.getTaskById(id));
            chaineReturn="taskform";
        }
        
        return chaineReturn;
    }
	
	
	
	//prendre aussi le status et l'acteur
	  // Afficher le formulaire de modification du Task
    @RequestMapping("task/addwithtick/{id}")
    public String creretaskfromtick(@PathVariable long id, Model model) {
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
		Task montask =new Task();
		montask.setId(taskService.showmaxidtask());
		montask.setIdtick(id);
		montask.setActeurtask(ticketService.getTicketById(id).getActeurtick());
		montask.setStatustask(ticketService.getTicketById(id).getStatustick());
		//montask.setDatetask(ticketService.getTicketById(id).getDatupdtick());
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
        LocalDateTime now = LocalDateTime.now();  
        String ladate= dtf.format(now);
        montask.setDatetask(ladate);
        model.addAttribute("tasks", taskService.showtaskfromtick(id));
        model.addAttribute("task", montask);
        return "taskformtick";
    }
	
	  @RequestMapping("task/showwithtick/{id}")
    public String showtaskfromtick(@PathVariable long id, Model model) {
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
		System.out.println("After changing database " + DataBaseContextHolder.getCurrentDb());
        model.addAttribute("tasks", taskService.showtaskfromtick(id));
        System.out.println("Returning tasks rpoducts:");
        return "tasks";
    }
	
    /**
     * New task.
     *
     * @param model
     * @return
     */
    @RequestMapping("task/new")
    public String newTask(Model model) {
		Task montask =new Task();
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
		montask.setId(taskService.showmaxidtask());
        model.addAttribute("task", montask);
        return "taskform";
    }

    /**
     * Save task to database.
     *
     * @param task
     * @return
     */
    @RequestMapping(value = "task", method = RequestMethod.POST)
    public String saveTask(Task task) {
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        String ladate=dtf.format(now);  
        String action;

        if (task.getStatustask()==9){
           
            action="Cloture task ";
            task.setEndtask(ladate);
            task.setStarttask(taskService.getTaskById(task.getId()).getStarttask());
        }
        else {

            System.out.println(task.getStarttask());
            if (taskService.getTaskById(task.getId()).getStarttask()== null && taskService.getTaskById(task.getId()).getStatustask()==1){
                task.setStarttask(ladate);
                System.out.println("Nous devons mettre la date "+ladate);
            }

            action="Modif task";
        }

        Comment comment=new Comment();
        comment.setIdtask(task.getId());
        comment.setDatecom(ladate);
        comment.setObs(action+task.getDonetask());
        commentService.saveComment(comment);

       
        taskService.saveTask(task);
        //return "redirect:/task/" + task.getId();
        return "redirect:/task/addwithtick/" + task.getIdtick();
    }


    @RequestMapping(value = "task/closed/{id}", method = RequestMethod.GET)
    public String closedtask(@PathVariable long id) {
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
        Task task=taskService.getTaskById(id);
        
        if (task.getStatustask()==9){

        }
        else{
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
            LocalDateTime now = LocalDateTime.now();  
            String ladate=dtf.format(now);  
            task.setEndtask(ladate);
            task.setStatustask(9);
           // task.setStarttask(taskService.getTaskById(task.getId()).getStarttask());
            taskService.saveTask(task);

            Comment comment=new Comment();
            comment.setIdtask(task.getId());
            comment.setDatecom(ladate);
            comment.setObs("Cloture task "+task.getDonetask());
            commentService.saveComment(comment);


        }

        //return "redirect:/task/" + task.getId();
        return "redirect:/task/addwithtick/" + task.getIdtick();
    }

    @RequestMapping(value = "task/started/{id}", method = RequestMethod.GET)
    public String startedtask(@PathVariable long id) {
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
        Task task=taskService.getTaskById(id);
        
        if (task.getStatustask()==0){

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
            LocalDateTime now = LocalDateTime.now();  
            String ladate=dtf.format(now);  
            task.setStarttask(ladate);
            task.setStatustask(1);
           // task.setStarttask(taskService.getTaskById(task.getId()).getStarttask());
            taskService.saveTask(task);

            Comment comment=new Comment();
            comment.setIdtask(task.getId());
            comment.setDatecom(ladate);
            comment.setObs("Begin task "+task.getDonetask());
            commentService.saveComment(comment);


        }
        else{
          


        }

        //return "redirect:/task/" + task.getId();
        return "redirect:/task/addwithtick/" + task.getIdtick();
    }

    @RequestMapping(value = "tasktick", method = RequestMethod.POST)
    public String saveTasktick(Task task) {
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        String ladate=dtf.format(now); 
        if (task.getStatustask() ==1){
            task.setStarttask(ladate);
        }
        taskService.saveTask(task);
        Comment comment=new Comment();
        comment.setIdtask(task.getId());
        comment.setDatecom(ladate);
        comment.setObs("Creation task "+task.getDonetask());
        commentService.saveComment(comment);
        return "redirect:/task/addwithtick/" + task.getIdtick();
    }

    /**
     * Delete task by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("task/delete/{id}")
    public String delete(@PathVariable long id) {
		DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }

}
