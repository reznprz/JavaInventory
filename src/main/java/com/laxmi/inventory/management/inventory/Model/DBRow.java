package com.laxmi.inventory.management.inventory.Model;

import java.util.HashMap;

public class DBRow extends HashMap<String, Object> {

    public DBRow() { super(); }

    public DBRow(HashMap<String, Object> properties){
        for(String key : properties.keySet()) {
            this.put(key, properties.get(key));
        }
    }
}
