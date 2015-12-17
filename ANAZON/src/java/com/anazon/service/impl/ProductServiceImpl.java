/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anazon.service.impl;

import com.anazon.dao.ProductDAO;
import com.anazon.dao.impl.ProductDAOImpl;
import com.anazon.model.Product;
import com.anazon.service.ProductService;
import java.util.List;

/**
 *
 * @author Abdallah
 */
public class ProductServiceImpl implements ProductService {

    private ProductDAO productDAO;

    public ProductServiceImpl() {
        productDAO = new ProductDAOImpl();
    }

    @Override
    public List<Product> getAll() {
        return productDAO.getAll();
    }

    @Override
    public Product add(Product product) {
        return productDAO.add(product);
    }

    @Override
    public Product get(long id) {
        return productDAO.get(id);
    }

    @Override
    public Product update(Product product) {
        return productDAO.update(product);
    }

    @Override
    public Product delete(Product product) {
        return productDAO.delete(product);
    }

    @Override
    public void deleteAll(List<Product> selectedProducts) {
        productDAO.deleteAll(selectedProducts);
    }

    @Override
    public List<Product> getProductsByCategoryId(int categoryId) {
        return productDAO.getProductsByCategoryId(categoryId);
    }

}
