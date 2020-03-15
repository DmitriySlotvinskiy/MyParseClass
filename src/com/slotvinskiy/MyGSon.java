package com.slotvinskiy;

import java.lang.reflect.Field;
import java.util.Map;

public class MyGSon {

    public static void parseData(Map<String, String> source, Person person) {

        Class clazz = person.getClass();
        for (Map.Entry<String, String> entry : source.entrySet()) {
            Field field = null;
            try {
                field = clazz.getDeclaredField(entry.getKey());
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            field.setAccessible(true);
            String fieldType = field.getType().getTypeName();
            parseValue(person, entry, field, fieldType);
        }
    }

    private static void parseValue(Person person, Map.Entry<String, String> entry, Field field, String fieldType) {
        try {
            switch (fieldType) {
                case "java.lang.String":
                    field.set(person, entry.getValue());
                    break;
                case "char":
                    field.set(person, entry.getValue().toCharArray()[0]);
                    break;
                case "long":
                    field.set(person, Long.parseLong(entry.getValue()));
                    break;
                case "int":
                    field.set(person, Integer.parseInt(entry.getValue()));
                    break;
                case "short":
                    field.set(person, Short.parseShort(entry.getValue()));
                    break;
                case "byte":
                    field.set(person, Byte.parseByte(entry.getValue()));
                    break;
                case "double":
                    field.set(person, Double.parseDouble(entry.getValue()));
                    break;
                case "float":
                    field.set(person, Float.parseFloat(entry.getValue()));
                    break;
                case "boolean":
                    field.set(person, Boolean.parseBoolean(entry.getValue()));
                    break;
                default:
                    throw new NoSuchFieldException();
            }
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
