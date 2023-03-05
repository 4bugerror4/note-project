package com.bug.note.entity.dto;

import javax.validation.constraints.NotBlank;

import com.bug.note.entity.Board;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardSaveDto {
	
	@NotBlank
	private String title;
	private String content;
	
	public Board toEntity() {
		return Board.builder()
				.title(title)
				.content(content)
				.build();
	}

}
