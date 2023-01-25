package com.springdemo2.course;

public class MotorModel {


    private String modelName;
    private String color;
    private int yearModel;
    private int mileage;
    private int price;


    public MotorModel(String modelName, String color, int yearModel, int mileage, int price) {
        this.modelName = modelName;
        this.color = color;
        this.yearModel = yearModel;
        this.mileage = mileage;
        this.price = price;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYearModel() {
        return yearModel;
    }

    public void setYearModel(int yearModel) {
        this.yearModel = yearModel;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
