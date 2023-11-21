package com.lulu02.GO1_login.Controller;

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

import com.lulu02.GO1_login.Entity.User_login;
import com.lulu02.GO1_login.Repository.User_loginRepo;

import jakarta.validation.Valid;

@RequestMapping("/user_login")
@RestController

public class User_loginController {
	@Autowired
	

	User_loginRepo userRepository;


	@GetMapping("/user")

	public List<User_login> getJPQL() {

 

		return userRepository.findAll(); // select * from <TableName>;

 

	}
	@PostMapping("/user")

	public User_login createuser(@Valid @RequestBody User_login prod) {

		return userRepository.save(prod);

	}

	@DeleteMapping("/user/{id}")
	public void deletProduct(@PathVariable("id") Integer id  ) {

 

		userRepository.deleteById(id); // select * from <TableName>;


}
	@PatchMapping("/user/{id}/{newInfo}")

	public User_login updateUser2patch (@PathVariable ("id") Integer id, @PathVariable ("newInfo") String newInfo) {

		

		//Optional<Users> user1 = ur.findById(id);

		User_login newUser = userRepository.findById(id)

				.orElseThrow(() -> new RuntimeException("Inventory not exist with id :" + id));

		

		newUser.setPassword(newInfo);

		

		return userRepository.save(newUser);

	}

	@PutMapping("/user/{id}")

 

	public User_login updateuser (@PathVariable ("id") Integer id, @RequestBody User_login UserBody) { //userbody - information comes from postman.

 

		

 

		//Optional<Users> user1 = ur.findById(id);

 

		

 

		User_login newUser = userRepository.findById(id) //old data

 

				.orElseThrow(() -> new RuntimeException("Inventory not exist with id :" + id));

 

		

 

		//newUser.setPassword("Ajith!123");

 

		newUser.setId(UserBody.getId()); //the new data replaces the old data.

 

		
		newUser.setUser_Name(UserBody.getUser_Name());

		newUser.setPassword(UserBody.getPassword());
		

		return userRepository.save(newUser);

 

	}
}
