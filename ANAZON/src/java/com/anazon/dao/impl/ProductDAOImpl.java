/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anazon.dao.impl;

import com.anazon.dao.ProductDAO;
import com.anazon.model.Product;
import java.util.List;
import org.eclipse.persistence.expressions.Expression;
import org.eclipse.persistence.expressions.ExpressionBuilder;

/**
 *
 * @author Abdallah
 */
public class ProductDAOImpl implements ProductDAO {

    private GeneralDAOImpl generalDAOImpl;

    public ProductDAOImpl() {
        generalDAOImpl = GeneralDAOImpl.getInstance();
    }

    @Override
    public List<Product> getAll() {
        return generalDAOImpl.getAllObjects(Product.class);
    }

    @Override
    public Product add(Product product) {
        return generalDAOImpl.addObject(product);
    }

    @Override
    public Product get(long id) {
        Expression expression = new ExpressionBuilder().get("id").equal(id);
        return generalDAOImpl.getObjectByExpression(Product.class, expression);
    }

    @Override
    public Product update(Product product) {
        return generalDAOImpl.updateObject(product);
    }

    @Override
    public Product delete(Product product) {
        return generalDAOImpl.deleteObject(product);
    }

    @Override
    public void deleteAll(List<Product> selectedProducts) {
        generalDAOImpl.deleteAllObjects(selectedProducts);
    }

    @Override
    public List<Product> getProductsByCategoryId(int categoryId) {
        Expression expression = new ExpressionBuilder().get("categoryId").get("id").equal(categoryId);
        return generalDAOImpl.getAllObjectsByExpression(Product.class, expression);
    }

}
