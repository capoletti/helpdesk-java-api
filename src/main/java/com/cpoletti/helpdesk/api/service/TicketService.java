package com.cpoletti.helpdesk.api.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.cpoletti.helpdesk.api.entity.ChangeStatus;
import com.cpoletti.helpdesk.api.entity.Ticket;

@Component
public interface TicketService {

	Ticket createOrUpdate(Ticket ticket);
	
	Ticket findById(String id);
	
	void delete(String id);
	
	Page<Ticket> listTicket(int page, int size);
	
	ChangeStatus createChangeStatus(ChangeStatus changeStatus);
	
	Iterable<ChangeStatus> listChangeStatus(String ticketId);
	
	Page<Ticket> findByCurrentUser(int page, int size, String userId);
	
	Page<Ticket> findByParameters(int page, int size, String title, String status, String priority);
	
	Page<Ticket> findByParametersAndCurrenteUser(int page, int size, String title, String status, String priority, String userId);
	
	Page<Ticket> findByNumber(int page, int size, Integer number);
	
	Iterable<Ticket> findAll();
	
	Page<Ticket> findByParametersAndAssignedUser(int page, int size, String title, String status, String priority, String assignedUserId);
	
}
