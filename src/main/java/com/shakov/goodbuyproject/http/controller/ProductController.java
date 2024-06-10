package com.shakov.goodbuyproject.http.controller;

import com.shakov.goodbuyproject.dto.ProductCreateDto;
import com.shakov.goodbuyproject.dto.ProductEditDto;
import com.shakov.goodbuyproject.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private static final String ONLINER = "Onliner";
    private static final String WILDBERRIES = "Wildberries";
    private static final String OZON = "Ozon";


    private final ProductService productService;
    private final MarketplaceService marketplaceService;
    private final OnlinerScrapperService onlinerScrapperService;
    private final WildberriesScrapperService wildberriesScrapperService;
    private final OzonScrapperService ozonScrapperService;


    @GetMapping("/products")
    public String findAllProductsByUsername(Model model,
                                            @AuthenticationPrincipal UserDetails userDetails) {

        String username = userDetails.getUsername();
        model.addAttribute("products", productService.findAllProductsByUsername(username));
        return "product/products";
    }

    @GetMapping("/products/{id}")
    public String findById(@PathVariable("id") long id, Model model) {

        return productService.findById(id)
                .map(product -> {
                    model.addAttribute("product", product);
                    return "product/product";
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/products/{id}/update")
    public String update(@PathVariable("id") Long id, @ModelAttribute @Validated ProductEditDto productEditDto) {

        return productService.update(id, productEditDto)
                .map(it -> "redirect:/products/{id}")
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/products/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        if (!productService.delete(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return "redirect:/products";
    }

    @GetMapping("/products/add")
    public String newProduct(Model model, @ModelAttribute ProductCreateDto productCreateDto) {
        model.addAttribute("productCreateDto", productCreateDto);
        model.addAttribute("marketplaces", marketplaceService.findAll());
        return "product/newProduct";
    }

    @PostMapping("/products/add")
    public String create(@ModelAttribute ProductCreateDto productCreateDto,
                                  @AuthenticationPrincipal UserDetails userDetails) {

        productCreateDto.setCustomer(userDetails.getUsername());
        if(productCreateDto.getMarketplace().equals(WILDBERRIES)){
            wildberriesScrapperService.finishCreateProductCreateDto(productCreateDto.getLink(),
                    productCreateDto);
            productService.create(productCreateDto);
        }

        if(productCreateDto.getMarketplace().equals(ONLINER)) {
            onlinerScrapperService.finishCreateProductCreateDto(productCreateDto.getLink(),
                    productCreateDto);
            productService.create(productCreateDto);
        }

        if(productCreateDto.getMarketplace().equals(OZON)) {
            ozonScrapperService.finishCreateProductCreateDto(productCreateDto.getLink(),
                    productCreateDto);
            productService.create(productCreateDto);
        }

        return "redirect:/products";
    }
}

