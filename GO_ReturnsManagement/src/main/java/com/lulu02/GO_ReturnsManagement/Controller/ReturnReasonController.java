package com.lulu02.GO_ReturnsManagement.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lulu02.GO_ReturnsManagement.Entity.ReturnReasonEntity;
import com.lulu02.GO_ReturnsManagement.Repository.ReturnReasonRepo;

@RestController
@CrossOrigin
@RequestMapping("/GO5")
public class ReturnReasonController {
	@Autowired
	ReturnReasonRepo rrr;
	
	@GetMapping("/returnReason")
	public List<ReturnReasonEntity> getJPQl(){
		return rrr.findAll();
		}
	
	
	@PostMapping("/returnReason")
	public ReturnReasonEntity createUser(@RequestBody ReturnReasonEntity prod) {
		return rrr.save(prod);
	}
	
	
	@DeleteMapping("/returnReason/{id}")
	public void delete(@PathVariable ("id") Integer id) {
		rrr.deleteById(id);
	}
	
	
//
//	@PatchMapping("/returnReason/{id}/{newInfo}")
//	public ReturnReasonEntity updateUser2patch (@PathVariable ("id") Integer id, @PathVariable ("newInfo") String newInfo) {
//		
//		//Optional<Users> user1 = ur.findById(id);
//		ReturnReasonEntity newUser = rrr.findById(id)
//				.orElseThrow(() -> new RuntimeException("Inventory not exist with id :" + id));
//		
//		newUser.setReasonDescription(newInfo);
//
//		
//		return rrr.save(newUser);
//	}
	
	
	@PutMapping("/returnReason/{id}")
	public ReturnReasonEntity updateUser (@PathVariable ("id") Integer id, @RequestBody ReturnReasonEntity userBody) { //userbody - information comes from postman.
		
		//Optional<Users> user1 = ur.findById(id);
		
		ReturnReasonEntity newUser = rrr.findById(id) //old data
				.orElseThrow(() -> new RuntimeException("Inventory not exist with id :" + id));
		
	
		newUser.setReasonDescription(userBody.getReasonDescription()); //the new data replaces the old data.


		
		return rrr.save(newUser);
	}

}
