package com.mprribeiro.service.impl;

import com.mprribeiro.dto.ProductInputDTO;
import com.mprribeiro.dto.ProductOutputDTO;
import com.mprribeiro.repository.ProductRepository;
import com.mprribeiro.service.IProductService;
import com.mprribeiro.util.ProductConverterUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductOutputDTO create(ProductInputDTO inputDTO) {
        var product = ProductConverterUtil.productInputDTOToProduct(inputDTO);
        return ProductConverterUtil.productToProductOutputDTO(repository.save(product));
    }

    @Override
    public ProductOutputDTO findById(Long id) {
        return ProductConverterUtil.productToProductOutputDTO(repository.findById(id).get());
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<ProductOutputDTO> findAll() {
        return repository.findAll().stream().map(ProductConverterUtil::productToProductOutputDTO).toList();
    }
}
