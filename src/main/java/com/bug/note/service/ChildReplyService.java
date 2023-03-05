package com.bug.note.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bug.note.entity.ChildReply;
import com.bug.note.repository.ChildReplyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChildReplyService {
	
	private final ChildReplyRepository childReplyRepository;
	
	@Transactional
	public ChildReply save(ChildReply cReply) {
		
		return childReplyRepository.save(cReply);
	}

}
