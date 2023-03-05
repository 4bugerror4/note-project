package com.bug.note.controller.api;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bug.note.config.auth.PrincipalUserDetails;
import com.bug.note.entity.Board;
import com.bug.note.entity.dto.BoardModifyDto;
import com.bug.note.entity.dto.BoardSaveDto;
import com.bug.note.entity.dto.ResponseDto;
import com.bug.note.service.BoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BoardApiController {
	
	private final BoardService boardService;
	
	@PostMapping("/board/save")
	public ResponseEntity<?> save(@Valid @RequestBody BoardSaveDto dto, BindingResult bindingResult, 
			@AuthenticationPrincipal PrincipalUserDetails principal) {
		
		Board board = boardService.save(dto.toEntity(), principal.getUser());
		
		return new ResponseEntity<>(new ResponseDto<>(1, "게시글 작성 완료", board), HttpStatus.CREATED);
	}
	
	@PutMapping("/board/modify")
	public ResponseEntity<?> modify(@Valid @RequestBody BoardModifyDto dto, BindingResult bindingResult, 
			@AuthenticationPrincipal PrincipalUserDetails principal) {
		
		Board board = boardService.modify(dto.toEntity());
		
		return new ResponseEntity<>(new ResponseDto<>(1, "게시글 수정 완료", board), HttpStatus.OK);
	}
	
	@DeleteMapping("/board/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		boardService.delete(id);
		
		return new ResponseEntity<>(new ResponseDto<>(1, "게시글 삭제 완료", null), HttpStatus.OK);
	}
}
