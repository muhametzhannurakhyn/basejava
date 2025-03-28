package com.urise.webapp;

import com.urise.webapp.model.Resume;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class mainRef {

    public static void main(String[] args) throws Exception {
        Resume r = new Resume();
        Method toStringMethod = r.getClass().getMethod("toString");
        String result = (String) toStringMethod.invoke(r);
        System.out.println(result);
    }
}
