package com.qf.service;

import java.util.List;

import com.qf.entity.InfoMation;
import com.qf.entity.User;

public interface IInfoMationService {

	void addInfoMation(InfoMation infoMation);

	int getInfoMationCountByUser(User user);

	List<InfoMation> getInfoMactionList(User user);

	void updateInfoMation(User user, List<InfoMation> infoMations);

}
