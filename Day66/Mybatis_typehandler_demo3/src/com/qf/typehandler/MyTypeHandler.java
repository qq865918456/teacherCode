package com.qf.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

/**
 * �Զ���Mybatis������ת����
 * 
 * ���ͣ���Ҫת����Java����
 * 
 * getResult - �����ݿ�ȥ������ʱ��ת������
 * setParameter - �����ݴ������ݿ��ת������
 * 
 * @author ken
 *
 */
@MappedTypes(String[].class)
@MappedJdbcTypes(JdbcType.VARCHAR)
public class MyTypeHandler implements TypeHandler<String[]> {

	public String[] getResult(ResultSet resultSet, String colume) throws SQLException {
		String value = resultSet.getString(colume);
		return value.split("-");
	}

	public String[] getResult(ResultSet resultSet, int index) throws SQLException {
		String value = resultSet.getString(index);
		return value.split("-");
	}

	public String[] getResult(CallableStatement arg0, int arg1) throws SQLException {
		return null;
	}

	public void setParameter(PreparedStatement preparedStatement, int index, String[] value, JdbcType arg3) throws SQLException {
		//{"a","b","c"} -> "a-b-c"
		StringBuilder sb = new StringBuilder();
		for(String s : value){
			if(sb.length() > 0){
				sb.append("-");
			}
			sb.append(s);
		}
		preparedStatement.setString(index, sb.toString());
	}
}
