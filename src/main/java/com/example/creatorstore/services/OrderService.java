package com.example.creatorstore.services;

import com.example.creatorstore.dto.OrderItemRequest;
import com.example.creatorstore.dto.OrderRequest;
import com.example.creatorstore.entities.Order;
import com.example.creatorstore.entities.OrderItem;
import com.example.creatorstore.entities.Product;
import com.example.creatorstore.repositories.OrderRepository;
import com.example.creatorstore.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    @Transactional
    public Order createOrder(OrderRequest orderRequest){
        List<OrderItem> orderItems=new ArrayList<>();
        BigDecimal totalPrice=BigDecimal.ZERO;
        Order order=new Order();
        order.setCustomerName(orderRequest.getCustomerName());
        order.setCustomerEmail(orderRequest.getCustomerEmail());
        order.setStatus("Confirmed");

        for(OrderItemRequest itemRequest: orderRequest.getItems()){
            Product product=productRepository.findById(
                    itemRequest.getProductId())
                    .orElseThrow(()->new RuntimeException(
                            "Product not Found with id "+itemRequest.getProductId()
                    ));
            //Checking Product for Stock
            if(product.getStockQuantity()<itemRequest.getQuantity()){
                throw new RuntimeException("Not Enough Stock"+itemRequest.getProductId());
            }
            //Calculate Total price
            BigDecimal priceOfItem= product.getPrice()
                    .multiply(BigDecimal.valueOf(itemRequest.getQuantity()));
            totalPrice=totalPrice.add(priceOfItem);
            //Update the product table with latest stock quantity
            product.setStockQuantity(
                    product.getStockQuantity()-itemRequest.getQuantity()
            );
            productRepository.save(product);
            //Builder Pattern To make obj
            OrderItem orderItem= OrderItem.builder()
                    .order(order)
                    .product(product)
                    .quantity(itemRequest.getQuantity())
                    .priceAtPurchase(product.getPrice())
                    .build();
            orderItems.add(orderItem);
            order.setOrderItems(orderItems);
            order.setTotalPrice(totalPrice);
        }
        return orderRepository.save(order);
    }
}
