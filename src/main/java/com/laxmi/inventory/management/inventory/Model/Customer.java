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

    private String phoneNumber;

    private String firstName;

    private String lastName;

    private String Address1;

    private String Address2;

    private String Address3;

    private int zipCode;

    private String city;

    private String email;
}
