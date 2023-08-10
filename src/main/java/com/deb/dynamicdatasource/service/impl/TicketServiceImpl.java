package com.deb.dynamicdatasource.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deb.dynamicdatasource.entity.Ticket;
import com.deb.dynamicdatasource.repo.TicketRepo;
import com.deb.dynamicdatasource.service.TicketService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class TicketServiceImpl implements TicketService{
	
	
	@Autowired
	private TicketRepo ticketRepo;
	
	//modif du 24/05/2022
	@Override
    public Iterable<Ticket> showticketfull() {
        return ticketRepo.showticketfull();
    }
	
	
    @Override
    public List<Ticket> listticketfull() {
        return ticketRepo.listticketfull();
    }

    @Autowired
    public void setTicketRepo(TicketRepo ticketRepo) {
        this.ticketRepo = ticketRepo;
    }

    @Override
    public Iterable<Ticket> listAllTickets() {
        return ticketRepo.findAll();
    }

    @Override
    public Ticket getTicketById(long id) {
        Ticket ticket=ticketRepo.findById(id).orElse(null);
		return ticket;
    }

    @Override
    public Ticket saveTicket(Ticket ticket) {
        return ticketRepo.save(ticket);
    }

    @Override
    public void deleteTicket(long id) {
        ticketRepo.deleteById(id);
    }
	

	 @Override
    public long showmaxidticket() {
      return  ticketRepo.showmaxidticket();
    }

	@Override
    public Iterable<Ticket> showticketsau() {
        return ticketRepo.showticketsau();
    }
	
	@Override
    public Iterable<Ticket> showticketsactif() {
        return ticketRepo.showticketsactif();
    }
	
	@Override
    public Iterable<Ticket> showticketsclose() {
        return ticketRepo.showticketsclose();
    }
	
	
	@Override
    public Iterable<Ticket> showticketsbycustomer(String nomcustomer) {
        return ticketRepo.showticketsbycustomer(nomcustomer);
     }
	
	@Override
    public Iterable<Ticket> showticketsstarts() {
        return ticketRepo.showticketsstarts();
    }
	
	// @Override
    // public Iterable<Ticket> Ticketsociete(String lecodsoc) {
        // return ticketRepo.Ticketsociete(lecodsoc);
    // }
	
}
