package com.byebye.kzj.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Accessors(chain = true)
public class VinUuidRelaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public VinUuidRelaExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andVinCodeIsNull() {
            addCriterion("vin_code is null");
            return (Criteria) this;
        }

        public Criteria andVinCodeIsNotNull() {
            addCriterion("vin_code is not null");
            return (Criteria) this;
        }

        public Criteria andVinCodeEqualTo(String value) {
            addCriterion("vin_code =", value, "vinCode");
            return (Criteria) this;
        }

        public Criteria andVinCodeNotEqualTo(String value) {
            addCriterion("vin_code <>", value, "vinCode");
            return (Criteria) this;
        }

        public Criteria andVinCodeGreaterThan(String value) {
            addCriterion("vin_code >", value, "vinCode");
            return (Criteria) this;
        }

        public Criteria andVinCodeGreaterThanOrEqualTo(String value) {
            addCriterion("vin_code >=", value, "vinCode");
            return (Criteria) this;
        }

        public Criteria andVinCodeLessThan(String value) {
            addCriterion("vin_code <", value, "vinCode");
            return (Criteria) this;
        }

        public Criteria andVinCodeLessThanOrEqualTo(String value) {
            addCriterion("vin_code <=", value, "vinCode");
            return (Criteria) this;
        }

        public Criteria andVinCodeLike(String value) {
            addCriterion("vin_code like", value, "vinCode");
            return (Criteria) this;
        }

        public Criteria andVinCodeNotLike(String value) {
            addCriterion("vin_code not like", value, "vinCode");
            return (Criteria) this;
        }

        public Criteria andVinCodeIn(List<String> values) {
            addCriterion("vin_code in", values, "vinCode");
            return (Criteria) this;
        }

        public Criteria andVinCodeNotIn(List<String> values) {
            addCriterion("vin_code not in", values, "vinCode");
            return (Criteria) this;
        }

        public Criteria andVinCodeBetween(String value1, String value2) {
            addCriterion("vin_code between", value1, value2, "vinCode");
            return (Criteria) this;
        }

        public Criteria andVinCodeNotBetween(String value1, String value2) {
            addCriterion("vin_code not between", value1, value2, "vinCode");
            return (Criteria) this;
        }

        public Criteria andUuidIsNull() {
            addCriterion("uuid is null");
            return (Criteria) this;
        }

        public Criteria andUuidIsNotNull() {
            addCriterion("uuid is not null");
            return (Criteria) this;
        }

        public Criteria andUuidEqualTo(String value) {
            addCriterion("uuid =", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotEqualTo(String value) {
            addCriterion("uuid <>", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThan(String value) {
            addCriterion("uuid >", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThanOrEqualTo(String value) {
            addCriterion("uuid >=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThan(String value) {
            addCriterion("uuid <", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThanOrEqualTo(String value) {
            addCriterion("uuid <=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLike(String value) {
            addCriterion("uuid like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotLike(String value) {
            addCriterion("uuid not like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidIn(List<String> values) {
            addCriterion("uuid in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotIn(List<String> values) {
            addCriterion("uuid not in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidBetween(String value1, String value2) {
            addCriterion("uuid between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotBetween(String value1, String value2) {
            addCriterion("uuid not between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andCollectTimeIsNull() {
            addCriterion("collect_time is null");
            return (Criteria) this;
        }

        public Criteria andCollectTimeIsNotNull() {
            addCriterion("collect_time is not null");
            return (Criteria) this;
        }

        public Criteria andCollectTimeEqualTo(Date value) {
            addCriterion("collect_time =", value, "collectTime");
            return (Criteria) this;
        }

        public Criteria andCollectTimeNotEqualTo(Date value) {
            addCriterion("collect_time <>", value, "collectTime");
            return (Criteria) this;
        }

        public Criteria andCollectTimeGreaterThan(Date value) {
            addCriterion("collect_time >", value, "collectTime");
            return (Criteria) this;
        }

        public Criteria andCollectTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("collect_time >=", value, "collectTime");
            return (Criteria) this;
        }

        public Criteria andCollectTimeLessThan(Date value) {
            addCriterion("collect_time <", value, "collectTime");
            return (Criteria) this;
        }

        public Criteria andCollectTimeLessThanOrEqualTo(Date value) {
            addCriterion("collect_time <=", value, "collectTime");
            return (Criteria) this;
        }

        public Criteria andCollectTimeIn(List<Date> values) {
            addCriterion("collect_time in", values, "collectTime");
            return (Criteria) this;
        }

        public Criteria andCollectTimeNotIn(List<Date> values) {
            addCriterion("collect_time not in", values, "collectTime");
            return (Criteria) this;
        }

        public Criteria andCollectTimeBetween(Date value1, Date value2) {
            addCriterion("collect_time between", value1, value2, "collectTime");
            return (Criteria) this;
        }

        public Criteria andCollectTimeNotBetween(Date value1, Date value2) {
            addCriterion("collect_time not between", value1, value2, "collectTime");
            return (Criteria) this;
        }

        public Criteria andCarCodeIsNull() {
            addCriterion("car_code is null");
            return (Criteria) this;
        }

        public Criteria andCarCodeIsNotNull() {
            addCriterion("car_code is not null");
            return (Criteria) this;
        }

        public Criteria andCarCodeEqualTo(String value) {
            addCriterion("car_code =", value, "carCode");
            return (Criteria) this;
        }

        public Criteria andCarCodeNotEqualTo(String value) {
            addCriterion("car_code <>", value, "carCode");
            return (Criteria) this;
        }

        public Criteria andCarCodeGreaterThan(String value) {
            addCriterion("car_code >", value, "carCode");
            return (Criteria) this;
        }

        public Criteria andCarCodeGreaterThanOrEqualTo(String value) {
            addCriterion("car_code >=", value, "carCode");
            return (Criteria) this;
        }

        public Criteria andCarCodeLessThan(String value) {
            addCriterion("car_code <", value, "carCode");
            return (Criteria) this;
        }

        public Criteria andCarCodeLessThanOrEqualTo(String value) {
            addCriterion("car_code <=", value, "carCode");
            return (Criteria) this;
        }

        public Criteria andCarCodeLike(String value) {
            addCriterion("car_code like", value, "carCode");
            return (Criteria) this;
        }

        public Criteria andCarCodeNotLike(String value) {
            addCriterion("car_code not like", value, "carCode");
            return (Criteria) this;
        }

        public Criteria andCarCodeIn(List<String> values) {
            addCriterion("car_code in", values, "carCode");
            return (Criteria) this;
        }

        public Criteria andCarCodeNotIn(List<String> values) {
            addCriterion("car_code not in", values, "carCode");
            return (Criteria) this;
        }

        public Criteria andCarCodeBetween(String value1, String value2) {
            addCriterion("car_code between", value1, value2, "carCode");
            return (Criteria) this;
        }

        public Criteria andCarCodeNotBetween(String value1, String value2) {
            addCriterion("car_code not between", value1, value2, "carCode");
            return (Criteria) this;
        }

        public Criteria andGearBoxCodeIsNull() {
            addCriterion("gear_box_code is null");
            return (Criteria) this;
        }

        public Criteria andGearBoxCodeIsNotNull() {
            addCriterion("gear_box_code is not null");
            return (Criteria) this;
        }

        public Criteria andGearBoxCodeEqualTo(String value) {
            addCriterion("gear_box_code =", value, "gearBoxCode");
            return (Criteria) this;
        }

        public Criteria andGearBoxCodeNotEqualTo(String value) {
            addCriterion("gear_box_code <>", value, "gearBoxCode");
            return (Criteria) this;
        }

        public Criteria andGearBoxCodeGreaterThan(String value) {
            addCriterion("gear_box_code >", value, "gearBoxCode");
            return (Criteria) this;
        }

        public Criteria andGearBoxCodeGreaterThanOrEqualTo(String value) {
            addCriterion("gear_box_code >=", value, "gearBoxCode");
            return (Criteria) this;
        }

        public Criteria andGearBoxCodeLessThan(String value) {
            addCriterion("gear_box_code <", value, "gearBoxCode");
            return (Criteria) this;
        }

        public Criteria andGearBoxCodeLessThanOrEqualTo(String value) {
            addCriterion("gear_box_code <=", value, "gearBoxCode");
            return (Criteria) this;
        }

        public Criteria andGearBoxCodeLike(String value) {
            addCriterion("gear_box_code like", value, "gearBoxCode");
            return (Criteria) this;
        }

        public Criteria andGearBoxCodeNotLike(String value) {
            addCriterion("gear_box_code not like", value, "gearBoxCode");
            return (Criteria) this;
        }

        public Criteria andGearBoxCodeIn(List<String> values) {
            addCriterion("gear_box_code in", values, "gearBoxCode");
            return (Criteria) this;
        }

        public Criteria andGearBoxCodeNotIn(List<String> values) {
            addCriterion("gear_box_code not in", values, "gearBoxCode");
            return (Criteria) this;
        }

        public Criteria andGearBoxCodeBetween(String value1, String value2) {
            addCriterion("gear_box_code between", value1, value2, "gearBoxCode");
            return (Criteria) this;
        }

        public Criteria andGearBoxCodeNotBetween(String value1, String value2) {
            addCriterion("gear_box_code not between", value1, value2, "gearBoxCode");
            return (Criteria) this;
        }

        public Criteria andEngineIsNull() {
            addCriterion("engine is null");
            return (Criteria) this;
        }

        public Criteria andEngineIsNotNull() {
            addCriterion("engine is not null");
            return (Criteria) this;
        }

        public Criteria andEngineEqualTo(String value) {
            addCriterion("engine =", value, "engine");
            return (Criteria) this;
        }

        public Criteria andEngineNotEqualTo(String value) {
            addCriterion("engine <>", value, "engine");
            return (Criteria) this;
        }

        public Criteria andEngineGreaterThan(String value) {
            addCriterion("engine >", value, "engine");
            return (Criteria) this;
        }

        public Criteria andEngineGreaterThanOrEqualTo(String value) {
            addCriterion("engine >=", value, "engine");
            return (Criteria) this;
        }

        public Criteria andEngineLessThan(String value) {
            addCriterion("engine <", value, "engine");
            return (Criteria) this;
        }

        public Criteria andEngineLessThanOrEqualTo(String value) {
            addCriterion("engine <=", value, "engine");
            return (Criteria) this;
        }

        public Criteria andEngineLike(String value) {
            addCriterion("engine like", value, "engine");
            return (Criteria) this;
        }

        public Criteria andEngineNotLike(String value) {
            addCriterion("engine not like", value, "engine");
            return (Criteria) this;
        }

        public Criteria andEngineIn(List<String> values) {
            addCriterion("engine in", values, "engine");
            return (Criteria) this;
        }

        public Criteria andEngineNotIn(List<String> values) {
            addCriterion("engine not in", values, "engine");
            return (Criteria) this;
        }

        public Criteria andEngineBetween(String value1, String value2) {
            addCriterion("engine between", value1, value2, "engine");
            return (Criteria) this;
        }

        public Criteria andEngineNotBetween(String value1, String value2) {
            addCriterion("engine not between", value1, value2, "engine");
            return (Criteria) this;
        }

        public Criteria andEngineTypeIsNull() {
            addCriterion("engine_type is null");
            return (Criteria) this;
        }

        public Criteria andEngineTypeIsNotNull() {
            addCriterion("engine_type is not null");
            return (Criteria) this;
        }

        public Criteria andEngineTypeEqualTo(String value) {
            addCriterion("engine_type =", value, "engineType");
            return (Criteria) this;
        }

        public Criteria andEngineTypeNotEqualTo(String value) {
            addCriterion("engine_type <>", value, "engineType");
            return (Criteria) this;
        }

        public Criteria andEngineTypeGreaterThan(String value) {
            addCriterion("engine_type >", value, "engineType");
            return (Criteria) this;
        }

        public Criteria andEngineTypeGreaterThanOrEqualTo(String value) {
            addCriterion("engine_type >=", value, "engineType");
            return (Criteria) this;
        }

        public Criteria andEngineTypeLessThan(String value) {
            addCriterion("engine_type <", value, "engineType");
            return (Criteria) this;
        }

        public Criteria andEngineTypeLessThanOrEqualTo(String value) {
            addCriterion("engine_type <=", value, "engineType");
            return (Criteria) this;
        }

        public Criteria andEngineTypeLike(String value) {
            addCriterion("engine_type like", value, "engineType");
            return (Criteria) this;
        }

        public Criteria andEngineTypeNotLike(String value) {
            addCriterion("engine_type not like", value, "engineType");
            return (Criteria) this;
        }

        public Criteria andEngineTypeIn(List<String> values) {
            addCriterion("engine_type in", values, "engineType");
            return (Criteria) this;
        }

        public Criteria andEngineTypeNotIn(List<String> values) {
            addCriterion("engine_type not in", values, "engineType");
            return (Criteria) this;
        }

        public Criteria andEngineTypeBetween(String value1, String value2) {
            addCriterion("engine_type between", value1, value2, "engineType");
            return (Criteria) this;
        }

        public Criteria andEngineTypeNotBetween(String value1, String value2) {
            addCriterion("engine_type not between", value1, value2, "engineType");
            return (Criteria) this;
        }

        public Criteria andCapacityIsNull() {
            addCriterion("capacity is null");
            return (Criteria) this;
        }

        public Criteria andCapacityIsNotNull() {
            addCriterion("capacity is not null");
            return (Criteria) this;
        }

        public Criteria andCapacityEqualTo(String value) {
            addCriterion("capacity =", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityNotEqualTo(String value) {
            addCriterion("capacity <>", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityGreaterThan(String value) {
            addCriterion("capacity >", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityGreaterThanOrEqualTo(String value) {
            addCriterion("capacity >=", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityLessThan(String value) {
            addCriterion("capacity <", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityLessThanOrEqualTo(String value) {
            addCriterion("capacity <=", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityLike(String value) {
            addCriterion("capacity like", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityNotLike(String value) {
            addCriterion("capacity not like", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityIn(List<String> values) {
            addCriterion("capacity in", values, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityNotIn(List<String> values) {
            addCriterion("capacity not in", values, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityBetween(String value1, String value2) {
            addCriterion("capacity between", value1, value2, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityNotBetween(String value1, String value2) {
            addCriterion("capacity not between", value1, value2, "capacity");
            return (Criteria) this;
        }

        public Criteria andPowerIsNull() {
            addCriterion("power is null");
            return (Criteria) this;
        }

        public Criteria andPowerIsNotNull() {
            addCriterion("power is not null");
            return (Criteria) this;
        }

        public Criteria andPowerEqualTo(String value) {
            addCriterion("power =", value, "power");
            return (Criteria) this;
        }

        public Criteria andPowerNotEqualTo(String value) {
            addCriterion("power <>", value, "power");
            return (Criteria) this;
        }

        public Criteria andPowerGreaterThan(String value) {
            addCriterion("power >", value, "power");
            return (Criteria) this;
        }

        public Criteria andPowerGreaterThanOrEqualTo(String value) {
            addCriterion("power >=", value, "power");
            return (Criteria) this;
        }

        public Criteria andPowerLessThan(String value) {
            addCriterion("power <", value, "power");
            return (Criteria) this;
        }

        public Criteria andPowerLessThanOrEqualTo(String value) {
            addCriterion("power <=", value, "power");
            return (Criteria) this;
        }

        public Criteria andPowerLike(String value) {
            addCriterion("power like", value, "power");
            return (Criteria) this;
        }

        public Criteria andPowerNotLike(String value) {
            addCriterion("power not like", value, "power");
            return (Criteria) this;
        }

        public Criteria andPowerIn(List<String> values) {
            addCriterion("power in", values, "power");
            return (Criteria) this;
        }

        public Criteria andPowerNotIn(List<String> values) {
            addCriterion("power not in", values, "power");
            return (Criteria) this;
        }

        public Criteria andPowerBetween(String value1, String value2) {
            addCriterion("power between", value1, value2, "power");
            return (Criteria) this;
        }

        public Criteria andPowerNotBetween(String value1, String value2) {
            addCriterion("power not between", value1, value2, "power");
            return (Criteria) this;
        }

        public Criteria andModeNameIsNull() {
            addCriterion("mode_name is null");
            return (Criteria) this;
        }

        public Criteria andModeNameIsNotNull() {
            addCriterion("mode_name is not null");
            return (Criteria) this;
        }

        public Criteria andModeNameEqualTo(String value) {
            addCriterion("mode_name =", value, "modeName");
            return (Criteria) this;
        }

        public Criteria andModeNameNotEqualTo(String value) {
            addCriterion("mode_name <>", value, "modeName");
            return (Criteria) this;
        }

        public Criteria andModeNameGreaterThan(String value) {
            addCriterion("mode_name >", value, "modeName");
            return (Criteria) this;
        }

        public Criteria andModeNameGreaterThanOrEqualTo(String value) {
            addCriterion("mode_name >=", value, "modeName");
            return (Criteria) this;
        }

        public Criteria andModeNameLessThan(String value) {
            addCriterion("mode_name <", value, "modeName");
            return (Criteria) this;
        }

        public Criteria andModeNameLessThanOrEqualTo(String value) {
            addCriterion("mode_name <=", value, "modeName");
            return (Criteria) this;
        }

        public Criteria andModeNameLike(String value) {
            addCriterion("mode_name like", value, "modeName");
            return (Criteria) this;
        }

        public Criteria andModeNameNotLike(String value) {
            addCriterion("mode_name not like", value, "modeName");
            return (Criteria) this;
        }

        public Criteria andModeNameIn(List<String> values) {
            addCriterion("mode_name in", values, "modeName");
            return (Criteria) this;
        }

        public Criteria andModeNameNotIn(List<String> values) {
            addCriterion("mode_name not in", values, "modeName");
            return (Criteria) this;
        }

        public Criteria andModeNameBetween(String value1, String value2) {
            addCriterion("mode_name between", value1, value2, "modeName");
            return (Criteria) this;
        }

        public Criteria andModeNameNotBetween(String value1, String value2) {
            addCriterion("mode_name not between", value1, value2, "modeName");
            return (Criteria) this;
        }

        public Criteria andModeNoIsNull() {
            addCriterion("mode_no is null");
            return (Criteria) this;
        }

        public Criteria andModeNoIsNotNull() {
            addCriterion("mode_no is not null");
            return (Criteria) this;
        }

        public Criteria andModeNoEqualTo(String value) {
            addCriterion("mode_no =", value, "modeNo");
            return (Criteria) this;
        }

        public Criteria andModeNoNotEqualTo(String value) {
            addCriterion("mode_no <>", value, "modeNo");
            return (Criteria) this;
        }

        public Criteria andModeNoGreaterThan(String value) {
            addCriterion("mode_no >", value, "modeNo");
            return (Criteria) this;
        }

        public Criteria andModeNoGreaterThanOrEqualTo(String value) {
            addCriterion("mode_no >=", value, "modeNo");
            return (Criteria) this;
        }

        public Criteria andModeNoLessThan(String value) {
            addCriterion("mode_no <", value, "modeNo");
            return (Criteria) this;
        }

        public Criteria andModeNoLessThanOrEqualTo(String value) {
            addCriterion("mode_no <=", value, "modeNo");
            return (Criteria) this;
        }

        public Criteria andModeNoLike(String value) {
            addCriterion("mode_no like", value, "modeNo");
            return (Criteria) this;
        }

        public Criteria andModeNoNotLike(String value) {
            addCriterion("mode_no not like", value, "modeNo");
            return (Criteria) this;
        }

        public Criteria andModeNoIn(List<String> values) {
            addCriterion("mode_no in", values, "modeNo");
            return (Criteria) this;
        }

        public Criteria andModeNoNotIn(List<String> values) {
            addCriterion("mode_no not in", values, "modeNo");
            return (Criteria) this;
        }

        public Criteria andModeNoBetween(String value1, String value2) {
            addCriterion("mode_no between", value1, value2, "modeNo");
            return (Criteria) this;
        }

        public Criteria andModeNoNotBetween(String value1, String value2) {
            addCriterion("mode_no not between", value1, value2, "modeNo");
            return (Criteria) this;
        }

        public Criteria andZnameIsNull() {
            addCriterion("zname is null");
            return (Criteria) this;
        }

        public Criteria andZnameIsNotNull() {
            addCriterion("zname is not null");
            return (Criteria) this;
        }

        public Criteria andZnameEqualTo(String value) {
            addCriterion("zname =", value, "zname");
            return (Criteria) this;
        }

        public Criteria andZnameNotEqualTo(String value) {
            addCriterion("zname <>", value, "zname");
            return (Criteria) this;
        }

        public Criteria andZnameGreaterThan(String value) {
            addCriterion("zname >", value, "zname");
            return (Criteria) this;
        }

        public Criteria andZnameGreaterThanOrEqualTo(String value) {
            addCriterion("zname >=", value, "zname");
            return (Criteria) this;
        }

        public Criteria andZnameLessThan(String value) {
            addCriterion("zname <", value, "zname");
            return (Criteria) this;
        }

        public Criteria andZnameLessThanOrEqualTo(String value) {
            addCriterion("zname <=", value, "zname");
            return (Criteria) this;
        }

        public Criteria andZnameLike(String value) {
            addCriterion("zname like", value, "zname");
            return (Criteria) this;
        }

        public Criteria andZnameNotLike(String value) {
            addCriterion("zname not like", value, "zname");
            return (Criteria) this;
        }

        public Criteria andZnameIn(List<String> values) {
            addCriterion("zname in", values, "zname");
            return (Criteria) this;
        }

        public Criteria andZnameNotIn(List<String> values) {
            addCriterion("zname not in", values, "zname");
            return (Criteria) this;
        }

        public Criteria andZnameBetween(String value1, String value2) {
            addCriterion("zname between", value1, value2, "zname");
            return (Criteria) this;
        }

        public Criteria andZnameNotBetween(String value1, String value2) {
            addCriterion("zname not between", value1, value2, "zname");
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