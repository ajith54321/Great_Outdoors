package com.lulu02.GO1_login;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.net.URI;
import java.net.URISyntaxException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.lulu02.GO1_login.Entity.Admin;
import com.lulu02.GO1_login.Entity.User_login;
import com.lulu02.GO1_login.Entity.User_registry;

@SpringBootTest
class Go1LoginApplicationTests {
	//@Mock
	//private AdminRepo repo;
	//private AdminController yourController ;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void testgetUser_registry() throws URISyntaxException
	{
	    RestTemplate restTemplate = new RestTemplate();
	    //String randomServerPort="8080";
	   
	    final String baseUrl = "http://localhost:9202"+ "/user_registry/user";
	    URI uri = new URI(baseUrl);
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	    //Verify request succeed
	    assertEquals(200, result.getStatusCodeValue());
	  
	}
	@Test
    public void testAddUser_registry() throws URISyntaxException 
    {
    	RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = "http://localhost:9202"+"/user_registry/user";
       URI uri = new URI(baseUrl);
       User_registry user = new User_registry(1,"keerthana15@gamail.com","keerthana","L P",5787489,"mandya","ggdtdtftfgfdt","ytyryttftdf");
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
       
        final String baseUrl = "http://localhost:9202"+"/user_registry/user/2";	     
        URI uri = new URI(baseUrl);
        User_registry userToUpdate = new User_registry(1, "keertha@gamail.com", "keerthana", "LoP", 57889, "mysore", "mygugvugre", "mygugvugre");	        restTemplate.put(uri, userToUpdate);
        // Optionally, verify that the update was successful.
    }
	@Test
	 public void testDeleteUser_register() throws URISyntaxException {
		    RestTemplate restTemplate = new RestTemplate();
		    
		      final String baseUrl = "http://localhost:9202/user_registry/user/1"; // Replace with your actual delete endpoint
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
	
	    final String baseUrl = "http://localhost:9202"+ "/user_login/user";
	    URI uri = new URI(baseUrl);
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	    //Verify request succeed
	    assertEquals(200, result.getStatusCodeValue());
	
	}
	@Test
   public void testAddUserLoginSuccess() throws URISyntaxException 
    {
   	RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = "http://localhost:9202"+"/user_login/user";
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
        final String baseUrl = "http://localhost:9202/user_login/user/1"; // Replace with your actual update endpoint
       URI uri = new URI(baseUrl);
       User_login userToUpdate = new  User_login(1, "golu", "Itinfrakjfk");
       restTemplate.put(uri, userToUpdate);
        // Optionally, verify that the update was successful.
    }
	@Test
 public void testDeleteUser_login() throws URISyntaxException {
    RestTemplate restTemplate = new RestTemplate();
	     System.out.println("Testing user deletion");
	      final String baseUrl = "http://localhost:9202/user_login/user/1"; // Replace with your actual delete endpoint
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
  
    final String baseUrl = "http://localhost:9202"+ "/admin_login/user";
    URI uri = new URI(baseUrl);
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	    //Verify request succeed
	    assertEquals(200, result.getStatusCodeValue());
	   
	}
	@Test
    public void testAddAdminSuccess() throws URISyntaxException 
    {
   	RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = "http://localhost:9202"+"/admin_login/user";
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
      final String baseUrl = "http://localhost:9202/admin_login/user/1"; // Replace with your actual delete endpoint
    URI uri = new URI(baseUrl);
     restTemplate.delete(uri);
    // Optionally, verify that the delete was successful.
 }

	

		

}
