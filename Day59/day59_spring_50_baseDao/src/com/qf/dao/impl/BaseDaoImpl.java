package com.qf.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.qf.dao.IBaseDao;

// 反射？
public class BaseDaoImpl<T> extends HibernateTemplate implements IBaseDao<T> {

	private Class<T> cls;

	// 在构造器中给cls实例化
	public BaseDaoImpl() {
		
		// 1.返回表示此 Class 所表示的实体
		ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
		
		// 2.获取参数
		Type[] actualTypeArguments = type.getActualTypeArguments();
		
		// 3.获取第0个
		cls = (Class<T>)actualTypeArguments[0];
	}
	
	@Override
	public int add(T t) {
		return (int) save(t);
	}

	@Override
	public int getCount() {
		return execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session) throws HibernateException, SQLException {
				Long count = (Long) session.createQuery("select count(t) from " + cls.getSimpleName() + " t")
						.uniqueResult();
				return count.intValue();
			}
		});
	}

	@Override
	public List<T> getList(Integer index, Integer pageSize) {
		try {
			return findByExample(cls.newInstance(), index, pageSize);
		} catch (DataAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public T getById(Integer id) {
		return super.get(cls, id);
	}

	@Override
	public int udpate(T t) {
		update(t); // ?
		return 0;
	}

	@Override
	public int delete(Integer id) {
		return bulkUpdate("delete from " + cls.getSimpleName() + " where id = ?", id);
	}

}
