package pl.akademiaspring.hwweek3.model;

import org.springframework.stereotype.Component;

public class Car {
    private long id;
    private String model;
    private String color;
    private boolean rented;

    public Car() {
    }

    public Car(long id, String model, String color, boolean rented) {
        this.id = id;
        this.model = model;
        this.color = color;
        this.rented = rented;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }
}
