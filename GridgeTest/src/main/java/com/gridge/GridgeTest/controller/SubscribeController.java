package com.gridge.GridgeTest.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/subscribe")
@RequiredArgsConstructor
public class SubscribeController {
    @ApiOperation(value = "구독여부 조회 API", notes = "구독여부 조회한다.", response = Map.class)
    @GetMapping("/{userId}")
    public ResponseEntity<Map<String, Object>> check(@PathVariable("userId") @ApiParam(value = "userId",required = true, example = "0")
                                                        int userId) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;

        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }
    @ApiOperation(value = "구독 결제 API", notes = "구독 후 결제를 진행한다.", response = Map.class)
    @PostMapping("/{userId}")
    public ResponseEntity<Map<String, Object>> createSubscribe(@PathVariable("userId") @ApiParam(value = "userId",required = true, example = "0")
                                                    int userId) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;

        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }
    @ApiOperation(value = "구독 결제 취소 API", notes = "구독을 취소한다.", response = Map.class)
    @PatchMapping("/{userId}")
    public ResponseEntity<Map<String, Object>> cancelSubscribe(@PathVariable("userId") @ApiParam(value = "userId",required = true, example = "0")
                                                               int userId) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;

        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }
}
