package com.rest.webservices.restfulwebservices.Versioning;

public class PersonV1 {
    private String name;

    public PersonV1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "PerconV1 [name=" + name + "]";
    }

    
    
}
