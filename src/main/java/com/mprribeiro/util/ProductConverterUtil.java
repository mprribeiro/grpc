package com.mprribeiro.util;

import com.mprribeiro.domain.Product;
import com.mprribeiro.dto.ProductInputDTO;
import com.mprribeiro.dto.ProductOutputDTO;

public class ProductConverterUtil {

    public static ProductOutputDTO productToProductOutputDTO(Product product) {
        return new ProductOutputDTO(product.getId(),
                product.getName(), product.getPrice(), product.getQuantity_in_stock());
    }

    public static Product productInputDTOToProduct(ProductInputDTO inputDTO) {
        return new Product(null,
                inputDTO.getName(), inputDTO.getPrice(), inputDTO.getQuantity_in_stock());
    }
}
