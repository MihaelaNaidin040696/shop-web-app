package com.codecool.shop.controller;

import com.codecool.shop.model.Product;
import com.codecool.shop.service.ProductService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(urlPatterns = {"/decrease-value"}, loadOnStartup = 5)
public class DecreaseValueFromCartServlet extends HttpServlet {
    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService productService = new ProductService();

        StringBuffer buffer = new StringBuffer();
        String line;

        try {
            BufferedReader reader = req.getReader();
            while((line = reader.readLine()) != null) {
                buffer.append(line);
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        String productId = buffer.toString().split("\"")[3];
        Product product = productService.getProductDao().find(Integer.parseInt(productId));

        productService.getCartDao().removeFromCart(product);
    }
}
