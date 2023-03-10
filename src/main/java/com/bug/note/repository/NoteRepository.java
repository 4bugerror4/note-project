package com.bug.note.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bug.note.entity.Note;

public interface NoteRepository extends JpaRepository<Note, Long>{
	
	Page<Note> findByTitleContainingOrContentContaining(Pageable pageable, String title, String content);

}
