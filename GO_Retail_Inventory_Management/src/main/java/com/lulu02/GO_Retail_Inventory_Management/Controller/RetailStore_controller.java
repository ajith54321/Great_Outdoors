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

import com.lulu02.GO_Retail_Inventory_Management.Entity.ProductCategory;
import com.lulu02.GO_Retail_Inventory_Management.Entity.RetailStore;
import com.lulu02.GO_Retail_Inventory_Management.Repository.ProductCategory_repo;
import com.lulu02.GO_Retail_Inventory_Management.Repository.RetailStore_repo;

@RestController
@RequestMapping("/GO6")
public class RetailStore_controller {
	@Autowired
	RetailStore_repo RetailStore_repository;


	@GetMapping("/userRetailStore")

	public List<RetailStore> getJPQL() {

 

		return RetailStore_repository.findAll(); // select * from <TableName>;

	}
	@PostMapping("/userRetailStore")

	public RetailStore createuser(@RequestBody RetailStore prod) {

		return RetailStore_repository.save(prod);

	}

	@DeleteMapping("/userRetailStore/{id}")
	public void deletProduct(@PathVariable("id") Integer id  ) {

 
		RetailStore_repository.deleteById(id); // select * from <TableName>;


}
	@PatchMapping("/userRetailStore/{id}/{newInfo}")

	public RetailStore updateUser2patch (@PathVariable ("id") Integer id, @PathVariable ("newInfo") String newInfo) {

		

		//Optional<Users> user1 = ur.findById(id);

		RetailStore newUser = RetailStore_repository.findById(id)

				.orElseThrow(() -> new RuntimeException("Inventory not exist with id :" + id));

		

		newUser.setCategoryName(newInfo);
	
		

		return RetailStore_repository.save(newUser);

	}

	@PutMapping("/userRetailStore/{id}")

 

	public RetailStore updateuser (@PathVariable ("id") Integer id, @RequestBody RetailStore UserBody) { //userbody - information comes from postman.

 

		

 

		//Optional<Users> user1 = ur.findById(id);

 

		

 

		RetailStore newUser =RetailStore_repository.findById(id) //old data

 

				.orElseThrow(() -> new RuntimeException("Inventory not exist with id :" + id));

 

		

 

		//newUser.setPassword("Ajith!123");

 

		newUser.setCategoryId(UserBody.getCategoryId()); //the new data replaces the old data.

		
		
		newUser.setCategoryName(UserBody.getCategoryName());

		newUser.setDescription(UserBody.getDescription());

		return RetailStore_repository.save(newUser);

 

	}
}
