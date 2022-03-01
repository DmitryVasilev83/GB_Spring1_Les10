package ru.gb.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.rest.dto.ManufacturerDto;
import ru.gb.rest.entity.Orders;
import ru.gb.rest.entity.Product;
import ru.gb.rest.service.OrdersGateway;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/orders")
public class OrdersController implements OrdersApi{

//    private final OrdersApi ordersApi;
    private final OrdersGateway ordersGateway;


    @Override
    @GetMapping("/all")
    public List<Product> findAllInOrders(){
        return  ordersGateway.findAllInOrders();
    }

    @Override
    @GetMapping("/add/{productId}")
    public List<Product> addProductToOrders(Long id){
        return ordersGateway.addProductToOrders(id);
    }

    @Override
    @GetMapping("/orders/delete/{productId}")
    public List<Product> deleteProductFromOrders(Long id){
        return ordersGateway.deleteProductFromOrders(id);
    }


}
