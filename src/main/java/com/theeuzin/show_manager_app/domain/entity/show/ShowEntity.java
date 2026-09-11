package com.theeuzin.show_manager_app.domain.entity.show;

import com.theeuzin.show_manager_app.domain.entity.DomainEntity;
import com.theeuzin.show_manager_app.domain.enums.ShowStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class ShowEntity extends DomainEntity {

    private String name;
    private String venue;
    private BigDecimal price;
    private LocalDateTime date;
    private ShowStatus status;

    public ShowEntity(UUID id, String name, String venue, BigDecimal price, LocalDateTime date, ShowStatus status) {
        super(id);
        validate(name, price, date);
        if (status == null) {
            throw new IllegalArgumentException("Status é obrigatório");
        }
        this.name = name;
        this.venue = venue;
        this.price = price;
        this.date = date;
        this.status = status;
    }

    public static ShowEntity create(String name, String venue, BigDecimal price, LocalDateTime date) {
        return new ShowEntity(null, name, venue, price, date, ShowStatus.PENDING);
    }

    public void updateDetails(String name, String venue, BigDecimal price, LocalDateTime date) {
        if (status == ShowStatus.CANCELLED) {
            throw new IllegalStateException("Não é possível alterar um show cancelado");
        }
        validate(name, price, date);
        this.name = name;
        this.venue = venue;
        this.price = price;
        this.date = date;
    }

    public void pay() {
        if (status == ShowStatus.CANCELLED) {
            throw new IllegalStateException("Não é possível pagar um show cancelado");
        }
        this.status = ShowStatus.PAID;
    }

    public void cancel() {
        if (status == ShowStatus.CANCELLED) {
            throw new IllegalStateException("O show já está cancelado");
        }
        this.status = ShowStatus.CANCELLED;
    }

    private static void validate(String name, BigDecimal price, LocalDateTime date) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Nome é obrigatório");
        }
        if (price == null || price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Preço não pode ser negativo");
        }
        if (date == null) {
            throw new IllegalArgumentException("Data é obrigatória");
        }
    }

    public String getName() { return name; }
    public String getVenue() { return venue; }
    public BigDecimal getPrice() { return price; }
    public LocalDateTime getDate() { return date; }
    public ShowStatus getStatus() { return status; }
}