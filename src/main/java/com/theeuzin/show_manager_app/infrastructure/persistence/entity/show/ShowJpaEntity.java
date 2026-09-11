package com.theeuzin.show_manager_app.infrastructure.persistence.entity.show;

import com.theeuzin.show_manager_app.domain.enums.ShowStatus;
import com.theeuzin.show_manager_app.infrastructure.persistence.entity.BaseEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDateTime;
import java.math.BigDecimal;


@Entity
@Table(name = "shows")
@SQLDelete(sql = "UPDATE shows SET deleted_at = CURRENT_TIMESTAMP, updated_at = CURRENT_TIMESTAMP WHERE id = ?")
@SQLRestriction("deleted_at IS NULL")
public class ShowJpaEntity extends BaseEntity {

    @Column(nullable = false, length = 150)
    private String name;

    @Column(length = 150)
    private String venue;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(nullable = false)
    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private ShowStatus status;

    protected ShowJpaEntity() {}

    public ShowJpaEntity(String name, String venue, BigDecimal price, LocalDateTime date, ShowStatus status){
        this.name = name;
        this.venue = venue;
        this.price = price;
        this.date = date;
        this.status = status;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getVenue() { return venue; }
    public void setVenue(String venue) { this.venue = venue; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public LocalDateTime getDate() { return date; }
    public void setDate(LocalDateTime date) { this.date = date; }

    public ShowStatus getStatus() { return status; }
    public void setStatus(ShowStatus status) { this.status = status; }

}
