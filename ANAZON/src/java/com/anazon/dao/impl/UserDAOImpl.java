/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anazon.dao.impl;

import com.anazon.dao.UserDAO;
import com.anazon.model.SystemUser;
import java.util.List;

/**
 *
 * @author Abdallah
 */
public class UserDAOImpl implements UserDAO {

    private GeneralDAOImpl generalDAOImpl;

    public UserDAOImpl() {
        generalDAOImpl = GeneralDAOImpl.getInstance();
    }

    @Override
    public List<SystemUser> getAllUsers() {
        return generalDAOImpl.getAllObjects(SystemUser.class);
    }

}
