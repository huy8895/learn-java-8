package com.training.java_8.reflectionvsanotation;

import java.lang.annotation.*;

/**
 * là một Annotation sử dụng để đánh dấu đây là một phần cha
 * và giá trị của nó là một Collection (có chứa tài liệu xml con).
 */
@Documented
@Target({ ElementType.FIELD })
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface XmlElementWrapper {

    String name();

}
