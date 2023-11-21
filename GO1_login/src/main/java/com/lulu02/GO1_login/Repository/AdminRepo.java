package com.lulu02.GO1_login.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lulu02.GO1_login.Entity.Admin;
import com.lulu02.GO1_login.Entity.User_login;

public interface AdminRepo extends JpaRepository<Admin, Integer>{

}
