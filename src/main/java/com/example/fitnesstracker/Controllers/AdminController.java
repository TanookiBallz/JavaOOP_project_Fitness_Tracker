package com.example.fitnesstracker.Controllers;

import com.example.fitnesstracker.model.*;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.*;

public class AdminController {
    @FXML TableView<UserTableRow> userTable;
    @FXML TableColumn<UserTableRow,String> colName;
    @FXML TableColumn<UserTableRow,String> colEmail;
    @FXML TableColumn<UserTableRow,String> colPhone;
    @FXML TableColumn<UserTableRow,String> colBmi;

    public void initialize(){
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colBmi.setCellValueFactory(new PropertyValueFactory<>("bmi"));
        loadUsers();
    }

    private void loadUsers(){
        try {
            List<User> users=UserDAO.getAllUsers();
            for(User u: users) {
                UserDetails d=UserDetailsDAO.getDetails(u.getId());
                String bmi="N/A";
                if(d!=null) bmi=String.format("%.2f",d.getBmi());
                userTable.getItems().add(new UserTableRow(u.getName(),u.getEmail(),u.getPhone(),bmi));
            }
        }catch(Exception e){}
    }

    public static class UserTableRow {
        private String name;private String email;private String phone;private String bmi;
        public UserTableRow(String name,String email,String phone,String bmi){this.name=name;this.email=email;this.phone=phone;this.bmi=bmi;}
        public String getName(){return name;}
        public String getEmail(){return email;}
        public String getPhone(){return phone;}
        public String getBmi(){return bmi;}
    }
}

