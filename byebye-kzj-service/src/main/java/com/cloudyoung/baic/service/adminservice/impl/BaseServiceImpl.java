package com.cloudyoung.baic.service.adminservice.impl;

import com.cloudyoung.baic.common.utils.ReflectUtils;
import com.cloudyoung.baic.dao.BaseMapper;
import com.cloudyoung.baic.service.BaseService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;


@Transactional
public class BaseServiceImpl<T extends Serializable, E> implements BaseService<T, E>, ApplicationContextAware, InitializingBean {
    private ApplicationContext applicationContext;
    protected BaseMapper<T, E> mapper;

    public BaseServiceImpl() {
    }

    @Transactional(readOnly = true)
    @Override
    public long countByExample(E E) {
        return this.mapper.countByExample(E);
    }

    @Override
    public int deleteByExample(E E) {
        return this.mapper.deleteByExample(E);
    }

    @Override
    public int deleteByPrimaryKey(Object id) {
        return this.mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(T record) {
        return this.mapper.insert(record);
    }

    @Override
    public int insertSelective(T record) {
        return this.mapper.insertSelective(record);
    }

    @Transactional(readOnly = true)
    @Override
    public List<T> selectByExample(E E) {
        return this.mapper.selectByExample(E);
    }

    @Transactional(readOnly = true)
    @Override
    public T selectByPrimaryKey(Object id) {
        return this.mapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(T record, E E) {
        return this.mapper.updateByExampleSelective(record, E);
    }

    @Override
    public int updateByExample(T record, E E) {
        return this.mapper.updateByExample(record, E);
    }

    @Override
    public int updateByPrimaryKeySelective(T record) {
        return this.mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(T record) {
        return this.mapper.updateByPrimaryKey(record);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        String className = ReflectUtils.getSuperClassGenricType(this.getClass()).getSimpleName();

        String firstLowerClassName = className.substring(0, 1).toLowerCase() + className.substring(1);

        if (this.applicationContext.containsBean(firstLowerClassName + "Mapper")) {
            this.mapper = (BaseMapper) this.applicationContext.getBean(firstLowerClassName + "Mapper");
        } else if (this.applicationContext.containsBean(className + "Mapper")) {
            //前两个及以上字母大写开头，Mapper格式为CUserOpportunityMapper
            this.mapper = (BaseMapper) this.applicationContext.getBean(className + "Mapper");
        }
    }

    public BaseMapper<T, E> getMapper() {
        return this.mapper;
    }

    public void setMapper(BaseMapper<T, E> mapper) {
        this.mapper = mapper;
    }
}
