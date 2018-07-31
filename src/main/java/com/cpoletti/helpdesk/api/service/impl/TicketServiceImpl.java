package com.cpoletti.helpdesk.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cpoletti.helpdesk.api.entity.ChangeStatus;
import com.cpoletti.helpdesk.api.entity.Ticket;
import com.cpoletti.helpdesk.api.repository.ChangeStatusRepository;
import com.cpoletti.helpdesk.api.repository.TicketRepository;
import com.cpoletti.helpdesk.api.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private ChangeStatusRepository changeStatusRepository;
	
	@Override
	public Ticket createOrUpdate(Ticket ticket) {
		return this.ticketRepository.save(ticket);
	}

	@Override
	public Ticket findById(String id) {
		return this.ticketRepository.findOne(id);
	}

	@Override
	public void delete(String id) {
		this.ticketRepository.delete(id);		
	}

	@Override
	public Page<Ticket> listTicket(int page, int size) {
		Pageable pages = new PageRequest(page, size);
		return this.ticketRepository.findAll(pages);
	}

	@Override
	public ChangeStatus createChangeStatus(ChangeStatus changeStatus) {
		return this.changeStatusRepository.save(changeStatus);
	}

	@Override
	public Iterable<ChangeStatus> listChangeStatus(String ticketId) {
		return this.changeStatusRepository.findByTicketIdOrderByDateChangeStatus(ticketId);
	}

	@Override
	public Page<Ticket> findByCurrentUser(int page, int size, String userId) {
		Pageable pages = new PageRequest(page, size);
		return this.ticketRepository.findByUserIdOrderByDateDesc(pages, userId);
	}

	@Override
	public Page<Ticket> findByParameters(int page, int size, String title, String status, String priority) {
		Pageable pages = new PageRequest(page, size);
		return this.ticketRepository.findByTitleIgnoreCaseContainingAndStatusContainingAndPriorityContainingOrderByDateDesc(title, status, priority, pages);
	}

	@Override
	public Page<Ticket> findByParametersAndCurrenteUser(int page, int size, String title, String status,
			String priority, String userId) {
		Pageable pages = new PageRequest(page, size);
		return this.ticketRepository.findByTitleIgnoreCaseContainingAndStatusContainingAndPriorityContainingAndUserIdOrderByDateDesc(title, status, priority, userId, pages);
	}

	@Override
	public Page<Ticket> findByNumber(int page, int size, Integer number) {
		Pageable pages = new PageRequest(page, size);
		return this.ticketRepository.findByNumber(number, pages);
	}

	@Override
	public Iterable<Ticket> findAll() {
		return this.ticketRepository.findAll();
	}

	@Override
	public Page<Ticket> findByParametersAndAssignedUser(int page, int size, String title, String status,
			String priority, String assignedUserId) {
		Pageable pages = new PageRequest(page, size);
		return this.ticketRepository.findByTitleIgnoreCaseContainingAndStatusContainingAndPriorityContainingAndAssignedUserIdOrderByDateDesc(title, status, priority, assignedUserId, pages);
	}

}
