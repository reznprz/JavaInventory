package com.laxmi.inventory.management.inventory.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StaffInfoRes {

    private String status;
    private String comment;
    private String sessionId;
}
