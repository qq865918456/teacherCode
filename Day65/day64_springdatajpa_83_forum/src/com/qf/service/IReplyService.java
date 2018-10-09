package com.qf.service;

import com.qf.entity.Page;
import com.qf.entity.Reply;

public interface IReplyService {

	public int add(Reply reply);

	public org.springframework.data.domain.Page<Reply> getReplyPage(Page<Reply> page, Integer topicId);
}
