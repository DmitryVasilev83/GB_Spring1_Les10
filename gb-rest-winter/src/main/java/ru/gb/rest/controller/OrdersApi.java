package ru.gb.rest.controller;

import ru.gb.rest.dto.ManufacturerDto;
import ru.gb.rest.entity.Orders;
import ru.gb.rest.entity.Product;

import java.util.List;

public interface OrdersApi {

    List<Product> findAllInOrders();
    List<Product> addProductToOrders(Long id);
    List<Product> deleteProductFromOrders(Long id);

}
