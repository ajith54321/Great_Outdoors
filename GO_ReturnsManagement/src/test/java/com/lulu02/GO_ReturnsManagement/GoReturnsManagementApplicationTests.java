package com.lulu02.GO_ReturnsManagement;

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


import com.lulu02.GO_ReturnsManagement.Entity.ReturnItemEntity;
import com.lulu02.GO_ReturnsManagement.Entity.ReturnReasonEntity;

@SpringBootTest
class GoReturnsManagementApplicationTests {


    @Test
    void mytest() {
        System.out.println("returnItems Testing in progress");
    }

    @Test
    public void testGetReturnItem() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        System.out.println("Test case is in progress");
        final String baseUrl = "http://localhost:9200"+"/GO5/returnItems";
        URI uri = new URI(baseUrl);
        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        assertEquals(200, result.getStatusCodeValue());
   }

    @Test
    public void testUpdateReturnItem() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        System.out.println("Testing returnItems update");
        final String baseUrl = "http://localhost:9200"+"/GO5/returnItems/1"; 
        URI uri = new URI(baseUrl);
        ReturnItemEntity userToUpdate = new ReturnItemEntity(1, 555, 456, LocalDate.of(2023, 11, 16));
        restTemplate.put(uri, userToUpdate);
       
    }

    @Test
    public void testDeleteReturnItem() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        System.out.println("Testing returnItems deletion");
        final String baseUrl = "http://localhost:9200/GO5/returnItems/1"; 
        URI uri = new URI(baseUrl);
        restTemplate.delete(uri);
      
    }

    @Test
    public void testAddReturnItemSuccess() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:9200"+"/GO5/returnItems";
        URI uri = new URI(baseUrl);
        ReturnItemEntity user = new ReturnItemEntity(111, 222, 333, LocalDate.of(2023, 7, 16));
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");
        HttpEntity<ReturnItemEntity> request = new HttpEntity<>(user, headers);
        ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
        assertEquals(200, result.getStatusCodeValue());
    }
    
    
    ///////////////////////////////
    
    

    @Test
    void returnIDTest() {
        System.out.println("returnItems Testing in progress");
    }

    @Test
    public void testGetrReturnID() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        System.out.println("Test case is in progress");
        final String baseUrl = "http://localhost:9200"+"/GO5/returnReason";
        URI uri = new URI(baseUrl);
        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        assertEquals(200, result.getStatusCodeValue());
   }

    @Test
    public void testUpdateReturnID() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        System.out.println("Testing returnItems update");
        final String baseUrl = "http://localhost:9200"+"/GO5/returnReason/1"; 
        URI uri = new URI(baseUrl);
        ReturnReasonEntity userToUpdate = new ReturnReasonEntity(1, "Different color");
        restTemplate.put(uri, userToUpdate);
       
    }

    @Test
    public void testDeleteReturnID() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        System.out.println("Testing returnItems deletion");
        final String baseUrl = "http://localhost:9200/GO5/returnReason/1"; 
        URI uri = new URI(baseUrl);
        restTemplate.delete(uri);
      
    }

    @Test
    public void testAddReturnIDSuccess() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:9200"+"/GO5/returnReason";
        URI uri = new URI(baseUrl);
        ReturnReasonEntity user = new ReturnReasonEntity(111, "Over-Size");
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");
        HttpEntity<ReturnReasonEntity> request = new HttpEntity<>(user, headers);
        ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
        assertEquals(200, result.getStatusCodeValue());
    }
}
