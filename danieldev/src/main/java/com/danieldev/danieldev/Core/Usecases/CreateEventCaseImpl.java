package com.danieldev.danieldev.Core.Usecases;

import com.danieldev.danieldev.Core.Entities.Event;
import com.danieldev.danieldev.Core.Gateway.EventGateway;
import com.danieldev.danieldev.Infra.Exception.EventDuplicateException; // Certifique-se do import correto

public class CreateEventCaseImpl implements CreateEventCase {

    private final EventGateway eventGateway;

    public CreateEventCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public Event execute(Event event) {
        if (eventGateway.existsByIdentifier(event.identifier())) {
            throw new EventDuplicateException("O identificador de numero: " + event.identifier() + " ja foi utilizado!");
        }
        return eventGateway.createEvent(event);
    }
}