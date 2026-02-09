package com.danieldev.danieldev.Core.Usecases;

import com.danieldev.danieldev.Core.Gateway.EventGateway;
import com.danieldev.danieldev.Infra.Exception.EventNotFoundException;

public class DeleteEventCaseImpl implements DeleteEventCase{

    private final EventGateway eventGateway;

    public DeleteEventCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public void execute(String id) {
        if (eventGateway.existsByIdentifier(id)) {
            throw new EventNotFoundException("Evento com ID " + id + " não encontrado para deleção.");
        }
        eventGateway.deleteByIdentifier(id);
    }
}
