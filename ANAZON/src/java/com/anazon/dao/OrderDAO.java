/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anazon.dao;

import com.anazon.model.Orders;
import java.util.List;

/**
 *
 * @author Abdallah
 */
public interface OrderDAO {

    public List<Orders> getAll();

    public Orders add(Orders order);

    public Orders get(long id);

    public Orders update(Orders order);

    public Orders delete(Orders order);

    public void deleteAll(List<Orders> selectedOrders);
}
