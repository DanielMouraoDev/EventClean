package com.danieldev.danieldev.Core.Usecases;

import java.util.UUID;

public class CreateIdentifierCaseImpl implements CreateIdentifierCase {

        @Override
        public String execute() {
            UUID uuid = UUID.randomUUID();
            String codigoAleatorio = uuid.toString().substring(0, 8).toUpperCase();
            return String.format("EVT-2026-%s", codigoAleatorio);
        }
    }

