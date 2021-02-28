package com.training.java_8.reflectionvsanotation;

import java.lang.annotation.*;

/**
 *là một Annotation, sử dụng để đánh dấu đây là một thuộc tính của phần tử.
 */
@Documented
@Target({ ElementType.FIELD })
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface XmlAttribute {

    String name();

}
