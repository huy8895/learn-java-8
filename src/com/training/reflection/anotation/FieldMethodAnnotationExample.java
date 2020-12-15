package com.training.reflection.anotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class FieldMethodAnnotationExample {
    @MyAnnotation(name = "myField")
    private int myField;

    @MyAnnotation(name = "myMethod", value = "my method value")
    protected void myMethod(String string){

    };

    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException {
        Class<FieldMethodAnnotationExample> aClazz = FieldMethodAnnotationExample.class;
        // Lấy đối tượng Field
        System.out.println(" == FIELD == ");
        Field field = aClazz.getDeclaredField("myField");

        // Lấy ra danh sách các Annotation của field.
        Annotation[] fieldAnns = field.getAnnotations();
        for (Annotation methodAnn : fieldAnns) {
            System.out.println("Annotation: " + methodAnn.annotationType().getSimpleName());
        }

        // Lấy cụ thể.
        MyAnnotation myAnn1  = field.getAnnotation(MyAnnotation.class);
        System.out.println("Name = " + myAnn1.name());
        System.out.println("Value = " + myAnn1.value());

        // Tương tự với method ...
        System.out.println(" == METHOD == ");
        Method method = aClazz.getDeclaredMethod("myMethod", String.class);
        // Lấy ra danh sách các Annotation của method.
        Annotation[] methodAnns = method.getAnnotations();
        for (Annotation methodAnn : methodAnns) {
            System.out.println("Annotation: " + methodAnn.annotationType().getSimpleName());
        }

        // Lấy cụ thể.
        MyAnnotation methodAnn = method.getAnnotation(MyAnnotation.class);
        System.out.println("Name = " + methodAnn.name());
        System.out.println("Value = " + methodAnn.value());

    }
}
