package com.danieldev.danieldev.Core.Usecases;

import com.danieldev.danieldev.Core.Entities.Event;
import com.danieldev.danieldev.Core.Gateway.EventGateway;

import java.util.List;

public class SearchEventCaseImpl implements SearchEventCase{

    private final EventGateway eventGateway;

    public SearchEventCaseImpl(EventGateway eventGateway) {this.eventGateway = eventGateway; }

    @Override
    public List<Event> execute() {
        return eventGateway.searchEvent();
    }

}

