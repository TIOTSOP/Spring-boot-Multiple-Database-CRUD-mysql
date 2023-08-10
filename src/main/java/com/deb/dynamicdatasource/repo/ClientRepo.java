package com.deb.dynamicdatasource.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.deb.dynamicdatasource.entity.Client;

@Repository
public interface ClientRepo extends CrudRepository<Client, Long>{
	
	@Query(value = " SELECT u from  Client u")
	Iterable<Client> showclientfull();
	
	@Query(value = " SELECT if(isnull(max(u.idclient)),0,max(u.idclient))+1 from  Client u", nativeQuery = true)
	Long showmaxidclient();
	
/* 	@Query(value = " SELECT u from  Client u where u.idtick=:id")
	Iterable<Client> showclientfromtick(@Param("id") long id ); */
	
	/* @Query(value = " SELECT u from  Client u where u.statustick<>0 order by u.acteurtick,u.voltick desc")
	Iterable<Client> showclientsau();
	
	@Query(value = " SELECT u from  Client u where u.statustick=1 order by u.customertick,u.voltick,u.acteurtick desc")
	Iterable<Client> showclientsactif();
	
	@Query(value = " SELECT u from  Client u where u.statustick=9 order by u.datupdtick desc,u.customertick,u.voltick,u.acteurtick desc")
	Iterable<Client> showclientsclose(); */
	
}
