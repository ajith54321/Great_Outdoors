package com.lulu02.GO1_login;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import com.lulu02.GO1_login.Controller.AdminController;
import com.lulu02.GO1_login.Entity.Admin;
import com.lulu02.GO1_login.Entity.User_login;
import com.lulu02.GO1_login.Entity.User_registry;
import com.lulu02.GO1_login.Repository.AdminRepo;



@SpringBootTest
class Go1LoginApplicationTests {
	@Test
	void contextLoads() {
	}
	
	@Test
	public void testgetUser_registry() throws URISyntaxException
	{
	    RestTemplate restTemplate = new RestTemplate();
	    //String randomServerPort="8080";
	   
	    final String baseUrl = "http://localhost:9202"+ "/GO1/userRegister";
	    URI uri = new URI(baseUrl);
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	    //Verify request succeed
	    assertEquals(200, result.getStatusCodeValue());
	  
	}
	@Test
    public void testAddUser_registry() throws URISyntaxException 
    {
    	RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = "http://localhost:9202"+"/GO1/userRegister";
       URI uri = new URI(baseUrl);
       User_registry user = new User_registry(3,"keerthana15@gamail.com","keerthana","L P","5787489234","mandya","ggdtdtftfgfdt","ytyryttftdf");
        HttpHeaders headers = new HttpHeaders();
       headers.set("X-COM-PERSIST", "true");      
        HttpEntity<User_registry> request = new HttpEntity<>(user, headers);
        ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
        //Verify request succeed
        assertEquals(200, result.getStatusCodeValue());
   }
	@Test
    public void testUpdateUser_registry() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
       
        final String baseUrl = "http://localhost:9202"+"/GO1/uptUserRegister/2";	     
        URI uri = new URI(baseUrl);
        User_registry userToUpdate = new User_registry(2, "keertha@gamail.com", "keerthana", "LoP", "5788923456", "mysore", "mygugvugre", "mygugvugre");	        restTemplate.put(uri, userToUpdate);
        // Optionally, verify that the update was successful.
    }
	@Test
	 public void testDeleteUser_register() throws URISyntaxException {
		    RestTemplate restTemplate = new RestTemplate();
		    
		      final String baseUrl = "http://localhost:9202/api5/userRegister/1"; // Replace with your actual delete endpoint
		     URI uri = new URI(baseUrl);
		     restTemplate.delete(uri);
		    // Optionally, verify that the delete was successful.
		 }
	//////////////////////////////////////////////////////////////////////
	@Test
	public void testgetUserLogin() throws URISyntaxException
	{
	    RestTemplate restTemplate = new RestTemplate();
	    //String randomServerPort="8080";
	
	    final String baseUrl = "http://localhost:9202"+ "/GO1/userlogin";
	    URI uri = new URI(baseUrl);
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	    //Verify request succeed
	    assertEquals(200, result.getStatusCodeValue());
	
	}
	@Test
   public void testAddUserLoginSuccess() throws URISyntaxException 
    {
   	RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = "http://localhost:9202"+"/GO1/userlogin";
        URI uri = new URI(baseUrl);
        User_login userlogin = new User_login(1,"keerthana","ggdtdtftfgfdt");
       HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");      
        HttpEntity<User_login> request = new HttpEntity<>(userlogin, headers);
       ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
       //Verify request succeed
       assertEquals(200, result.getStatusCodeValue());
   }
	@Test
    public void testUpdateUser() throws URISyntaxException {
       RestTemplate restTemplate = new RestTemplate();
        System.out.println("Testing user update");
        final String baseUrl = "http://localhost:9202/GO1/userlogin/1"; // Replace with your actual update endpoint
       URI uri = new URI(baseUrl);
       User_login userToUpdate = new  User_login(1, "golu", "Itinfrakjfk");
       restTemplate.put(uri, userToUpdate);
        // Optionally, verify that the update was successful.
    }
	@Test
 public void testDeleteUser_login() throws URISyntaxException {
    RestTemplate restTemplate = new RestTemplate();
	     System.out.println("Testing user deletion");
	      final String baseUrl = "http://localhost:9202/GO1/userlogin/1"; // Replace with your actual delete endpoint
	     URI uri = new URI(baseUrl);
	      restTemplate.delete(uri);
	    // Optionally, verify that the delete was successful.
	 }
	///////////////////////////////////////////////////////////////////////////////////
	@Test
public void testgetAdminLogin() throws URISyntaxException
	{
	    RestTemplate restTemplate = new RestTemplate();
	    //String randomServerPort="8080";
  
    final String baseUrl = "http://localhost:9202"+ "/GO1/admin";
    URI uri = new URI(baseUrl);
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	    //Verify request succeed
	    assertEquals(200, result.getStatusCodeValue());
	   
	}
	@Test
    public void testAddAdminSuccess() throws URISyntaxException 
    {
   	RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = "http://localhost:9202"+"/GO1/admin";
        URI uri = new URI(baseUrl);
        Admin adminlogin = new Admin(1,"keerthana","ggdtdtftfgfdt");
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");      
        HttpEntity<Admin> request = new HttpEntity<>(adminlogin, headers);
       ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
        //Verify request succeed
       assertEquals(200, result.getStatusCodeValue());
    }

	@Test
 public void testDeleteUser() throws URISyntaxException {
   RestTemplate restTemplate = new RestTemplate();
     System.out.println("Testing user deletion");
      final String baseUrl = "http://localhost:9202/GO1/admin/1"; // Replace with your actual delete endpoint
    URI uri = new URI(baseUrl);
     restTemplate.delete(uri);
    // Optionally, verify that the delete was successful.
 }

	

		

}