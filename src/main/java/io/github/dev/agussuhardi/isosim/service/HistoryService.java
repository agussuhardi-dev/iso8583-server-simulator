package io.github.dev.agussuhardi.isosim.service;

import io.github.dev.agussuhardi.isosim.dto.HistoryDTO;
import io.github.dev.agussuhardi.isosim.vo.QueryVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author agussuhardi
 * {@code @created} 7/1/24 5:50 AM
 * {@code @project} isosim
 */
public interface HistoryService {
    HistoryDTO getById(String id);

    Page<HistoryDTO> query(QueryVO vO, Pageable pageable);
}
