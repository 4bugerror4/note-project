package com.bug.note.entity.dto;

import javax.validation.constraints.NotBlank;

import com.bug.note.entity.Board;
import com.bug.note.entity.Reply;
import com.bug.note.entity.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReplySaveDto {
	
	private Long boardId;
	
	@NotBlank
	private String comment;
	
	public Reply toEntity(Board board, User user) {
		return Reply.builder()
				.board(board)
				.user(user)
				.comment(comment)
				.build();
	}

}
