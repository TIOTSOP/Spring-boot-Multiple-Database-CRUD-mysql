package com.deb.dynamicdatasource.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deb.dynamicdatasource.entity.Task;
import com.deb.dynamicdatasource.repo.TaskRepo;
import com.deb.dynamicdatasource.service.TaskService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class TaskServiceImpl implements TaskService{
	
	
	@Autowired
	private TaskRepo taskRepo;
	
	//modif du 24/05/2022
	@Override
    public Iterable<Task> showtaskfull() {
        return taskRepo.showtaskfull();
    }
	
	
	@Override
    public Iterable<Task> showtaskfromtick(long id) {
        return taskRepo.showtaskfromtick(id);
    }
	

    @Autowired
    public void setTaskRepo(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    @Override
    public Iterable<Task> listAllTasks() {
        return taskRepo.findAll();
    }

    @Override
    public Task getTaskById(long id) {
        Task task=taskRepo.findById(id).orElse(null);
		return task;
    }

    @Override
    public Task saveTask(Task task) {
        return taskRepo.save(task);
    }

    @Override
    public void deleteTask(long id) {
        taskRepo.deleteById(id);
    }
	

	 @Override
    public long showmaxidtask() {
      return  taskRepo.showmaxidtask();
    }
	
	
	
	/* @Override
    public Iterable<Task> showtasksau() {
        return taskRepo.showtasksau();
    }
	
	@Override
    public Iterable<Task> showtasksactif() {
        return taskRepo.showtasksactif();
    }
	
	@Override
    public Iterable<Task> showtasksclose() {
        return taskRepo.showtasksclose();
    } */
	// @Override
    // public Iterable<Task> Tasksociete(String lecodsoc) {
        // return taskRepo.Tasksociete(lecodsoc);
    // }
	
}
