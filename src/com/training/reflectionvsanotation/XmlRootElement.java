package com.training.reflectionvsanotation;

import java.lang.annotation.*;

/**
 *  là một Annotation, sử dụng để đánh dấu phần tử gốc (root element) của một tài liệu xml.
 */

@Documented
@Target(ElementType.TYPE)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface XmlRootElement {
    String name();

    String namespace() default "";
}
