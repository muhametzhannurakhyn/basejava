package com.urise.webapp;

import com.urise.webapp.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Resume r = new Resume();
        Method toStringMethod = r.getClass().getMethod("toString");
        Object result = toStringMethod.invoke(r);
        System.out.println(result);

        Field field = r.getClass().getDeclaredFields()[0];
        System.out.println(field.getName());
        field.setAccessible(true);
        System.out.println(field.get(r));
        field.set(r, "bob");
        System.out.println(field.get(r));
        System.out.println(r);


    }
}
