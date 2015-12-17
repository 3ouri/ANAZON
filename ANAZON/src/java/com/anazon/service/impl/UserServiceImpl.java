/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anazon.service.impl;

import com.anazon.dao.UserDAO;
import com.anazon.dao.impl.UserDAOImpl;
import com.anazon.model.SystemUser;
import com.anazon.service.UserService;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Abdallah
 */
public class UserServiceImpl implements UserService ,Serializable{

    private UserDAO userDAO;

    public UserServiceImpl() {
        userDAO = new UserDAOImpl();
    }

    @Override
    public List<SystemUser> getAllUsers() {
        return userDAO.getAllUsers();
    }

}
