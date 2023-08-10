package com.deb.dynamicdatasource.service;
import java.util.List;

import com.deb.dynamicdatasource.entity.Ticket;

public interface TicketService {

	//modif du 24/05/2022
	Iterable<Ticket> showticketfull();
	
	List<Ticket> listticketfull();

	Iterable<Ticket> listAllTickets();

    Ticket getTicketById(long id);

    Ticket saveTicket(Ticket ticket);

    void deleteTicket(long id);
	
	//Iterable<Ticket> Ticketsociete(String lecodsoc);
	long showmaxidticket();
	
	Iterable<Ticket> showticketsau();
	
	Iterable<Ticket> showticketsactif();
	
	Iterable<Ticket> showticketsclose();
	
	Iterable<Ticket> showticketsbycustomer(String nomcustomer);
	
	Iterable<Ticket> showticketsstarts();
	
}
