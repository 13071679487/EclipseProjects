package com.mvc.app.model;

import java.util.ArrayList;
import java.util.List;

public class CollegeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CollegeExample() {
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

        public Criteria andColidIsNull() {
            addCriterion("colid is null");
            return (Criteria) this;
        }

        public Criteria andColidIsNotNull() {
            addCriterion("colid is not null");
            return (Criteria) this;
        }

        public Criteria andColidEqualTo(String value) {
            addCriterion("colid =", value, "colid");
            return (Criteria) this;
        }

        public Criteria andColidNotEqualTo(String value) {
            addCriterion("colid <>", value, "colid");
            return (Criteria) this;
        }

        public Criteria andColidGreaterThan(String value) {
            addCriterion("colid >", value, "colid");
            return (Criteria) this;
        }

        public Criteria andColidGreaterThanOrEqualTo(String value) {
            addCriterion("colid >=", value, "colid");
            return (Criteria) this;
        }

        public Criteria andColidLessThan(String value) {
            addCriterion("colid <", value, "colid");
            return (Criteria) this;
        }

        public Criteria andColidLessThanOrEqualTo(String value) {
            addCriterion("colid <=", value, "colid");
            return (Criteria) this;
        }

        public Criteria andColidLike(String value) {
            addCriterion("colid like", value, "colid");
            return (Criteria) this;
        }

        public Criteria andColidNotLike(String value) {
            addCriterion("colid not like", value, "colid");
            return (Criteria) this;
        }

        public Criteria andColidIn(List<String> values) {
            addCriterion("colid in", values, "colid");
            return (Criteria) this;
        }

        public Criteria andColidNotIn(List<String> values) {
            addCriterion("colid not in", values, "colid");
            return (Criteria) this;
        }

        public Criteria andColidBetween(String value1, String value2) {
            addCriterion("colid between", value1, value2, "colid");
            return (Criteria) this;
        }

        public Criteria andColidNotBetween(String value1, String value2) {
            addCriterion("colid not between", value1, value2, "colid");
            return (Criteria) this;
        }

        public Criteria andColnameIsNull() {
            addCriterion("colname is null");
            return (Criteria) this;
        }

        public Criteria andColnameIsNotNull() {
            addCriterion("colname is not null");
            return (Criteria) this;
        }

        public Criteria andColnameEqualTo(String value) {
            addCriterion("colname =", value, "colname");
            return (Criteria) this;
        }

        public Criteria andColnameNotEqualTo(String value) {
            addCriterion("colname <>", value, "colname");
            return (Criteria) this;
        }

        public Criteria andColnameGreaterThan(String value) {
            addCriterion("colname >", value, "colname");
            return (Criteria) this;
        }

        public Criteria andColnameGreaterThanOrEqualTo(String value) {
            addCriterion("colname >=", value, "colname");
            return (Criteria) this;
        }

        public Criteria andColnameLessThan(String value) {
            addCriterion("colname <", value, "colname");
            return (Criteria) this;
        }

        public Criteria andColnameLessThanOrEqualTo(String value) {
            addCriterion("colname <=", value, "colname");
            return (Criteria) this;
        }

        public Criteria andColnameLike(String value) {
            addCriterion("colname like", value, "colname");
            return (Criteria) this;
        }

        public Criteria andColnameNotLike(String value) {
            addCriterion("colname not like", value, "colname");
            return (Criteria) this;
        }

        public Criteria andColnameIn(List<String> values) {
            addCriterion("colname in", values, "colname");
            return (Criteria) this;
        }

        public Criteria andColnameNotIn(List<String> values) {
            addCriterion("colname not in", values, "colname");
            return (Criteria) this;
        }

        public Criteria andColnameBetween(String value1, String value2) {
            addCriterion("colname between", value1, value2, "colname");
            return (Criteria) this;
        }

        public Criteria andColnameNotBetween(String value1, String value2) {
            addCriterion("colname not between", value1, value2, "colname");
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