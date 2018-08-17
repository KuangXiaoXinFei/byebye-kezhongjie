package com.cloudyoung.baic.admin.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description:资源注解
 * All Rights Reserved.
 *
 * @version 1.0  2017/9/14 19:34  by  张成智（zhangcz@cloud-young.com）创建
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ResourceKey {
    String value() default "";
}
