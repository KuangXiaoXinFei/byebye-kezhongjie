package com.byebye.kzj.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T extends Serializable, E> {
    long countByExample(E var1);

    int deleteByExample(E var1);

    int deleteByPrimaryKey(Object var1);

    int insert(T var1);

    int insertSelective(T var1);

    List<T> selectByExample(E var1);

    T selectByPrimaryKey(Object var1);

    int updateByExampleSelective(T var1, E var2);

    int updateByExample(T var1, E var2);

    int updateByPrimaryKeySelective(T var1);

    int updateByPrimaryKey(T var1);

}
