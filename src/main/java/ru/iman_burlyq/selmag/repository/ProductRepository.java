package ru.iman_burlyq.selmag.repository;

import ru.iman_burlyq.selmag.entity.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
}
