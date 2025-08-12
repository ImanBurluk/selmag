package ru.iman_burlyq.selmag.repository;

import ru.iman_burlyq.selmag.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> findAll();

    Product save(Product product);

    Optional<Product> findById(int productId);
}
