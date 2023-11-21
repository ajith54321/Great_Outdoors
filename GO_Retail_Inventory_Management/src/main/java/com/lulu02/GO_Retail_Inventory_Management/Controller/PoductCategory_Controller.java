package com.lulu02.GO_Retail_Inventory_Management.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lulu02.GO_Retail_Inventory_Management.Entity.Inventory_Item;
import com.lulu02.GO_Retail_Inventory_Management.Entity.ProductCategory;
import com.lulu02.GO_Retail_Inventory_Management.Repository.Inventory_Item_repo;
import com.lulu02.GO_Retail_Inventory_Management.Repository.ProductCategory_repo;


@RestController
@RequestMapping("/GO6")
public class PoductCategory_Controller {
	@Autowired
	ProductCategory_repo ProductCategory_repository;


	@GetMapping("/user")

	public List<ProductCategory> getJPQL() {

 

		return ProductCategory_repository.findAll(); // select * from <TableName>;

	}
	@PostMapping("/user")

	public ProductCategory createuser(@RequestBody ProductCategory prod) {

		return ProductCategory_repository.save(prod);

	}

	@DeleteMapping("/user/{id}")
	public void deletProduct(@PathVariable("id") Integer id  ) {

 
		ProductCategory_repository.deleteById(id); // select * from <TableName>;


}
	@PatchMapping("/user/{id}/{newInfo}")

	public ProductCategory updateUser2patch (@PathVariable ("id") Integer id, @PathVariable ("newInfo") String newInfo) {

		

		//Optional<Users> user1 = ur.findById(id);

		ProductCategory newUser = ProductCategory_repository.findById(id)

				.orElseThrow(() -> new RuntimeException("Inventory not exist with id :" + id));

		

		newUser.setStoreName(newInfo);
		
		

		return ProductCategory_repository.save(newUser);

	}

	@PutMapping("/user/{id}")

 

	public ProductCategory updateuser (@PathVariable ("id") Integer id, @RequestBody ProductCategory UserBody) { //userbody - information comes from postman.

 

		

 

		//Optional<Users> user1 = ur.findById(id);

 

		

 

		ProductCategory newUser =ProductCategory_repository.findById(id) //old data

 

				.orElseThrow(() -> new RuntimeException("Inventory not exist with id :" + id));

 

		

 

		//newUser.setPassword("Ajith!123");

 

		newUser.setStoreId(UserBody.getStoreId()); //the new data replaces the old data.

		
		
		newUser.setStoreName(UserBody.getStoreName());

		newUser.setAddress(UserBody.getAddress());

		return ProductCategory_repository.save(newUser);

 

	}
}
