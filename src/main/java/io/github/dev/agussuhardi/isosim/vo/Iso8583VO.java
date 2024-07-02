package io.github.dev.agussuhardi.isosim.vo;


import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Map;

@Data
public class Iso8583VO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    private Map<String, Object> responseJSONB;
    private Boolean enabled;
    private String acquirerCode;
    private String acquirerName;
    private Long updatedAt;
    private Long createdAt;
    private String rc;
    private String mti;
}
