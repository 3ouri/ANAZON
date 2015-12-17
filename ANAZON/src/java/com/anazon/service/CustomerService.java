/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anazon.service;

import com.anazon.model.Customer;
import com.anazon.model.User;
import java.util.List;

/**
 *
 * @author Asem
 */
public interface CustomerService {

    public List<Customer> getAllCustomers();

    public Customer addCustomer(Customer customer);

    public List<User> getUsers();

    public int login(User systemUser);

    public Customer getCustByUserID(String usname);

    public Customer updateCustomer(Customer customer);

    public Customer deleteCustomer(Customer customer);

}
