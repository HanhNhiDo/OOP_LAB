package com.aims.model;

public class DigitalVideoDisc {
    // Biến thành viên lớp (class variable)
    private static int nbDigitalVideoDiscs = 0; 

    // Biến thành viên đối tượng (instance variable)
    private int id;
    private String title; 
    private String category;
    private String director;
    private int length;
    private double cost;

    public DigitalVideoDisc(String title) {
        this.title = title;
        assignId();
    }

    public DigitalVideoDisc(String category, String title, double cost) {
        this.category = category;
        this.title = title;
        this.cost = cost;
        assignId();
    }

    public DigitalVideoDisc(String director, String category, String title, double cost) {
        this.director = director;
        this.category = category;
        this.title = title;
        this.cost = cost;
        assignId(); 
    }

    // Constructor với tất cả các thuộc tính
    public DigitalVideoDisc(String title, String category, String director, int length, double cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        assignId();
    }

    // Phương thức gán id duy nhất cho mỗi DVD
    private void assignId() {
        nbDigitalVideoDiscs++;  
        this.id = nbDigitalVideoDiscs; 
    }

    // Các getter
    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public double getCost() {
        return cost;
    }

    public int getId() {
        return id; 
    }

    // Phương thức setter cho title
    public void setTitle(String title) {
        this.title = title;
    }
}
