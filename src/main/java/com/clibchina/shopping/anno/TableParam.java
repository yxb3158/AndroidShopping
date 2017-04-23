package com.clibchina.shopping.anno;

import java.lang.annotation.*;

/**
 * Created by changlifeng on 16/3/30.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface TableParam {
    String value();
}
