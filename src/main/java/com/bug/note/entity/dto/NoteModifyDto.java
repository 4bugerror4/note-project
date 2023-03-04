package com.bug.note.entity.dto;

import javax.validation.constraints.NotBlank;

import com.bug.note.entity.Note;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class NoteModifyDto {
	
	private Long id;
	
	@NotBlank
	private String title;
	private String content;
	
	public Note toEntity() {
		return Note.builder()
				.id(id)
				.title(title)
				.content(content)
				.build();
	}

}
