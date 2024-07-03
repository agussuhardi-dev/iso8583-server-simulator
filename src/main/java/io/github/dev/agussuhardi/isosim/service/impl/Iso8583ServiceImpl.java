package io.github.dev.agussuhardi.isosim.service.impl;


import io.github.dev.agussuhardi.isosim.dto.Iso8583DTO;
import io.github.dev.agussuhardi.isosim.entity.Iso8583;
import io.github.dev.agussuhardi.isosim.repository.Iso8583Repository;
import io.github.dev.agussuhardi.isosim.service.Iso8583Service;
import io.github.dev.agussuhardi.isosim.util.ObjectMapperUtil;
import io.github.dev.agussuhardi.isosim.vo.Iso8583QueryVO;
import io.github.dev.agussuhardi.isosim.vo.Iso8583VO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Slf4j
public class Iso8583ServiceImpl implements Iso8583Service {

    private final Iso8583Repository iso8583Repository;

    @Transactional
    @Override
    public Iso8583DTO save(Iso8583VO vO) {
        log.info("save => {}", vO);
        iso8583Repository.disableAll();
        Iso8583 bean = new Iso8583();
        BeanUtils.copyProperties(vO, bean);
        log.info("save => {}", bean);
        bean = iso8583Repository.save(bean);
        return toDTO(bean);
    }

    @Override
    public void delete(String id) {
        iso8583Repository.deleteById(id);
    }

    @Override
    public Iso8583DTO getById(String id) {
        Iso8583 original = requireOne(id);
        return toDTO(original);
    }

    @Override
    public Page<Iso8583DTO> query(Iso8583QueryVO vO, Pageable pageable) {
        return iso8583Repository.findAll(pageable).map(this::toDTO);
    }

    private Iso8583DTO toDTO(Iso8583 original) {
        Iso8583DTO bean = new Iso8583DTO();
        BeanUtils.copyProperties(original, bean);

        if (original.getResponse() != null) {
            bean.setResponse(ObjectMapperUtil.toMap(original.getResponse()));
        }

        return bean;
    }

    private Iso8583 requireOne(String id) {
        return iso8583Repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
