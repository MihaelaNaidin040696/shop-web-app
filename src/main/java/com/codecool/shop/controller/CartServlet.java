package com.codecool.shop.controller;

import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.model.Product;
import com.codecool.shop.service.ProductService;
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

@WebServlet(urlPatterns = {"/cart-page"})
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService productService = new ProductService();

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
        Map<String, Object> params = new HashMap<>();

        HashMap<Product, Integer> productsHashMap = productService.getCartDao().getCartProducts();

        int numberOfProducts = 0;
        for (Map.Entry<Product, Integer> entry : productsHashMap.entrySet()) {
            numberOfProducts += entry.getValue();
        }

        params.put("items", productsHashMap);
        params.put("numberOfItems", numberOfProducts);
        context.setVariables(params);
        engine.process("product/cart_page.html", context, resp.getWriter());

    }
}
