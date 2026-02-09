package com.danieldev.danieldev.Infra.Presentation;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventRepository extends JpaRepository<EventEntity, Long> {

    Optional<EventEntity> findByIdentifier(String identifier);

    boolean existsByIdentifier(String identifier);

    @Transactional
    void deleteByIdentifier(String identifier);


}
