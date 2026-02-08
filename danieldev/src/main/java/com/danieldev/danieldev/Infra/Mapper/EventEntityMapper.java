package com.danieldev.danieldev.Infra.Mapper;

import com.danieldev.danieldev.Core.Entities.Event;
import com.danieldev.danieldev.Infra.Presentation.EventEntity;
import org.springframework.stereotype.Component;

@Component
public class EventEntityMapper {

    public EventEntity toEntity(Event event) {
        return new EventEntity(
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

    public Event toDomain(EventEntity eventEntity) {
        return new Event(
                eventEntity.getId(),
                eventEntity.getName(),
                eventEntity.getDescription(),
                eventEntity.getIdentifier(),
                eventEntity.getLocalEvent(),
                eventEntity.getManager(),
                eventEntity.getDataStart(),
                eventEntity.getDataEnd(),
                eventEntity.getCapacity(),
                eventEntity.getType()
        );
    }
}