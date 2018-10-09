package com.qf.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name="t_topic")
@Entity
public class Topic {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String title;
	
	private String content;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user; // 发帖人
	
	@Column(name="create_time")
	private Date createDate; // 发帖时间
	
	@OneToMany // 一对多 
	@JoinColumn(name="topic_id") // 关联字段
	private Set<Reply> replies; //一对多

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Set<Reply> getReplies() {
		return replies;
	}

	public void setReplies(Set<Reply> replies) {
		this.replies = replies;
	}
	
	
}
