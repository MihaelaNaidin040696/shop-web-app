package com.codecool.shop.controller;

import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;
import com.codecool.shop.service.ProductService;
import com.google.gson.Gson;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@WebServlet(urlPatterns = {"/home/"})
public class FilterBySupplier extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());

        Map<String, Object> params = new HashMap<>();

        if(!req.getParameter("supplier").equals("")) {
            int supplierId = Integer.parseInt(req.getParameter("supplier"));
            Supplier supplier = supplierDataStore.find(supplierId);

            params.put("categories", productCategoryDataStore.getAll());
            params.put("products", productDataStore.getBy(supplier));
            params.put("suppliers", supplierDataStore.getAll());

        } else if(!req.getParameter("category").equals("")) {
            int categoryId = Integer.parseInt(req.getParameter("category"));
            ProductCategory productCategory = productCategoryDataStore.find(categoryId);

            params.put("categories", productCategoryDataStore.getAll());
            params.put("products", productDataStore.getBy(productCategory));
            params.put("suppliers", supplierDataStore.getAll());

        }
        context.setVariables(params);
        engine.process("product/index.html", context, resp.getWriter());
    }
}
