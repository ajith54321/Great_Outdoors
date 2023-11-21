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
import com.lulu02.GO_Retail_Inventory_Management.Repository.Inventory_Item_repo;


@RestController
@RequestMapping("/GO6")
public class Inventory_Item_controller {
	
		@Autowired
		Inventory_Item_repo Inventory_Item_repository;


		@GetMapping("/userIventory")

		public List<Inventory_Item> getJPQL() {

	 

			return Inventory_Item_repository.findAll(); // select * from <TableName>;

		}
		@PostMapping("/postuserIventory")

		public Inventory_Item createuser(@RequestBody Inventory_Item prod) {

			return Inventory_Item_repository.save(prod);

		}

		@DeleteMapping("/deleteuserIventory/{id}")
		public void deletProduct(@PathVariable("id") Integer id  ) {

	 

			Inventory_Item_repository.deleteById(id); // select * from <TableName>;


	}
		@PatchMapping("/patchuserIventory/{id}/{newInfo}")

		public Inventory_Item updateUser2patch (@PathVariable ("id") Integer id, @PathVariable ("newInfo") int newInfo) {

			

			//Optional<Users> user1 = ur.findById(id);

			Inventory_Item newUser = Inventory_Item_repository.findById(id)

					.orElseThrow(() -> new RuntimeException("Inventory not exist with id :" + id));

			

			newUser.setQuantity(newInfo);

			

			return Inventory_Item_repository.save(newUser);

		}

		@PutMapping("/putuserIventory/{id}")

	 

		public Inventory_Item updateuser (@PathVariable ("id") Integer id, @RequestBody Inventory_Item UserBody) { //userbody - information comes from postman.

	 

			

	 

			//Optional<Users> user1 = ur.findById(id);

	 

			

	 

			Inventory_Item newUser = Inventory_Item_repository.findById(id) //old data

	 

					.orElseThrow(() -> new RuntimeException("Inventory not exist with id :" + id));

	 

			

	 

			//newUser.setPassword("Ajith!123");

	 

			newUser.setItemId(UserBody.getItemId()); //the new data replaces the old data.

			newUser.setProductId(UserBody.getProductId());
			newUser.setStoreId(UserBody.getStoreId());
			
			newUser.setQuantity(UserBody.getQuantity());

			newUser.setPurchaseDate(UserBody.getPurchaseDate());

			return Inventory_Item_repository.save(newUser);

	 

		}
}
