/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anazon.service.impl;

import com.anazon.dao.ProductCategoryDAO;
import com.anazon.dao.impl.ProductCategoryDAOImpl;
import com.anazon.model.ProductCategory;
import com.anazon.service.ProductCategoryService;
import java.util.List;

/**
 *
 * @author Abdallah
 */
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private ProductCategoryDAO productCategoryDAO;

    public ProductCategoryServiceImpl() {
        productCategoryDAO = new ProductCategoryDAOImpl();
    }

    @Override
    public List<ProductCategory> getAll() {
        return productCategoryDAO.getAll();
    }

    @Override
    public ProductCategory add(ProductCategory productCategory) {
        return productCategoryDAO.add(productCategory);
    }

    @Override
    public ProductCategory get(long id) {
        return productCategoryDAO.get(id);
    }

    @Override
    public ProductCategory update(ProductCategory productCategory) {
        return productCategoryDAO.update(productCategory);
    }

    @Override
    public ProductCategory delete(ProductCategory productCategory) {
        return productCategoryDAO.delete(productCategory);
    }

    @Override
    public void deleteAll(List<ProductCategory> selectedProductCategories) {
        productCategoryDAO.deleteAll(selectedProductCategories);
    }

}
