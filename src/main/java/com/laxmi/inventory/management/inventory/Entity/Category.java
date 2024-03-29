package com.laxmi.inventory.management.inventory.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "category")
public class Category {

    @Id
    @Column(name = "categoryId", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "categoryName")
    private String categoryName;

    @Column(name = "categoryDescription")
    private String categoryDescription;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
//    private Set<Product> products;

}
