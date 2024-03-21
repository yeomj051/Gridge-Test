package com.gridge.GridgeTest.controller;

import com.gridge.GridgeTest.dto.request.UserCreateDto;
import com.gridge.GridgeTest.dto.request.UserLoginDto;
import com.gridge.GridgeTest.dto.request.UserPasswordModifyDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private static final String MESSAGE = "message";
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";
    @ApiOperation(value = "회원가입 API", notes = "서비스 자체 회원가입으로 최초 회원정보를 저장한다.", response = Map.class)
    @PostMapping()
    public ResponseEntity<Map<String, Object>> join(@Valid @RequestBody @ApiParam(value = "UserCreateDto", required = true, example  = "0")
                                                        UserCreateDto userCreateDto) {
        HttpStatus status = null;
        Map<String, Object> resultMap = new HashMap<>();

        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    @ApiOperation(value = "로그인 API", notes = "Access-token과 로그인 결과 메세지를 반환한다.", response = Map.class)
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@Valid @RequestBody @ApiParam(value = "UserLoginDto", required = true, example  = "0")
                                                         UserLoginDto userLoginFormDto) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;

        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    @ApiOperation(value = "로그아웃 API", notes = "회원 정보를 담은 Token을 제거한다.", response = Map.class)
    @GetMapping("/{userId}/logout")
    public ResponseEntity<Map<String, Object>> logout(@PathVariable("userId") @ApiParam(value = "userId", required = true, example  = "0")
                                                          int userId) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;

        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    @ApiOperation(value = "회원탈퇴 API", notes = "Access-token 해제와 탈퇴할 회원의 status를 변경한다.", response = Map.class)
    @PatchMapping("/{userId}/delete")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable("userId") @ApiParam(value = "userId", required = true, example  = "0")
                                                          int userId) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;

        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    @ApiOperation(value = "개인정보처리동의 API", notes = "개인정보처리에 동의한 날짜로 변환한다.", response = Map.class)
    @PatchMapping("/{userId}/agree")
    public ResponseEntity<Map<String, Object>> agreeToPersonal(@PathVariable("userId") @ApiParam(value = "userId", required = true, example  = "0")
                                                                   int userId) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;

        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    @ApiOperation(value = "비밀번호 수정 API", notes = "회원의 비밀번호를 수정한다.", response = Map.class)
    @PatchMapping("/{userId}/password")
    public ResponseEntity<Map<String, Object>> passwordModify(@PathVariable("userId") @ApiParam(value = "userId",required = true, example = "0")
                                                                  int userId,
                                                              @Valid @RequestBody @ApiParam(value = "UserPasswordModifyDto", required = true, example = "0")
                                                                UserPasswordModifyDto userPasswordModifyDto){
        Map<String,Object> resultMap = new HashMap<>();
        HttpStatus status = null;

        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    @ApiOperation(value = "회원 전화번호 확인 API", notes = "해당 회원의 전화번호가 맞는지 확인한다.", response = Map.class)
    @PostMapping("/{userId}/phone")
    public ResponseEntity<Map<String, Object>> passwordModify(@PathVariable("userId") @ApiParam(value = "userId",required = true, example = "0")
                                                                  int userId,
                                                              @Valid @RequestBody @ApiParam(value = "phone", required = true, example = "0")
                                                                String phone){
        Map<String,Object> resultMap = new HashMap<>();
        HttpStatus status = null;

        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

}
