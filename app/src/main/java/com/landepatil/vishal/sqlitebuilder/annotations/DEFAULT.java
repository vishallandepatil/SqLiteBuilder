package com.landepatil.vishal.sqlitebuilder.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Administrator on 23.08.2017.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface DEFAULT{
    String value() default "0";
}