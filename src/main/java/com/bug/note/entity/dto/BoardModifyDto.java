package com.bug.note.entity.dto;

import lombok.Setter;

import javax.validation.constraints.NotBlank;

import com.bug.note.entity.Board;

import lombok.Getter;

@Getter
@Setter
public class BoardModifyDto {
	
	private Long id;
	
	@NotBlank
	private String title;
	
	private String content;
	
	public Board toEntity() {
		return Board.builder()
				.id(id)
				.title(title)
				.content(content)
				.build();
	}

}
