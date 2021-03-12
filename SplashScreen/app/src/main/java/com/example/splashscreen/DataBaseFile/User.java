package com.example.splashscreen.DataBaseFile;

public class User {
    private int id ;
    private String password ;
    private String email ;

    public User(int id, String password, String email) {
        this.id = id;
        this.password = password;
        this.email = email;
    }






    public User() {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
