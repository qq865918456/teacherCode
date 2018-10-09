package com.qf.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.qf.dao.InfoMationDao;
import com.qf.entity.InfoMation;
import com.qf.entity.User;

@Repository
public class InfoMationDaoImpl extends HibernateTemplate implements InfoMationDao {

	@Autowired
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	
	@Override
	public void addInfoMation(InfoMation infoMation) {
		save(infoMation);
	}

	@Override
	public int getInfoMationCountByUser(User user) {
		return super.execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(org.hibernate.Session session) throws HibernateException, SQLException {
				Query query = session
						.createQuery("select count(r) from InfoMation r where r.topic.user.id = :id and r.state = 0");
				query.setInteger("id", user.getId());
				Long count = (Long) query.uniqueResult();
				return count.intValue();
			}
		});
	}

	@Override
	public List<InfoMation> getInfoMactionList(User user) {
		return super.execute(new HibernateCallback<List<InfoMation>>() {
			@Override
			public List<InfoMation> doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery("select r from InfoMation r where r.topic.user.id = :id and r.state = 0");
				query.setInteger("id", user.getId());
				List<InfoMation> infoMations = query.list();
				return infoMations;
			}
		});
	}

	@Override
	public void updateInfoMation(User user,List<InfoMation> infoMations ) {
		
		// update InfoMation r set r.state = 1 where r.id in (1,3,4);
		StringBuffer buffer= new StringBuffer("update InfoMation r set r.state = 1 where r.id in (");
		
		for(int i =0;i<infoMations.size();i++){
			InfoMation infoMation = infoMations.get(i);
			if(i == (infoMations.size() -1)){
				buffer.append(infoMation.getId()+")");
			}else{
				buffer.append(infoMation.getId()+",");
			}
		}
		super.bulkUpdate(buffer.toString());
	}

}
