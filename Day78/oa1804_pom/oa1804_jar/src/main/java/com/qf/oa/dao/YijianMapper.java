package com.qf.oa.dao;

import com.qf.oa.entity.Yijian;

import java.util.List;

public interface YijianMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yijian
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yijian
     *
     * @mbggenerated
     */
    int insert(Yijian record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yijian
     *
     * @mbggenerated
     */
    int insertSelective(Yijian record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yijian
     *
     * @mbggenerated
     */
    Yijian selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yijian
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Yijian record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yijian
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Yijian record);

    List<Yijian> queryByCid(Integer cid);
}