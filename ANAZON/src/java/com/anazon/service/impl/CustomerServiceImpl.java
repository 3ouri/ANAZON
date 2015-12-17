/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anazon.service.impl;

import com.anazon.common.Util;
import com.anazon.dao.CustomerDAO;
import com.anazon.dao.impl.CustomreDAOImpl;
import com.anazon.model.Customer;
import com.anazon.model.SystemUser;
import com.anazon.service.CustomerService;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Asem
 */
public class CustomerServiceImpl implements CustomerService {

    CustomreDAOImpl customreDAOImpl = CustomreDAOImpl.getInstance();
    String uname;

    @Override
    public List<Customer> getAllCustomers() {
        return customreDAOImpl.getAllCustomers();
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customreDAOImpl.addCustomer(customer);
    }

    @Override
    public List<SystemUser> getUsers() {
        return customreDAOImpl.getUsers();
    }

    @Override
    public int  login(SystemUser u) {
        List<SystemUser> systemUsers = customreDAOImpl.getUsers();

        for (SystemUser sys : systemUsers) {
            if (u.getUsername().equals(sys.getUsername())
                    && u.getPassword().equals(sys.getPassword()))
            {
                if((sys.getStatus().equals("ACTIVE")))
                    return 1;
                else 
                    return 2;
            }
        }
        return 0;
    }

    @Override
    public Customer getCustByUserID(String usname) {
        return customreDAOImpl.getCustByUserID(usname);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customreDAOImpl.updateCustomer(customer);
    }

    @Override
    public Customer deleteCustomer(Customer customer) {
        return customreDAOImpl.deleteCustomer(customer);
    }

}
