package com.github.supercodingspring.repository.AirlineTicket;

import java.util.List;

public interface AirlineTicketRepository {
    List<AirlineTicket> findAllAirlineTicketsWithPlaceAndTicketType(String likePlace, String ticketType);

    List<AirlineTicketAndFlightInfo> findAllAirLineTicketAndFlightInfo(Integer airlineTicketId);
}