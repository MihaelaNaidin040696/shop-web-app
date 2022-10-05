package com.codecool.shop.controller;

import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.model.Order;
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

@WebServlet(urlPatterns = {"/order"})
public class OrderController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());

        WebContext context = new WebContext(req,resp, req.getServletContext());

        engine.process("product/order.html",context,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService productService = new ProductService();

        String username = req.getParameter("name");
        String billingAddress = req.getParameter("billingAddress");
        String shippingAddress = req.getParameter("shippingAddress");

        productService.getOrderDao().addInformationFromUser(username);
        productService.getOrderDao().addInformationFromUser(billingAddress);
        productService.getOrderDao().addInformationFromUser(shippingAddress);

        System.out.println(productService.getOrderDao().getInfoUser());

        productService.getOrderDao().clearOrder();
        resp.sendRedirect("index.html");

    }
}
