package com.example.libraryonline.DTO;

import lombok.Data;

@Data
public class ShippingResponse {
    private String method;

    private String status;

    private double amount;

    private String shippingAddress;

    private String receiverPhone;
}
