package com.bug.note.controller.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bug.note.entity.Note;
import com.bug.note.entity.dto.NoteModifyDto;
import com.bug.note.entity.dto.NoteSaveDto;
import com.bug.note.entity.dto.ResponseDto;
import com.bug.note.service.NoteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MainApiController {
	
	private final NoteService noteService;
	
	// 전체 노트 보기
	@GetMapping("/notes")
	public ResponseEntity<?> getNotes() {
		
		List<Note> notes = noteService.getNotes();
		
		return new ResponseEntity<>(new ResponseDto<List<Note>>(1, "전체 리스트 출력", notes), HttpStatus.OK);
	}
	
	// 노트 보기
	@GetMapping("/note/{id}")
	public ResponseEntity<?> getNoteId(@PathVariable Long id) {
		
		Note note = noteService.getNoteId(id);
		
		return new ResponseEntity<>(new ResponseDto<Note>(1, "아이디 글 출력", note), HttpStatus.OK);
	}
	
	// 노트 추가
	@PostMapping("/save")
	public ResponseEntity<?> saveNote(@Valid @RequestBody NoteSaveDto dto, BindingResult bindingResult) {
		
		Note note = noteService.saveNote(dto.toEntity());
		
		return new ResponseEntity<>(new ResponseDto<Note>(1, "글 추가 성공", note), HttpStatus.CREATED);
	}
	// 노트 수정
	@PutMapping("/modify")
	public ResponseEntity<?> modifyNote(@Valid @RequestBody NoteModifyDto dto, BindingResult bindingResult) {
		
		Note note = noteService.modifyNote(dto.toEntity());
		
		return new ResponseEntity<>(new ResponseDto<Note>(1, "글 수정 성공", note), HttpStatus.OK);
	}
	
	// 노트 삭제
	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteNote(@RequestBody Note note) {
		
		noteService.deleteNote(note.getId());
		
		return new ResponseEntity<>(new ResponseDto<Note>(1, "글 삭제 성공", null), HttpStatus.OK);
	}

}
