package com.gridge.GridgeTest.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/admin/report")
@RequiredArgsConstructor
public class AdminReportController {
    @ApiOperation(value = "신고목록 조회 API", notes = "신고목록을 조회한다.", response = Map.class)
    @GetMapping()
    public ResponseEntity<Map<String, Object>> list() {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;

        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }
}
