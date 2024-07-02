package io.github.dev.agussuhardi.isosim.service.impl;

import io.github.dev.agussuhardi.isosim.dto.HistoryDTO;
import io.github.dev.agussuhardi.isosim.entity.History;
import io.github.dev.agussuhardi.isosim.repository.HistoryRepository;
import io.github.dev.agussuhardi.isosim.service.HistoryService;
import io.github.dev.agussuhardi.isosim.util.ObjectMapperUtil;
import io.github.dev.agussuhardi.isosim.vo.QueryVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class HistoryServiceImpl implements HistoryService {

    private final HistoryRepository historyRepository;

    @Override
    public HistoryDTO getById(String id) {
        History original = requireOne(id);
        return toDTO(original);
    }

    @Override
    public Page<HistoryDTO> query(QueryVO vO, Pageable pageable) {
        return historyRepository.findAll(pageable).map(this::toDTO);
    }

    private HistoryDTO toDTO(History original) {
        HistoryDTO bean = new HistoryDTO();
        BeanUtils.copyProperties(original, bean);

        if (original.getRequest() != null) {
            bean.setRequest(ObjectMapperUtil.toMap(original.getRequest()));
        }

        return bean;
    }

    private History requireOne(String id) {
        return historyRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
