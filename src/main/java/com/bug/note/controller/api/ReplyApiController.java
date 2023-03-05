package com.bug.note.controller.api;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bug.note.config.auth.PrincipalUserDetails;
import com.bug.note.entity.Board;
import com.bug.note.entity.Reply;
import com.bug.note.entity.dto.ReplyDeleteDto;
import com.bug.note.entity.dto.ReplyModifyDto;
import com.bug.note.entity.dto.ReplySaveDto;
import com.bug.note.entity.dto.ResponseDto;
import com.bug.note.service.BoardService;
import com.bug.note.service.ReplyService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ReplyApiController {
	
	private final ReplyService replyService;
	private final BoardService boardService;
	
	@PostMapping("/reply/save")
	public ResponseEntity<?> save(@Valid @RequestBody ReplySaveDto dto, BindingResult bindingResult,
			@AuthenticationPrincipal PrincipalUserDetails principal) {
		
		Board board = boardService.getboard(dto.getBoardId());
		
		Reply reply = replyService.save(dto.toEntity(board, principal.getUser()));
		
		return new ResponseEntity<>(new ResponseDto<>(1, "댓글 작성 완료", reply), HttpStatus.CREATED);
	}
	
	@PutMapping("/reply/modify")
	public ResponseEntity<?> modify(@Valid @RequestBody ReplyModifyDto dto, BindingResult bindingResult,
			@AuthenticationPrincipal PrincipalUserDetails principal) {
		
		Board board = boardService.getboard(dto.getBoardId());
		
		Reply reply = replyService.save(dto.toEntity(principal.getUser(), board));
		
		return new ResponseEntity<>(new ResponseDto<>(1, "댓글 수정 완료", reply), HttpStatus.OK);
	}
	
	@DeleteMapping("/reply/delete")
	public ResponseEntity<?> delete(@RequestBody ReplyDeleteDto dto) {
		
		replyService.delete(dto.getId());
		
		return new ResponseEntity<>(new ResponseDto<>(1, "댓글 삭제 완료", null), HttpStatus.OK);
	}
	

}
