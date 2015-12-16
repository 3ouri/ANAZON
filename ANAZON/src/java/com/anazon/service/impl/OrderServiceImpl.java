/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anazon.service.impl;

import com.anazon.dao.OrderDAO;
import com.anazon.dao.impl.OrderDAOImpl;
import com.anazon.model.Orders;
import com.anazon.service.OrderService;
import java.util.List;

/**
 *
 * @author Abdallah
 */
public class OrderServiceImpl implements OrderService {

    private OrderDAO orderDAO;

    public OrderServiceImpl() {
        orderDAO = new OrderDAOImpl();
    }

    @Override
    public List<Orders> getAll() {
        return orderDAO.getAll();
    }

    @Override
    public Orders add(Orders order) {
        return orderDAO.add(order);
    }

    @Override
    public Orders get(long id) {
        return orderDAO.get(id);
    }

    @Override
    public Orders update(Orders order) {
        return orderDAO.update(order);
    }

    @Override
    public Orders delete(Orders order) {
        return orderDAO.delete(order);
    }

    @Override
    public void deleteAll(List<Orders> selectedOrders) {
        orderDAO.deleteAll(selectedOrders);
    }

    @Override
    public List<Orders> getAllByCustomerId(String customerId) {
        return orderDAO.getAllByCustomerId(customerId);
    }

    @Override
    public List<Orders> getAllByProductId(String productId) {
        return orderDAO.getAllByProductId(productId);
    }

}
