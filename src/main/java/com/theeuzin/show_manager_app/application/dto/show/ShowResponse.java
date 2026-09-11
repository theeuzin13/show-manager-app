package com.theeuzin.show_manager_app.application.dto.show;

import com.theeuzin.show_manager_app.domain.enums.ShowStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record ShowResponse(
        UUID id,
        String name,
        String venue,
        BigDecimal price,
        LocalDateTime date,
        ShowStatus status
) { }
