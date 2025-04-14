package org.example.pharmacy_web.service.value;

public class Price {
    private final double value;

    public Price(double value){
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public static Price create(double value){
        if (value < 0){
            throw new IllegalArgumentException("Price cannot be negative");
        }
        var rounded = (double) Math.round(value * 100) / 100;
        return new Price(rounded);
    }
}
