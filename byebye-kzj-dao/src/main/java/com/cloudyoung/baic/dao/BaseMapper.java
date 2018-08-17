package com.cloudyoung.baic.dao;


import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/2/2 16:51  by  zhoudalin（zhoudl@cloud-young.com）创建
 */
public interface BaseMapper<T extends Serializable, E> {

    long countByExample(E example);

    int deleteByExample(E example);

    int deleteByPrimaryKey(@Param("id") Object pk);

    int insert(T record);

    int insertSelective(T record);

    List<T> selectByExample(E example);

    T selectByPrimaryKey(@Param("id") Object pk);

    int updateByExampleSelective(@Param("record") T record, @Param("example") E example);

    int updateByExample(@Param("record") T record, @Param("example") E example);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
}
