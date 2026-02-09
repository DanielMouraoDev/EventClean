package com.danieldev.danieldev.Infra.Presentation;

import com.danieldev.danieldev.Core.Entities.Event;
import com.danieldev.danieldev.Core.Usecases.*;
import com.danieldev.danieldev.Infra.DTOs.EventDto;
import com.danieldev.danieldev.Infra.Mapper.EventDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/events")
public class EventController {

    private final CreateEventCase createEventCase;
    private final SearchEventCase searchEventCase;
    private final FilterIdentifierCase filterIdentifierCase;
    private final DeleteEventCase deleteEventCase;
    private final UpdateEventCase updateEventCase; // Novo Use Case injetado
    private final EventDtoMapper eventDtoMapper;

    // Construtor completo com todas as dependências
    public EventController(CreateEventCase createEventCase,
                           SearchEventCase searchEventCase,
                           FilterIdentifierCase filterIdentifierCase,
                           DeleteEventCase deleteEventCase,
                           UpdateEventCase updateEventCase,
                           EventDtoMapper eventDtoMapper) {
        this.createEventCase = createEventCase;
        this.searchEventCase = searchEventCase;
        this.filterIdentifierCase = filterIdentifierCase;
        this.deleteEventCase = deleteEventCase;
        this.updateEventCase = updateEventCase;
        this.eventDtoMapper = eventDtoMapper;
    }

    @PostMapping("createevent")
    public ResponseEntity<Map<String, Object>> createEvent(@RequestBody EventDto eventoDto) {
        Event newEvent = createEventCase.execute(eventDtoMapper.toDomain(eventoDto));
        Map<String, Object> response = new HashMap<>();
        response.put("Menssagem:", "Evento cadastrado com sucesso!");
        response.put("Dados do Evento", eventDtoMapper.toDto(newEvent));
        return ResponseEntity.ok(response);
    }

    @GetMapping("searchevent")
    public List<EventDto> searchEvent() {
        return searchEventCase.execute()
                .stream()
                .map(eventDtoMapper::toDto)
                .toList();
    }

    @GetMapping("/identifier/{identifier}")
    public ResponseEntity<EventDto> searchByIdentifier(@PathVariable String identifier) {
        Event event = filterIdentifierCase.execute(identifier);
        return ResponseEntity.ok(eventDtoMapper.toDto(event));
    }

    @DeleteMapping("/identifier/{identifier}")
    public ResponseEntity<Map<String, String>> deleteByIdentifier(@PathVariable String identifier) {
        deleteEventCase.execute(identifier);
        Map<String, String> response = new HashMap<>();
        response.put("Mensagem", "Evento " + identifier + " removido com sucesso!");
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update/{identifier}")
    public ResponseEntity<Map<String, Object>> update(@PathVariable String identifier, @RequestBody EventDto eventDto) {
        Event updatedEvent = updateEventCase.execute(identifier, eventDtoMapper.toDomain(eventDto));

        Map<String, Object> response = new HashMap<>();
        response.put("Mensagem:", "Evento atualizado com sucesso!");
        response.put("Dados Atualizados", eventDtoMapper.toDto(updatedEvent));

        return ResponseEntity.ok(response);
    }
}