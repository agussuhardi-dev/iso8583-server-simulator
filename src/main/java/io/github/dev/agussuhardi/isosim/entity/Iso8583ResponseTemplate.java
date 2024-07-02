package io.github.dev.agussuhardi.isosim.entity;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UuidGenerator;

import java.io.Serial;
import java.io.Serializable;
import java.util.Map;

@Data
@Entity
@Table(name = "iso8583_response_template")
public class Iso8583ResponseTemplate implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @Column(name = "updated_at")
    protected Long updatedAt;
    @Column(name = "created_at", nullable = false, updatable = false)
    protected Long createdAt;
    @Column(name = "id", nullable = false)
    @Id
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    @GeneratedValue
    private String id;
    private String name;
    private String explain;
    @Type(JsonType.class)
    @Column(name = "template", columnDefinition = "text")
    private String template;

    @PrePersist
    public void prePersist() {
        this.createdAt = System.currentTimeMillis();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = System.currentTimeMillis();
    }
}
