package com.byebye.kzj.common.utils;

import java.io.IOException;

@FunctionalInterface
public interface CustomFunction<T, R> {

    R apply(T t) throws IOException;
}
