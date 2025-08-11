package ru.iman_burlyq.selmag.service;

import ru.iman_burlyq.selmag.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAllProducts();

    Product createProduct(String title, String details);
}
