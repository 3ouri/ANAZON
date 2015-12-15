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
        FacesMessage message;
        if (addOperation) {
            productCategoryService.add(productCategory);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Operation Done Successfully", "Product Category \"" + productCategory.getTitle() + "\" is added.");
        } else {
            productCategoryService.update(productCategory);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Operation Done Successfully", "Product Category \"" + productCategory.getTitle() + "\" is updated.");
        }

        FacesContext.getCurrentInstance().addMessage(null, message);
        return goToProductCategories();
    }

    public String delete() {
        productCategoryService.deleteAll(selectedProductCategories);
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Operation Done Successfully", "Selected product categories were deleted.");
        FacesContext.getCurrentInstance().addMessage(null, message);
        return goToProductCategories();
    }

    public String goToProductCategories() {
        searchAll();
        productCategory = new ProductCategory();
        return "listProductCategories?faces-redirect=true";
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public List<ProductCategory> getProductCategoriesList() {
        return productCategoriesList;
    }

    public void setProductCategoriesList(List<ProductCategory> productCategoriesList) {
        this.productCategoriesList = productCategoriesList;
    }

    public List<ProductCategory> getSelectedProductCategories() {
        return selectedProductCategories;
    }

    public void setSelectedProductCategories(List<ProductCategory> selectedProductCategories) {
        this.selectedProductCategories = selectedProductCategories;
    }

    public boolean isAddOperation() {
        return addOperation;
    }

    public void setAddOperation(boolean addOperation) {
        this.addOperation = addOperation;
    }

}
