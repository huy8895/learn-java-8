package com.training.java_8.reflectionvsanotation;

import java.lang.annotation.*;

/**
 *  là một Annotation, sử dụng để đánh dấu đây là một phần tử của tài liệu xml.
 */
@Documented
@Target({ ElementType.FIELD })
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface XmlElement {

    String name();

}
