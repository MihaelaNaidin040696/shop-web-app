package com.codecool.shop.service;

import com.codecool.shop.dao.CartDao;
import com.codecool.shop.dao.OrderDao;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.CartDaoMem;
import com.codecool.shop.dao.implementation.OrderDaoMem;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;

import java.util.List;

public class ProductService {

    private ProductDao productDao;
    private ProductCategoryDao productCategoryDao;
    private SupplierDao supplierDao;
    private OrderDao orderDao;
    private CartDao cartDao;

    public ProductService () {
        this.productDao = ProductDaoMem.getInstance();
        this.productCategoryDao = ProductCategoryDaoMem.getInstance();
        this.supplierDao = SupplierDaoMem.getInstance();
        this.orderDao = OrderDaoMem.getInstance();
        this.cartDao = CartDaoMem.getInstance();
    }

    public OrderDao getOrderDao () {
        return orderDao;
    }

    public void setOrderDao (OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public ProductDao getProductDao () {
        return productDao;
    }

    public void setProductDao (ProductDao productDao) {
        this.productDao = productDao;
    }

    public ProductCategoryDao getProductCategoryDao () {
        return productCategoryDao;
    }

    public void setProductCategoryDao (ProductCategoryDao productCategoryDao) {
        this.productCategoryDao = productCategoryDao;
    }

    public SupplierDao getSupplierDao () {
        return supplierDao;
    }

    public void setSupplierDao (SupplierDao supplierDao) {
        this.supplierDao = supplierDao;
    }

    public CartDao getCartDao () {
        return cartDao;
    }

    public void setCartDao (CartDao cartDao) {
        this.cartDao = cartDao;
    }

    public ProductCategory getProductCategory (int categoryId) {
        return productCategoryDao.find(categoryId);
    }

    public List<Product> getProductsForCategory (int categoryId) {
        var category = productCategoryDao.find(categoryId);
        return productDao.getBy(category);
    }


}
