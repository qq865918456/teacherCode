package com.qf.service.impl;

import com.qf.dao.IReplyDao;
import com.qf.dao.impl.ReplyDaoImpl;
import com.qf.entity.Page;
import com.qf.entity.Reply;
import com.qf.service.IReplyService;

public class ReplyServiceImpl implements IReplyService {
	
	private IReplyDao replyDao = new ReplyDaoImpl();

	@Override
	public int add(Reply reply) {
		return replyDao.add(reply);
	}

	@Override
	public void getReplyPage(Page<Reply> page,Integer topicId) {
		Integer currentPage = page.getCurrentPage();
		Integer pageSize = page.getPageSize();
		
		page.setTotalCount(replyDao.getReplyDaoCount(topicId));
		page.setData(replyDao.getReplyList(topicId,(currentPage-1)*pageSize, pageSize));
	}

}
