package com.lulu02.GO_ReturnsManagement.Controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lulu02.GO_ReturnsManagement.Entity.ReturnItemEntity;
import com.lulu02.GO_ReturnsManagement.Repository.ReturnItemRepo;

@RestController
@CrossOrigin
@RequestMapping("/GO5")
public class ReturnItemController {
	@Autowired
	ReturnItemRepo ri;
	

	@GetMapping("/returnItems")
	public List<ReturnItemEntity> getJPQl(){
		return ri.findAll();
		}
	
	
	@PostMapping("/returnItems")
	public ReturnItemEntity createUser(@RequestBody ReturnItemEntity prod) {
		return ri.save(prod);
	}
	
	
	@DeleteMapping("/returnItems/{id}")
	public void delete(@PathVariable ("id") Integer id) {
		ri.deleteById(id);
	}
	
	
	@PatchMapping("/returnItems/{id}/{newInfo}")
	public ReturnItemEntity updateUser2patch (@PathVariable ("id") Integer id, @PathVariable ("newInfo") LocalDate newInfo) {
		
		//Optional<Users> user1 = ur.findById(id);
		ReturnItemEntity newUser = ri.findById(id)
				.orElseThrow(() -> new RuntimeException("Inventory not exist with id :" + id));
		
		newUser.setReturnDate(newInfo);
		
		return ri.save(newUser);
	}
	//returnId`, `productId`, `reasonId`, `returnDate`
	
	@PutMapping("/returnItems/{id}")
	public ReturnItemEntity updateUser (@PathVariable ("id") Integer id, @RequestBody ReturnItemEntity userBody) { //userbody - information comes from postman.
		
		//Optional<Users> user1 = ur.findById(id);
		
		ReturnItemEntity newUser = ri.findById(id) //old data
				.orElseThrow(() -> new RuntimeException("Inventory not exist with id :" + id));
		
	
		newUser.setProductId(userBody.getProductId()); //the new data replaces the old data.
		newUser.setReasonId(userBody.getReasonId());
		newUser.setReturnDate(userBody.getReturnDate()); 
 
		
		return ri.save(newUser);
	}
	@GetMapping("/returnReport")
	 
	public String list()
 
	{
 
		float r = (float) ri.count();
		float result = (((r) / 100)*100);
		System.out.println("Number of returns = " + r);
 
		System.out.println("Percentage of return = " + result + "%");
 
		if (result <= 10)
 
		{
 
			return "Green";
 
		}
 
		else if ((result > 10) && (result <= 20))
 
		{
 
			return "Amber";
 
		}
 
		else
 
		{
 
			return "Red";
 
		}
 
	}
 
}

