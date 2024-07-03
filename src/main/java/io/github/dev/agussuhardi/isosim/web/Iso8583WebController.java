package io.github.dev.agussuhardi.isosim.web;

import io.github.dev.agussuhardi.isosim.config.GlobalApiResponse;
import io.github.dev.agussuhardi.isosim.dto.Iso8583DTO;
import io.github.dev.agussuhardi.isosim.service.Iso8583Service;
import io.github.dev.agussuhardi.isosim.vo.Iso8583QueryVO;
import io.github.dev.agussuhardi.isosim.vo.Iso8583VO;
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
@RequestMapping("web/api/v1/iso8583")
@Slf4j
@RequiredArgsConstructor
@Validated
public class Iso8583WebController {

    private final Iso8583Service iso8583Service;

    @GetMapping()
    public ResponseEntity<Page<Iso8583DTO>> query(Iso8583QueryVO vo, Pageable pageable) {
        return new GlobalApiResponse<>(iso8583Service.query(vo, pageable), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Iso8583DTO> save(@RequestBody @Valid Iso8583VO vo) {
        return new GlobalApiResponse<>(iso8583Service.save(vo), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Iso8583DTO> getById(@PathVariable String id) {
        return new GlobalApiResponse<>(iso8583Service.getById(id), HttpStatus.OK);
    }
}
