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

@WebServlet(urlPatterns = {"/payment"})
public class PaymentServlet extends HttpServlet {

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());

        engine.process("product/payment.html", context, resp.getWriter());
    }

    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService productService = new ProductService();

        String cardHolder = req.getParameter("card-holder");
        String cardNumber = req.getParameter("card-number");
        String expirationMonth = req.getParameter("exp-month");
        String expirationYear = req.getParameter("exp-year");
        String cvvCode = req.getParameter("cvv-code");

        productService.getOrderDao().addInformationFromUser(cardHolder);
        productService.getOrderDao().addInformationFromUser(cardNumber);
        productService.getOrderDao().addInformationFromUser(expirationMonth);
        productService.getOrderDao().addInformationFromUser(expirationYear);
        productService.getOrderDao().addInformationFromUser(cvvCode);

        resp.sendRedirect("/confirmation");
    }
}
