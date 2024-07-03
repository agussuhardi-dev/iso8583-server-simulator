package io.github.dev.agussuhardi.isosim.vo;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;


@Data
public class Iso8583ResponseTemplateVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    @NotNull(message = "name can not null")
    private String name;
    private String explain;
    @NotNull(message = "template can not null")
    private String template;

}
