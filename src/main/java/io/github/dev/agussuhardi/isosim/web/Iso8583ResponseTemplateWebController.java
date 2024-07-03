package io.github.dev.agussuhardi.isosim.web;

import io.github.dev.agussuhardi.isosim.config.GlobalApiResponse;
import io.github.dev.agussuhardi.isosim.dto.Iso8583ResponseTemplateDTO;
import io.github.dev.agussuhardi.isosim.service.Iso8583ResponseTemplateService;
import io.github.dev.agussuhardi.isosim.vo.Iso8583ResponseTemplateQueryVO;
import io.github.dev.agussuhardi.isosim.vo.Iso8583ResponseTemplateVO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author agussuhardii
 * {@code @created} 29/08/23/08/2023 :11
 * {@code @project} inventory
 */

@RestController
@RequestMapping("web/api/v1/iso8583/templates")
@Slf4j
@RequiredArgsConstructor
@Validated
public class Iso8583ResponseTemplateWebController {

    private final Iso8583ResponseTemplateService templateService;

    @GetMapping()
    public ResponseEntity<Page<Iso8583ResponseTemplateDTO>> query(Iso8583ResponseTemplateQueryVO vo, Pageable pageable) {
        return new GlobalApiResponse<>(templateService.query(vo, pageable), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Valid Iso8583ResponseTemplateVO vo) {
        templateService.save(vo);
        return new GlobalApiResponse<>(HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Iso8583ResponseTemplateDTO> getById(@PathVariable String id) {
        return new GlobalApiResponse<>(templateService.getById(id), HttpStatus.OK);
    }
}
