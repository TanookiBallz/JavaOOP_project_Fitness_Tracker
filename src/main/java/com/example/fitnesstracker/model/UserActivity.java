package com.example.fitnesstracker.model;

import java.time.LocalDate;

public class UserActivity {
    private int id;
    private int userId;
    private LocalDate activityDate;
    private int steps;
    private int waterMl;
    private int calories;
    public UserActivity(){}
    public UserActivity(int id,int userId,LocalDate activityDate,int steps,int waterMl,int calories){
        this.id=id;this.userId=userId;this.activityDate=activityDate;this.steps=steps;this.waterMl=waterMl;this.calories=calories;
    }
    public int getId(){return id;}
    public void setId(int id){this.id=id;}
    public int getUserId(){return userId;}
    public void setUserId(int userId){this.userId=userId;}
    public LocalDate getActivityDate(){return activityDate;}
    public void setActivityDate(LocalDate activityDate){this.activityDate=activityDate;}
    public int getSteps(){return steps;}
    public void setSteps(int steps){this.steps=steps;}
    public int getWaterMl(){return waterMl;}
    public void setWaterMl(int waterMl){this.waterMl=waterMl;}
    public int getCalories(){return calories;}
    public void setCalories(int calories){this.calories=calories;}
}