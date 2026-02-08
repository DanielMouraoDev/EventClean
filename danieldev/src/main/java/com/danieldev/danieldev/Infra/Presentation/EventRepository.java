package com.danieldev.danieldev.Infra.Presentation;

import com.danieldev.danieldev.Core.Entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventRepository extends JpaRepository<EventEntity, Long> {

    Optional<EventEntity> findByIdentifier(String identifier);

}
