package com.lulu02.GO1_login.Controller;

import java.util.List;
import java.util.Optional;

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


import com.lulu02.GO1_login.Entity.User_registry;

import com.lulu02.GO1_login.Repository.User_registryRepo;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
@RequestMapping("/user_registry")
@RestController
public class User_registerController {
  @Autowired
  User_registryRepo user_registryRepository;


	@GetMapping("/user")

	public List<User_registry> getJPQL() {

 

		return user_registryRepository.findAll(); // select * from <TableName>;

 

	}
	@PostMapping("/user")

	public User_registry createuser(@Valid @RequestBody User_registry prod) {

		return user_registryRepository.save(prod);

	}

	@DeleteMapping("/user/{id}")
	public void deletProduct(@PathVariable("id") Integer id  ) {

 

		user_registryRepository.deleteById(id); // select * from <TableName>;


}
	@PatchMapping("/user/{id}/{newInfo}")

	public User_registry updateUser2patch (@PathVariable ("id") Integer id, @PathVariable ("newInfo") String newInfo) {

		

		//Optional<Users> user1 = ur.findById(id);

		User_registry newUser_reg = user_registryRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Inventory not exist with id :" + id));

		

		newUser_reg.setPassword(newInfo);

		

		return user_registryRepository.save(newUser_reg);

	}
	@PutMapping("/user/{id}")
	public User_registry updatePurchase(@PathVariable("id") int id, @RequestBody User_registry updatedProduct) {
	    Optional<User_registry> existingProduct = user_registryRepository.findById(id);

	    if (existingProduct.isPresent()) {
	        User_registry productToUpdate = existingProduct.get();

	        // Update the fields of the existing product with the new data
	        productToUpdate.setFirst_name(updatedProduct.getFirst_name());
	        productToUpdate.setLast_name(updatedProduct.getLast_name());
	        productToUpdate.setPhoneno(updatedProduct.getPhoneno());
	        productToUpdate.setAddress(updatedProduct.getAddress());
	        productToUpdate.setPassword(updatedProduct.getPassword());
	        productToUpdate.setConfirm_password(updatedProduct.getConfirm_password());

	        return user_registryRepository.save(productToUpdate);
	    } else {
	        // Handle the case where the product with the given ID doesn't exist
	        throw new EntityNotFoundException("User with ID " + id + " not found");
	    }
	}

	
}
