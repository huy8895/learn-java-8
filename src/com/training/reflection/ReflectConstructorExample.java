package com.training.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectConstructorExample {
    public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        // Lấy ra đối tượng Class mô tả class Cat
        Class<Cat> aClass = Cat.class;

        // Lấy ra cấu tử có tham số (String,int) của class Cat
        Constructor<?> constructor = aClass.getConstructor(String.class, int.class);

        // Lấy ra thông tin kiểu tham số của cấu tử.
        System.out.println("Params:");
        Class<?>[] paramClasses = constructor.getParameterTypes();
        for (Class<?> paramClass : paramClasses) {
            System.out.println("+ " + paramClass.getSimpleName());
        }

        // Khởi tạo đối tượng Cat theo cách thông thường.
        Cat tom = new Cat("Tom", 1);
        System.out.println("Cat 1: " + tom.getName() + ", age =" + tom.getAge());

        // Khởi tạo đối tượng Cat theo cách của reflect.
        Cat tom2 = (Cat) constructor.newInstance("Tom", 2);
        System.out.println("Cat 2: " + tom.getName() + ", age =" + tom2.getAge());

        //============================================================================
        Class<Cat> catClass = Cat.class;
        Constructor<Cat> constructor1 = catClass.getConstructor(String.class, int.class);
        System.out.println("Params:");
        Class<?>[] parameterTypes = constructor1.getParameterTypes();
        for (Class<?> parameterType : parameterTypes) {
            System.out.println("+ " + parameterType.getSimpleName());
        }

        Cat tom1 = constructor1.newInstance("tom", 4);
        System.out.println("tom1 = " + tom1);


    }
}
