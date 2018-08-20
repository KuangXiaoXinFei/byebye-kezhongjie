package com.byebye.kzj.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Accessors(chain = true)
public class CarInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public CarInfoExample() {
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

        public Criteria andCarIdIsNull() {
            addCriterion("car_id is null");
            return (Criteria) this;
        }

        public Criteria andCarIdIsNotNull() {
            addCriterion("car_id is not null");
            return (Criteria) this;
        }

        public Criteria andCarIdEqualTo(Integer value) {
            addCriterion("car_id =", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotEqualTo(Integer value) {
            addCriterion("car_id <>", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdGreaterThan(Integer value) {
            addCriterion("car_id >", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("car_id >=", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdLessThan(Integer value) {
            addCriterion("car_id <", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdLessThanOrEqualTo(Integer value) {
            addCriterion("car_id <=", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdIn(List<Integer> values) {
            addCriterion("car_id in", values, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotIn(List<Integer> values) {
            addCriterion("car_id not in", values, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdBetween(Integer value1, Integer value2) {
            addCriterion("car_id between", value1, value2, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotBetween(Integer value1, Integer value2) {
            addCriterion("car_id not between", value1, value2, "carId");
            return (Criteria) this;
        }

        public Criteria andBrandIdIsNull() {
            addCriterion("brand_id is null");
            return (Criteria) this;
        }

        public Criteria andBrandIdIsNotNull() {
            addCriterion("brand_id is not null");
            return (Criteria) this;
        }

        public Criteria andBrandIdEqualTo(Integer value) {
            addCriterion("brand_id =", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotEqualTo(Integer value) {
            addCriterion("brand_id <>", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdGreaterThan(Integer value) {
            addCriterion("brand_id >", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("brand_id >=", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLessThan(Integer value) {
            addCriterion("brand_id <", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLessThanOrEqualTo(Integer value) {
            addCriterion("brand_id <=", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdIn(List<Integer> values) {
            addCriterion("brand_id in", values, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotIn(List<Integer> values) {
            addCriterion("brand_id not in", values, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdBetween(Integer value1, Integer value2) {
            addCriterion("brand_id between", value1, value2, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotBetween(Integer value1, Integer value2) {
            addCriterion("brand_id not between", value1, value2, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandNameIsNull() {
            addCriterion("brand_name is null");
            return (Criteria) this;
        }

        public Criteria andBrandNameIsNotNull() {
            addCriterion("brand_name is not null");
            return (Criteria) this;
        }

        public Criteria andBrandNameEqualTo(String value) {
            addCriterion("brand_name =", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotEqualTo(String value) {
            addCriterion("brand_name <>", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameGreaterThan(String value) {
            addCriterion("brand_name >", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameGreaterThanOrEqualTo(String value) {
            addCriterion("brand_name >=", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLessThan(String value) {
            addCriterion("brand_name <", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLessThanOrEqualTo(String value) {
            addCriterion("brand_name <=", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLike(String value) {
            addCriterion("brand_name like", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotLike(String value) {
            addCriterion("brand_name not like", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameIn(List<String> values) {
            addCriterion("brand_name in", values, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotIn(List<String> values) {
            addCriterion("brand_name not in", values, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameBetween(String value1, String value2) {
            addCriterion("brand_name between", value1, value2, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotBetween(String value1, String value2) {
            addCriterion("brand_name not between", value1, value2, "brandName");
            return (Criteria) this;
        }

        public Criteria andLogoIsNull() {
            addCriterion("logo is null");
            return (Criteria) this;
        }

        public Criteria andLogoIsNotNull() {
            addCriterion("logo is not null");
            return (Criteria) this;
        }

        public Criteria andLogoEqualTo(String value) {
            addCriterion("logo =", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotEqualTo(String value) {
            addCriterion("logo <>", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoGreaterThan(String value) {
            addCriterion("logo >", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoGreaterThanOrEqualTo(String value) {
            addCriterion("logo >=", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoLessThan(String value) {
            addCriterion("logo <", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoLessThanOrEqualTo(String value) {
            addCriterion("logo <=", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoLike(String value) {
            addCriterion("logo like", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotLike(String value) {
            addCriterion("logo not like", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoIn(List<String> values) {
            addCriterion("logo in", values, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotIn(List<String> values) {
            addCriterion("logo not in", values, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoBetween(String value1, String value2) {
            addCriterion("logo between", value1, value2, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotBetween(String value1, String value2) {
            addCriterion("logo not between", value1, value2, "logo");
            return (Criteria) this;
        }

        public Criteria andSerialIdIsNull() {
            addCriterion("serial_id is null");
            return (Criteria) this;
        }

        public Criteria andSerialIdIsNotNull() {
            addCriterion("serial_id is not null");
            return (Criteria) this;
        }

        public Criteria andSerialIdEqualTo(Integer value) {
            addCriterion("serial_id =", value, "serialId");
            return (Criteria) this;
        }

        public Criteria andSerialIdNotEqualTo(Integer value) {
            addCriterion("serial_id <>", value, "serialId");
            return (Criteria) this;
        }

        public Criteria andSerialIdGreaterThan(Integer value) {
            addCriterion("serial_id >", value, "serialId");
            return (Criteria) this;
        }

        public Criteria andSerialIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("serial_id >=", value, "serialId");
            return (Criteria) this;
        }

        public Criteria andSerialIdLessThan(Integer value) {
            addCriterion("serial_id <", value, "serialId");
            return (Criteria) this;
        }

        public Criteria andSerialIdLessThanOrEqualTo(Integer value) {
            addCriterion("serial_id <=", value, "serialId");
            return (Criteria) this;
        }

        public Criteria andSerialIdIn(List<Integer> values) {
            addCriterion("serial_id in", values, "serialId");
            return (Criteria) this;
        }

        public Criteria andSerialIdNotIn(List<Integer> values) {
            addCriterion("serial_id not in", values, "serialId");
            return (Criteria) this;
        }

        public Criteria andSerialIdBetween(Integer value1, Integer value2) {
            addCriterion("serial_id between", value1, value2, "serialId");
            return (Criteria) this;
        }

        public Criteria andSerialIdNotBetween(Integer value1, Integer value2) {
            addCriterion("serial_id not between", value1, value2, "serialId");
            return (Criteria) this;
        }

        public Criteria andSerialNameIsNull() {
            addCriterion("serial_name is null");
            return (Criteria) this;
        }

        public Criteria andSerialNameIsNotNull() {
            addCriterion("serial_name is not null");
            return (Criteria) this;
        }

        public Criteria andSerialNameEqualTo(String value) {
            addCriterion("serial_name =", value, "serialName");
            return (Criteria) this;
        }

        public Criteria andSerialNameNotEqualTo(String value) {
            addCriterion("serial_name <>", value, "serialName");
            return (Criteria) this;
        }

        public Criteria andSerialNameGreaterThan(String value) {
            addCriterion("serial_name >", value, "serialName");
            return (Criteria) this;
        }

        public Criteria andSerialNameGreaterThanOrEqualTo(String value) {
            addCriterion("serial_name >=", value, "serialName");
            return (Criteria) this;
        }

        public Criteria andSerialNameLessThan(String value) {
            addCriterion("serial_name <", value, "serialName");
            return (Criteria) this;
        }

        public Criteria andSerialNameLessThanOrEqualTo(String value) {
            addCriterion("serial_name <=", value, "serialName");
            return (Criteria) this;
        }

        public Criteria andSerialNameLike(String value) {
            addCriterion("serial_name like", value, "serialName");
            return (Criteria) this;
        }

        public Criteria andSerialNameNotLike(String value) {
            addCriterion("serial_name not like", value, "serialName");
            return (Criteria) this;
        }

        public Criteria andSerialNameIn(List<String> values) {
            addCriterion("serial_name in", values, "serialName");
            return (Criteria) this;
        }

        public Criteria andSerialNameNotIn(List<String> values) {
            addCriterion("serial_name not in", values, "serialName");
            return (Criteria) this;
        }

        public Criteria andSerialNameBetween(String value1, String value2) {
            addCriterion("serial_name between", value1, value2, "serialName");
            return (Criteria) this;
        }

        public Criteria andSerialNameNotBetween(String value1, String value2) {
            addCriterion("serial_name not between", value1, value2, "serialName");
            return (Criteria) this;
        }

        public Criteria andSerialColorIsNull() {
            addCriterion("serial_color is null");
            return (Criteria) this;
        }

        public Criteria andSerialColorIsNotNull() {
            addCriterion("serial_color is not null");
            return (Criteria) this;
        }

        public Criteria andSerialColorEqualTo(String value) {
            addCriterion("serial_color =", value, "serialColor");
            return (Criteria) this;
        }

        public Criteria andSerialColorNotEqualTo(String value) {
            addCriterion("serial_color <>", value, "serialColor");
            return (Criteria) this;
        }

        public Criteria andSerialColorGreaterThan(String value) {
            addCriterion("serial_color >", value, "serialColor");
            return (Criteria) this;
        }

        public Criteria andSerialColorGreaterThanOrEqualTo(String value) {
            addCriterion("serial_color >=", value, "serialColor");
            return (Criteria) this;
        }

        public Criteria andSerialColorLessThan(String value) {
            addCriterion("serial_color <", value, "serialColor");
            return (Criteria) this;
        }

        public Criteria andSerialColorLessThanOrEqualTo(String value) {
            addCriterion("serial_color <=", value, "serialColor");
            return (Criteria) this;
        }

        public Criteria andSerialColorLike(String value) {
            addCriterion("serial_color like", value, "serialColor");
            return (Criteria) this;
        }

        public Criteria andSerialColorNotLike(String value) {
            addCriterion("serial_color not like", value, "serialColor");
            return (Criteria) this;
        }

        public Criteria andSerialColorIn(List<String> values) {
            addCriterion("serial_color in", values, "serialColor");
            return (Criteria) this;
        }

        public Criteria andSerialColorNotIn(List<String> values) {
            addCriterion("serial_color not in", values, "serialColor");
            return (Criteria) this;
        }

        public Criteria andSerialColorBetween(String value1, String value2) {
            addCriterion("serial_color between", value1, value2, "serialColor");
            return (Criteria) this;
        }

        public Criteria andSerialColorNotBetween(String value1, String value2) {
            addCriterion("serial_color not between", value1, value2, "serialColor");
            return (Criteria) this;
        }

        public Criteria andWhitecoverImageIsNull() {
            addCriterion("whitecover_image is null");
            return (Criteria) this;
        }

        public Criteria andWhitecoverImageIsNotNull() {
            addCriterion("whitecover_image is not null");
            return (Criteria) this;
        }

        public Criteria andWhitecoverImageEqualTo(String value) {
            addCriterion("whitecover_image =", value, "whitecoverImage");
            return (Criteria) this;
        }

        public Criteria andWhitecoverImageNotEqualTo(String value) {
            addCriterion("whitecover_image <>", value, "whitecoverImage");
            return (Criteria) this;
        }

        public Criteria andWhitecoverImageGreaterThan(String value) {
            addCriterion("whitecover_image >", value, "whitecoverImage");
            return (Criteria) this;
        }

        public Criteria andWhitecoverImageGreaterThanOrEqualTo(String value) {
            addCriterion("whitecover_image >=", value, "whitecoverImage");
            return (Criteria) this;
        }

        public Criteria andWhitecoverImageLessThan(String value) {
            addCriterion("whitecover_image <", value, "whitecoverImage");
            return (Criteria) this;
        }

        public Criteria andWhitecoverImageLessThanOrEqualTo(String value) {
            addCriterion("whitecover_image <=", value, "whitecoverImage");
            return (Criteria) this;
        }

        public Criteria andWhitecoverImageLike(String value) {
            addCriterion("whitecover_image like", value, "whitecoverImage");
            return (Criteria) this;
        }

        public Criteria andWhitecoverImageNotLike(String value) {
            addCriterion("whitecover_image not like", value, "whitecoverImage");
            return (Criteria) this;
        }

        public Criteria andWhitecoverImageIn(List<String> values) {
            addCriterion("whitecover_image in", values, "whitecoverImage");
            return (Criteria) this;
        }

        public Criteria andWhitecoverImageNotIn(List<String> values) {
            addCriterion("whitecover_image not in", values, "whitecoverImage");
            return (Criteria) this;
        }

        public Criteria andWhitecoverImageBetween(String value1, String value2) {
            addCriterion("whitecover_image between", value1, value2, "whitecoverImage");
            return (Criteria) this;
        }

        public Criteria andWhitecoverImageNotBetween(String value1, String value2) {
            addCriterion("whitecover_image not between", value1, value2, "whitecoverImage");
            return (Criteria) this;
        }

        public Criteria andClarityImageIsNull() {
            addCriterion("clarity_image is null");
            return (Criteria) this;
        }

        public Criteria andClarityImageIsNotNull() {
            addCriterion("clarity_image is not null");
            return (Criteria) this;
        }

        public Criteria andClarityImageEqualTo(String value) {
            addCriterion("clarity_image =", value, "clarityImage");
            return (Criteria) this;
        }

        public Criteria andClarityImageNotEqualTo(String value) {
            addCriterion("clarity_image <>", value, "clarityImage");
            return (Criteria) this;
        }

        public Criteria andClarityImageGreaterThan(String value) {
            addCriterion("clarity_image >", value, "clarityImage");
            return (Criteria) this;
        }

        public Criteria andClarityImageGreaterThanOrEqualTo(String value) {
            addCriterion("clarity_image >=", value, "clarityImage");
            return (Criteria) this;
        }

        public Criteria andClarityImageLessThan(String value) {
            addCriterion("clarity_image <", value, "clarityImage");
            return (Criteria) this;
        }

        public Criteria andClarityImageLessThanOrEqualTo(String value) {
            addCriterion("clarity_image <=", value, "clarityImage");
            return (Criteria) this;
        }

        public Criteria andClarityImageLike(String value) {
            addCriterion("clarity_image like", value, "clarityImage");
            return (Criteria) this;
        }

        public Criteria andClarityImageNotLike(String value) {
            addCriterion("clarity_image not like", value, "clarityImage");
            return (Criteria) this;
        }

        public Criteria andClarityImageIn(List<String> values) {
            addCriterion("clarity_image in", values, "clarityImage");
            return (Criteria) this;
        }

        public Criteria andClarityImageNotIn(List<String> values) {
            addCriterion("clarity_image not in", values, "clarityImage");
            return (Criteria) this;
        }

        public Criteria andClarityImageBetween(String value1, String value2) {
            addCriterion("clarity_image between", value1, value2, "clarityImage");
            return (Criteria) this;
        }

        public Criteria andClarityImageNotBetween(String value1, String value2) {
            addCriterion("clarity_image not between", value1, value2, "clarityImage");
            return (Criteria) this;
        }

        public Criteria andStyleIdIsNull() {
            addCriterion("style_id is null");
            return (Criteria) this;
        }

        public Criteria andStyleIdIsNotNull() {
            addCriterion("style_id is not null");
            return (Criteria) this;
        }

        public Criteria andStyleIdEqualTo(Integer value) {
            addCriterion("style_id =", value, "styleId");
            return (Criteria) this;
        }

        public Criteria andStyleIdNotEqualTo(Integer value) {
            addCriterion("style_id <>", value, "styleId");
            return (Criteria) this;
        }

        public Criteria andStyleIdGreaterThan(Integer value) {
            addCriterion("style_id >", value, "styleId");
            return (Criteria) this;
        }

        public Criteria andStyleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("style_id >=", value, "styleId");
            return (Criteria) this;
        }

        public Criteria andStyleIdLessThan(Integer value) {
            addCriterion("style_id <", value, "styleId");
            return (Criteria) this;
        }

        public Criteria andStyleIdLessThanOrEqualTo(Integer value) {
            addCriterion("style_id <=", value, "styleId");
            return (Criteria) this;
        }

        public Criteria andStyleIdIn(List<Integer> values) {
            addCriterion("style_id in", values, "styleId");
            return (Criteria) this;
        }

        public Criteria andStyleIdNotIn(List<Integer> values) {
            addCriterion("style_id not in", values, "styleId");
            return (Criteria) this;
        }

        public Criteria andStyleIdBetween(Integer value1, Integer value2) {
            addCriterion("style_id between", value1, value2, "styleId");
            return (Criteria) this;
        }

        public Criteria andStyleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("style_id not between", value1, value2, "styleId");
            return (Criteria) this;
        }

        public Criteria andStyleNameIsNull() {
            addCriterion("style_name is null");
            return (Criteria) this;
        }

        public Criteria andStyleNameIsNotNull() {
            addCriterion("style_name is not null");
            return (Criteria) this;
        }

        public Criteria andStyleNameEqualTo(String value) {
            addCriterion("style_name =", value, "styleName");
            return (Criteria) this;
        }

        public Criteria andStyleNameNotEqualTo(String value) {
            addCriterion("style_name <>", value, "styleName");
            return (Criteria) this;
        }

        public Criteria andStyleNameGreaterThan(String value) {
            addCriterion("style_name >", value, "styleName");
            return (Criteria) this;
        }

        public Criteria andStyleNameGreaterThanOrEqualTo(String value) {
            addCriterion("style_name >=", value, "styleName");
            return (Criteria) this;
        }

        public Criteria andStyleNameLessThan(String value) {
            addCriterion("style_name <", value, "styleName");
            return (Criteria) this;
        }

        public Criteria andStyleNameLessThanOrEqualTo(String value) {
            addCriterion("style_name <=", value, "styleName");
            return (Criteria) this;
        }

        public Criteria andStyleNameLike(String value) {
            addCriterion("style_name like", value, "styleName");
            return (Criteria) this;
        }

        public Criteria andStyleNameNotLike(String value) {
            addCriterion("style_name not like", value, "styleName");
            return (Criteria) this;
        }

        public Criteria andStyleNameIn(List<String> values) {
            addCriterion("style_name in", values, "styleName");
            return (Criteria) this;
        }

        public Criteria andStyleNameNotIn(List<String> values) {
            addCriterion("style_name not in", values, "styleName");
            return (Criteria) this;
        }

        public Criteria andStyleNameBetween(String value1, String value2) {
            addCriterion("style_name between", value1, value2, "styleName");
            return (Criteria) this;
        }

        public Criteria andStyleNameNotBetween(String value1, String value2) {
            addCriterion("style_name not between", value1, value2, "styleName");
            return (Criteria) this;
        }

        public Criteria andReferPriceIsNull() {
            addCriterion("refer_price is null");
            return (Criteria) this;
        }

        public Criteria andReferPriceIsNotNull() {
            addCriterion("refer_price is not null");
            return (Criteria) this;
        }

        public Criteria andReferPriceEqualTo(BigDecimal value) {
            addCriterion("refer_price =", value, "referPrice");
            return (Criteria) this;
        }

        public Criteria andReferPriceNotEqualTo(BigDecimal value) {
            addCriterion("refer_price <>", value, "referPrice");
            return (Criteria) this;
        }

        public Criteria andReferPriceGreaterThan(BigDecimal value) {
            addCriterion("refer_price >", value, "referPrice");
            return (Criteria) this;
        }

        public Criteria andReferPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("refer_price >=", value, "referPrice");
            return (Criteria) this;
        }

        public Criteria andReferPriceLessThan(BigDecimal value) {
            addCriterion("refer_price <", value, "referPrice");
            return (Criteria) this;
        }

        public Criteria andReferPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("refer_price <=", value, "referPrice");
            return (Criteria) this;
        }

        public Criteria andReferPriceIn(List<BigDecimal> values) {
            addCriterion("refer_price in", values, "referPrice");
            return (Criteria) this;
        }

        public Criteria andReferPriceNotIn(List<BigDecimal> values) {
            addCriterion("refer_price not in", values, "referPrice");
            return (Criteria) this;
        }

        public Criteria andReferPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("refer_price between", value1, value2, "referPrice");
            return (Criteria) this;
        }

        public Criteria andReferPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("refer_price not between", value1, value2, "referPrice");
            return (Criteria) this;
        }

        public Criteria andEngineCapacityIsNull() {
            addCriterion("engine_capacity is null");
            return (Criteria) this;
        }

        public Criteria andEngineCapacityIsNotNull() {
            addCriterion("engine_capacity is not null");
            return (Criteria) this;
        }

        public Criteria andEngineCapacityEqualTo(BigDecimal value) {
            addCriterion("engine_capacity =", value, "engineCapacity");
            return (Criteria) this;
        }

        public Criteria andEngineCapacityNotEqualTo(BigDecimal value) {
            addCriterion("engine_capacity <>", value, "engineCapacity");
            return (Criteria) this;
        }

        public Criteria andEngineCapacityGreaterThan(BigDecimal value) {
            addCriterion("engine_capacity >", value, "engineCapacity");
            return (Criteria) this;
        }

        public Criteria andEngineCapacityGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("engine_capacity >=", value, "engineCapacity");
            return (Criteria) this;
        }

        public Criteria andEngineCapacityLessThan(BigDecimal value) {
            addCriterion("engine_capacity <", value, "engineCapacity");
            return (Criteria) this;
        }

        public Criteria andEngineCapacityLessThanOrEqualTo(BigDecimal value) {
            addCriterion("engine_capacity <=", value, "engineCapacity");
            return (Criteria) this;
        }

        public Criteria andEngineCapacityIn(List<BigDecimal> values) {
            addCriterion("engine_capacity in", values, "engineCapacity");
            return (Criteria) this;
        }

        public Criteria andEngineCapacityNotIn(List<BigDecimal> values) {
            addCriterion("engine_capacity not in", values, "engineCapacity");
            return (Criteria) this;
        }

        public Criteria andEngineCapacityBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("engine_capacity between", value1, value2, "engineCapacity");
            return (Criteria) this;
        }

        public Criteria andEngineCapacityNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("engine_capacity not between", value1, value2, "engineCapacity");
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

        public Criteria andYearIsNull() {
            addCriterion("year is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("year is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(Integer value) {
            addCriterion("year =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(Integer value) {
            addCriterion("year <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(Integer value) {
            addCriterion("year >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("year >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(Integer value) {
            addCriterion("year <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(Integer value) {
            addCriterion("year <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<Integer> values) {
            addCriterion("year in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<Integer> values) {
            addCriterion("year not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(Integer value1, Integer value2) {
            addCriterion("year between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(Integer value1, Integer value2) {
            addCriterion("year not between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andAddPressTypeIsNull() {
            addCriterion("add_press_type is null");
            return (Criteria) this;
        }

        public Criteria andAddPressTypeIsNotNull() {
            addCriterion("add_press_type is not null");
            return (Criteria) this;
        }

        public Criteria andAddPressTypeEqualTo(String value) {
            addCriterion("add_press_type =", value, "addPressType");
            return (Criteria) this;
        }

        public Criteria andAddPressTypeNotEqualTo(String value) {
            addCriterion("add_press_type <>", value, "addPressType");
            return (Criteria) this;
        }

        public Criteria andAddPressTypeGreaterThan(String value) {
            addCriterion("add_press_type >", value, "addPressType");
            return (Criteria) this;
        }

        public Criteria andAddPressTypeGreaterThanOrEqualTo(String value) {
            addCriterion("add_press_type >=", value, "addPressType");
            return (Criteria) this;
        }

        public Criteria andAddPressTypeLessThan(String value) {
            addCriterion("add_press_type <", value, "addPressType");
            return (Criteria) this;
        }

        public Criteria andAddPressTypeLessThanOrEqualTo(String value) {
            addCriterion("add_press_type <=", value, "addPressType");
            return (Criteria) this;
        }

        public Criteria andAddPressTypeLike(String value) {
            addCriterion("add_press_type like", value, "addPressType");
            return (Criteria) this;
        }

        public Criteria andAddPressTypeNotLike(String value) {
            addCriterion("add_press_type not like", value, "addPressType");
            return (Criteria) this;
        }

        public Criteria andAddPressTypeIn(List<String> values) {
            addCriterion("add_press_type in", values, "addPressType");
            return (Criteria) this;
        }

        public Criteria andAddPressTypeNotIn(List<String> values) {
            addCriterion("add_press_type not in", values, "addPressType");
            return (Criteria) this;
        }

        public Criteria andAddPressTypeBetween(String value1, String value2) {
            addCriterion("add_press_type between", value1, value2, "addPressType");
            return (Criteria) this;
        }

        public Criteria andAddPressTypeNotBetween(String value1, String value2) {
            addCriterion("add_press_type not between", value1, value2, "addPressType");
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