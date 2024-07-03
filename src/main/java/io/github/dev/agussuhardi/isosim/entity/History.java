package io.github.dev.agussuhardi.isosim.entity;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UuidGenerator;

import java.io.Serial;
import java.io.Serializable;

@Data
@Entity
@Table(name = "history")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class History implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "id", nullable = false)
    @Id
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    @GeneratedValue
    private String id;

    @Column(name = "acquirer_code", nullable = false)
    private String acquirerCode;

    @Type(JsonType.class)
    @Column(name = "request", columnDefinition = "text")
    private String request;

    @Column(name = "created_at", nullable = false)
    private Long createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = System.currentTimeMillis();
    }

}
