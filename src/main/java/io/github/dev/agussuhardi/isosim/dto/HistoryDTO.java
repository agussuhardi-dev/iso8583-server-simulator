package io.github.dev.agussuhardi.isosim.dto;


import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Map;

@Data
public class HistoryDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String id;

    private String acquirerCode;

    private Map<String, Object> request;

    private Long createdAt;

}
