package com.danieldev.danieldev.Core.Usecases;

import com.danieldev.danieldev.Core.Entities.Event;
import com.danieldev.danieldev.Core.Gateway.EventGateway;
import com.danieldev.danieldev.Infra.Exception.EventNotFoundException;

public class FilterIdentifierCaseImpl implements FilterIdentifierCase {

    private final EventGateway eventGateway;

    public FilterIdentifierCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public Event execute(String identificator) {
        return eventGateway.filterEventIdentificator(identificator)
                .orElseThrow(() -> new EventNotFoundException("Evento com identificador: " + identificator + " nao encontrado"));
    }
}
