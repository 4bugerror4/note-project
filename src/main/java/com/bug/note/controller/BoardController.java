package com.bug.note.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.bug.note.entity.Board;
import com.bug.note.repository.BoardRepository;
import com.bug.note.service.BoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService boardService;
	
	@GetMapping("/board")
	public String list(Model model, 
			@PageableDefault(size = 2, sort = "id", direction = Direction.DESC) Pageable pageable, 
			@RequestParam(defaultValue = "", required = false) String searchText) {
		
		
		Page<Board> boards = boardService.getboards(pageable, searchText, searchText);
		
		int startPage = Math.max(1, boards.getPageable().getPageNumber() - 4);
		int endPage = Math.min(boards.getTotalPages(), boards.getPageable().getPageNumber() + 4);
		
		model.addAttribute("boards", boards);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		
		return "board/list";
	}
	
	@GetMapping("/board/write")
	public String write() {
		return "board/write";	
	}
	
	@GetMapping("/board/{id}")
	public String detail(Model model, @PathVariable Long id) {
		
		Board board = boardService.getboard(id);
		
		model.addAttribute("board", board);
		
		return "board/detail";	
	}
	
	@GetMapping("/board/modify/{id}")
	public String modify(Model model, @PathVariable Long id) {
		
		Board board = boardService.getboard(id);
		
		model.addAttribute("board", board);
		
		return "board/modify";	
	}

}
