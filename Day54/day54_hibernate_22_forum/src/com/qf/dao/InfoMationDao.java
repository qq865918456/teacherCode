package com.qf.dao;

import java.util.List;

import com.qf.entity.InfoMation;
import com.qf.entity.User;

public interface InfoMationDao {

	void addInfoMation(InfoMation infoMation);

	int getInfoMationCountByUser(User user);

	List<InfoMation> getInfoMactionList(User user);

	void updateInfoMation(User user, List<InfoMation> infoMations);

}
