/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anazon.dao;

import com.anazon.model.Customer;
import com.anazon.model.SystemUser;
import java.util.List;

/**
 *
 * @author Asem
 */
public interface CustomerDAO {

    public List<Customer> getAllCustomers();

    public Customer deleteCustomer(Customer customer);

    public Customer getCubyId(int id);

    public Customer addCustomer(Customer c);

    public List<SystemUser> getUsers();

    public Customer getCustByUserID(String usname);

    public Customer updateCustomer(Customer customer);
}
