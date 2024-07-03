package io.github.dev.agussuhardi.isosim.entity;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UuidGenerator;

import java.io.Serial;
import java.io.Serializable;

@Data
@Entity
@Table(name = "iso8583")
public class Iso8583 implements Serializable {

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

    @Type(JsonType.class)
    @Column(name = "response", columnDefinition = "text")
    private String response;

    @Column(name = "is_enabled")
    private Boolean enabled;
    @Column(name = "acquirer_code")
    private String acquirerCode;
    @Column(name = "acquirer_name")
    private String acquirerName;
    private String rc;
    private String mti;

    @PrePersist
    public void prePersist() {
        this.createdAt = System.currentTimeMillis();
        this.enabled = true;
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = System.currentTimeMillis();
        this.enabled = true;
    }

}
