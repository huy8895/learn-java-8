package com.training.java_8.reflection;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelColumn {

    int index();

    String title();

    String description() default "Default value";

}
