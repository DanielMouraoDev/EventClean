package com.danieldev.danieldev.Core.Usecases;

import com.danieldev.danieldev.Core.Entities.Event;
import com.danieldev.danieldev.Core.Gateway.EventGateway;
import com.danieldev.danieldev.Infra.Exception.EventDuplicateException;

import static com.danieldev.danieldev.Core.Gateway.EventGateway.idUnico;

public class CreateEventCaseImpl implements CreateEventCase {

    private final EventGateway eventGateway;
    private final CreateIdentifierCase createIdentifierCase;

    public CreateEventCaseImpl(EventGateway eventGateway, CreateIdentifierCase createIdentifierCase) {
        this.eventGateway = eventGateway;
        this.createIdentifierCase = createIdentifierCase;
    }
    @Override
    public Event execute(Event event) {
        String finalIdentifier;

        if (event.identifier() != null && !event.identifier().isBlank()) {
            if (eventGateway.existsByIdentifier(event.identifier())) {
                throw new EventDuplicateException("O identificador: " + event.identifier() + " já está em uso!");
            }
            finalIdentifier = event.identifier();
        } else {
            finalIdentifier = createIdentifierCase.execute();
            while (eventGateway.existsByIdentifier(finalIdentifier)) {
                finalIdentifier = createIdentifierCase.execute();
            }
        }

        Event eventComId = new Event(
                idUnico,                // id Long (banco gera)
                event.name(),
                event.description(),
                finalIdentifier,
                event.localEvent(),
                event.manager(),
                event.dataStart(),
                event.dataEnd(),
                event.capacity(),
                event.type()
        );

        return eventGateway.createEvent(eventComId);
    }
    }