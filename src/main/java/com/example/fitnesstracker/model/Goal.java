package com.example.fitnesstracker.model;

public class Goal {
    private int id;
    private int userId;
    private String goalDescription;
    public Goal(){}
    public Goal(int id,int userId,String goalDescription){
        this.id=id;this.userId=userId;this.goalDescription=goalDescription;
    }
    public int getId(){return id;}
    public void setId(int id){this.id=id;}
    public int getUserId(){return userId;}
    public void setUserId(int userId){this.userId=userId;}
    public String getGoalDescription(){return goalDescription;}
    public void setGoalDescription(String goalDescription){this.goalDescription=goalDescription;}
}