package com.theeuzin.show_manager_app.application.dto.show;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ShowRequest(
    @NotBlank @Size(max = 150) String name,
    @Size(max = 150) String venue,
    @NotNull @PositiveOrZero @Digits(integer = 8, fraction = 2) BigDecimal price,
    @NotNull LocalDateTime date
) {}
