/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anazon.controller;

import com.anazon.model.User;
import com.anazon.service.UserService;
import com.anazon.service.impl.UserServiceImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Abdallah
 */
@Named("userController")

@SessionScoped
public class UserController implements Serializable {

    private UserService service;
    private List<User> usersList= new ArrayList<User>();

    public UserController() {
        service = new UserServiceImpl();
        usersList = service.getAllUsers();
    }

    public List<User> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<User> usersList) {
        this.usersList = usersList;
    }

}
