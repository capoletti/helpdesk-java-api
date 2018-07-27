package com.cpoletti.helpdesk.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cpoletti.helpdesk.api.entity.ChangeStatus;

public interface ChangeStatusRepository extends MongoRepository<ChangeStatus, String>{

	Iterable<ChangeStatus> findByTicketIdOrderByDateChangeStatus(String ticketId);
}
