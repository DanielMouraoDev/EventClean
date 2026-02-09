package com.danieldev.danieldev.Core.Usecases;

import com.danieldev.danieldev.Core.Entities.Event;

public interface UpdateEventCase {

    Event execute(String identifier, Event eventData);
}
