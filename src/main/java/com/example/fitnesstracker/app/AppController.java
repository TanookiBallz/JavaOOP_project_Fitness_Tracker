package com.example.fitnesstracker.app;

import com.example.fitnesstracker.model.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

public class AppController {
    private static AppController instance;
    private Stage stage;
    private User currentUser;
    public static AppController getInstance(){
        if(instance==null) instance=new AppController();
        return instance;
    }
    public void setStage(Stage s){this.stage=s;}
    public User getCurrentUser(){return currentUser;}
    public void setCurrentUser(User u){currentUser=u;}
    public void goNext() {
        try {
            if(currentUser.isAdmin()){
                showAdmin();
            } else {
                if(currentUser.isFirstLogin()){
                    showUser();
                } else {
                    showUser();
                }
            }
        } catch(Exception e){}
    }
    public void showLogin(){
        try {
            
            FXMLLoader f=new FXMLLoader(getClass().getResource("/com/example/fitnesstracker/login.fxml"));
            stage.setScene(new Scene(f.load()));
            stage.getScene().getStylesheets().add(org.kordamp.bootstrapfx.BootstrapFX.bootstrapFXStylesheet());
            stage.show();
        }catch(Exception e){}
    }
    public void showRegister(){
        try {
            FXMLLoader f=new FXMLLoader(getClass().getResource("/com/example/fitnesstracker/register.fxml"));
            stage.setScene(new Scene(f.load()));
            stage.show();
        }catch(Exception e){}
    }
    public void showUser(){
        try {
            FXMLLoader f=new FXMLLoader(getClass().getResource("/com/example/fitnesstracker/user.fxml"));
            stage.setScene(new Scene(f.load()));
            stage.show();
        }catch(Exception e){}
    }
    public void showAdmin(){
        try {
            FXMLLoader f=new FXMLLoader(getClass().getResource("/com/example/fitnesstracker/admin.fxml"));
            stage.setScene(new Scene(f.load()));
            stage.show();
        }catch(Exception e){}
    }
}