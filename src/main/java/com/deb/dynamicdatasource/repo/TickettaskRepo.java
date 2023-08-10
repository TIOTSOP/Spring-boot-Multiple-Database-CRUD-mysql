package com.deb.dynamicdatasource.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.deb.dynamicdatasource.entity.Tickettask;

@Repository
public interface TickettaskRepo extends CrudRepository<Tickettask, Long>{
	
	@Query(value = " SELECT u from  Tickettask u order by customertick,projettick")
	Iterable<Tickettask> showtickettaskfull();
	
	@Query(value = " SELECT max(u.id)+1 from  Tickettask u")
	Long showmaxidtickettask();
	

	
	/* @Query(value = " SELECT u from  Tickettickettask u where u.statustick<>0 order by u.acteurtick,u.voltick desc")
	Iterable<Tickettickettask> showtickettasksau();
	
	@Query(value = " SELECT u from  Tickettickettask u where u.statustick=1 order by u.customertick,u.voltick,u.acteurtick desc")
	Iterable<Tickettickettask> showtickettasksactif();
	
	@Query(value = " SELECT u from  Tickettickettask u where u.statustick=9 order by u.datupdtick desc,u.customertick,u.voltick,u.acteurtick desc")
	Iterable<Tickettickettask> showtickettasksclose(); */
	
}
