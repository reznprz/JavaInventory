//
//
//package com.laxmi.inventory.management.inventory.Entity;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.hibernate.annotations.OnDelete;
//import org.hibernate.annotations.OnDeleteAction;
//
//import javax.persistence.*;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//@Entity
//@Table(name = "purchaseOrderLineItem")
//public class PurchaseOrderLineItem {
//
//    @Id
//    @Column(name = "poLineItem_id", nullable = false)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long poLineItemId;
//
//    private String createdDate;
//
//    private String itemName;
//
//    private int itemQuantity;
//
//    private float itemUnitPrice;
//
//    private float itemUnitDiscount;
//
//    private String sku;
//
//    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
//    @JoinColumn(name = "purchase_order_po_id")
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
//    PurchaseOrder purchaseOrder;
//
////    @OneToOne(fetch = FetchType.LAZY, optional = false)
////    @JoinColumn(name = "product_id", nullable = false)
//    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
//    @JoinColumn(name = "product_id")
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
//    Product product;
//
//}
