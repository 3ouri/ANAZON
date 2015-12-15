/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anazon.dao;

import com.anazon.model.ProductCategory;
import java.util.List;

/**
 *
 * @author Abdallah
 */
public interface ProductCategoryDAO {

    public List<ProductCategory> getAll();

    public ProductCategory add(ProductCategory productCategory);

    public ProductCategory get(long id);

    public ProductCategory update(ProductCategory productCategory);

    public ProductCategory delete(ProductCategory productCategory);

    public void deleteAll(List<ProductCategory> selectedProductCategories);
}
