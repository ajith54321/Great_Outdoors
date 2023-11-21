package com.lulu02.GO_Retail_Inventory_Management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class GoRetailInventoryManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoRetailInventoryManagementApplication.class, args);
	}

}
