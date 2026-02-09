package com.danieldev.danieldev.Infra.Presentation;

import com.danieldev.danieldev.Core.Enums.EventType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_event")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventEntity {

    @Id
    private String id;
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

