package com.fundamentos.springboot.fundamentos.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;
import org.springframework.validation.annotation.Validated;


@Validated
@ConfigurationProperties(prefix = "user")

public class UserPojo {
    private String email;
    private String passaword;
    private String age;

    public UserPojo(String email, String passaword, String age) {
        this.email = email;
        this.passaword = passaword;
        this.age = age;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassaword() {
        return passaword;
    }
    public void setPassaword(String passaword) {
        this.passaword = passaword;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
}

