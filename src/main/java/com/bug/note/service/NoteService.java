package com.bug.note.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bug.note.entity.Note;
import com.bug.note.repository.NoteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NoteService {
	
	private final NoteRepository noteRepository;
	
	@Transactional(readOnly = true)
	public List<Note> getNotes() {
		return noteRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public Note getNoteId(Long id) {
		return noteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 아이디의 글은 없습니다."));
	}
	
	@Transactional(readOnly = true)
	public Page<Note> getPagingAndSearchNotes(Pageable pageable, String searchText) {
		
		return noteRepository.findByTitleContainingOrContentContaining(pageable, searchText, searchText);
	}
	
	@Transactional
	public Note saveNote(Note note) {
		return noteRepository.save(note);
	}
	
	@Transactional
	public Note modifyNote(Note note) {
		
		System.out.println(note.getTitle());
		System.out.println(note.getContent());
		Note noteEntity = noteRepository.findById(note.getId()).orElseThrow(() -> new IllegalArgumentException("해당 아이디의 글은 없습니다."));
		
		noteEntity.setTitle(note.getTitle());
		noteEntity.setContent(note.getContent());
		
		return noteEntity;
	}
	
	@Transactional
	public void deleteNote(Long id) {
		noteRepository.deleteById(id);
	}

}
