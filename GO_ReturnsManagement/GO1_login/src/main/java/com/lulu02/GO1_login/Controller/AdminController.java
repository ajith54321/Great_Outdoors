package com.lulu02.GO1_login.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lulu02.GO1_login.Entity.Admin;
import com.lulu02.GO1_login.Repository.AdminRepo;

import jakarta.validation.Valid;

@RequestMapping("/admin_login")

@RestController

public class AdminController {
	
			@Autowired

			AdminRepo AdminRepository;


			@GetMapping("/user")

			public List<Admin> getJPQL() {

		 

				return AdminRepository.findAll(); // select * from <TableName>;

		 

			}
			@PostMapping("/user")

			public Admin createuser(@Valid @RequestBody Admin prod) {

				return AdminRepository.save(prod);

			}

			@DeleteMapping("/user/{id}")
			public void deletProduct(@PathVariable("id") Integer id  ) {

		 

				AdminRepository.deleteById(id); // select * from <TableName>;


		}
			@PatchMapping("/user/{id}/{newInfo}")

			public Admin updateUser2patch (@PathVariable ("id") Integer id, @PathVariable ("newInfo") String newInfo) {

				

				//Optional<Users> user1 = ur.findById(id);

				Admin newUser = AdminRepository.findById(id)

						.orElseThrow(() -> new RuntimeException("Inventory not exist with id :" + id));

				
			    newUser.setPassword("Ajith!123");
				

				

				return AdminRepository.save(newUser);

			}
}
