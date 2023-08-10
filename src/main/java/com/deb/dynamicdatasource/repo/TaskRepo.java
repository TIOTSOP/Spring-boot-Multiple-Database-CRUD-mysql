package com.deb.dynamicdatasource.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.deb.dynamicdatasource.entity.Task;

@Repository
public interface TaskRepo extends CrudRepository<Task, Long>{
	
	@Query(value = " SELECT u from  Task u")
	Iterable<Task> showtaskfull();
	
	@Query(value = " SELECT max(u.id)+1 from  Task u")
	Long showmaxidtask();
	
	@Query(value = " SELECT u from  Task u where u.idtick=:id")
	Iterable<Task> showtaskfromtick(@Param("id") long id );
	
	/* @Query(value = " SELECT u from  Task u where u.statustick<>0 order by u.acteurtick,u.voltick desc")
	Iterable<Task> showtasksau();
	
	@Query(value = " SELECT u from  Task u where u.statustick=1 order by u.customertick,u.voltick,u.acteurtick desc")
	Iterable<Task> showtasksactif();
	
	@Query(value = " SELECT u from  Task u where u.statustick=9 order by u.datupdtick desc,u.customertick,u.voltick,u.acteurtick desc")
	Iterable<Task> showtasksclose(); */
	
}
