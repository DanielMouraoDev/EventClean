package com.danieldev.danieldev.Infra.Beans;

import com.danieldev.danieldev.Core.Gateway.EventGateway;
import com.danieldev.danieldev.Core.Usecases.CreateEventCaseImpl;
import com.danieldev.danieldev.Core.Usecases.FilterIdentificatorCase;
import com.danieldev.danieldev.Core.Usecases.FilterIdentificatorCaseImpl;
import com.danieldev.danieldev.Core.Usecases.SearchEventCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfiguration {


    @Bean
    public CreateEventCaseImpl createEventCase(EventGateway eventGateway) {
        return new CreateEventCaseImpl(eventGateway);
    }

    @Bean
    public SearchEventCaseImpl searchEventCase(EventGateway eventGateway) {
        return new SearchEventCaseImpl(eventGateway);
    }

    @Bean
    public FilterIdentificatorCaseImpl filterIdentificatorCase(EventGateway eventGateway) {
        return new FilterIdentificatorCaseImpl(eventGateway);
    }
}