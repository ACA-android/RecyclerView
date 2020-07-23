package com.dm.recyclerview;

import android.graphics.Bitmap;

public class Car {

    private String name;
    private int color;
    private String manufacturer;

    private int horsePower;

    private Bitmap image;

    private boolean isSelected;

    public Car(String name, int color, String manufacturer, int horsePower, Bitmap image) {
        this.name = name;
        this.color = color;
        this.manufacturer = manufacturer;
        this.horsePower = horsePower;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
