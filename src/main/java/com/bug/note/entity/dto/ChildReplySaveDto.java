package com.bug.note.entity.dto;

import javax.validation.constraints.NotBlank;

import com.bug.note.entity.ChildReply;
import com.bug.note.entity.Reply;
import com.bug.note.entity.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChildReplySaveDto {
	
	private Long replyId;
	
	@NotBlank
	private String comment;
	
	public ChildReply toEntity(User user, Reply reply) {
		return ChildReply.builder()
				.comment(comment)
				.user(user)
				.reply(reply)
				.build();
	}

}
