package com.arnas.sprint3;

public class Person implements Writeable, Filterable {
    private String name;
    private String lastName;
    private int age;

    public Person(String n, String ln, int age) {
        this.name = n;
        this.lastName = ln;
        this.age = age;
    }

    public Person(){

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

    @Override
    public String toFile() {
        return this.name + ";" + this.lastName + ";" + this.age;
    }

    @Override
    public boolean isUnique(Filterable o) {
        if (this.getName().equals(((Person)o).getName()) && this.getLastName().equals(((Person)o).getLastName())) {
            return true;
        } else {
            return false;
        }
    }
}
