package com.qf.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.qf.entity.Reply;

public interface IReplyDao  extends JpaRepository<Reply, Integer>,JpaSpecificationExecutor<Reply>{

//	int add(Reply reply);
//
//	Integer getReplyDaoCount(Integer topicId);
//
//	List<Reply> getReplyList(Integer topicId, Integer start, Integer pageSize);

}
