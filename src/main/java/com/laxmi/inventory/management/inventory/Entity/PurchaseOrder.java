package com.laxmi.inventory.management.inventory.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "purchaseOrder")
public class PurchaseOrder {

    @Id
    @Column(name = "purchase_order_po_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private float totalPrice;

    private float tax;

    private float itemDiscount;

    private String status;

    private float subTotalPrice;

    private String type;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "staff_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Staff staff;

}
