package com.java.usermanagementclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class UserManagementClientApplication {

    static RestTemplate restTemplate = new RestTemplate();
    static String baseUrl = "http://localhost:8083/springDataJpa/";

    public static void main(String[] args) {

//        SpringApplication.run(UserManagementClientApplication.class, args);

        useExchangeMethodsOfRestTemplate();
    }
    private static void useExchangeMethodsOfRestTemplate() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Object> requestEntity = new HttpEntity<>(headers);

        getSingleUserByExchangeMethod(requestEntity);
        getListUserByExchangeMethod(requestEntity);

        User sysUser = new User();
        sysUser.setFirstName("Arvind");
        sysUser.setLastName("Kuamr");
        sysUser.setAddress("Noida");
        sysUser.setGender("M");

        //requestEntity = new HttpEntity<>(sysUser, headers);

        //addUserByExchangeMethod(requestEntity);

        //updateUserByExchangeMethod(requestEntity);

        //deleteUserByExchangeMethod(requestEntity);
    }

    private static void deleteUserByExchangeMethod(HttpEntity<User> requestEntity) {
        ResponseEntity<String> responseEntity = restTemplate.exchange(baseUrl + "user/21",
                HttpMethod.DELETE,
                requestEntity,
                String.class);
        HttpStatus statusCode = responseEntity.getStatusCode();
        System.out.println("status code - " + statusCode);
        String userDetails = responseEntity.getBody();
        System.out.println("response body - " + userDetails);
        HttpHeaders responseHeaders = responseEntity.getHeaders();
        System.out.println("response Headers - " + responseHeaders);
    }

    private static void updateUserByExchangeMethod(HttpEntity<User> requestEntity) {
        ResponseEntity<String> responseEntity = restTemplate.exchange(baseUrl + "updateAddress/21/Delhi",
                HttpMethod.PUT,
                requestEntity,
                String.class);
        HttpStatus statusCode = responseEntity.getStatusCode();
        System.out.println("status code - " + statusCode);
        String userDetails = responseEntity.getBody();
        System.out.println("response body - " + userDetails);
        HttpHeaders responseHeaders = responseEntity.getHeaders();
        System.out.println("response Headers - " + responseHeaders);
    }

    private static void addUserByExchangeMethod(HttpEntity<User> requestEntity) {
        ResponseEntity<User> responseEntity = restTemplate.exchange(baseUrl + "user",
                HttpMethod.POST,
                requestEntity,
                User.class);
        HttpStatus statusCode = responseEntity.getStatusCode();
        System.out.println("status code - " + statusCode);
        User userDetails = responseEntity.getBody();
        System.out.println("response body - " + userDetails);
        HttpHeaders responseHeaders = responseEntity.getHeaders();
        System.out.println("response Headers - " + responseHeaders);
    }


    private static void getListUserByExchangeMethod(HttpEntity<Object> requestEntity) {
        ResponseEntity<List> responseEntity = restTemplate.exchange(baseUrl + "users",
                HttpMethod.GET,
                requestEntity,
                List.class);
        HttpStatus statusCode = responseEntity.getStatusCode();
        System.out.println("status code - " + statusCode);
        List user = responseEntity.getBody();
        System.out.println("response body - " + user);
        HttpHeaders responseHeaders = responseEntity.getHeaders();
        System.out.println("response Headers - " + responseHeaders);
    }

    private static void getSingleUserByExchangeMethod(HttpEntity<Object> requestEntity) {
        ResponseEntity<String> responseEntity = restTemplate.exchange(baseUrl + "user/5",
                HttpMethod.GET,
                requestEntity,
                String.class);
        HttpStatus statusCode = responseEntity.getStatusCode();
        System.out.println("status code - " + statusCode);
        String user = responseEntity.getBody();
        System.out.println("response body - " + user);
        HttpHeaders responseHeaders = responseEntity.getHeaders();
        System.out.println("response Headers - " + responseHeaders);

        ResponseEntity<User> responseUser = restTemplate.exchange(baseUrl + "user/5",
                HttpMethod.GET,
                requestEntity,
                User.class);
        User userBody = responseUser.getBody();
        System.out.println("user object - " + userBody);
    }

}