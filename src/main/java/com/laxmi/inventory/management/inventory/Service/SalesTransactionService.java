package com.laxmi.inventory.management.inventory.Service;

import com.laxmi.inventory.management.inventory.mySqlRepository.SQLRepository;
import org.springframework.stereotype.Service;

@Service
public class SalesTransactionService {

    SQLRepository sqlRepository;

    public SalesTransactionService(SQLRepository sqlRepository){
        this.sqlRepository = sqlRepository;
    }

    public void createSalesTransaction(){

    }

}
