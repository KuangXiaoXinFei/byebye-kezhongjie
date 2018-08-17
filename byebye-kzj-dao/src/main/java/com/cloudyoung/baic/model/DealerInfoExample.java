package com.cloudyoung.baic.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Accessors(chain = true)
public class DealerInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public DealerInfoExample() {
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

        public Criteria andDealerIdIsNull() {
            addCriterion("dealer_id is null");
            return (Criteria) this;
        }

        public Criteria andDealerIdIsNotNull() {
            addCriterion("dealer_id is not null");
            return (Criteria) this;
        }

        public Criteria andDealerIdEqualTo(Integer value) {
            addCriterion("dealer_id =", value, "dealerId");
            return (Criteria) this;
        }

        public Criteria andDealerIdNotEqualTo(Integer value) {
            addCriterion("dealer_id <>", value, "dealerId");
            return (Criteria) this;
        }

        public Criteria andDealerIdGreaterThan(Integer value) {
            addCriterion("dealer_id >", value, "dealerId");
            return (Criteria) this;
        }

        public Criteria andDealerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("dealer_id >=", value, "dealerId");
            return (Criteria) this;
        }

        public Criteria andDealerIdLessThan(Integer value) {
            addCriterion("dealer_id <", value, "dealerId");
            return (Criteria) this;
        }

        public Criteria andDealerIdLessThanOrEqualTo(Integer value) {
            addCriterion("dealer_id <=", value, "dealerId");
            return (Criteria) this;
        }

        public Criteria andDealerIdIn(List<Integer> values) {
            addCriterion("dealer_id in", values, "dealerId");
            return (Criteria) this;
        }

        public Criteria andDealerIdNotIn(List<Integer> values) {
            addCriterion("dealer_id not in", values, "dealerId");
            return (Criteria) this;
        }

        public Criteria andDealerIdBetween(Integer value1, Integer value2) {
            addCriterion("dealer_id between", value1, value2, "dealerId");
            return (Criteria) this;
        }

        public Criteria andDealerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("dealer_id not between", value1, value2, "dealerId");
            return (Criteria) this;
        }

        public Criteria andDealerCodeIsNull() {
            addCriterion("dealer_code is null");
            return (Criteria) this;
        }

        public Criteria andDealerCodeIsNotNull() {
            addCriterion("dealer_code is not null");
            return (Criteria) this;
        }

        public Criteria andDealerCodeEqualTo(String value) {
            addCriterion("dealer_code =", value, "dealerCode");
            return (Criteria) this;
        }

        public Criteria andDealerCodeNotEqualTo(String value) {
            addCriterion("dealer_code <>", value, "dealerCode");
            return (Criteria) this;
        }

        public Criteria andDealerCodeGreaterThan(String value) {
            addCriterion("dealer_code >", value, "dealerCode");
            return (Criteria) this;
        }

        public Criteria andDealerCodeGreaterThanOrEqualTo(String value) {
            addCriterion("dealer_code >=", value, "dealerCode");
            return (Criteria) this;
        }

        public Criteria andDealerCodeLessThan(String value) {
            addCriterion("dealer_code <", value, "dealerCode");
            return (Criteria) this;
        }

        public Criteria andDealerCodeLessThanOrEqualTo(String value) {
            addCriterion("dealer_code <=", value, "dealerCode");
            return (Criteria) this;
        }

        public Criteria andDealerCodeLike(String value) {
            addCriterion("dealer_code like", value, "dealerCode");
            return (Criteria) this;
        }

        public Criteria andDealerCodeNotLike(String value) {
            addCriterion("dealer_code not like", value, "dealerCode");
            return (Criteria) this;
        }

        public Criteria andDealerCodeIn(List<String> values) {
            addCriterion("dealer_code in", values, "dealerCode");
            return (Criteria) this;
        }

        public Criteria andDealerCodeNotIn(List<String> values) {
            addCriterion("dealer_code not in", values, "dealerCode");
            return (Criteria) this;
        }

        public Criteria andDealerCodeBetween(String value1, String value2) {
            addCriterion("dealer_code between", value1, value2, "dealerCode");
            return (Criteria) this;
        }

        public Criteria andDealerCodeNotBetween(String value1, String value2) {
            addCriterion("dealer_code not between", value1, value2, "dealerCode");
            return (Criteria) this;
        }

        public Criteria andDealerNameIsNull() {
            addCriterion("dealer_name is null");
            return (Criteria) this;
        }

        public Criteria andDealerNameIsNotNull() {
            addCriterion("dealer_name is not null");
            return (Criteria) this;
        }

        public Criteria andDealerNameEqualTo(String value) {
            addCriterion("dealer_name =", value, "dealerName");
            return (Criteria) this;
        }

        public Criteria andDealerNameNotEqualTo(String value) {
            addCriterion("dealer_name <>", value, "dealerName");
            return (Criteria) this;
        }

        public Criteria andDealerNameGreaterThan(String value) {
            addCriterion("dealer_name >", value, "dealerName");
            return (Criteria) this;
        }

        public Criteria andDealerNameGreaterThanOrEqualTo(String value) {
            addCriterion("dealer_name >=", value, "dealerName");
            return (Criteria) this;
        }

        public Criteria andDealerNameLessThan(String value) {
            addCriterion("dealer_name <", value, "dealerName");
            return (Criteria) this;
        }

        public Criteria andDealerNameLessThanOrEqualTo(String value) {
            addCriterion("dealer_name <=", value, "dealerName");
            return (Criteria) this;
        }

        public Criteria andDealerNameLike(String value) {
            addCriterion("dealer_name like", value, "dealerName");
            return (Criteria) this;
        }

        public Criteria andDealerNameNotLike(String value) {
            addCriterion("dealer_name not like", value, "dealerName");
            return (Criteria) this;
        }

        public Criteria andDealerNameIn(List<String> values) {
            addCriterion("dealer_name in", values, "dealerName");
            return (Criteria) this;
        }

        public Criteria andDealerNameNotIn(List<String> values) {
            addCriterion("dealer_name not in", values, "dealerName");
            return (Criteria) this;
        }

        public Criteria andDealerNameBetween(String value1, String value2) {
            addCriterion("dealer_name between", value1, value2, "dealerName");
            return (Criteria) this;
        }

        public Criteria andDealerNameNotBetween(String value1, String value2) {
            addCriterion("dealer_name not between", value1, value2, "dealerName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("company_name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("company_name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("company_name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("company_name like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("company_name not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("company_name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andSaleAddressIsNull() {
            addCriterion("sale_address is null");
            return (Criteria) this;
        }

        public Criteria andSaleAddressIsNotNull() {
            addCriterion("sale_address is not null");
            return (Criteria) this;
        }

        public Criteria andSaleAddressEqualTo(String value) {
            addCriterion("sale_address =", value, "saleAddress");
            return (Criteria) this;
        }

        public Criteria andSaleAddressNotEqualTo(String value) {
            addCriterion("sale_address <>", value, "saleAddress");
            return (Criteria) this;
        }

        public Criteria andSaleAddressGreaterThan(String value) {
            addCriterion("sale_address >", value, "saleAddress");
            return (Criteria) this;
        }

        public Criteria andSaleAddressGreaterThanOrEqualTo(String value) {
            addCriterion("sale_address >=", value, "saleAddress");
            return (Criteria) this;
        }

        public Criteria andSaleAddressLessThan(String value) {
            addCriterion("sale_address <", value, "saleAddress");
            return (Criteria) this;
        }

        public Criteria andSaleAddressLessThanOrEqualTo(String value) {
            addCriterion("sale_address <=", value, "saleAddress");
            return (Criteria) this;
        }

        public Criteria andSaleAddressLike(String value) {
            addCriterion("sale_address like", value, "saleAddress");
            return (Criteria) this;
        }

        public Criteria andSaleAddressNotLike(String value) {
            addCriterion("sale_address not like", value, "saleAddress");
            return (Criteria) this;
        }

        public Criteria andSaleAddressIn(List<String> values) {
            addCriterion("sale_address in", values, "saleAddress");
            return (Criteria) this;
        }

        public Criteria andSaleAddressNotIn(List<String> values) {
            addCriterion("sale_address not in", values, "saleAddress");
            return (Criteria) this;
        }

        public Criteria andSaleAddressBetween(String value1, String value2) {
            addCriterion("sale_address between", value1, value2, "saleAddress");
            return (Criteria) this;
        }

        public Criteria andSaleAddressNotBetween(String value1, String value2) {
            addCriterion("sale_address not between", value1, value2, "saleAddress");
            return (Criteria) this;
        }

        public Criteria andServiceAddressIsNull() {
            addCriterion("service_address is null");
            return (Criteria) this;
        }

        public Criteria andServiceAddressIsNotNull() {
            addCriterion("service_address is not null");
            return (Criteria) this;
        }

        public Criteria andServiceAddressEqualTo(String value) {
            addCriterion("service_address =", value, "serviceAddress");
            return (Criteria) this;
        }

        public Criteria andServiceAddressNotEqualTo(String value) {
            addCriterion("service_address <>", value, "serviceAddress");
            return (Criteria) this;
        }

        public Criteria andServiceAddressGreaterThan(String value) {
            addCriterion("service_address >", value, "serviceAddress");
            return (Criteria) this;
        }

        public Criteria andServiceAddressGreaterThanOrEqualTo(String value) {
            addCriterion("service_address >=", value, "serviceAddress");
            return (Criteria) this;
        }

        public Criteria andServiceAddressLessThan(String value) {
            addCriterion("service_address <", value, "serviceAddress");
            return (Criteria) this;
        }

        public Criteria andServiceAddressLessThanOrEqualTo(String value) {
            addCriterion("service_address <=", value, "serviceAddress");
            return (Criteria) this;
        }

        public Criteria andServiceAddressLike(String value) {
            addCriterion("service_address like", value, "serviceAddress");
            return (Criteria) this;
        }

        public Criteria andServiceAddressNotLike(String value) {
            addCriterion("service_address not like", value, "serviceAddress");
            return (Criteria) this;
        }

        public Criteria andServiceAddressIn(List<String> values) {
            addCriterion("service_address in", values, "serviceAddress");
            return (Criteria) this;
        }

        public Criteria andServiceAddressNotIn(List<String> values) {
            addCriterion("service_address not in", values, "serviceAddress");
            return (Criteria) this;
        }

        public Criteria andServiceAddressBetween(String value1, String value2) {
            addCriterion("service_address between", value1, value2, "serviceAddress");
            return (Criteria) this;
        }

        public Criteria andServiceAddressNotBetween(String value1, String value2) {
            addCriterion("service_address not between", value1, value2, "serviceAddress");
            return (Criteria) this;
        }

        public Criteria andServiceCallIsNull() {
            addCriterion("service_call is null");
            return (Criteria) this;
        }

        public Criteria andServiceCallIsNotNull() {
            addCriterion("service_call is not null");
            return (Criteria) this;
        }

        public Criteria andServiceCallEqualTo(String value) {
            addCriterion("service_call =", value, "serviceCall");
            return (Criteria) this;
        }

        public Criteria andServiceCallNotEqualTo(String value) {
            addCriterion("service_call <>", value, "serviceCall");
            return (Criteria) this;
        }

        public Criteria andServiceCallGreaterThan(String value) {
            addCriterion("service_call >", value, "serviceCall");
            return (Criteria) this;
        }

        public Criteria andServiceCallGreaterThanOrEqualTo(String value) {
            addCriterion("service_call >=", value, "serviceCall");
            return (Criteria) this;
        }

        public Criteria andServiceCallLessThan(String value) {
            addCriterion("service_call <", value, "serviceCall");
            return (Criteria) this;
        }

        public Criteria andServiceCallLessThanOrEqualTo(String value) {
            addCriterion("service_call <=", value, "serviceCall");
            return (Criteria) this;
        }

        public Criteria andServiceCallLike(String value) {
            addCriterion("service_call like", value, "serviceCall");
            return (Criteria) this;
        }

        public Criteria andServiceCallNotLike(String value) {
            addCriterion("service_call not like", value, "serviceCall");
            return (Criteria) this;
        }

        public Criteria andServiceCallIn(List<String> values) {
            addCriterion("service_call in", values, "serviceCall");
            return (Criteria) this;
        }

        public Criteria andServiceCallNotIn(List<String> values) {
            addCriterion("service_call not in", values, "serviceCall");
            return (Criteria) this;
        }

        public Criteria andServiceCallBetween(String value1, String value2) {
            addCriterion("service_call between", value1, value2, "serviceCall");
            return (Criteria) this;
        }

        public Criteria andServiceCallNotBetween(String value1, String value2) {
            addCriterion("service_call not between", value1, value2, "serviceCall");
            return (Criteria) this;
        }

        public Criteria andSaleCallIsNull() {
            addCriterion("sale_call is null");
            return (Criteria) this;
        }

        public Criteria andSaleCallIsNotNull() {
            addCriterion("sale_call is not null");
            return (Criteria) this;
        }

        public Criteria andSaleCallEqualTo(String value) {
            addCriterion("sale_call =", value, "saleCall");
            return (Criteria) this;
        }

        public Criteria andSaleCallNotEqualTo(String value) {
            addCriterion("sale_call <>", value, "saleCall");
            return (Criteria) this;
        }

        public Criteria andSaleCallGreaterThan(String value) {
            addCriterion("sale_call >", value, "saleCall");
            return (Criteria) this;
        }

        public Criteria andSaleCallGreaterThanOrEqualTo(String value) {
            addCriterion("sale_call >=", value, "saleCall");
            return (Criteria) this;
        }

        public Criteria andSaleCallLessThan(String value) {
            addCriterion("sale_call <", value, "saleCall");
            return (Criteria) this;
        }

        public Criteria andSaleCallLessThanOrEqualTo(String value) {
            addCriterion("sale_call <=", value, "saleCall");
            return (Criteria) this;
        }

        public Criteria andSaleCallLike(String value) {
            addCriterion("sale_call like", value, "saleCall");
            return (Criteria) this;
        }

        public Criteria andSaleCallNotLike(String value) {
            addCriterion("sale_call not like", value, "saleCall");
            return (Criteria) this;
        }

        public Criteria andSaleCallIn(List<String> values) {
            addCriterion("sale_call in", values, "saleCall");
            return (Criteria) this;
        }

        public Criteria andSaleCallNotIn(List<String> values) {
            addCriterion("sale_call not in", values, "saleCall");
            return (Criteria) this;
        }

        public Criteria andSaleCallBetween(String value1, String value2) {
            addCriterion("sale_call between", value1, value2, "saleCall");
            return (Criteria) this;
        }

        public Criteria andSaleCallNotBetween(String value1, String value2) {
            addCriterion("sale_call not between", value1, value2, "saleCall");
            return (Criteria) this;
        }

        public Criteria andHelpCallIsNull() {
            addCriterion("help_call is null");
            return (Criteria) this;
        }

        public Criteria andHelpCallIsNotNull() {
            addCriterion("help_call is not null");
            return (Criteria) this;
        }

        public Criteria andHelpCallEqualTo(String value) {
            addCriterion("help_call =", value, "helpCall");
            return (Criteria) this;
        }

        public Criteria andHelpCallNotEqualTo(String value) {
            addCriterion("help_call <>", value, "helpCall");
            return (Criteria) this;
        }

        public Criteria andHelpCallGreaterThan(String value) {
            addCriterion("help_call >", value, "helpCall");
            return (Criteria) this;
        }

        public Criteria andHelpCallGreaterThanOrEqualTo(String value) {
            addCriterion("help_call >=", value, "helpCall");
            return (Criteria) this;
        }

        public Criteria andHelpCallLessThan(String value) {
            addCriterion("help_call <", value, "helpCall");
            return (Criteria) this;
        }

        public Criteria andHelpCallLessThanOrEqualTo(String value) {
            addCriterion("help_call <=", value, "helpCall");
            return (Criteria) this;
        }

        public Criteria andHelpCallLike(String value) {
            addCriterion("help_call like", value, "helpCall");
            return (Criteria) this;
        }

        public Criteria andHelpCallNotLike(String value) {
            addCriterion("help_call not like", value, "helpCall");
            return (Criteria) this;
        }

        public Criteria andHelpCallIn(List<String> values) {
            addCriterion("help_call in", values, "helpCall");
            return (Criteria) this;
        }

        public Criteria andHelpCallNotIn(List<String> values) {
            addCriterion("help_call not in", values, "helpCall");
            return (Criteria) this;
        }

        public Criteria andHelpCallBetween(String value1, String value2) {
            addCriterion("help_call between", value1, value2, "helpCall");
            return (Criteria) this;
        }

        public Criteria andHelpCallNotBetween(String value1, String value2) {
            addCriterion("help_call not between", value1, value2, "helpCall");
            return (Criteria) this;
        }

        public Criteria andCityIdIsNull() {
            addCriterion("city_id is null");
            return (Criteria) this;
        }

        public Criteria andCityIdIsNotNull() {
            addCriterion("city_id is not null");
            return (Criteria) this;
        }

        public Criteria andCityIdEqualTo(Integer value) {
            addCriterion("city_id =", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotEqualTo(Integer value) {
            addCriterion("city_id <>", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThan(Integer value) {
            addCriterion("city_id >", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("city_id >=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThan(Integer value) {
            addCriterion("city_id <", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThanOrEqualTo(Integer value) {
            addCriterion("city_id <=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdIn(List<Integer> values) {
            addCriterion("city_id in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotIn(List<Integer> values) {
            addCriterion("city_id not in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdBetween(Integer value1, Integer value2) {
            addCriterion("city_id between", value1, value2, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("city_id not between", value1, value2, "cityId");
            return (Criteria) this;
        }

        public Criteria andServiceLongitudeIsNull() {
            addCriterion("service_longitude is null");
            return (Criteria) this;
        }

        public Criteria andServiceLongitudeIsNotNull() {
            addCriterion("service_longitude is not null");
            return (Criteria) this;
        }

        public Criteria andServiceLongitudeEqualTo(String value) {
            addCriterion("service_longitude =", value, "serviceLongitude");
            return (Criteria) this;
        }

        public Criteria andServiceLongitudeNotEqualTo(String value) {
            addCriterion("service_longitude <>", value, "serviceLongitude");
            return (Criteria) this;
        }

        public Criteria andServiceLongitudeGreaterThan(String value) {
            addCriterion("service_longitude >", value, "serviceLongitude");
            return (Criteria) this;
        }

        public Criteria andServiceLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("service_longitude >=", value, "serviceLongitude");
            return (Criteria) this;
        }

        public Criteria andServiceLongitudeLessThan(String value) {
            addCriterion("service_longitude <", value, "serviceLongitude");
            return (Criteria) this;
        }

        public Criteria andServiceLongitudeLessThanOrEqualTo(String value) {
            addCriterion("service_longitude <=", value, "serviceLongitude");
            return (Criteria) this;
        }

        public Criteria andServiceLongitudeLike(String value) {
            addCriterion("service_longitude like", value, "serviceLongitude");
            return (Criteria) this;
        }

        public Criteria andServiceLongitudeNotLike(String value) {
            addCriterion("service_longitude not like", value, "serviceLongitude");
            return (Criteria) this;
        }

        public Criteria andServiceLongitudeIn(List<String> values) {
            addCriterion("service_longitude in", values, "serviceLongitude");
            return (Criteria) this;
        }

        public Criteria andServiceLongitudeNotIn(List<String> values) {
            addCriterion("service_longitude not in", values, "serviceLongitude");
            return (Criteria) this;
        }

        public Criteria andServiceLongitudeBetween(String value1, String value2) {
            addCriterion("service_longitude between", value1, value2, "serviceLongitude");
            return (Criteria) this;
        }

        public Criteria andServiceLongitudeNotBetween(String value1, String value2) {
            addCriterion("service_longitude not between", value1, value2, "serviceLongitude");
            return (Criteria) this;
        }

        public Criteria andServiceLatitudeIsNull() {
            addCriterion("service_latitude is null");
            return (Criteria) this;
        }

        public Criteria andServiceLatitudeIsNotNull() {
            addCriterion("service_latitude is not null");
            return (Criteria) this;
        }

        public Criteria andServiceLatitudeEqualTo(String value) {
            addCriterion("service_latitude =", value, "serviceLatitude");
            return (Criteria) this;
        }

        public Criteria andServiceLatitudeNotEqualTo(String value) {
            addCriterion("service_latitude <>", value, "serviceLatitude");
            return (Criteria) this;
        }

        public Criteria andServiceLatitudeGreaterThan(String value) {
            addCriterion("service_latitude >", value, "serviceLatitude");
            return (Criteria) this;
        }

        public Criteria andServiceLatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("service_latitude >=", value, "serviceLatitude");
            return (Criteria) this;
        }

        public Criteria andServiceLatitudeLessThan(String value) {
            addCriterion("service_latitude <", value, "serviceLatitude");
            return (Criteria) this;
        }

        public Criteria andServiceLatitudeLessThanOrEqualTo(String value) {
            addCriterion("service_latitude <=", value, "serviceLatitude");
            return (Criteria) this;
        }

        public Criteria andServiceLatitudeLike(String value) {
            addCriterion("service_latitude like", value, "serviceLatitude");
            return (Criteria) this;
        }

        public Criteria andServiceLatitudeNotLike(String value) {
            addCriterion("service_latitude not like", value, "serviceLatitude");
            return (Criteria) this;
        }

        public Criteria andServiceLatitudeIn(List<String> values) {
            addCriterion("service_latitude in", values, "serviceLatitude");
            return (Criteria) this;
        }

        public Criteria andServiceLatitudeNotIn(List<String> values) {
            addCriterion("service_latitude not in", values, "serviceLatitude");
            return (Criteria) this;
        }

        public Criteria andServiceLatitudeBetween(String value1, String value2) {
            addCriterion("service_latitude between", value1, value2, "serviceLatitude");
            return (Criteria) this;
        }

        public Criteria andServiceLatitudeNotBetween(String value1, String value2) {
            addCriterion("service_latitude not between", value1, value2, "serviceLatitude");
            return (Criteria) this;
        }

        public Criteria andSaleLongitudeIsNull() {
            addCriterion("sale_longitude is null");
            return (Criteria) this;
        }

        public Criteria andSaleLongitudeIsNotNull() {
            addCriterion("sale_longitude is not null");
            return (Criteria) this;
        }

        public Criteria andSaleLongitudeEqualTo(String value) {
            addCriterion("sale_longitude =", value, "saleLongitude");
            return (Criteria) this;
        }

        public Criteria andSaleLongitudeNotEqualTo(String value) {
            addCriterion("sale_longitude <>", value, "saleLongitude");
            return (Criteria) this;
        }

        public Criteria andSaleLongitudeGreaterThan(String value) {
            addCriterion("sale_longitude >", value, "saleLongitude");
            return (Criteria) this;
        }

        public Criteria andSaleLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("sale_longitude >=", value, "saleLongitude");
            return (Criteria) this;
        }

        public Criteria andSaleLongitudeLessThan(String value) {
            addCriterion("sale_longitude <", value, "saleLongitude");
            return (Criteria) this;
        }

        public Criteria andSaleLongitudeLessThanOrEqualTo(String value) {
            addCriterion("sale_longitude <=", value, "saleLongitude");
            return (Criteria) this;
        }

        public Criteria andSaleLongitudeLike(String value) {
            addCriterion("sale_longitude like", value, "saleLongitude");
            return (Criteria) this;
        }

        public Criteria andSaleLongitudeNotLike(String value) {
            addCriterion("sale_longitude not like", value, "saleLongitude");
            return (Criteria) this;
        }

        public Criteria andSaleLongitudeIn(List<String> values) {
            addCriterion("sale_longitude in", values, "saleLongitude");
            return (Criteria) this;
        }

        public Criteria andSaleLongitudeNotIn(List<String> values) {
            addCriterion("sale_longitude not in", values, "saleLongitude");
            return (Criteria) this;
        }

        public Criteria andSaleLongitudeBetween(String value1, String value2) {
            addCriterion("sale_longitude between", value1, value2, "saleLongitude");
            return (Criteria) this;
        }

        public Criteria andSaleLongitudeNotBetween(String value1, String value2) {
            addCriterion("sale_longitude not between", value1, value2, "saleLongitude");
            return (Criteria) this;
        }

        public Criteria andSaleLatitudeIsNull() {
            addCriterion("sale_latitude is null");
            return (Criteria) this;
        }

        public Criteria andSaleLatitudeIsNotNull() {
            addCriterion("sale_latitude is not null");
            return (Criteria) this;
        }

        public Criteria andSaleLatitudeEqualTo(String value) {
            addCriterion("sale_latitude =", value, "saleLatitude");
            return (Criteria) this;
        }

        public Criteria andSaleLatitudeNotEqualTo(String value) {
            addCriterion("sale_latitude <>", value, "saleLatitude");
            return (Criteria) this;
        }

        public Criteria andSaleLatitudeGreaterThan(String value) {
            addCriterion("sale_latitude >", value, "saleLatitude");
            return (Criteria) this;
        }

        public Criteria andSaleLatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("sale_latitude >=", value, "saleLatitude");
            return (Criteria) this;
        }

        public Criteria andSaleLatitudeLessThan(String value) {
            addCriterion("sale_latitude <", value, "saleLatitude");
            return (Criteria) this;
        }

        public Criteria andSaleLatitudeLessThanOrEqualTo(String value) {
            addCriterion("sale_latitude <=", value, "saleLatitude");
            return (Criteria) this;
        }

        public Criteria andSaleLatitudeLike(String value) {
            addCriterion("sale_latitude like", value, "saleLatitude");
            return (Criteria) this;
        }

        public Criteria andSaleLatitudeNotLike(String value) {
            addCriterion("sale_latitude not like", value, "saleLatitude");
            return (Criteria) this;
        }

        public Criteria andSaleLatitudeIn(List<String> values) {
            addCriterion("sale_latitude in", values, "saleLatitude");
            return (Criteria) this;
        }

        public Criteria andSaleLatitudeNotIn(List<String> values) {
            addCriterion("sale_latitude not in", values, "saleLatitude");
            return (Criteria) this;
        }

        public Criteria andSaleLatitudeBetween(String value1, String value2) {
            addCriterion("sale_latitude between", value1, value2, "saleLatitude");
            return (Criteria) this;
        }

        public Criteria andSaleLatitudeNotBetween(String value1, String value2) {
            addCriterion("sale_latitude not between", value1, value2, "saleLatitude");
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