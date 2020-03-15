package com.slotvinskiy;
import java.util.HashMap;
import java.util.Map;

public class MainTestMyGSon {

    public static void main(String[] args) {

        Map<String, String> source = new HashMap<>();
        source.put("name", "Bob");
        source.put("age", "32");
        source.put("isEmployee", "true");
        source.put("favoriteCharacter", "s");
        source.put("favoriteNumber", "7");
        Person person = new Person();
        MyGSon.parseData(source, person);
        System.out.println(person);
    }


}
