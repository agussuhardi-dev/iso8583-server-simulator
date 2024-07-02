package io.github.dev.agussuhardi.isosim.service;

import io.github.dev.agussuhardi.isosim.dto.Iso8583DTO;
import io.github.dev.agussuhardi.isosim.vo.Iso8583QueryVO;
import io.github.dev.agussuhardi.isosim.vo.Iso8583VO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author agussuhardi
 * {@code @created} 7/1/24 1:10 AM
 * {@code @project} isosim
 */
public interface Iso8583Service {
    Iso8583DTO save(Iso8583VO vO);

    void delete(String id);

    Iso8583DTO getById(String id);

    Page<Iso8583DTO> query(Iso8583QueryVO vO, Pageable pageable);
}
