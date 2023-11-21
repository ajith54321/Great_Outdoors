package com.lulu02.GO_Retail_Inventory_Management.Controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
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

import com.lulu02.GO_Retail_Inventory_Management.Entity.ShelfTime;
import com.lulu02.GO_Retail_Inventory_Management.Repository.ShelfTime_repo;

@RestController
@RequestMapping("/GO6")
public class ShelfTime_Controller {

	@Autowired
	ShelfTime_repo ShelfTime_repository;

	@GetMapping("/ShelfTime")

	public List<ShelfTime> getJPQL() {

		return ShelfTime_repository.findAll(); // select * from <TableName>;

	}

	@PostMapping("/ShelfTime")

	public ShelfTime createuser(@RequestBody ShelfTime prod) {

		return ShelfTime_repository.save(prod);

	}

	@DeleteMapping("/ShelfTime/{id}")
	public void deletProduct(@PathVariable("id") Integer id) {

		ShelfTime_repository.deleteById(id); // select * from <TableName>;

	}

	@PatchMapping("/ShelfTime/{id}/{newInfo}")

	public ShelfTime updateUser2patch(@PathVariable("id") Integer id, @PathVariable("newInfo") LocalDate newInfo) {

		// Optional<Users> user1 = ur.findById(id);

		ShelfTime newUser = ShelfTime_repository.findById(id)

				.orElseThrow(() -> new RuntimeException("Inventory not exist with id :" + id));

		newUser.setTimeToRetail(newInfo);

		return ShelfTime_repository.save(newUser);

	}

	@PutMapping("/ShelfTime/{id}")

	public ShelfTime updateuser(@PathVariable("id") Integer id, @RequestBody ShelfTime UserBody) { // userbody -
																									// information comes
																									// from postman.

		// Optional<Users> user1 = ur.findById(id);

		ShelfTime newUser = ShelfTime_repository.findById(id) // old data

				.orElseThrow(() -> new RuntimeException("Inventory not exist with id :" + id));

		// newUser.setPassword("Ajith!123");

		newUser.setShelfTimeId(UserBody.getShelfTimeId()); // the new data replaces the old data.

		newUser.setProductId(UserBody.getProductId());
		newUser.setStoreId(UserBody.getStoreId());
		newUser.setTimeOnShelf(UserBody.getTimeOnShelf());
		newUser.setTimeToRetail(UserBody.getTimeToRetail());
		return ShelfTime_repository.save(newUser);

	}

	@GetMapping("/shelflife/{id}")

	public String shelflife(@PathVariable("id") int id)

	{

		ShelfTime inventory = ShelfTime_repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Inventory not exist with id :" + id));

		LocalDate timeOnShelf = inventory.getTimeOnShelf();

		LocalDate timeToRetail = inventory.getTimeToRetail();

		ZoneId default_ZoneId = ZoneId.systemDefault();

		Date s_date = Date.from(timeOnShelf.atStartOfDay(default_ZoneId.systemDefault()).toInstant());

		Date e_date = Date.from(timeToRetail.atStartOfDay(default_ZoneId.systemDefault()).toInstant());

		long difference_In_Time = e_date.getTime() - s_date.getTime();

		long difference_In_Days = (difference_In_Time / (1000 * 60 * 60 * 24)) % 365;

		System.out.println(difference_In_Days);

		if (difference_In_Days <= 5)

		{

			return "Green";

		}

		else if (difference_In_Days <= 10)

		{

			return "Amber";

		}

		return "Red";

	}

}