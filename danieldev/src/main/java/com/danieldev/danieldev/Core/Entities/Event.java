package com.danieldev.danieldev.Core.Entities;

import com.danieldev.danieldev.Core.Enums.EventType;

import java.time.LocalDateTime;

public record Event(
        Long id,
        String name,
        String description,
        String identificator,
        String local,
        String manager,
        LocalDateTime dataInicio,
        LocalDateTime dataFim,
        EventType type
) {
}
