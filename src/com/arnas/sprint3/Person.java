package com.arnas.sprint3;

public class Person {
    private String name;
    private String lastName;
    private int age;

    public Person(String n, String ln, int age) {
        this.name = n;
        this.lastName = ln;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0 || age > 130) {
            System.err.println("Invalid age value. Please enter a value within the range of 0 - 130");
        } else {
            this.age = age;
        }
    }

    @Override
    public String toString() {
        return name + ", " + lastName + ", age: " + age;
    }
}
