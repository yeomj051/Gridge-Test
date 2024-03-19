package com.gridge.GridgeTest.controller;

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
@RequestMapping("/api/admin/user")
@RequiredArgsConstructor
public class AdminUserController {
    @ApiOperation(value = "회원목록 조회 API", notes = "회원의 목록을 조회한다.", response = Map.class)
    @GetMapping()
    public ResponseEntity<Map<String, Object>> list(@ModelAttribute("userSearchDto") @ApiParam(value = "UserSearchDto", required = true, example  = "0")
                                                        UserSearchDto userSearchDto) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;

        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }
    @ApiOperation(value = "회원 상세조회 API", notes = "회원의 정보를 상세조회한다.", response = Map.class)
    @GetMapping("/{userId}/detail")
    public ResponseEntity<Map<String, Object>> detail(@PathVariable("userId") @ApiParam(value = "userId", required = true, example  = "0")
                                                          int userId) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;

        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }
    @ApiOperation(value = "회원정지 API", notes = "Access-token 해제와 정지할 회원의 status를 변경한다.", response = Map.class)
    @PatchMapping("/{userId}")
    public ResponseEntity<Map<String, Object>> block(@PathVariable("userId") @ApiParam(value = "userId", required = true, example  = "0")
                                                      int userId) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;

        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }
}
