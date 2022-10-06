package com.codecool.shop.controller;

import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.service.ProductService;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/order"})
public class OrderController extends HttpServlet {

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());

        engine.process("product/order.html", context, resp.getWriter());
    }

    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService productService = new ProductService();

        String firstName = req.getParameter("first-name");
        String lastName = req.getParameter("last-name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String billingCountry = req.getParameter("billing-country");
        String billingCity = req.getParameter("billing-city");
        String billingZip = req.getParameter("billing-zip");
        String billingAddress = req.getParameter("billing-address");
        String shippingCountry = req.getParameter("shipping-country");
        String shippingCity = req.getParameter("shipping-city");
        String shippingZip = req.getParameter("shipping-zip");
        String shippingAddress = req.getParameter("shipping-address");

        productService.getOrderDao().addInformationFromUser(firstName);
        productService.getOrderDao().addInformationFromUser(lastName);
        productService.getOrderDao().addInformationFromUser(email);
        productService.getOrderDao().addInformationFromUser(phone);
        productService.getOrderDao().addInformationFromUser(billingCountry);
        productService.getOrderDao().addInformationFromUser(billingCity);
        productService.getOrderDao().addInformationFromUser(billingZip);
        productService.getOrderDao().addInformationFromUser(billingAddress);
        productService.getOrderDao().addInformationFromUser(shippingCountry);
        productService.getOrderDao().addInformationFromUser(shippingCity);
        productService.getOrderDao().addInformationFromUser(shippingZip);
        productService.getOrderDao().addInformationFromUser(shippingAddress);

        productService.getOrderDao().clearOrder();
        resp.sendRedirect("/payment");
    }
}
