package io.github.dev.agussuhardi.isosim.service;

import io.github.dev.agussuhardi.isosim.dto.Iso8583ResponseTemplateDTO;
import io.github.dev.agussuhardi.isosim.vo.Iso8583ResponseTemplateQueryVO;
import io.github.dev.agussuhardi.isosim.vo.Iso8583ResponseTemplateVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author agussuhardi
 * {@code @created} 7/1/24 2:56 AM
 * {@code @project} isosim
 */
public interface Iso8583ResponseTemplateService {
    void save(Iso8583ResponseTemplateVO vO);

    void delete(String id);

    Iso8583ResponseTemplateDTO getById(String id);

    Page<Iso8583ResponseTemplateDTO> query(Iso8583ResponseTemplateQueryVO vO, Pageable pageable);
}
