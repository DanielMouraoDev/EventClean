package com.danieldev.danieldev.Core.Usecases;

import com.danieldev.danieldev.Core.Entities.Event;
import com.danieldev.danieldev.Core.Gateway.EventGateway;
import com.danieldev.danieldev.Infra.Exception.EventNotFoundException;

public class UpdateEventCaseImpl implements UpdateEventCase{

    private final EventGateway eventGateway;

    public UpdateEventCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public Event execute(String identifier, Event eventData) {
        Event existingEvent = eventGateway.findByIdentifier(identifier)
                .orElseThrow(() -> new EventNotFoundException("Evento não encontrado para atualização."));

        Event updatedEvent = new Event(
                existingEvent.id(),
                eventData.name(),
                eventData.description(),
                existingEvent.identifier(), // O identifier não muda!
                eventData.localEvent(),
                eventData.manager(),
                eventData.dataStart(),
                eventData.dataEnd(),
                eventData.capacity(),
                eventData.type()
        );

        return eventGateway.updateEvent(updatedEvent);
    }
}
