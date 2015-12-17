/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anazon.controller;

import com.anazon.common.Util;
import com.anazon.model.Customer;
import com.anazon.model.SystemUser;
import com.anazon.model.UserRole;
import com.anazon.service.CustomerService;
import com.anazon.service.UserService;
import com.anazon.service.impl.CustomerServiceImpl;
import com.anazon.service.impl.UserServiceImpl;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import javax.servlet.http.HttpSession;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Asem
 */
@SessionScoped
@Named("customercontroller")
public class CustomerController implements Serializable {

    private CustomerService customerService;
    private UserService userService;
    private List<Customer> clist;
    private Customer cust;
    private SystemUser user;
    private UserRole userRole;
    private String uname;
    private int isloged;

    public CustomerController() {
        customerService = new CustomerServiceImpl();
        userService = new UserServiceImpl();
        clist = new ArrayList<Customer>();
        user = new SystemUser();
        userRole = new UserRole();
        cust = new Customer();
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public List<Customer> getClist() {
        return clist;
    }

    public SystemUser getUser() {
        return user;
    }

    public void setUser(SystemUser user) {
        this.user = user;
    }

    public void setClist(List<Customer> clist) {
        this.clist = clist;
    }

    public Customer getCust() {
        return cust;
    }

    public void setCust(Customer cust) {
        this.cust = cust;
    }

    public List<Customer> getCustomList() {
        clist = customerService.getAllCustomers();
        return clist;
    }

    public String addCustomer(Customer customer, SystemUser u) {
        user.setStatus("ACTIVE");
        user.setRoleId(userRole);
        customer.setUserid(user);
        customerService.addCustomer(customer);
        return "sucess";
    }

    public String login(SystemUser u) {
        isloged = customerService.login(user);
        switch (isloged) {
            case 1:
                cust = customerService.getCustByUserID(user.getUsername());
                user.setStatus("ACTIVE");
                System.out.println("com.anazon.controller.CustomerController.login()  status " + user.getStatus());
                return "sucess";
            case 2:
                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                "Your Account has been deactivated",
                                "y!"));
                return "";
            default:
                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN,
                                "Invalid Login! Username or Password dosn't exist",
                                "Please Try Again!"));
                return "";
        }
    }

    public String logout() {
//        isloged = false;
        HttpSession session = Util.getSession();
        session.invalidate();
        return "index";
    }

    public String updateCustomer(Customer c ) {
//      System.out.println("com.anazon.controller.CustomerController.updateCustomer() + stats = " +  c.getUserid().getId());
//      c.setUserid(systemUser);
        System.out.println("com.anazon.controller.CustomerController.updateCustomer() + username "  + user.getUsername());
//        customerService.updateCustomer(c);
        return "";
    }

    public String deleteCustomer() {
        customerService.deleteCustomer(cust);
        return "";
    }
    public void setUserStatus()
    {
      user.setStatus("ACTIVE");
    }
    
        public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Customer Edited", ((Customer) event.getObject()).getFirstname());
            System.out.println("com.anazon.controller.CustomerController.onRowEdit() id = " + cust.getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Customer) event.getObject()).getFirstname());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    
//    public String login(ActionEvent event) {
//        RequestContext context = RequestContext.getCurrentInstance();
//        FacesMessage message = null;
//        boolean loggedIn = false;
//
//        if (user.getUsername() != null && user.getUsername().equals("admin") && user.getPassword() != null && user.getPassword().equals("admin")) {
//            loggedIn = true;
//            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", user.getUsername());
//            return "x";
//        } else {
//            loggedIn = false;
//            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
//            return "";
//        }
//
////        FacesContext.getCurrentInstance().addMessage(null, message);
////        context.addCallbackParam("loggedIn", loggedIn);
//    }
}
