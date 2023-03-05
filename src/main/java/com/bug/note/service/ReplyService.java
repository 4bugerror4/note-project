package com.bug.note.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bug.note.entity.Reply;
import com.bug.note.repository.ReplyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReplyService {
	
	private final ReplyRepository replyRepository;
	
	@Transactional(readOnly = true)
	public Reply getReply(Long id) {
		
		return replyRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 번호의 댓글은 존재하지 않습니다."));
	}
	
	@Transactional
	public Reply save(Reply reply) {
		
		return replyRepository.save(reply);
	}
	
	@Transactional
	public Reply modify(Reply reply) {
		
		Reply replyEntity = replyRepository.findById(reply.getId()).orElseThrow(() -> new IllegalArgumentException("해당 번호의 댓글은 존재하지 않습니다."));
		
		replyEntity.setComment(reply.getComment());
		replyEntity.setUser(reply.getUser());
		replyEntity.setBoard(reply.getBoard());
		
		return replyEntity;
		
	}
	
	@Transactional
	public void delete(Long id) {
		
		replyRepository.deleteById(id);
	}

}
