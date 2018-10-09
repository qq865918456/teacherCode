package com.qf.service.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.qf.dao.IReplyDao;
import com.qf.entity.Page;
import com.qf.entity.Reply;
import com.qf.service.IReplyService;

@Service
public class ReplyServiceImpl implements IReplyService {
	
	@Autowired
	private IReplyDao replyDao;

	@Override
	public int add(Reply reply) {
		return replyDao.save(reply) == null ?0:1;
	}

	@Override
	public org.springframework.data.domain.Page<Reply> getReplyPage(Page<Reply> page,Integer topicId) {
		Integer currentPage = page.getCurrentPage();
		Integer pageSize = page.getPageSize();
		
		// ?要用级联查询
//		page.setTotalCount(replyDao.getReplyDaoCount(topicId));
//		page.setData(replyDao.getReplyList(topicId,(currentPage-1)*pageSize, pageSize));
		
		
		Specification<Reply> specification = new Specification<Reply>() {
			@Override
			public Predicate toPredicate(Root<Reply> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				
				// 找到帖子id的对象
				Path<Object> path = root.get("replyTopic").get("id");
				
				// 给贴子id赋值
				Predicate predicate = cb.equal(path, topicId);
				
				return predicate;
			}
		};
		Pageable pageable = new PageRequest(currentPage-1, pageSize);
		return replyDao.findAll(specification, pageable);
		
	}

}
