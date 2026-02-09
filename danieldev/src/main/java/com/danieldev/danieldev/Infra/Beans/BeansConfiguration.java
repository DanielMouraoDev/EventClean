package com.danieldev.danieldev.Infra.Beans;

import com.danieldev.danieldev.Core.Gateway.EventGateway;
import com.danieldev.danieldev.Core.Usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfiguration {

    @Bean
    public CreateIdentifierCase createIdentifierCase() {
        return new CreateIdentifierCaseImpl();
    }

    @Bean
    public CreateEventCaseImpl createEventCase(EventGateway eventGateway, CreateIdentifierCase identifierCase) {
        return new CreateEventCaseImpl(eventGateway, identifierCase);
    }

    @Bean
    public SearchEventCaseImpl searchEventCase(EventGateway eventGateway) {
        return new SearchEventCaseImpl(eventGateway);
    }

    @Bean
    public FilterIdentifierCaseImpl filterIdentificatorCase(EventGateway eventGateway) {
        return new FilterIdentifierCaseImpl(eventGateway);
    }

    @Bean
    public DeleteEventCaseImpl deleteEventCase(EventGateway eventGateway) {
        return new DeleteEventCaseImpl(eventGateway);
    }

    @Bean
    public UpdateEventCase updateEventCase (EventGateway eventGateway) {
        return new UpdateEventCaseImpl(eventGateway);
    }
}