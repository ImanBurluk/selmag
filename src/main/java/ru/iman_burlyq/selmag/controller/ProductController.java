package ru.iman_burlyq.selmag.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.iman_burlyq.selmag.entity.Product;
import ru.iman_burlyq.selmag.service.ProductService;

@Controller
@RequiredArgsConstructor
@RequestMapping("{productId:\\d+}")
public class ProductController {

    private final ProductService productService;

    @ModelAttribute("product")
    public Product product(@PathVariable("productId") int productId) {
        return this.productService.findProduct(productId).orElseThrow();
    }

    //Todo 42:13
    @GetMapping
    public String getProduct(@PathVariable("productId") int productId, Model model) {
        return "catalogue/products/product";
    }
    //TODO 48:36
    @GetMapping("edit")
    public String getProductEditPage(@PathVariable("productId") int productId, Model model) {
        return "catalogue/products/edit";
    }
}
