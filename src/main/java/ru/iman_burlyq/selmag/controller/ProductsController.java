package ru.iman_burlyq.selmag.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.iman_burlyq.selmag.controller.payload.NewProductPayload;
import ru.iman_burlyq.selmag.entity.Product;
import ru.iman_burlyq.selmag.service.ProductService;

@Controller
@RequiredArgsConstructor
@RequestMapping("catalogue/products")
public class ProductsController {
    private final ProductService productService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String getProductsList(Model model) {
        model.addAttribute("products", this.productService.findAllProducts());
        return "catalogue/products/list";
    }

    @GetMapping("create")
    public String getNewProductPage() {
        return "catalogue/products/new_product";
    }

    @PostMapping("create")
    public String createProduct(NewProductPayload payload) {
        Product product = this.productService.createProduct(payload.title(), payload.details());
        return "redirect:/catalogue/products/list";
    }
    //Todo 42:13
    @GetMapping("/{productId:\\d+}")
    public String getProduct(@PathVariable("productId") int productId, Model model) {
        model.addAttribute("product",this.productService.findProduct(productId).orElseThrow());
        return "catalogue/products/product";
    }
    //TODO 48:36
}
