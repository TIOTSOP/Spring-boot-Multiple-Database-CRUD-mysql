package com.deb.dynamicdatasource.service;
import com.deb.dynamicdatasource.entity.Task;

public interface TaskService {

	//modif du 24/05/2022
	Iterable<Task> showtaskfull();
	
	Iterable<Task> listAllTasks();

    Task getTaskById(long id);

    Task saveTask(Task task);

    void deleteTask(long id);
	
	//Iterable<Task> Tasksociete(String lecodsoc);
	long showmaxidtask();
	
	Iterable<Task> showtaskfromtick(long id);

/* 	Iterable<Task> showtasksau();
	
	Iterable<Task> showtasksactif();
	
	Iterable<Task> showtasksclose(); */
}
