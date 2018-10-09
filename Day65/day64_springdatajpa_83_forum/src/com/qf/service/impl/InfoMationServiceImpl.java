package com.qf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qf.dao.InfoMationDao;
import com.qf.entity.InfoMation;
import com.qf.entity.User;
import com.qf.service.IInfoMationService;

@Service
public class InfoMationServiceImpl implements IInfoMationService {

	@Autowired
	private InfoMationDao infoDao;
	
	@Override
	public void addInfoMation(InfoMation infoMation) {
		infoDao.save(infoMation);
	}

	@Override
	public int getInfoMationCountByUser(User user) {
		return infoDao.getInfoMationCountByUser(user.getId());
	}

	@Override
	public List<InfoMation> getInfoMactionList(User user) {
		return infoDao.getInfoMationByTopicUserIdAndState(user.getId(),0);
	}

	@Override
	public void updateInfoMation(User user, List<InfoMation> infoMations) {
//		infoDao.updateInfoMation(user,infoMations);
		for (InfoMation infoMation : infoMations) {
			infoMation.setState(1);
		}
		infoDao.save(infoMations);
	}

}
