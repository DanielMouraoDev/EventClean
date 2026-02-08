package com.danieldev.danieldev.Infra.Gateway;

import com.danieldev.danieldev.Core.Entities.Event;
import com.danieldev.danieldev.Core.Gateway.EventGateway;
import com.danieldev.danieldev.Infra.Mapper.EventEntityMapper;
import com.danieldev.danieldev.Infra.Presentation.EventEntity;
import com.danieldev.danieldev.Infra.Presentation.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class EventRepositoryGateway implements EventGateway {

    private final EventRepository eventRepository;
    private final EventEntityMapper mapper;

    @Override
    public Event createEvent(Event event) {
        EventEntity entity = mapper.toEntity(event);
        EventEntity saved = eventRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public List<Event> searchEvent() {
        return eventRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public boolean existsByIdentifier(String identificator) {
        return eventRepository.findAll().stream()
                .anyMatch(eventEntity -> eventEntity.getIdentifier().equalsIgnoreCase(identificator));
    }

    @Override
    public Optional<Event> filterEventIdentificator(String identificator) {
        return eventRepository.findByIdentifier(identificator)
                .map(mapper::toDomain);
    }
}
