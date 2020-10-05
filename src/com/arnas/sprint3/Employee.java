package com.arnas.sprint3;

public class Employee extends Person {
    private String position;
    private double workingYears;

    public Employee(String name, String lastName, int age, String pos, double workYrs) {
        super(name, lastName, age);
        this.position = pos;
        this.workingYears = workYrs;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getWorkingYears() {
        return workingYears;
    }

    public void setWorkingYears(double workingYears) {
        this.workingYears = workingYears;
    }

    @Override
    public String toString() {
        return super.toString() + ", position: " + position + ", working here for: " + workingYears;
    }

    @Override
    public String toFile() {
        return this.getName() + ";" + this.getLastName() + ";" + this.getAge() + ";" + this.position + ";" + this.workingYears;
    }
}
