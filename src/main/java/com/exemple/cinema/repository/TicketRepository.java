package com.exemple.cinema.repository;

import com.exemple.cinema.entity.Ticket;
import com.exemple.cinema.exception.ServiceException;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TicketRepository {
    private List<Ticket> ticketList;
    private Long count;

    @PostConstruct
    public void initOrders() {
        ticketList = new ArrayList<>();
        count = 0L;
    }

    public List<Ticket> getAll(){
        return ticketList;
    }

    public Ticket getById(final Long id){
        Ticket ticket = ticketList.stream()
                .filter((e -> e.getId().equals(id)))
                .findFirst()
                .orElseThrow(()-> new ServiceException(400,"Ticket not found",null));

        return ticket;
    }

    public Ticket save(final Ticket ticket){
        ++count;
        ticket.setId(count);
        ticketList.add(ticket);
        return ticket;
    }

    public Ticket update(Ticket ticket) {
        final Ticket oldTicket = getById(ticket.getId());
        if (oldTicket==null){
            throw new ServiceException(400,"Ticket not found", null);
        }
        ticketList.remove(oldTicket);
        ticketList.add(ticket);

        return ticket;
    }

    public  List<Ticket> delete(final Long id){
        Ticket ticket = getById(id);
        if(ticket==null){
            throw new ServiceException(400, "Ticket not found", null);
        }
        ticketList.remove(ticket);

        return ticketList;
    }

}
