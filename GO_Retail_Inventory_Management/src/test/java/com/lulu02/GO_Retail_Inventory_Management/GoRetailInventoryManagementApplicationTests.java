package com.lulu02.GO_Retail_Inventory_Management;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.lulu02.GO_Retail_Inventory_Management.Entity.Inventory_Item;
import com.lulu02.GO_Retail_Inventory_Management.Entity.ProductCategory;
import com.lulu02.GO_Retail_Inventory_Management.Entity.RetailStore;
import com.lulu02.GO_Retail_Inventory_Management.Entity.ShelfTime;




@SpringBootTest
class GoRetailInventoryManagementApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testgetInventory_Item() throws URISyntaxException
	{
	    RestTemplate restTemplate = new RestTemplate();
	    //String randomServerPort="8080";
	   
	    final String baseUrl = "http://localhost:9205"+ "/GO6/userIventory";
	    URI uri = new URI(baseUrl);
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	    //Verify request succeed
	    assertEquals(200, result.getStatusCodeValue());
	  
	}
	@SuppressWarnings("deprecation")
	@Test
    public void testaddInventory_Item() throws URISyntaxException 
    {
    	RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = "http://localhost:9205"+"/GO6/postuserIventory";
       URI uri = new URI(baseUrl);
       Inventory_Item user = new Inventory_Item(1,2,3,3,LocalDate.of(2023, 4, 23));
        HttpHeaders headers = new HttpHeaders();
       headers.set("X-COM-PERSIST", "true");      
        HttpEntity<Inventory_Item> request = new HttpEntity<>(user, headers);
        ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
        //Verify request succeed
        assertEquals(200, result.getStatusCodeValue());
   }
	@Test
    public void testUpdateInventory_Item() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
       
        final String baseUrl = "http://localhost:9205"+"/GO6/putuserIventory/1";	     
        URI uri = new URI(baseUrl);
        Inventory_Item userToUpdate = new Inventory_Item(1,5,4,2,LocalDate.of(2025, 4, 23));	      
        restTemplate.put(uri, userToUpdate);
        // Optionally, verify that the update was successful.
    }
	@Test
	 public void testDeleteInventory_Item() throws URISyntaxException {
		    RestTemplate restTemplate = new RestTemplate();
		    
		      final String baseUrl = "http://localhost:9205/GO6/deleteuserIventory/1"; // Replace with your actual delete endpoint
		     URI uri = new URI(baseUrl);
		     restTemplate.delete(uri);
		    // Optionally, verify that the delete was successful.
		 }
///////////////////////////////////////////////////////////////////////////////////////////////
	@Test
	public void testgetProductCategory() throws URISyntaxException
	{
	    RestTemplate restTemplate = new RestTemplate();
	    //String randomServerPort="8080";
	   
	    final String baseUrl = "http://localhost:9205"+ "/GO6/user";
	    URI uri = new URI(baseUrl);
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	    //Verify request succeed
	    assertEquals(200, result.getStatusCodeValue());
	  
	}
	@Test
    public void testaddProductCategory() throws URISyntaxException 
    {
    	RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = "http://localhost:9205"+"/GO6/user";
       URI uri = new URI(baseUrl);
       ProductCategory user = new ProductCategory(1,"nayana","mandya");
        HttpHeaders headers = new HttpHeaders();
       headers.set("X-COM-PERSIST", "true");      
        HttpEntity<ProductCategory> request = new HttpEntity<>(user, headers);
        ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
        //Verify request succeed
        assertEquals(200, result.getStatusCodeValue());
   }
	@Test
    public void testUpdateProductCategory() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
       
        final String baseUrl = "http://localhost:9205"+"/GO6/user/1";	     
        URI uri = new URI(baseUrl);
        ProductCategory userToUpdate = new ProductCategory(1,"appu","patna");	      
        restTemplate.put(uri, userToUpdate);
        // Optionally, verify that the update was successful.
    }
	@Test
	 public void testDeleteProductCategory() throws URISyntaxException {
		    RestTemplate restTemplate = new RestTemplate();
		    
		      final String baseUrl = "http://localhost:9205/GO6/user/1"; // Replace with your actual delete endpoint
		     URI uri = new URI(baseUrl);
		     restTemplate.delete(uri);
		    // Optionally, verify that the delete was successful.
		 }	
	////////////////////////////////////////////////////////////////////////////////////////
	@Test
	public void testgetRetailStore() throws URISyntaxException
	{
	    RestTemplate restTemplate = new RestTemplate();
	    //String randomServerPort="8080";
	   
	    final String baseUrl = "http://localhost:9205"+ "/GO6/userRetailStore";
	    URI uri = new URI(baseUrl);
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	    //Verify request succeed
	    assertEquals(200, result.getStatusCodeValue());
	  
	}
	@Test
    public void testaddRetailStore() throws URISyntaxException 
    {
    	RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = "http://localhost:9205"+"/GO6/userRetailStore";
       URI uri = new URI(baseUrl);
       RetailStore user = new RetailStore(1,"nayana","dress");
        HttpHeaders headers = new HttpHeaders();
       headers.set("X-COM-PERSIST", "true");      
        HttpEntity<RetailStore> request = new HttpEntity<>(user, headers);
        ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
        //Verify request succeed
        assertEquals(200, result.getStatusCodeValue());
   }
	@Test
    public void testUpdateRetailStore() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
       
        final String baseUrl = "http://localhost:9205"+"/GO6/userRetailStore/1";	     
        URI uri = new URI(baseUrl);
        RetailStore userToUpdate = new RetailStore(1,"appu","great outdoor");	      
        restTemplate.put(uri, userToUpdate);
        // Optionally, verify that the update was successful.
    }
	@Test
	 public void testDeleteRetailStore() throws URISyntaxException {
		    RestTemplate restTemplate = new RestTemplate();
		    
		      final String baseUrl = "http://localhost:9205/GO6/userRetailStore/1"; // Replace with your actual delete endpoint
		     URI uri = new URI(baseUrl);
		     restTemplate.delete(uri);
		    // Optionally, verify that the delete was successful.
		 }	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Test
	public void testgetShelfTime() throws URISyntaxException
	{
	    RestTemplate restTemplate = new RestTemplate();
	    //String randomServerPort="8080";
	   
	    final String baseUrl = "http://localhost:9205"+ "/GO6/ShelfTime";
	    URI uri = new URI(baseUrl);
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	    //Verify request succeed
	    assertEquals(200, result.getStatusCodeValue());
	  
	}
	@SuppressWarnings("deprecation")
	@Test
    public void testaddShelfTime() throws URISyntaxException
    {
    	RestTemplate restTemplate = new RestTemplate();
 
        final String baseUrl = "http://localhost:9205"+"/GO6/ShelfTime";
       URI uri = new URI(baseUrl);
       ShelfTime user = new ShelfTime(1,2,3,LocalDate.of(2022, 1, 23),LocalDate.of(2022, 5, 23));
        HttpHeaders headers = new HttpHeaders();
       headers.set("X-COM-PERSIST", "true");      
        HttpEntity<ShelfTime> request = new HttpEntity<>(user, headers);
        ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
        //Verify request succeed
        assertEquals(200, result.getStatusCodeValue());
   }
	@Test
    public void testUpdateShelfTime() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
       
        final String baseUrl = "http://localhost:9205"+"/GO6/ShelfTime/1";	     
        URI uri = new URI(baseUrl);
        ShelfTime userToUpdate = new ShelfTime(1,2,3,LocalDate.of(2023, 4, 23),LocalDate.of(2024, 5, 3));	      
        restTemplate.put(uri, userToUpdate);
        // Optionally, verify that the update was successful.
    }
	@Test
	 public void testDeleteShelfTime() throws URISyntaxException {
		    RestTemplate restTemplate = new RestTemplate();
		    
		      final String baseUrl = "http://localhost:9205/GO6/ShelfTime/1"; // Replace with your actual delete endpoint
		     URI uri = new URI(baseUrl);
		     restTemplate.delete(uri);
		    // Optionally, verify that the delete was successful.
		 }

}