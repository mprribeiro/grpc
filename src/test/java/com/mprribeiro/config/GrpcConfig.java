package com.mprribeiro.config;

import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@Configuration
@ImportAutoConfiguration({
        net.devh.boot.grpc.server.autoconfigure.GrpcClientAutoConfiguration.class,
        net.devh.boot.grpc.server.autoconfigure.GrpcClientMetricAutoConfiguration.class,
        net.devh.boot.grpc.server.autoconfigure.GrpcClientHealthAutoConfiguration.class,
        net.devh.boot.grpc.server.autoconfigure.GrpcClientSecurityAutoConfiguration.class,
        net.devh.boot.grpc.client.autoconfigure.GrpcClientTraceAutoConfiguration.class,
        net.devh.boot.grpc.client.autoconfigure.GrpcDiscoveryClientAutoConfiguration.class
})
public class GrpcConfig {
}
