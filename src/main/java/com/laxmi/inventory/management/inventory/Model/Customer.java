package com.laxmi.inventory.management.inventory.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {


    private Long customerId;

    private String firstName;

    private String lastName;

    private String email;

    private String address;

    private String phoneNumber;
}
