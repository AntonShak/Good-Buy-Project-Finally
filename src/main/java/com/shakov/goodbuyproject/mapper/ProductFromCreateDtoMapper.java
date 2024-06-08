package com.shakov.goodbuyproject.mapper;

import com.shakov.goodbuyproject.database.entity.Marketplace;
import com.shakov.goodbuyproject.database.entity.Product;
import com.shakov.goodbuyproject.database.entity.User;
import com.shakov.goodbuyproject.database.repository.MarketplaceRepository;
import com.shakov.goodbuyproject.database.repository.UserRepository;
import com.shakov.goodbuyproject.dto.ProductCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProductFromCreateDtoMapper implements Mapper<ProductCreateDto, Product> {

    private final MarketplaceRepository marketplaceRepository;
    private final UserRepository userRepository;

    @Override
    public Product map(ProductCreateDto object) {
        Product product = new Product();
        copyInProduct(object, product);
        return product;
    }

    @Override
    public Product map(ProductCreateDto fromObject, Product toObject) {
        copyInProduct(fromObject, toObject);
        return toObject;
    }

    private void copyInProduct(ProductCreateDto object, Product product) {
        product.setMarketplace(getMarketplace(object.getMarketplace()));
        product.setCustomer(getUser(object.getCustomer()));
        product.setImage(object.getImageLink());
        product.setPrice(object.getPrice());
        product.setVendorCode(object.getVendorCode());
        product.setName(object.getName());
        product.setDescription(object.getDescription());
        product.setDiscount(object.getDiscount());
    }


    public Marketplace getMarketplace(String name) {
        return Optional.ofNullable(name)
                .flatMap(marketplaceRepository::findByName)
                .orElseThrow();
    }

    public User getUser(String username) {
        return Optional.ofNullable(username)
                .flatMap(userRepository::findByUsername)
                .orElseThrow();
    }
}
