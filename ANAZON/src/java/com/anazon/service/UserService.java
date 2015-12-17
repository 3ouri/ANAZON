/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anazon.service;

import com.anazon.model.SystemUser;
import java.util.List;

/**
 *
 * @author Abdallah
 */
public interface UserService {

    public List<SystemUser> getAllUsers();
}
