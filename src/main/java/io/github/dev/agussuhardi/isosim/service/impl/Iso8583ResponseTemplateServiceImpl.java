package io.github.dev.agussuhardi.isosim.service.impl;

import io.github.dev.agussuhardi.isosim.dto.Iso8583ResponseTemplateDTO;
import io.github.dev.agussuhardi.isosim.entity.Iso8583ResponseTemplate;
import io.github.dev.agussuhardi.isosim.repository.Iso8583ResponseTemplateRepository;
import io.github.dev.agussuhardi.isosim.service.Iso8583ResponseTemplateService;
import io.github.dev.agussuhardi.isosim.util.ObjectMapperUtil;
import io.github.dev.agussuhardi.isosim.vo.Iso8583ResponseTemplateQueryVO;
import io.github.dev.agussuhardi.isosim.vo.Iso8583ResponseTemplateVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class Iso8583ResponseTemplateServiceImpl implements Iso8583ResponseTemplateService {

    private final Iso8583ResponseTemplateRepository iso8583ResponseTemplateRepository;

    @Override
    public void save(Iso8583ResponseTemplateVO vO) {
        Iso8583ResponseTemplate bean = new Iso8583ResponseTemplate();
        BeanUtils.copyProperties(vO, bean);
        iso8583ResponseTemplateRepository.save(bean);
    }

    @Override
    public void delete(String id) {
        iso8583ResponseTemplateRepository.deleteById(id);
    }

    @Override
    public Iso8583ResponseTemplateDTO getById(String id) {
        Iso8583ResponseTemplate original = requireOne(id);
        return toDTO(original);
    }

    @Override
    public Page<Iso8583ResponseTemplateDTO> query(Iso8583ResponseTemplateQueryVO vO, Pageable pageable) {
        return iso8583ResponseTemplateRepository.findAll(pageable).map(this::toDTO);
    }

    private Iso8583ResponseTemplateDTO toDTO(Iso8583ResponseTemplate original) {
        Iso8583ResponseTemplateDTO bean = new Iso8583ResponseTemplateDTO();
        BeanUtils.copyProperties(original, bean);

        if (original.getTemplate() != null) {
            bean.setTemplate(ObjectMapperUtil.toMap(original.getTemplate()));
        }
        return bean;
    }

    private Iso8583ResponseTemplate requireOne(String id) {
        return iso8583ResponseTemplateRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
