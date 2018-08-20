package com.byebye.kzj.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Accessors(chain = true)
public class UserLocationHistoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public UserLocationHistoryExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andLocalIdIsNull() {
            addCriterion("local_id is null");
            return (Criteria) this;
        }

        public Criteria andLocalIdIsNotNull() {
            addCriterion("local_id is not null");
            return (Criteria) this;
        }

        public Criteria andLocalIdEqualTo(Integer value) {
            addCriterion("local_id =", value, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdNotEqualTo(Integer value) {
            addCriterion("local_id <>", value, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdGreaterThan(Integer value) {
            addCriterion("local_id >", value, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("local_id >=", value, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdLessThan(Integer value) {
            addCriterion("local_id <", value, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdLessThanOrEqualTo(Integer value) {
            addCriterion("local_id <=", value, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdIn(List<Integer> values) {
            addCriterion("local_id in", values, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdNotIn(List<Integer> values) {
            addCriterion("local_id not in", values, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdBetween(Integer value1, Integer value2) {
            addCriterion("local_id between", value1, value2, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdNotBetween(Integer value1, Integer value2) {
            addCriterion("local_id not between", value1, value2, "localId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andSourceIsNull() {
            addCriterion("source is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("source is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(Integer value) {
            addCriterion("source =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(Integer value) {
            addCriterion("source <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(Integer value) {
            addCriterion("source >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(Integer value) {
            addCriterion("source >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(Integer value) {
            addCriterion("source <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(Integer value) {
            addCriterion("source <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<Integer> values) {
            addCriterion("source in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<Integer> values) {
            addCriterion("source not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(Integer value1, Integer value2) {
            addCriterion("source between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(Integer value1, Integer value2) {
            addCriterion("source not between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andAmapLongitudeIsNull() {
            addCriterion("amap_longitude is null");
            return (Criteria) this;
        }

        public Criteria andAmapLongitudeIsNotNull() {
            addCriterion("amap_longitude is not null");
            return (Criteria) this;
        }

        public Criteria andAmapLongitudeEqualTo(BigDecimal value) {
            addCriterion("amap_longitude =", value, "amapLongitude");
            return (Criteria) this;
        }

        public Criteria andAmapLongitudeNotEqualTo(BigDecimal value) {
            addCriterion("amap_longitude <>", value, "amapLongitude");
            return (Criteria) this;
        }

        public Criteria andAmapLongitudeGreaterThan(BigDecimal value) {
            addCriterion("amap_longitude >", value, "amapLongitude");
            return (Criteria) this;
        }

        public Criteria andAmapLongitudeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amap_longitude >=", value, "amapLongitude");
            return (Criteria) this;
        }

        public Criteria andAmapLongitudeLessThan(BigDecimal value) {
            addCriterion("amap_longitude <", value, "amapLongitude");
            return (Criteria) this;
        }

        public Criteria andAmapLongitudeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amap_longitude <=", value, "amapLongitude");
            return (Criteria) this;
        }

        public Criteria andAmapLongitudeIn(List<BigDecimal> values) {
            addCriterion("amap_longitude in", values, "amapLongitude");
            return (Criteria) this;
        }

        public Criteria andAmapLongitudeNotIn(List<BigDecimal> values) {
            addCriterion("amap_longitude not in", values, "amapLongitude");
            return (Criteria) this;
        }

        public Criteria andAmapLongitudeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amap_longitude between", value1, value2, "amapLongitude");
            return (Criteria) this;
        }

        public Criteria andAmapLongitudeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amap_longitude not between", value1, value2, "amapLongitude");
            return (Criteria) this;
        }

        public Criteria andAmapLatitudeIsNull() {
            addCriterion("amap_latitude is null");
            return (Criteria) this;
        }

        public Criteria andAmapLatitudeIsNotNull() {
            addCriterion("amap_latitude is not null");
            return (Criteria) this;
        }

        public Criteria andAmapLatitudeEqualTo(BigDecimal value) {
            addCriterion("amap_latitude =", value, "amapLatitude");
            return (Criteria) this;
        }

        public Criteria andAmapLatitudeNotEqualTo(BigDecimal value) {
            addCriterion("amap_latitude <>", value, "amapLatitude");
            return (Criteria) this;
        }

        public Criteria andAmapLatitudeGreaterThan(BigDecimal value) {
            addCriterion("amap_latitude >", value, "amapLatitude");
            return (Criteria) this;
        }

        public Criteria andAmapLatitudeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amap_latitude >=", value, "amapLatitude");
            return (Criteria) this;
        }

        public Criteria andAmapLatitudeLessThan(BigDecimal value) {
            addCriterion("amap_latitude <", value, "amapLatitude");
            return (Criteria) this;
        }

        public Criteria andAmapLatitudeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amap_latitude <=", value, "amapLatitude");
            return (Criteria) this;
        }

        public Criteria andAmapLatitudeIn(List<BigDecimal> values) {
            addCriterion("amap_latitude in", values, "amapLatitude");
            return (Criteria) this;
        }

        public Criteria andAmapLatitudeNotIn(List<BigDecimal> values) {
            addCriterion("amap_latitude not in", values, "amapLatitude");
            return (Criteria) this;
        }

        public Criteria andAmapLatitudeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amap_latitude between", value1, value2, "amapLatitude");
            return (Criteria) this;
        }

        public Criteria andAmapLatitudeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amap_latitude not between", value1, value2, "amapLatitude");
            return (Criteria) this;
        }

        public Criteria andBaiduLongitudeIsNull() {
            addCriterion("baidu_longitude is null");
            return (Criteria) this;
        }

        public Criteria andBaiduLongitudeIsNotNull() {
            addCriterion("baidu_longitude is not null");
            return (Criteria) this;
        }

        public Criteria andBaiduLongitudeEqualTo(BigDecimal value) {
            addCriterion("baidu_longitude =", value, "baiduLongitude");
            return (Criteria) this;
        }

        public Criteria andBaiduLongitudeNotEqualTo(BigDecimal value) {
            addCriterion("baidu_longitude <>", value, "baiduLongitude");
            return (Criteria) this;
        }

        public Criteria andBaiduLongitudeGreaterThan(BigDecimal value) {
            addCriterion("baidu_longitude >", value, "baiduLongitude");
            return (Criteria) this;
        }

        public Criteria andBaiduLongitudeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("baidu_longitude >=", value, "baiduLongitude");
            return (Criteria) this;
        }

        public Criteria andBaiduLongitudeLessThan(BigDecimal value) {
            addCriterion("baidu_longitude <", value, "baiduLongitude");
            return (Criteria) this;
        }

        public Criteria andBaiduLongitudeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("baidu_longitude <=", value, "baiduLongitude");
            return (Criteria) this;
        }

        public Criteria andBaiduLongitudeIn(List<BigDecimal> values) {
            addCriterion("baidu_longitude in", values, "baiduLongitude");
            return (Criteria) this;
        }

        public Criteria andBaiduLongitudeNotIn(List<BigDecimal> values) {
            addCriterion("baidu_longitude not in", values, "baiduLongitude");
            return (Criteria) this;
        }

        public Criteria andBaiduLongitudeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("baidu_longitude between", value1, value2, "baiduLongitude");
            return (Criteria) this;
        }

        public Criteria andBaiduLongitudeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("baidu_longitude not between", value1, value2, "baiduLongitude");
            return (Criteria) this;
        }

        public Criteria andBaiduLatitudeIsNull() {
            addCriterion("baidu_latitude is null");
            return (Criteria) this;
        }

        public Criteria andBaiduLatitudeIsNotNull() {
            addCriterion("baidu_latitude is not null");
            return (Criteria) this;
        }

        public Criteria andBaiduLatitudeEqualTo(BigDecimal value) {
            addCriterion("baidu_latitude =", value, "baiduLatitude");
            return (Criteria) this;
        }

        public Criteria andBaiduLatitudeNotEqualTo(BigDecimal value) {
            addCriterion("baidu_latitude <>", value, "baiduLatitude");
            return (Criteria) this;
        }

        public Criteria andBaiduLatitudeGreaterThan(BigDecimal value) {
            addCriterion("baidu_latitude >", value, "baiduLatitude");
            return (Criteria) this;
        }

        public Criteria andBaiduLatitudeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("baidu_latitude >=", value, "baiduLatitude");
            return (Criteria) this;
        }

        public Criteria andBaiduLatitudeLessThan(BigDecimal value) {
            addCriterion("baidu_latitude <", value, "baiduLatitude");
            return (Criteria) this;
        }

        public Criteria andBaiduLatitudeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("baidu_latitude <=", value, "baiduLatitude");
            return (Criteria) this;
        }

        public Criteria andBaiduLatitudeIn(List<BigDecimal> values) {
            addCriterion("baidu_latitude in", values, "baiduLatitude");
            return (Criteria) this;
        }

        public Criteria andBaiduLatitudeNotIn(List<BigDecimal> values) {
            addCriterion("baidu_latitude not in", values, "baiduLatitude");
            return (Criteria) this;
        }

        public Criteria andBaiduLatitudeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("baidu_latitude between", value1, value2, "baiduLatitude");
            return (Criteria) this;
        }

        public Criteria andBaiduLatitudeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("baidu_latitude not between", value1, value2, "baiduLatitude");
            return (Criteria) this;
        }

        public Criteria andIsActiveIsNull() {
            addCriterion("is_active is null");
            return (Criteria) this;
        }

        public Criteria andIsActiveIsNotNull() {
            addCriterion("is_active is not null");
            return (Criteria) this;
        }

        public Criteria andIsActiveEqualTo(Integer value) {
            addCriterion("is_active =", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveNotEqualTo(Integer value) {
            addCriterion("is_active <>", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveGreaterThan(Integer value) {
            addCriterion("is_active >", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_active >=", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveLessThan(Integer value) {
            addCriterion("is_active <", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveLessThanOrEqualTo(Integer value) {
            addCriterion("is_active <=", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveIn(List<Integer> values) {
            addCriterion("is_active in", values, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveNotIn(List<Integer> values) {
            addCriterion("is_active not in", values, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveBetween(Integer value1, Integer value2) {
            addCriterion("is_active between", value1, value2, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveNotBetween(Integer value1, Integer value2) {
            addCriterion("is_active not between", value1, value2, "isActive");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}