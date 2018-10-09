package com.qf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qf.dao.InfoMationDao;
import com.qf.dao.impl.InfoMationDaoImpl;
import com.qf.entity.InfoMation;
import com.qf.entity.User;
import com.qf.service.IInfoMationService;

@Service
public class InfoMationServiceImpl implements IInfoMationService {

	@Autowired
	private InfoMationDao infoDao;
	
	@Override
	public void addInfoMation(InfoMation infoMation) {
		infoDao.addInfoMation(infoMation);
	}

	@Override
	public int getInfoMationCountByUser(User user) {
		return infoDao.getInfoMationCountByUser(user);
	}

	@Override
	public List<InfoMation> getInfoMactionList(User user) {
		// TODO Auto-generated method stub
		return infoDao.getInfoMactionList(user);
	}

	@Override
	public void updateInfoMation(User user, List<InfoMation> infoMations) {
		infoDao.updateInfoMation(user,infoMations);
	}

}
