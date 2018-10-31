package com.rifu.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WeatherExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WeatherExample() {
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

        public Criteria andWeatherCityidIsNull() {
            addCriterion("weather_cityid is null");
            return (Criteria) this;
        }

        public Criteria andWeatherCityidIsNotNull() {
            addCriterion("weather_cityid is not null");
            return (Criteria) this;
        }

        public Criteria andWeatherCityidEqualTo(Integer value) {
            addCriterion("weather_cityid =", value, "weatherCityid");
            return (Criteria) this;
        }

        public Criteria andWeatherCityidNotEqualTo(Integer value) {
            addCriterion("weather_cityid <>", value, "weatherCityid");
            return (Criteria) this;
        }

        public Criteria andWeatherCityidGreaterThan(Integer value) {
            addCriterion("weather_cityid >", value, "weatherCityid");
            return (Criteria) this;
        }

        public Criteria andWeatherCityidGreaterThanOrEqualTo(Integer value) {
            addCriterion("weather_cityid >=", value, "weatherCityid");
            return (Criteria) this;
        }

        public Criteria andWeatherCityidLessThan(Integer value) {
            addCriterion("weather_cityid <", value, "weatherCityid");
            return (Criteria) this;
        }

        public Criteria andWeatherCityidLessThanOrEqualTo(Integer value) {
            addCriterion("weather_cityid <=", value, "weatherCityid");
            return (Criteria) this;
        }

        public Criteria andWeatherCityidIn(List<Integer> values) {
            addCriterion("weather_cityid in", values, "weatherCityid");
            return (Criteria) this;
        }

        public Criteria andWeatherCityidNotIn(List<Integer> values) {
            addCriterion("weather_cityid not in", values, "weatherCityid");
            return (Criteria) this;
        }

        public Criteria andWeatherCityidBetween(Integer value1, Integer value2) {
            addCriterion("weather_cityid between", value1, value2, "weatherCityid");
            return (Criteria) this;
        }

        public Criteria andWeatherCityidNotBetween(Integer value1, Integer value2) {
            addCriterion("weather_cityid not between", value1, value2, "weatherCityid");
            return (Criteria) this;
        }

        public Criteria andWeatherCitynameIsNull() {
            addCriterion("weather_cityname is null");
            return (Criteria) this;
        }

        public Criteria andWeatherCitynameIsNotNull() {
            addCriterion("weather_cityname is not null");
            return (Criteria) this;
        }

        public Criteria andWeatherCitynameEqualTo(String value) {
            addCriterion("weather_cityname =", value, "weatherCityname");
            return (Criteria) this;
        }

        public Criteria andWeatherCitynameNotEqualTo(String value) {
            addCriterion("weather_cityname <>", value, "weatherCityname");
            return (Criteria) this;
        }

        public Criteria andWeatherCitynameGreaterThan(String value) {
            addCriterion("weather_cityname >", value, "weatherCityname");
            return (Criteria) this;
        }

        public Criteria andWeatherCitynameGreaterThanOrEqualTo(String value) {
            addCriterion("weather_cityname >=", value, "weatherCityname");
            return (Criteria) this;
        }

        public Criteria andWeatherCitynameLessThan(String value) {
            addCriterion("weather_cityname <", value, "weatherCityname");
            return (Criteria) this;
        }

        public Criteria andWeatherCitynameLessThanOrEqualTo(String value) {
            addCriterion("weather_cityname <=", value, "weatherCityname");
            return (Criteria) this;
        }

        public Criteria andWeatherCitynameLike(String value) {
            addCriterion("weather_cityname like", value, "weatherCityname");
            return (Criteria) this;
        }

        public Criteria andWeatherCitynameNotLike(String value) {
            addCriterion("weather_cityname not like", value, "weatherCityname");
            return (Criteria) this;
        }

        public Criteria andWeatherCitynameIn(List<String> values) {
            addCriterion("weather_cityname in", values, "weatherCityname");
            return (Criteria) this;
        }

        public Criteria andWeatherCitynameNotIn(List<String> values) {
            addCriterion("weather_cityname not in", values, "weatherCityname");
            return (Criteria) this;
        }

        public Criteria andWeatherCitynameBetween(String value1, String value2) {
            addCriterion("weather_cityname between", value1, value2, "weatherCityname");
            return (Criteria) this;
        }

        public Criteria andWeatherCitynameNotBetween(String value1, String value2) {
            addCriterion("weather_cityname not between", value1, value2, "weatherCityname");
            return (Criteria) this;
        }

        public Criteria andWeatherCitypyIsNull() {
            addCriterion("weather_citypy is null");
            return (Criteria) this;
        }

        public Criteria andWeatherCitypyIsNotNull() {
            addCriterion("weather_citypy is not null");
            return (Criteria) this;
        }

        public Criteria andWeatherCitypyEqualTo(String value) {
            addCriterion("weather_citypy =", value, "weatherCitypy");
            return (Criteria) this;
        }

        public Criteria andWeatherCitypyNotEqualTo(String value) {
            addCriterion("weather_citypy <>", value, "weatherCitypy");
            return (Criteria) this;
        }

        public Criteria andWeatherCitypyGreaterThan(String value) {
            addCriterion("weather_citypy >", value, "weatherCitypy");
            return (Criteria) this;
        }

        public Criteria andWeatherCitypyGreaterThanOrEqualTo(String value) {
            addCriterion("weather_citypy >=", value, "weatherCitypy");
            return (Criteria) this;
        }

        public Criteria andWeatherCitypyLessThan(String value) {
            addCriterion("weather_citypy <", value, "weatherCitypy");
            return (Criteria) this;
        }

        public Criteria andWeatherCitypyLessThanOrEqualTo(String value) {
            addCriterion("weather_citypy <=", value, "weatherCitypy");
            return (Criteria) this;
        }

        public Criteria andWeatherCitypyLike(String value) {
            addCriterion("weather_citypy like", value, "weatherCitypy");
            return (Criteria) this;
        }

        public Criteria andWeatherCitypyNotLike(String value) {
            addCriterion("weather_citypy not like", value, "weatherCitypy");
            return (Criteria) this;
        }

        public Criteria andWeatherCitypyIn(List<String> values) {
            addCriterion("weather_citypy in", values, "weatherCitypy");
            return (Criteria) this;
        }

        public Criteria andWeatherCitypyNotIn(List<String> values) {
            addCriterion("weather_citypy not in", values, "weatherCitypy");
            return (Criteria) this;
        }

        public Criteria andWeatherCitypyBetween(String value1, String value2) {
            addCriterion("weather_citypy between", value1, value2, "weatherCitypy");
            return (Criteria) this;
        }

        public Criteria andWeatherCitypyNotBetween(String value1, String value2) {
            addCriterion("weather_citypy not between", value1, value2, "weatherCitypy");
            return (Criteria) this;
        }

        public Criteria andWeatherDateIsNull() {
            addCriterion("weather_date is null");
            return (Criteria) this;
        }

        public Criteria andWeatherDateIsNotNull() {
            addCriterion("weather_date is not null");
            return (Criteria) this;
        }

        public Criteria andWeatherDateEqualTo(Date value) {
            addCriterion("weather_date =", value, "weatherDate");
            return (Criteria) this;
        }

        public Criteria andWeatherDateNotEqualTo(Date value) {
            addCriterion("weather_date <>", value, "weatherDate");
            return (Criteria) this;
        }

        public Criteria andWeatherDateGreaterThan(Date value) {
            addCriterion("weather_date >", value, "weatherDate");
            return (Criteria) this;
        }

        public Criteria andWeatherDateGreaterThanOrEqualTo(Date value) {
            addCriterion("weather_date >=", value, "weatherDate");
            return (Criteria) this;
        }

        public Criteria andWeatherDateLessThan(Date value) {
            addCriterion("weather_date <", value, "weatherDate");
            return (Criteria) this;
        }

        public Criteria andWeatherDateLessThanOrEqualTo(Date value) {
            addCriterion("weather_date <=", value, "weatherDate");
            return (Criteria) this;
        }

        public Criteria andWeatherDateIn(List<Date> values) {
            addCriterion("weather_date in", values, "weatherDate");
            return (Criteria) this;
        }

        public Criteria andWeatherDateNotIn(List<Date> values) {
            addCriterion("weather_date not in", values, "weatherDate");
            return (Criteria) this;
        }

        public Criteria andWeatherDateBetween(Date value1, Date value2) {
            addCriterion("weather_date between", value1, value2, "weatherDate");
            return (Criteria) this;
        }

        public Criteria andWeatherDateNotBetween(Date value1, Date value2) {
            addCriterion("weather_date not between", value1, value2, "weatherDate");
            return (Criteria) this;
        }

        public Criteria andWeatherTypeIsNull() {
            addCriterion("weather_type is null");
            return (Criteria) this;
        }

        public Criteria andWeatherTypeIsNotNull() {
            addCriterion("weather_type is not null");
            return (Criteria) this;
        }

        public Criteria andWeatherTypeEqualTo(String value) {
            addCriterion("weather_type =", value, "weatherType");
            return (Criteria) this;
        }

        public Criteria andWeatherTypeNotEqualTo(String value) {
            addCriterion("weather_type <>", value, "weatherType");
            return (Criteria) this;
        }

        public Criteria andWeatherTypeGreaterThan(String value) {
            addCriterion("weather_type >", value, "weatherType");
            return (Criteria) this;
        }

        public Criteria andWeatherTypeGreaterThanOrEqualTo(String value) {
            addCriterion("weather_type >=", value, "weatherType");
            return (Criteria) this;
        }

        public Criteria andWeatherTypeLessThan(String value) {
            addCriterion("weather_type <", value, "weatherType");
            return (Criteria) this;
        }

        public Criteria andWeatherTypeLessThanOrEqualTo(String value) {
            addCriterion("weather_type <=", value, "weatherType");
            return (Criteria) this;
        }

        public Criteria andWeatherTypeLike(String value) {
            addCriterion("weather_type like", value, "weatherType");
            return (Criteria) this;
        }

        public Criteria andWeatherTypeNotLike(String value) {
            addCriterion("weather_type not like", value, "weatherType");
            return (Criteria) this;
        }

        public Criteria andWeatherTypeIn(List<String> values) {
            addCriterion("weather_type in", values, "weatherType");
            return (Criteria) this;
        }

        public Criteria andWeatherTypeNotIn(List<String> values) {
            addCriterion("weather_type not in", values, "weatherType");
            return (Criteria) this;
        }

        public Criteria andWeatherTypeBetween(String value1, String value2) {
            addCriterion("weather_type between", value1, value2, "weatherType");
            return (Criteria) this;
        }

        public Criteria andWeatherTypeNotBetween(String value1, String value2) {
            addCriterion("weather_type not between", value1, value2, "weatherType");
            return (Criteria) this;
        }

        public Criteria andWeatherDescIsNull() {
            addCriterion("weather_desc is null");
            return (Criteria) this;
        }

        public Criteria andWeatherDescIsNotNull() {
            addCriterion("weather_desc is not null");
            return (Criteria) this;
        }

        public Criteria andWeatherDescEqualTo(String value) {
            addCriterion("weather_desc =", value, "weatherDesc");
            return (Criteria) this;
        }

        public Criteria andWeatherDescNotEqualTo(String value) {
            addCriterion("weather_desc <>", value, "weatherDesc");
            return (Criteria) this;
        }

        public Criteria andWeatherDescGreaterThan(String value) {
            addCriterion("weather_desc >", value, "weatherDesc");
            return (Criteria) this;
        }

        public Criteria andWeatherDescGreaterThanOrEqualTo(String value) {
            addCriterion("weather_desc >=", value, "weatherDesc");
            return (Criteria) this;
        }

        public Criteria andWeatherDescLessThan(String value) {
            addCriterion("weather_desc <", value, "weatherDesc");
            return (Criteria) this;
        }

        public Criteria andWeatherDescLessThanOrEqualTo(String value) {
            addCriterion("weather_desc <=", value, "weatherDesc");
            return (Criteria) this;
        }

        public Criteria andWeatherDescLike(String value) {
            addCriterion("weather_desc like", value, "weatherDesc");
            return (Criteria) this;
        }

        public Criteria andWeatherDescNotLike(String value) {
            addCriterion("weather_desc not like", value, "weatherDesc");
            return (Criteria) this;
        }

        public Criteria andWeatherDescIn(List<String> values) {
            addCriterion("weather_desc in", values, "weatherDesc");
            return (Criteria) this;
        }

        public Criteria andWeatherDescNotIn(List<String> values) {
            addCriterion("weather_desc not in", values, "weatherDesc");
            return (Criteria) this;
        }

        public Criteria andWeatherDescBetween(String value1, String value2) {
            addCriterion("weather_desc between", value1, value2, "weatherDesc");
            return (Criteria) this;
        }

        public Criteria andWeatherDescNotBetween(String value1, String value2) {
            addCriterion("weather_desc not between", value1, value2, "weatherDesc");
            return (Criteria) this;
        }

        public Criteria andWeatherHightempIsNull() {
            addCriterion("weather_hightemp is null");
            return (Criteria) this;
        }

        public Criteria andWeatherHightempIsNotNull() {
            addCriterion("weather_hightemp is not null");
            return (Criteria) this;
        }

        public Criteria andWeatherHightempEqualTo(Short value) {
            addCriterion("weather_hightemp =", value, "weatherHightemp");
            return (Criteria) this;
        }

        public Criteria andWeatherHightempNotEqualTo(Short value) {
            addCriterion("weather_hightemp <>", value, "weatherHightemp");
            return (Criteria) this;
        }

        public Criteria andWeatherHightempGreaterThan(Short value) {
            addCriterion("weather_hightemp >", value, "weatherHightemp");
            return (Criteria) this;
        }

        public Criteria andWeatherHightempGreaterThanOrEqualTo(Short value) {
            addCriterion("weather_hightemp >=", value, "weatherHightemp");
            return (Criteria) this;
        }

        public Criteria andWeatherHightempLessThan(Short value) {
            addCriterion("weather_hightemp <", value, "weatherHightemp");
            return (Criteria) this;
        }

        public Criteria andWeatherHightempLessThanOrEqualTo(Short value) {
            addCriterion("weather_hightemp <=", value, "weatherHightemp");
            return (Criteria) this;
        }

        public Criteria andWeatherHightempIn(List<Short> values) {
            addCriterion("weather_hightemp in", values, "weatherHightemp");
            return (Criteria) this;
        }

        public Criteria andWeatherHightempNotIn(List<Short> values) {
            addCriterion("weather_hightemp not in", values, "weatherHightemp");
            return (Criteria) this;
        }

        public Criteria andWeatherHightempBetween(Short value1, Short value2) {
            addCriterion("weather_hightemp between", value1, value2, "weatherHightemp");
            return (Criteria) this;
        }

        public Criteria andWeatherHightempNotBetween(Short value1, Short value2) {
            addCriterion("weather_hightemp not between", value1, value2, "weatherHightemp");
            return (Criteria) this;
        }

        public Criteria andWeatherLowtempIsNull() {
            addCriterion("weather_lowtemp is null");
            return (Criteria) this;
        }

        public Criteria andWeatherLowtempIsNotNull() {
            addCriterion("weather_lowtemp is not null");
            return (Criteria) this;
        }

        public Criteria andWeatherLowtempEqualTo(Short value) {
            addCriterion("weather_lowtemp =", value, "weatherLowtemp");
            return (Criteria) this;
        }

        public Criteria andWeatherLowtempNotEqualTo(Short value) {
            addCriterion("weather_lowtemp <>", value, "weatherLowtemp");
            return (Criteria) this;
        }

        public Criteria andWeatherLowtempGreaterThan(Short value) {
            addCriterion("weather_lowtemp >", value, "weatherLowtemp");
            return (Criteria) this;
        }

        public Criteria andWeatherLowtempGreaterThanOrEqualTo(Short value) {
            addCriterion("weather_lowtemp >=", value, "weatherLowtemp");
            return (Criteria) this;
        }

        public Criteria andWeatherLowtempLessThan(Short value) {
            addCriterion("weather_lowtemp <", value, "weatherLowtemp");
            return (Criteria) this;
        }

        public Criteria andWeatherLowtempLessThanOrEqualTo(Short value) {
            addCriterion("weather_lowtemp <=", value, "weatherLowtemp");
            return (Criteria) this;
        }

        public Criteria andWeatherLowtempIn(List<Short> values) {
            addCriterion("weather_lowtemp in", values, "weatherLowtemp");
            return (Criteria) this;
        }

        public Criteria andWeatherLowtempNotIn(List<Short> values) {
            addCriterion("weather_lowtemp not in", values, "weatherLowtemp");
            return (Criteria) this;
        }

        public Criteria andWeatherLowtempBetween(Short value1, Short value2) {
            addCriterion("weather_lowtemp between", value1, value2, "weatherLowtemp");
            return (Criteria) this;
        }

        public Criteria andWeatherLowtempNotBetween(Short value1, Short value2) {
            addCriterion("weather_lowtemp not between", value1, value2, "weatherLowtemp");
            return (Criteria) this;
        }
    }

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