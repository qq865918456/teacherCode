package com.qf.dao.impl;

import java.util.List;

import org.apache.jasper.util.UniqueAttributesImpl;
import org.eclipse.jdt.internal.compiler.codegen.StackMapFrameCodeStream;
import org.hibernate.Query;
import org.hibernate.classic.Session;

import com.qf.dao.InfoMationDao;
import com.qf.entity.InfoMation;
import com.qf.entity.User;
import com.qf.utils.HibernateUtil;

public class InfoMationDaoImpl implements InfoMationDao {

	@Override
	public void addInfoMation(InfoMation infoMation) {
		HibernateUtil.getSessionFactory().getCurrentSession().save(infoMation);
	}

	@Override
	public int getInfoMationCountByUser(User user) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("select count(r) from InfoMation r where r.topic.user.id = :id and r.state = 0");
		query.setInteger("id", user.getId());
		Long count = (Long) query.uniqueResult();
		return count.intValue();
	}

	@Override
	public List<InfoMation> getInfoMactionList(User user) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Query query = session.createQuery("select r from InfoMation r where r.topic.user.id = :id and r.state = 0");
		query.setInteger("id", user.getId());
		List<InfoMation> infoMations = query.list();
		return infoMations;
	}

	@Override
	public void updateInfoMation(User user,List<InfoMation> infoMations ) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		StringBuffer buffer= new StringBuffer("update InfoMation r set r.state = 1 where r.id in (");
		
		for(int i =0;i<infoMations.size();i++){
			InfoMation infoMation = infoMations.get(i);
			if(i == (infoMations.size() -1)){
				buffer.append(infoMation.getId()+")");
			}else{
				buffer.append(infoMation.getId()+",");
			}
		}
		Query query = session.createQuery(buffer.toString());
		query.executeUpdate();
	}

}
