package com.slotvinskiy;

public class Person {

    private String name;
    private int age;
    private boolean isEmployee;
    private char favoriteCharacter;
    private short favoriteNumber;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isEmployee=" + isEmployee +
                ", favoriteCharacter=" + favoriteCharacter +
                ", favoriteNumber=" + favoriteNumber +
                '}';
    }
}
