package com.example.fitnesstracker.Controllers;

import com.example.fitnesstracker.model.User;
import com.example.fitnesstracker.model.UserDAO;
import com.example.fitnesstracker.util.HashUtil;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.control.Alert.AlertType;
import com.example.fitnesstracker.app.AppController;

public class LoginController {
    @FXML TextField emailField;
    @FXML PasswordField passwordField;
    @FXML Hyperlink registerLink;
    @FXML Button loginButton;
    public void login() {
        try {
            String email=emailField.getText();
            String pass=HashUtil.hash(passwordField.getText());
            User u=UserDAO.getUserByEmail(email);
            if(u==null||!u.getPasswordHash().equals(pass)) {
                Alert a=new Alert(AlertType.ERROR,"Invalid credentials");
                a.showAndWait();
                return;
            }
            AppController.getInstance().setCurrentUser(u);
            AppController.getInstance().goNext();
        } catch(Exception e) {
            Alert a=new Alert(AlertType.ERROR,"Error");
            a.showAndWait();
        }
    }
    public void goRegister(){
        AppController.getInstance().showRegister();
    }
}