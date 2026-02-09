package com.danieldev.danieldev.Core.Gateway;

import com.danieldev.danieldev.Core.Entities.Event;

import java.util.List;
import java.util.Optional;

public interface EventGateway {

    Event createEvent(Event event);
    List<Event> searchEvent();
    boolean existsByIdentifier(String identificator);
    Optional<Event> filterEventIdentificator(String identificator);
    String idUnico = java.util.UUID.randomUUID().toString();
    void deleteByIdentifier(String identifier);
    Optional<Event> findByIdentifier(String identifier);
    Event updateEvent(Event event);
}