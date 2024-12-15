package com.example.fitnesstracker.model;

public class UserDetails {
    private int userId;
    private double height;
    private double weight;
    private boolean isMale;
    private int age;
    private double bmi;
    public UserDetails(){}
    public UserDetails(int userId,double height,double weight,boolean isMale,int age,double bmi){
        this.userId=userId;this.height=height;this.weight=weight;this.isMale=isMale;this.age=age;this.bmi=bmi;
    }
    public int getUserId(){return userId;}
    public void setUserId(int userId){this.userId=userId;}
    public double getHeight(){return height;}
    public void setHeight(double height){this.height=height;}
    public double getWeight(){return weight;}
    public void setWeight(double weight){this.weight=weight;}
    public boolean isMale(){return isMale;}
    public void setMale(boolean male){isMale=male;}
    public int getAge(){return age;}
    public void setAge(int age){this.age=age;}
    public double getBmi(){return bmi;}
    public void setBmi(double bmi){this.bmi=bmi;}
}