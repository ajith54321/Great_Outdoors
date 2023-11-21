package com.lulu02.GO1_login.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lulu02.GO1_login.Entity.User_login;
import com.lulu02.GO1_login.Entity.User_registry;



public interface User_loginRepo extends JpaRepository<User_login, Integer> {
	@Query(value = "SELECT * FROM user_register WHERE user_name  LIKE(:letter)", nativeQuery = true)
		User_registry findByNameLike(@Param("letter") String letter);
}
