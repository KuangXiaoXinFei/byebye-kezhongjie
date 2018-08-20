package com.byebye.kzj.common.model;

import java.lang.reflect.Type;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/7/5 10:24  by  李娜（lina@cloud-young.com）创建
 */
public class FieldChangeInfo {
    private String fieldName;
    private String fieldComment;
    private Type fieldType;
    private Object sourceValue;
    private Object targetValue;

    public FieldChangeInfo() {
    }

    public String getFieldComment() {
        return this.fieldComment;
    }

    public void setFieldComment(String fieldComment) {
        this.fieldComment = fieldComment;
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Object getSourceValue() {
        return this.sourceValue;
    }

    public void setSourceValue(Object sourceValue) {
        this.sourceValue = sourceValue;
    }

    public Object getTargetValue() {
        return this.targetValue;
    }

    public void setTargetValue(Object targetValue) {
        this.targetValue = targetValue;
    }

    public Type getFieldType() {
        return this.fieldType;
    }

    public void setFieldType(Type fieldType) {
        this.fieldType = fieldType;
    }
}
