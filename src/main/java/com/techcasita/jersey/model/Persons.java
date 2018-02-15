package com.techcasita.jersey.model;

/**
 * Created by wolf on 8/13/15.
 */
public class Persons {
    private Person[] pa;

    @Override
    public String toString() {
        return Integer.toString(pa.length);
    }
}