package com.deb.dynamicdatasource.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.deb.dynamicdatasource.entity.Ticket;

@Repository
public interface TicketRepo extends CrudRepository<Ticket, Long>{
	
	@Query(value = " SELECT u from  Ticket u")
	Iterable<Ticket> showticketfull();

	@Query(value = " SELECT u from  Ticket u")
	List<Ticket> listticketfull();

	@Query(value = " SELECT max(u.id)+1 from  Ticket u")
	Long showmaxidticket();
	
	@Query(value = " SELECT u from  Ticket u where u.statustick<>0 order by u.acteurtick,u.voltick desc")
	Iterable<Ticket> showticketsau();
	
	@Query(value = " SELECT u from  Ticket u where u.statustick<>9 order by u.customertick,u.voltick,u.acteurtick desc")
	Iterable<Ticket> showticketsactif();
	
	@Query(value = " SELECT u from  Ticket u where u.statustick=9 order by u.datupdtick desc,u.customertick,u.voltick,u.acteurtick desc")
	Iterable<Ticket> showticketsclose();

	@Query(value = " SELECT u from  Ticket u where u.customertick=:nomcustomer and u.statustick<>9 order by u.voltick desc,u.acteurtick desc")
	Iterable<Ticket> showticketsbycustomer(@Param("nomcustomer") String nomcustomer);
	
	@Query(value = " SELECT  u from  Ticket u where u.statustick=1 order by u.customertick,u.voltick,u.acteurtick desc")
	Iterable<Ticket> showticketsstarts();
	
}
