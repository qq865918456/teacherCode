package com.qf.dao;

import java.util.List;

import com.qf.entity.Reply;

public interface IReplyDao {

	int add(Reply reply);

	Integer getReplyDaoCount(Integer topicId);

	List<Reply> getReplyList(Integer topicId, Integer start, Integer pageSize);

}
