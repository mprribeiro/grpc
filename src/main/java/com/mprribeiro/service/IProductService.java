package com.mprribeiro.service;

import com.mprribeiro.dto.ProductInputDTO;
import com.mprribeiro.dto.ProductOutputDTO;

import java.util.List;

public interface IProductService {

    ProductOutputDTO create(ProductInputDTO inputDTO);

    ProductOutputDTO findById(Long id);

    void delete(Long id);

    List<ProductOutputDTO> findAll();

}
