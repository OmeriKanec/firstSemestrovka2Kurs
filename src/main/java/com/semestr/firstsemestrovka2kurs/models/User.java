package com.semestr.firstsemestrovka2kurs.models;

public class User {
    private String userName;
    private String password;
    private String email;
    private String profilePicture;
    private String bio;
    public User (String userName, String password, String email){
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public String getBio() {
        return bio;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public User(String userName, String password, String email, String profilePicture, String bio) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.profilePicture = profilePicture;
        this.bio = bio;
    }
}
