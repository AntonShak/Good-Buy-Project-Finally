package com.shakov.goodbuyproject.mapper;

import com.shakov.goodbuyproject.database.entity.Product;
import com.shakov.goodbuyproject.dto.ProductEditDto;
import org.springframework.stereotype.Component;

@Component
public class ProductFromEditDtoMapper implements Mapper<ProductEditDto, Product> {

    @Override
    public Product map(ProductEditDto object) {
        Product product = new Product();
        copyInProduct(object, product);
        return product;
    }

    @Override
    public Product map(ProductEditDto fromObject, Product toObject) {
        copyInProduct(fromObject, toObject);
        return toObject;
    }


    private void copyInProduct(ProductEditDto object, Product product) {
//        product.setId(product.getId());
//        product.setMarketplace(product.getMarketplace());
//        product.setCustomer(product.getCustomer());
//        product.setImage(product.getImage());
//        product.setPrice(product.getPrice());
        product.setName(object.getName());
        product.setDescription(object.getDescription());
        product.setDiscount(object.getDiscount());
    }
}
