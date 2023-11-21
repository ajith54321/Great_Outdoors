package com.lulu02.GO_Retail_Inventory_Management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lulu02.GO_Retail_Inventory_Management.Entity.Inventory_Item;
import com.lulu02.GO_Retail_Inventory_Management.Entity.ProductCategory;

public interface ProductCategory_repo extends JpaRepository<ProductCategory, Integer>{

}
