package com.danieldev.danieldev.Core.Entities;

import com.danieldev.danieldev.Core.Enums.EventType;

import java.time.LocalDateTime;

public record Event(
        Long id,
        String name,
        String description,
        String identifier,
        String localEvent,
        String manager,
        LocalDateTime dataStart,
        LocalDateTime dataEnd,
        Integer capacity,
        EventType type
) {
}
