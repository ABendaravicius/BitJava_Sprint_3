package com.arnas.sprint3;

public class Visitor extends Person implements Filterable {
    private String visitIntent;
    private int visitDurationMin;

    public Visitor(String name, String lastName, int age, String intent, int duration) {
        super(name, lastName, age);
        this.visitIntent = intent;
        this.visitDurationMin = duration;
    }

    public String getVisitIntent() {
        return visitIntent;
    }

    public void setVisitIntent(String visitIntent) {
        this.visitIntent = visitIntent;
    }

    public int getVisitDurationMin() {
        return visitDurationMin;
    }

    public void setVisitDurationMin(int visitDurationMin) {
        this.visitDurationMin = visitDurationMin;
    }

    @Override
    public String toString() {
        return super.toString() + ", intent of visit: " + visitIntent + ", visiting here for: " + visitDurationMin;
    }

    @Override
    public String toFile() {
        return this.getName() + ";" + this.getLastName() + ";" + this.getAge() + ";" + this.visitIntent + ";" + this.visitDurationMin;
    }

    public boolean equals(Visitor v2) {
        if (this.getName() == v2.getName() && this.getLastName() == v2.getLastName()) {
            return true;
        } else {
            return false;
        }
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
