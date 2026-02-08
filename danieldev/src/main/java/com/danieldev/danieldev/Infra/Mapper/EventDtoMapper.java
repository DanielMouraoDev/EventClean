package com.danieldev.danieldev.Infra.Mapper;

import com.danieldev.danieldev.Core.Entities.Event;
import com.danieldev.danieldev.Infra.DTOs.EventDto;
import org.springframework.stereotype.Component;

@Component
public class EventDtoMapper {

    public EventDto toDto(Event event) {
        return new EventDto(
                event.id(),
                event.name(),
                event.description(),
                event.identifier(),
                event.localEvent(),
                event.manager(),
                event.dataStart(),
                event.dataEnd(),
                event.capacity(),
                event.type()
        );
    }

    public Event toDomain(EventDto dto) {
        return new Event(
                dto.id(),
                dto.name(),
                dto.description(),
                dto.identifier(),
                dto.localEvent(),
                dto.manager(),
                dto.dataStart(),
                dto.dataEnd(),
                dto.capacity(),
                dto.type()
        );
    }
}