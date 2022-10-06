package com.codecool.shop.config;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.math.BigDecimal;

@WebListener
public class Initializer implements ServletContextListener {

    @Override
    public void contextInitialized (ServletContextEvent sce) {
        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();

        //setting up a new supplier
        Supplier lenovo = new Supplier("Lenovo");
        supplierDataStore.add(lenovo);

        Supplier asus = new Supplier("Asus");
        supplierDataStore.add(asus);

        Supplier apple = new Supplier("Apple");
        supplierDataStore.add(apple);

        Supplier samsung = new Supplier("Samsung");
        supplierDataStore.add(samsung);

        //setting up a new product category
        ProductCategory laptop = new ProductCategory("Laptop", "Computer", "");
        productCategoryDataStore.add(laptop);

        ProductCategory smartphone = new ProductCategory("Smartphone", "Phone", "");
        productCategoryDataStore.add(smartphone);

        ProductCategory tablet = new ProductCategory("Tablet", "Phone", "");
        productCategoryDataStore.add(tablet);

        //setting up products and printing it
        productDataStore.add(new Product("Lenovo Yoga Slim 7",
                new BigDecimal("600"), "EUR", "Ultra portable laptop with AMD Ryzen 7 5800U processor, 13.3\", 16GB, Windows 11 Home, Light Silver",
                laptop, lenovo));

        productDataStore.add(new Product("Lenovo IdeaPad Gaming 3",
                new BigDecimal("750"), "EUR", "Lenovo laptop with AMD Ryzen™ 5 5600H processor up to 4.20 GHz, 15.6\", Full HD, 16GB",
                laptop, lenovo));

        productDataStore.add(new Product("Apple iPhone 14 Pro",
                new BigDecimal("900"), "EUR", "Mobile phone Apple iPhone 14 Pro, 128GB, 5G, 48MP main camera, crash detection, Deep Purple",
                smartphone, apple));

        productDataStore.add(new Product("Samsung Galaxy S22",
                new BigDecimal("490"), "EUR", "Mobile phone Samsung Galaxy S22, Dual SIM, 256GB, 8GB RAM, 5G, Phantom Black",
                smartphone, samsung));

        productDataStore.add(new Product("Samsung Galaxy Z Flip4",
                new BigDecimal("370"), "EUR", "Phone Samsung Z Flip4 5G, 256GB, 8GB RAM, Dual SIM, Bora Purple",
                smartphone, samsung));

        productDataStore.add(new Product("Asus TUF F15",
                new BigDecimal("840"), "EUR", "Intel Core i7-11800H up to 4.6GHz, 15.6\" Full HD, 8GB, Eclipse Gray",
                laptop, asus));

        productDataStore.add(new Product("Lenovo P11 Plus",
                new BigDecimal("200"), "EUR", "Lenovo P11 Plus tablet, 11\", 6GB, 128GB, Wi-Fi + 4G, Slate Gray",
                tablet, lenovo));

        productDataStore.add(new Product("APPLE iPad 9",
                new BigDecimal("350"), "EUR", "Tablet Apple iPad 9 (2021), 10.2\", 64GB, Wi-Fi, Space Gray",
                tablet, apple));

        productDataStore.add(new Product("Samsung Galaxy Tab S8",
                new BigDecimal("180"), "EUR", "Tablet Samsung Galaxy Tab S8, 11\", 128GB, 8GB RAM, Wi-Fi + 5G, Pink Gold",
                tablet, samsung));

    }
}
