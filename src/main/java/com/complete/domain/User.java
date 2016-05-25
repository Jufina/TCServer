package com.complete.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User implements Serializable{
    @Transient
    private static final long serialVersionUID = -3323223680030341871L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
//    private String group;
//    private String login;
//    private String password;
//    private String token; // Необязательное
//    private Boolean participate;

    public Long getId() {
        return id;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Solution> solution = new ArrayList<>();

    public User(String firstName, String lastName, String group, String login, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
//        this.group = group;
//        this.login = login;
//        this.password = password;
//        this.participate = false;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

//    public String getGroup() {
//        return group;
//    }
//
//    public void setGroup(String group) {
//        this.group = group;
//    }
//
//    public String getLogin() {
//        return login;
//    }
//
//    public void setLogin(String login) {
//        this.login = login;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getToken() {
//        return token;
//    }
//
//    public void setToken(String token) {
//        this.token = token;
//    }
//
//    public boolean isParticipate() {
//        return participate;
//    }
//
//    public void setParticipate(boolean participate) {
//        this.participate = participate;
//    }

    public User() {
    }

    public List<Solution> getSolution() {
        return solution;
    }

    public void setSolution(List<Solution> solution) {
        this.solution = solution;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
