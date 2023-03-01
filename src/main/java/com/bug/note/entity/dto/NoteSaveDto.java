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
public class NoteSaveDto {
	
	@NotBlank
	private String title;
	
	private String content;
	
	public Note toEntity() {
		return Note.builder()
				.title(title)
				.content(content)
				.build();
	}

}
