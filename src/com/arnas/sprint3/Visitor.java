package com.arnas.app;

public class Visitor extends Person {
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
}
