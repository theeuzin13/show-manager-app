package com.theeuzin.show_manager_app.domain.exception.show;

import java.util.UUID;

public class ShowNotFoundException extends RuntimeException {
    public ShowNotFoundException(UUID id) {
        super("Show not found: " + id);
    }
}