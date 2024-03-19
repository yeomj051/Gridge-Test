package com.gridge.GridgeTest.controller;

import com.gridge.GridgeTest.dto.FeedSearchDto;
import com.gridge.GridgeTest.dto.UserSearchDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/admin/feed")
@RequiredArgsConstructor
public class AdminFeedController {
    @ApiOperation(value = "피드목록 조회 API", notes = "피드의 목록을 조회한다.", response = Map.class)
    @GetMapping()
    public ResponseEntity<Map<String, Object>> list(@ModelAttribute("FeedSearchDto") @ApiParam(value = "FeedSearchDto", required = true, example  = "0")
                                                        FeedSearchDto feedSearchDto) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;

        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }
    @ApiOperation(value = "피드 상세조회 API", notes = "피드의 정보를 상세조회한다.", response = Map.class)
    @GetMapping("/{feedId}/detail")
    public ResponseEntity<Map<String, Object>> detail(@PathVariable("feedId") @ApiParam(value = "feedId", required = true, example  = "0")
                                                          int feedId) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;

        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }
    @ApiOperation(value = "피드 삭제 API", notes = "삭제할 피드와 관련 댓글의 status를 변경한다.", response = Map.class)
    @PatchMapping("/{feedId}")
    public ResponseEntity<Map<String, Object>> block(@PathVariable("feedId") @ApiParam(value = "feedId", required = true, example  = "0")
                                                         int feedId) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;

        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }
}
