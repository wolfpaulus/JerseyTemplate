package com.techcasita.jersey.model;


public class Person {
    private String name;
    private String email;

    @Override
    public String toString() {
        return "Name = " + name;
    }
}
