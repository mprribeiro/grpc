package com.mprribeiro.resources;

import com.mprribeiro.*;
import com.mprribeiro.dto.ProductInputDTO;
import com.mprribeiro.service.IProductService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class ProductResource extends ProductServiceGrpc.ProductServiceImplBase {

    private final IProductService productService;

    public ProductResource(IProductService productService) {
        this.productService = productService;
    }

    @Override
    public void create(ProductRequest request, StreamObserver<ProductResponse> responseObserver) {
        var inputDTO = new ProductInputDTO(request.getName(), request.getPrice(), request.getQuantityInStock());
        var outputDTO = productService.create(inputDTO);

        responseObserver.onNext(ProductResponse.newBuilder()
                .setId(outputDTO.getId())
                .setName(outputDTO.getName())
                .setPrice(outputDTO.getPrice())
                .setQuantityInStock(outputDTO.getQuantity_in_stock()).build());
        responseObserver.onCompleted();
    }

    @Override
    public void findById(RequestById request, StreamObserver<ProductResponse> responseObserver) {
        var outputDTO = productService.findById(request.getId());

        responseObserver.onNext(ProductResponse.newBuilder()
                .setId(outputDTO.getId())
                .setName(outputDTO.getName())
                .setPrice(outputDTO.getPrice())
                .setQuantityInStock(outputDTO.getQuantity_in_stock()).build());
        responseObserver.onCompleted();
    }

    @Override
    public void delete(RequestById request, StreamObserver<ProductResponse> responseObserver) {
        productService.delete(request.getId());

        responseObserver.onCompleted();
    }

    @Override
    public void findAll(EmptyRequest request, StreamObserver<ProductResponseList> responseObserver) {
        var outputDTOS = productService.findAll();

        var response = outputDTOS.stream().map(outputDTO -> ProductResponse.newBuilder()
                .setId(outputDTO.getId())
                .setName(outputDTO.getName())
                .setPrice(outputDTO.getPrice())
                .setQuantityInStock(outputDTO.getQuantity_in_stock()).build()).toList();

        var responseList = ProductResponseList.newBuilder().addAllProducts(response).build();

        responseObserver.onNext(responseList);
        responseObserver.onCompleted();
    }
}
