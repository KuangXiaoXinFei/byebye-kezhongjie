package com.cloudyoung.baic.common.model;

import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.HibernateValidatorConfiguration;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.io.Serializable;
import java.util.Set;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/7/5 10:09  by  李娜（lina@cloud-young.com）创建
 */
public class BaseModel implements Serializable {
    private static Validator validator = ((HibernateValidatorConfiguration) Validation.byProvider(HibernateValidator.class).configure()).failFast(true).buildValidatorFactory().getValidator();

    public BaseModel() {
    }

    public ValidateResult isValidate() {
        ValidateResult validateResult = new ValidateResult();
        validateResult.setValid(true);
        Set<ConstraintViolation<BaseModel>> constraintViolations = validator.validate(this, new Class[0]);
        if (constraintViolations.size() > 0) {
            validateResult.setValid(false);
            validateResult.setValidateMsg(((ConstraintViolation)constraintViolations.iterator().next()).getMessage());
        }

        return validateResult;
    }
}
