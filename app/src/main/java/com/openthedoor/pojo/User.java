package com.openthedoor.pojo;

public class User {
    String name,password,confirmPassword,email,photo,phone;

    public User(String name, String password, String confirmPassword, String email, String photo, String phone) {
        this.name = name;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.email = email;
        this.photo = photo;
        this.phone = phone;

    }


    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoto() {
        return photo;
    }

    public String getPhone() {
        return phone;
    }
}
