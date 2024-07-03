package io.github.dev.agussuhardi.isosim.dto;


import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Map;

@Data
public class Iso8583ResponseTemplateDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    protected Long updatedAt;
    protected Long createdAt;
    private String id;
    private String name;
    private String explain;
    private Map<String, Object> template;

}
