package io.github.dev.agussuhardi.isosim.vo;


import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class Iso8583QueryVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String q;

}
