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
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "product_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "productName")
    private String productName;

    @Column(name = "productDescription")
    private String productDescription;

    @Column(name = "productUnitQuantityStock")
    private int productUnitQuantityStock;

    @Column(name = "productUnitPrice")
    private int productUnitPrice;

    @Column(name = "sku")
    private String sku;

    @Column(name = "image_url")
    private String image_url;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Category category;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "product")
    PurchaseOrderLineItem purchaseOrderLineItem;

}
