package com.example.creatorstore.dto;

import com.example.creatorstore.entities.OrderItem;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequest {
    @NotBlank(message = "Customer Name is Required")
    private String customerName;

    @NotBlank(message = "Customer Email is Required")
    @Email(message = "Give a Valid Email")
    private String customerEmail;
    @Valid
    @NotEmpty(message = "Order must contain atleat one item")
    private List<OrderItemRequest> items;
}
