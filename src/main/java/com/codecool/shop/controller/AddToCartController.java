package com.codecool.shop.controller;


import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.implementation.CartDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.model.LineItem;
import com.codecool.shop.model.Product;
import com.codecool.shop.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/add-to-cart"},loadOnStartup = 4)
public class AddToCartController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService productService = new ProductService();
        CartDaoMem cartDaoMem = CartDaoMem.getInstance();

        List<LineItem> listOfItems = cartDaoMem.getItems();

        ProductDao productDao = ProductDaoMem.getInstance();
        List<Product> listOfProducts = productDao.getAll();

        StringBuffer buffer = new StringBuffer();
        String line;
        try {
            BufferedReader reader = req.getReader();
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        String productId = buffer.toString().split("\"")[3];
        String productQuantity = buffer.toString().split("\"")[6].split(":")[1].split("}")[0];

        for (Product product : listOfProducts) {
            if(product.getId()==Integer.parseInt(productId)){
                LineItem lineItem = new LineItem(product,1);
                listOfItems.add(lineItem);

            } //TODO verificare daca exista sau nu in cart si incrementare quantity

        }
        System.out.println(listOfItems);
    }
}
