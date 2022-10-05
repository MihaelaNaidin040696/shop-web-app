package com.codecool.shop.service;

import com.codecool.shop.dao.*;
import com.codecool.shop.dao.implementation.*;
import com.codecool.shop.model.Cart;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;

import java.util.List;

public class ProductService{

    private ProductDao productDao;
    private ProductCategoryDao productCategoryDao;
    private SupplierDao supplierDao;
    private OrderDao orderDao;
    private CartDao cartDao;

    public ProductService() {
        this.productDao = ProductDaoMem.getInstance();
        this.productCategoryDao = ProductCategoryDaoMem.getInstance();
        this.supplierDao = SupplierDaoMem.getInstance();
        this.orderDao = OrderDaoMem.getInstance();
        this.cartDao = CartDaoMem.getInstance();
    }

    public OrderDao getOrderDao() {
        return orderDao;
    }

    public ProductDao getProductDao() {
        return productDao;
    }

    public ProductCategoryDao getProductCategoryDao() {
        return productCategoryDao;
    }

    public SupplierDao getSupplierDao() {
        return supplierDao;
    }

    public ProductCategory getProductCategory(int categoryId){
        return productCategoryDao.find(categoryId);
    }

    public List<Product> getProductsForCategory(int categoryId){
        var category = productCategoryDao.find(categoryId);
        return productDao.getBy(category);
    }


}
