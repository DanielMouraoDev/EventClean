package com.danieldev.danieldev.Infra.DTOs;

import com.danieldev.danieldev.Core.Enums.EventType;

import java.time.LocalDateTime;

public record EventDto(String id,
                       String name,
                       String description,
                       String identifier,
                       String localEvent,
                       String manager,
                       LocalDateTime dataStart,
                       LocalDateTime dataEnd,
                       Integer capacity,
                       EventType type) {}



