package com.qf.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.qf.entity.InfoMation;

public interface InfoMationDao  extends JpaRepository<InfoMation, Integer>{

//	void addInfoMation(InfoMation infoMation);
//
//	?
	@Query(value="select count(i) from InfoMation i where i.topic.user.id =:id and i.state = 0")
	public int getInfoMationCountByUser(@Param("id")Integer userId);

//	?
	List<InfoMation> getInfoMationByTopicUserIdAndState(Integer id,Integer state);
	
// ?
	@Query(value="update InfoMation i set i.state = 1 where i.topic.user.id =:id")
	void updateInfoMation(Integer id);
	
}
