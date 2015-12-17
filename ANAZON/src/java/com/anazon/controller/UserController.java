/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anazon.controller;

import com.anazon.model.SystemUser;
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
    private List<SystemUser> usersList= new ArrayList<SystemUser>();

    public UserController() {
        service = new UserServiceImpl();
        usersList = service.getAllUsers();
    }

    public List<SystemUser> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<SystemUser> usersList) {
        this.usersList = usersList;
    }

}
