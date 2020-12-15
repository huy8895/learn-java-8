package com.training.reflection.anotation;

import java.lang.annotation.Annotation;

@MyAnnotation(name = "table", value = "employee")
public class ClassAnnotationExample {
    public static void main(String[] args) {
        Class<ClassAnnotationExample> aClass = ClassAnnotationExample.class;
        Annotation[] annotations = aClass.getAnnotations();

        for (Annotation annotation : annotations) {
            System.out.println("annotation = " + annotation.annotationType().getSimpleName());
        }

        MyAnnotation annotation = aClass.getAnnotation(MyAnnotation.class);
        System.out.println("annotation.name() = " + annotation.name());
        System.out.println("annotation.value() = " + annotation.value());

    }
}
