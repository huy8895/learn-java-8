package com.training.java_8.reflection.anotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ParameterAnnotationExample {
    protected void doSomething(int jobType,
                               @MyAnnotation(name = "table",value = "employee")
                               String info){};

    public static void main(String[] args) throws NoSuchMethodException {
        Class<ParameterAnnotationExample> aClass = ParameterAnnotationExample.class;

        Method doSomething = aClass.getDeclaredMethod("doSomething", int.class, String.class);
        Class<?>[] parameterTypes = doSomething.getParameterTypes();
        for (Class<?> parameterType : parameterTypes) {
            System.out.println("parameterType = " + parameterType.getSimpleName());
        }

        System.out.println("------------------");
        Parameter[] parameters = doSomething.getParameters();
        for (Parameter parameter : parameters) {
            System.out.println("parameter = " + parameter.getType().getSimpleName());
        }


        Annotation[][] parameterAnnotations = doSomething.getParameterAnnotations();
        for (Annotation[] parameterAnnotation : parameterAnnotations) {
            for (Annotation annotation : parameterAnnotation) {
                System.out.println("annotation = " + annotation.annotationType().getSimpleName());
            }
        }
    }
}
