package com.bug.note.controller.api;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bug.note.entity.User;
import com.bug.note.entity.dto.ResponseDto;
import com.bug.note.entity.dto.UserJoinDto;
import com.bug.note.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserApiController {
	
	private final UserService userService;
	
	@PostMapping("/join")
	public ResponseEntity<?> userJoin(@Valid @RequestBody UserJoinDto dto, BindingResult bindingResult) {
		
		User user = userService.join(dto.toEntity());
		
		return new ResponseEntity<>(new ResponseDto<>(1, "회원가입 성공", user), HttpStatus.CREATED);
	}

}
