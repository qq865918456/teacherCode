package com.qf.entity;

public class InfoMation {

	private Integer id;
	
	private Integer state = 0; // 状态(默认0)，1:已读,0:未读
	
	private Topic topic; // 给那个帖子的记录
	
	private Reply reply; // 那条回复的记录

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public Reply getReply() {
		return reply;
	}

	public void setReply(Reply reply) {
		this.reply = reply;
	}
	
}
