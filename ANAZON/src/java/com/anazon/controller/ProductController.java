/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anazon.controller;

import com.anazon.model.Product;
import com.anazon.model.ProductCategory;
import com.anazon.service.ProductCategoryService;
import com.anazon.service.ProductService;
import com.anazon.service.impl.ProductCategoryServiceImpl;
import com.anazon.service.impl.ProductServiceImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Named;

/**
 *
 * @author Abdallah
 */
@SessionScoped
@Named("productController")
public class ProductController implements Serializable {

    private Product product;
    private List<Product> productsList;
    private List<Product> selectedProducts;
    private boolean addOperation;
    private ProductService productService;
    private List<SelectItem> productCategoryListAsSelectItem;
    private long selectedProductCategoryId;
    private ProductCategoryService productCategoryService;

    public ProductController() {
        productService = new ProductServiceImpl();
        productCategoryService = new ProductCategoryServiceImpl();

    }

    public String searchAll() {
        productsList = productService.getAll();
        return "";
    }

    public String goToAddEdit() {
        return "addEditProduct?faces-redirect=true";
    }

    public String applyAddEdit() {
        if (addOperation) {
            ProductCategory productCategory = productCategoryService.get(selectedProductCategoryId);
            product.setCategoryId(productCategory);
            productService.add(product);
        } else {
            productService.update(product);
        }
        return goToProducts();
    }

    public String delete() {
        productService.deleteAll(selectedProducts);
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Operation Success", "Selected products were deleted.");
        FacesContext.getCurrentInstance().addMessage(null, message);
        return goToProducts();
    }

    public String goToProducts() {
        searchAll();
        product = new Product();
        return "listProducts?faces-redirect=true";
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Product> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Product> productsList) {
        this.productsList = productsList;
    }

    public List<Product> getSelectedProducts() {
        return selectedProducts;
    }

    public void setSelectedProducts(List<Product> selectedProducts) {
        this.selectedProducts = selectedProducts;
    }

    public boolean isAddOperation() {
        return addOperation;
    }

    public void setAddOperation(boolean addOperation) {
        this.addOperation = addOperation;
    }

    public List<SelectItem> getProductCategoryListAsSelectItem() {
        productCategoryListAsSelectItem = new ArrayList<>();
        productCategoryService.getAll().stream().map((productCategory) -> new SelectItem(productCategory.getId(), productCategory.getTitle())).forEach((item) -> {
            productCategoryListAsSelectItem.add(item);
        });
        return productCategoryListAsSelectItem;
    }

    public void setProductCategoryListAsSelectItem(List<SelectItem> productCategoryListAsSelectItem) {
        this.productCategoryListAsSelectItem = productCategoryListAsSelectItem;
    }

    public long getSelectedProductCategoryId() {
        return selectedProductCategoryId;
    }

    public void setSelectedProductCategoryId(long selectedProductCategoryId) {
        this.selectedProductCategoryId = selectedProductCategoryId;
    }
}
