package com.exemple.cinema.resource;

import com.exemple.cinema.dto.OrderDto;
import com.exemple.cinema.dto.TicketDto;
import com.exemple.cinema.service.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ticket")
public class TicketResource {
    private final TicketService ticketService;

    public TicketResource(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/{id}")
    public TicketDto getTicketById(@PathVariable Long id) {
        return ticketService.getTicketById(id);
    }

    @GetMapping("/order_id/{id}")
    public List<TicketDto> getTicketsByOrderId(@PathVariable Long id) {
        return ticketService.getTicketsByOrderId(id);
    }

    @GetMapping("/")
    public List<TicketDto> getAll() {
        return ticketService.getAll();
    }

    @PostMapping("/")
    public TicketDto createTicket(@RequestBody TicketDto ticketDto) {
        return ticketService.createTicket(ticketDto);
    }

    @GetMapping("/addToOrder/{orderId}/ticket/{ticketId}")
    public OrderDto addTicketToOrder(@PathVariable Long orderId, @PathVariable Long ticketId){
        return ticketService.addTicketToOrder(orderId, ticketId);
    }

    @PutMapping("/")
    public TicketDto updateTicket(@RequestBody TicketDto ticketDto) {
        return ticketService.updateTicket(ticketDto);
    }

    @DeleteMapping("/{id}")
    public List<TicketDto> deleteTicket(@PathVariable Long id) {
        return ticketService.deleteTicketById(id);
    }
}
