package com.github.aneureka.util;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author hiki on 2018-02-02
 */

public class ClassFieldsResolver {

    public static Map<String, String> getFields(Object o) {
        Map<String, String> fieldValues = new LinkedHashMap<>();
        try {
            getFields(o, o.getClass(), fieldValues);
        } catch (IllegalAccessException e) {
            System.err.println(e.getMessage());
        }
        return fieldValues;
    }

    private static void getFields(Object o, Class<?> clazz, Map<String, String> container) throws IllegalAccessException {
        // resolve the fields of the clazz recursively
        Class<?> superClass = clazz.getSuperclass();
        if (superClass != null)
            getFields(o, superClass, container);

        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            container.put(f.getName(), f.get(o).toString());
        }
    }

}
