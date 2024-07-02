package io.github.dev.agussuhardi.isosim.vo;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class Iso85838583ResponseTemplateUpdateVO extends Iso8583ResponseTemplateVO implements Serializable {
    private static final long serialVersionUID = 1L;

}
