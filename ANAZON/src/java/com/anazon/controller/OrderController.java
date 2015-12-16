/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anazon.controller;

import com.anazon.model.Customer;
import com.anazon.model.Orders;
import com.anazon.model.PaymentInfo;
import com.anazon.model.Product;
import com.anazon.service.OrderService;
import com.anazon.service.impl.OrderServiceImpl;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Abdallah
 */
@SessionScoped
@Named("orderController")
public class OrderController implements Serializable {

    private Orders order;
    private List<Orders> ordersList;
    private List<Orders> selectedOrders;
    private boolean addOperation;
    private final OrderService orderService;
    private Customer customer;
    private Product product;
    private PaymentInfo paymentInfo;
    private String message;

    public OrderController() {
        customer = new Customer();
        orderService = new OrderServiceImpl();
        paymentInfo = new PaymentInfo();
    }

    public String searchAll() {
        ordersList = orderService.getAll();
        return "";
    }

    public String goToAddEdit() {
        return "addEditOrder?faces-redirect=true";
    }

    public String applyAddEdit() {
        if (addOperation) {
            orderService.add(order);
        } else {
            orderService.update(order);
        }
        return goToOrders();
    }

    public String delete() {
        orderService.deleteAll(selectedOrders);
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Operation Done Successfully", "Selected orders were deleted.");
        FacesContext.getCurrentInstance().addMessage(null, message);
        return goToOrders();
    }

    public String goToOrders() {
        searchAll();
        order = new Orders();
        return "listOrders?faces-redirect=true";
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    public List<Orders> getSelectedOrders() {
        return selectedOrders;
    }

    public void setSelectedOrders(List<Orders> selectedOrders) {
        this.selectedOrders = selectedOrders;
    }

    public boolean isAddOperation() {
        return addOperation;
    }

    public void setAddOperation(boolean addOperation) {
        this.addOperation = addOperation;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void saveMessage() {
        FacesContext context = FacesContext.getCurrentInstance();

        context.addMessage(null, new FacesMessage("Successful", "Your message: " + message));

    }
    public String goToConfirmationPage() {
        return "confirmationPage";
    }
//    public void addOrder(){
//        order.setPaymentId(paymentInfo);
//        order.setCustomreId(customer);
//        order.setPaymentId(paymentInfo.setCreditCardNum());
//    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public PaymentInfo getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(PaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }
}