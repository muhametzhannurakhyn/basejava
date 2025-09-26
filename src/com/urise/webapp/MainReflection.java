package com.urise.webapp;

import com.urise.webapp.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MainReflection {

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
//        Resume r = new Resume();
//        Method toStringMethod = r.getClass().getMethod("toString");
//        Object result = toStringMethod.invoke(r);
//        System.out.println(result);
//
//        Field field = r.getClass().getDeclaredFields()[0];
//        System.out.println(field.getName());
//        field.setAccessible(true);
//        System.out.println(field.get(r));
//        field.set(r, "bob");
//        System.out.println(field.get(r));
//        System.out.println(r);


        System.out.println(solution(10));

    }


        public static int solution(int n) {
        int sum = 0;
            for (int i = 0; i <= n; i++) {
                if(i % 3 == 0||i % 5 == 0){
                    sum = sum+i;
                }
            }
            return sum;
        }

}
