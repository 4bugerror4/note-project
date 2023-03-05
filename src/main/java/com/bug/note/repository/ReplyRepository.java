package com.bug.note.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bug.note.entity.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

}
