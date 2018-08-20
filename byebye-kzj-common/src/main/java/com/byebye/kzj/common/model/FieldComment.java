package com.byebye.kzj.common.model;

import java.lang.annotation.*;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/7/5 10:24  by  李娜（lina@cloud-young.com）创建
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FieldComment {
    String value() default "";
}

