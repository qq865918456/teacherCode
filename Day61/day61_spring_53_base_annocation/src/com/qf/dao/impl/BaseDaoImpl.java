package com.qf.dao.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();

		// 2.获取参数
		Type[] actualTypeArguments = type.getActualTypeArguments();

		// 3.获取第0个
		cls = (Class<T>) actualTypeArguments[0];
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
	public int delete(Integer id) {
		return bulkUpdate("delete from " + cls.getSimpleName() + " where id = ?", id);
	}

	@Override
	public int baseUpdate(T t) {
		return bulkUpdate(getHql(t));
	}

	// update from User set name = 'adin', where id = 1;
	private String getHql(T t) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("update from ");
		buffer.append(t.getClass().getSimpleName());
		buffer.append(" set ");
		Field[] dFields = t.getClass().getDeclaredFields();
		Integer idValue = null;
		try {
			for (int i = 0; i < dFields.length; i++) {
				Field field = dFields[i];
				field.setAccessible(true);
				String fieldName = field.getName();
				Object value = field.get(t);
				// 处理id

				if (fieldName.equals("id")) {
					idValue = Integer.parseInt(value.toString());
					continue;
				}

				// 处理空值的情况
				if (value == null) {
					continue;
				}
				if (field.getType().getSimpleName().equals("String")) {
					buffer.append(fieldName + " = '" + value + "'");
				} else {
					buffer.append(fieldName + " = " + value);
				}
				if (i != (dFields.length - 1)) {
					buffer.append(" ,");
				}
			}
			buffer.append(" where id = " + idValue);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return splitHql(buffer.toString());
	}

	private static String splitHql(String hql) {
		int lastIndexOf = hql.lastIndexOf(",");
		String substring = hql.substring(lastIndexOf + 1).trim();
		String value = null;
		if (substring.startsWith("where")) {
			value = hql.substring(0, lastIndexOf) + hql.substring(lastIndexOf + 1, hql.length());
		} else {
			value = hql;
		}
		return value;
	}
	
	@Autowired
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		// TODO Auto-generated method stub
		super.setSessionFactory(sessionFactory);
	}

}
