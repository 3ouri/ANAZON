/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anazon.dao.impl;

import com.anazon.dao.ProductCategoryDAO;
import com.anazon.model.ProductCategory;
import java.util.List;
import org.eclipse.persistence.expressions.Expression;
import org.eclipse.persistence.expressions.ExpressionBuilder;

/**
 *
 * @author Abdallah
 */
public class ProductCategoryDAOImpl implements ProductCategoryDAO {

    private GeneralDAOImpl generalDAOImpl;

    public ProductCategoryDAOImpl() {
        generalDAOImpl = GeneralDAOImpl.getInstance();
    }

    @Override
    public List<ProductCategory> getAll() {
        return generalDAOImpl.getAllObjects(ProductCategory.class);
    }

    @Override
    public ProductCategory add(ProductCategory productCategory) {
        return generalDAOImpl.addObject(productCategory);
    }

    @Override
    public ProductCategory get(long id) {
        Expression expression = new ExpressionBuilder().get("id").equal(id);
        return generalDAOImpl.getObjectByExpression(ProductCategory.class, expression);
    }

    @Override
    public ProductCategory update(ProductCategory productCategory) {
        return generalDAOImpl.updateObject(productCategory);
    }

    @Override
    public ProductCategory delete(ProductCategory productCategory) {
        return generalDAOImpl.deleteObject(productCategory);
    }

    @Override
    public void deleteAll(List<ProductCategory> selectedProductCategories) {
        generalDAOImpl.deleteAllObjects(selectedProductCategories);
    }

}
