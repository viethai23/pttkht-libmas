package com.example.libraryonline.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class PaymentResponse {
    private double amount;

    private Date paymentDate;

    private String paymentMethod;

    private String status;
}
