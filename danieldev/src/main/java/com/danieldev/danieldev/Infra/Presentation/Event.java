package com.danieldev.danieldev.Infra.Presentation;

import com.danieldev.danieldev.Core.Enums.EventType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "Events")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String identifier;
    private String localEvent;
    private String manager;
    private LocalDateTime dataStart;
    private LocalDateTime dataEnd;
    private Integer capacity;
    @Enumerated(EnumType.STRING)
    private EventType type;


    }

