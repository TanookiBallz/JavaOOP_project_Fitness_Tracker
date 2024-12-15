package com.example.fitnesstracker.Controllers;

import com.example.fitnesstracker.model.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import java.time.LocalDate;
import com.example.fitnesstracker.app.AppController;

public class UserController {
    @FXML TextField heightField;
    @FXML TextField weightField;
    @FXML CheckBox maleCheck;
    @FXML TextField ageField;
    @FXML Label bmiLabel;
    @FXML TextField goalField;
    @FXML TextField stepsField;
    @FXML TextField waterField;
    @FXML TextField caloriesField;
    @FXML ListView<String> goalsList;
    @FXML ListView<String> activityList;

    private User user;
    private UserDetails details;

    public void initialize() {
        user=AppController.getInstance().getCurrentUser();
        loadData();
    }

    private void loadData() {
        try {
            details=UserDetailsDAO.getDetails(user.getId());
            if(details!=null) {
                heightField.setText(String.valueOf(details.getHeight()));
                weightField.setText(String.valueOf(details.getWeight()));
                maleCheck.setSelected(details.isMale());
                ageField.setText(String.valueOf(details.getAge()));
                bmiLabel.setText(String.format("%.2f",details.getBmi()));
            }
            for(Goal g: GoalDAO.getUserGoals(user.getId())) {
                goalsList.getItems().add(g.getGoalDescription());
            }
            for(UserActivity a: UserActivityDAO.getActivities(user.getId())) {
                activityList.getItems().add(a.getActivityDate()+" Steps:"+a.getSteps()+" Water:"+a.getWaterMl()+"ml Calories:"+a.getCalories());
            }
        }catch(Exception e){}
    }

    public void saveDetails() {
        try {
            double h=Double.parseDouble(heightField.getText());
            double w=Double.parseDouble(weightField.getText());
            int ag=Integer.parseInt(ageField.getText());
            boolean male=maleCheck.isSelected();
            double bmi=ModelUtil.calculateBMI(w,h);
            if(details==null) {
                details=new UserDetails(user.getId(),h,w,male,ag,bmi);
                UserDetailsDAO.insertDetails(details);
            } else {
                details.setHeight(h);
                details.setWeight(w);
                details.setAge(ag);
                details.setMale(male);
                details.setBmi(bmi);
                UserDetailsDAO.updateDetails(details);
            }
            user.setFirstLogin(false);
            UserDAO.updateUser(user);
            bmiLabel.setText(String.format("%.2f",bmi));
        }catch(Exception e){
            Alert a=new Alert(AlertType.ERROR,"Invalid input");
            a.showAndWait();
        }
    }

    public void addGoal(){
        try {
            if(goalField.getText().isEmpty()){
                Alert a=new Alert(AlertType.ERROR,"Goal empty");
                a.showAndWait();
                return;
            }
            Goal g=new Goal(0,user.getId(),goalField.getText());
            GoalDAO.insertGoal(g);
            goalsList.getItems().add(g.getGoalDescription());
            goalField.clear();
        }catch(Exception e){
            Alert a=new Alert(AlertType.ERROR,"Error");
            a.showAndWait();
        }
    }

    public void addActivity(){
        try {
            int steps=Integer.parseInt(stepsField.getText());
            int water=Integer.parseInt(waterField.getText());
            int cals=Integer.parseInt(caloriesField.getText());
            UserActivity ua=new UserActivity(0,user.getId(), LocalDate.now(),steps,water,cals);
            UserActivityDAO.insertActivity(ua);
            activityList.getItems().add(ua.getActivityDate()+" Steps:"+ua.getSteps()+" Water:"+ua.getWaterMl()+"ml Calories:"+ua.getCalories());
            stepsField.clear();
            waterField.clear();
            caloriesField.clear();
        }catch(Exception e){
            Alert a=new Alert(AlertType.ERROR,"Invalid input");
            a.showAndWait();
        }
    }
}