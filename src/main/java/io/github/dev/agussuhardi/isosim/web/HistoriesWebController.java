package io.github.dev.agussuhardi.isosim.web;

import io.github.dev.agussuhardi.isosim.config.GlobalApiResponse;
import io.github.dev.agussuhardi.isosim.dto.HistoryDTO;
import io.github.dev.agussuhardi.isosim.service.HistoryService;
import io.github.dev.agussuhardi.isosim.vo.QueryVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author agussuhardii
 * {@code @created} 29/08/23/08/2023 :11
 * {@code @project} inventory
 */

@RestController
@RequestMapping("web/api/v1/iso8583/histories")
@Slf4j
@RequiredArgsConstructor
@Validated
public class HistoriesWebController {

    private final HistoryService historyService;

    @GetMapping()
    public ResponseEntity<Page<HistoryDTO>> query(QueryVO vo, Pageable pageable) {
        return new GlobalApiResponse<>(historyService.query(vo, pageable), HttpStatus.OK);
    }
}
