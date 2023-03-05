package com.bug.note.controller.api;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bug.note.config.auth.PrincipalUserDetails;
import com.bug.note.entity.Board;
import com.bug.note.entity.ChildReply;
import com.bug.note.entity.Reply;
import com.bug.note.entity.User;
import com.bug.note.entity.dto.ChildReplySaveDto;
import com.bug.note.entity.dto.ResponseDto;
import com.bug.note.service.BoardService;
import com.bug.note.service.ChildReplyService;
import com.bug.note.service.ReplyService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ChildReplyApiController {
	
	private final ChildReplyService childReplyService;
	private final ReplyService replyService;
	private final BoardService boardService;
	
	@PostMapping("/reply/child/save")
	public ResponseEntity<?> save(@Valid @RequestBody ChildReplySaveDto dto, BindingResult bindingResult, 
			@AuthenticationPrincipal PrincipalUserDetails principal) {
		
		Reply reply = replyService.getReply(dto.getReplyId());
		User user = principal.getUser();
		
		ChildReply cReply = childReplyService.save(dto.toEntity(user, reply));
		
		return new ResponseEntity<>(new ResponseDto<>(1, "답글 작성 완료", cReply), HttpStatus.OK);
	}

}
