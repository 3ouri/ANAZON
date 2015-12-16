/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anazon.dao.impl;

import com.anazon.dao.OrderDAO;
import com.anazon.model.Orders;
import java.util.List;
import org.eclipse.persistence.expressions.Expression;
import org.eclipse.persistence.expressions.ExpressionBuilder;

/**
 *
 * @author Abdallah
 */
public class OrderDAOImpl implements OrderDAO {

    private GeneralDAOImpl generalDAOImpl;

    public OrderDAOImpl() {
        generalDAOImpl = GeneralDAOImpl.getInstance();
    }

    @Override
    public List<Orders> getAll() {
        return generalDAOImpl.getAllObjects(Orders.class);
    }

    @Override
    public Orders add(Orders order) {
        return generalDAOImpl.addObject(order);
    }

    @Override
    public Orders get(long id) {
        Expression expression = new ExpressionBuilder().get("id").equal(id);
        return generalDAOImpl.getObjectByExpression(Orders.class, expression);
    }

    @Override
    public Orders update(Orders order) {
        return generalDAOImpl.updateObject(order);
    }

    @Override
    public Orders delete(Orders order) {
        return generalDAOImpl.deleteObject(order);
    }

    @Override
    public void deleteAll(List<Orders> selectedOrders) {
        generalDAOImpl.deleteAllObjects(selectedOrders);
    }

    @Override
    public List<Orders> getAllByCustomerId(String customerId) {
        Expression expression = new ExpressionBuilder().get("customreId").get("id").equal(customerId);
        return generalDAOImpl.getAllObjectsByExpression(Orders.class, expression);
    }

    @Override
    public List<Orders> getAllByProductId(String productId) {
        Expression expression = new ExpressionBuilder().get("productId").get("id").equal(productId);
        return generalDAOImpl.getAllObjectsByExpression(Orders.class, expression);
    }

}
