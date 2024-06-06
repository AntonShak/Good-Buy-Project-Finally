package com.shakov.goodbuyproject.http.controller;

import com.shakov.goodbuyproject.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public String findAllProductsByUsername(Model model,
                                            @AuthenticationPrincipal UserDetails userDetails) {

        String username = userDetails.getUsername();
        model.addAttribute("products", productService.findAllProductsByUsername(username));
        return "product/products";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") long id, Model model) {

        return productService.findById(id)
                .map(product -> {
                    model.addAttribute("product", product);
                    return "product/product";
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}

