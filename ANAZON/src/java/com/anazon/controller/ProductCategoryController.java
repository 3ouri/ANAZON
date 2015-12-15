/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anazon.controller;

import com.anazon.model.ProductCategory;
import com.anazon.service.ProductCategoryService;
import com.anazon.service.impl.ProductCategoryServiceImpl;
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
@Named("productCategoryController")
public class ProductCategoryController implements Serializable {

    private ProductCategory productCategory;
    private List<ProductCategory> productCategoriesList;
    private List<ProductCategory> selectedProductCategories;
    private boolean addOperation;
    private ProductCategoryService productCategoryService;

    public ProductCategoryController() {
        productCategoryService = new ProductCategoryServiceImpl();
    }

    public String searchAll() {
        productCategoriesList = productCategoryService.getAll();
        return "";
    }

    public String goToAddEdit() {
        return "addEditProductCategory?faces-redirect=true";
    }

    public String applyAddEdit() {
        if (addOperation) {
            productCategoryService.add(productCategory);
        } else {
            productCategoryService.update(productCategory);
        }
        return goToProducts();
    }

    public String delete() {
        productCategoryService.deleteAll(selectedProductCategories);
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Operation Success", "Selected products were deleted.");
        FacesContext.getCurrentInstance().addMessage(null, message);
        return goToProducts();
    }

    public String goToProducts() {
        searchAll();
        productCategory = new ProductCategory();
        return "listProductCategories?faces-redirect=true";
    }

}
