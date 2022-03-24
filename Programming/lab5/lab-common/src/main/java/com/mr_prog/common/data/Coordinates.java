package com.mr_prog.common.data;

public class Coordinates implements Validatable {
    private Double x; //Поле не может быть null
    private int y;

    public Coordinates(Double x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Double getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean validate() {
        return x != null;
    }
}
