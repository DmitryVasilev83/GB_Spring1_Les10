package ru.gb.rest.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import ru.gb.rest.dto.ManufacturerDto;
import ru.gb.rest.entity.Orders;
import ru.gb.rest.entity.Product;

import java.util.List;

@FeignClient(url = "localhost:8080/api/v1/product/orders", value = "ordersGateway")
public interface OrdersGateway {


    @GetMapping(value = "/all", produces = "application/json;charset=UTF-8")
    List<Product> findAllInOrders();

    @GetMapping(value = "/add/{productId}", produces = "application/json;charset=UTF-8")
    List<Product> addProductToOrders(Long id);

    @GetMapping(value = "/orders/delete/{productId}", produces = "application/json;charset=UTF-8")
    List<Product> deleteProductFromOrders(Long id);
}
