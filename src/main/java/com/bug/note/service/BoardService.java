package com.bug.note.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bug.note.entity.Board;
import com.bug.note.entity.User;
import com.bug.note.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
	
	private final BoardRepository boardRepository;
	
	@Transactional(readOnly = true)
	public Page<Board> getboards(Pageable pageable, String title, String content) {
		
		return boardRepository.findByTitleContainingOrContentContaining(pageable, title, content);
	}
	
	@Transactional(readOnly = true)
	public Board getboard(Long id) {
		
		return boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 번호의 글은 존재하지 않습니다."));
	}
	
	@Transactional
	public Board save(Board board, User user) {
		
		board.setTitle(board.getTitle());
		board.setContent(board.getContent());
		board.setUser(user);
		
		return boardRepository.save(board);
	}
	
	@Transactional
	public Board modify(Board board) {
		
		Board boardEntity = boardRepository.findById(board.getId()).orElseThrow(() -> new IllegalArgumentException("해당 번호의 글은 존재하지 않습니다."));
		
		boardEntity.setTitle(board.getTitle());
		boardEntity.setContent(board.getContent());
		
		return boardEntity;
	}
	
	@Transactional
	public void delete(Long id) {
		boardRepository.deleteById(id);
	}

}
