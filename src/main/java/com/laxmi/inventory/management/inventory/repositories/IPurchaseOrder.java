package com.laxmi.inventory.management.inventory.repositories;

import com.laxmi.inventory.management.inventory.Entity.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPurchaseOrder extends JpaRepository<PurchaseOrder, Long> {
}
