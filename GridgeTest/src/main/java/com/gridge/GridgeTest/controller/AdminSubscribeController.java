package com.gridge.GridgeTest.controller;

import com.gridge.GridgeTest.dto.request.SubscribeSearchDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/admin/subscribe")
@RequiredArgsConstructor
public class AdminSubscribeController {
    @ApiOperation(value = "구독목록 조회 API", notes = "구독의 목록을 조회한다.", response = Map.class)
    @GetMapping()
    public ResponseEntity<Map<String, Object>> list(@ModelAttribute("SubscribeSearchDto") @ApiParam(value = "SubscribeSearchDto", required = true, example  = "0")
                                                    SubscribeSearchDto subscribeSearchDto) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;

        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }
    @ApiOperation(value = "구독 상세조회 API", notes = "구독정보를 상세조회한다.", response = Map.class)
    @GetMapping("/{subscribeId}/detail")
    public ResponseEntity<Map<String, Object>> detail(@PathVariable("subscribeId") @ApiParam(value = "subscribeId", required = true, example  = "0")
                                                      int subscribeId) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;

        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }
}
