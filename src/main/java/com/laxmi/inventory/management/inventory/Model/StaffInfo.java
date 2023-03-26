package com.laxmi.inventory.management.inventory.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StaffInfo {

    private String firstName;

    private String lastName;

    private String sessionId;
}
