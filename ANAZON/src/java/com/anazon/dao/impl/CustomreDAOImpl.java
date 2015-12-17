/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anazon.dao.impl;

import com.anazon.dao.CustomerDAO;
import com.anazon.dao.impl.CustomreDAOImpl;
import com.anazon.model.Customer;
import com.anazon.model.SystemUser;
import com.anazon.model.UserRole;
import java.io.Serializable;
import java.util.List;


/**
 *
 * @author Asem
 */
public class CustomreDAOImpl implements CustomerDAO , Serializable{
    private static  CustomreDAOImpl customreDAOImpl;
    private GeneralDAOImpl generalDAO;
    private static UserDAOImpl userDAOImpl;
    public CustomreDAOImpl() {
        generalDAO = GeneralDAOImpl.getInstance();
    }
    
    	public static CustomreDAOImpl getInstance() {
		if (customreDAOImpl == null) 
			return new CustomreDAOImpl();
		return customreDAOImpl;
	}
    
    @Override
    public List<Customer> getAllCustomers() {
//        List<User> cuser = generalDAO.getAllObjects(SystemUser.class);
            return generalDAO.getAllObjects(Customer.class);
    }

    @Override
    public Customer deleteCustomer(Customer customer) {
        return generalDAO.deleteObject(customer);
    }

    @Override
    public Customer getCubyId(int id) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Customer addCustomer(Customer customer) {
        UserRole role = generalDAO.getUSerByWhere();
        System.out.println ( " id =  "+ role.getId() +  "  type " + role.getRoleType() );
        customer.getUserid().setRoleId(role);
        return generalDAO.addObject(customer);
    }

    @Override
    public List<SystemUser> getUsers() {
        return generalDAO.getSystemUsers();
    }

    @Override
    public Customer getCustByUserID(String usname) {
        return generalDAO.getCustByUserID(usname);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
            return generalDAO.updateObject(customer);
        }
    
}
