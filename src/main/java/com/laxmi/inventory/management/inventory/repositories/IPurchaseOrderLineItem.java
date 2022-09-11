package com.laxmi.inventory.management.inventory.repositories;

import com.laxmi.inventory.management.inventory.Entity.PurchaseOrderLineItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPurchaseOrderLineItem extends JpaRepository<PurchaseOrderLineItem, Long> {
}
