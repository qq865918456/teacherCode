package com.qf.test1;

import java.lang.reflect.Field;

public class BaseEntity {

	@Override
	public String toString() {
		
		//class
		Class c = this.getClass();
		//获得当前实现对象的所有属性
		Field[] fields = c.getDeclaredFields();
		
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(Field field : fields){
			field.setAccessible(true);
			if(sb.length() > 1){
				sb.append(",");
			}
			
			try {
				sb.append(field.getName())
					.append("=")
					.append(field.get(this));
			} catch (Exception e) {
			} 
		}
		sb.append("]");
		
		return sb.toString();
	}
}
