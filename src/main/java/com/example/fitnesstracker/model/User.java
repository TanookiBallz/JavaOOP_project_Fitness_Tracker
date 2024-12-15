package com.example.fitnesstracker.model;

public class User {
    private int id;
    private String name;
    private String email;
    private String passwordHash;
    private String phone;
    private boolean isAdmin;
    private boolean firstLogin;
    public User(){}
    public User(int id,String name,String email,String passwordHash,String phone,boolean isAdmin,boolean firstLogin){
        this.id=id;this.name=name;this.email=email;this.passwordHash=passwordHash;this.phone=phone;this.isAdmin=isAdmin;this.firstLogin=firstLogin;
    }
    public int getId(){return id;}
    public void setId(int id){this.id=id;}
    public String getName(){return name;}
    public void setName(String name){this.name=name;}
    public String getEmail(){return email;}
    public void setEmail(String email){this.email=email;}
    public String getPasswordHash(){return passwordHash;}
    public void setPasswordHash(String passwordHash){this.passwordHash=passwordHash;}
    public String getPhone(){return phone;}
    public void setPhone(String phone){this.phone=phone;}
    public boolean isAdmin(){return isAdmin;}
    public void setAdmin(boolean admin){isAdmin=admin;}
    public boolean isFirstLogin(){return firstLogin;}
    public void setFirstLogin(boolean firstLogin){this.firstLogin=firstLogin;}
}