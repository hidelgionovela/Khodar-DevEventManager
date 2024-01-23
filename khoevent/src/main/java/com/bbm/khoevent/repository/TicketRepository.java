package com.bbm.khoevent.repository;

import com.bbm.khoevent.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
