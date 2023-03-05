package com.bug.note.entity.dto;

import javax.validation.constraints.NotBlank;

import com.bug.note.entity.Board;
import com.bug.note.entity.Reply;
import com.bug.note.entity.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReplyModifyDto {
	
	private Long replyId;
	
	private Long boardId;
	
	@NotBlank
	private String comment;
	
	public Reply toEntity(User user, Board board) {
		return Reply.builder()
				.id(replyId)
				.comment(comment)
				.user(user)
				.board(board)
				.build();
	}

}
