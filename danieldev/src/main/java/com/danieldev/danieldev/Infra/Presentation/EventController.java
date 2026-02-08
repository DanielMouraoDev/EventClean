package com.danieldev.danieldev.Infra.Presentation;

import com.danieldev.danieldev.Core.Entities.Event;
import com.danieldev.danieldev.Core.Usecases.CreateEventCase;
import com.danieldev.danieldev.Core.Usecases.FilterIdentificatorCase;
import com.danieldev.danieldev.Core.Usecases.SearchEventCase;
import com.danieldev.danieldev.Infra.DTOs.EventDto;
import com.danieldev.danieldev.Infra.Mapper.EventDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("api/v1/events")
public class EventController {

    private final CreateEventCase createEventCase;
    private final SearchEventCase searchEventCase;
    private final EventDtoMapper eventDtoMapper;
    private final FilterIdentificatorCase filterIdentificatorCase;


    public EventController(CreateEventCase createEventCase, SearchEventCase searchEventCase, EventDtoMapper eventDtoMapper, FilterIdentificatorCase filterIdentificatorCase) {
        this.createEventCase = createEventCase;
        this.searchEventCase = searchEventCase;
        this.eventDtoMapper = eventDtoMapper;
        this.filterIdentificatorCase = filterIdentificatorCase;
    }


    @PostMapping("createevent")
    public ResponseEntity<Map<String, Object>> createEvent(@RequestBody EventDto eventoDto) {
        Event newEvent = createEventCase.execute(eventDtoMapper.toDomain(eventoDto));
        Map<String, Object> response = new HashMap<>();
        response.put("Menssagem:", "Evento cadastrado com sucesso no nosso banco de dados!");
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

    @GetMapping("/identificator/{identificator}")
    public ResponseEntity<EventDto> searchByIdentificator(@PathVariable String identificator) {
        Event event = filterIdentificatorCase.execute(identificator);
        return ResponseEntity.ok(eventDtoMapper.toDto(event));
    }
}