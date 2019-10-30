package com.example.shop.controller;

import com.example.shop.ShopApplication;
import com.example.shop.model.User;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {ShopApplication.class})
public class TestControllerTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getUsersData() {
        //Response response=RestAssured.get("http://localhost:8080/test");
        RestAssured.get("http://localhost:8080/test").then().assertThat().statusCode(200)
        .and().body("users[0].id", equalTo(3));
//                .and().body("users.id", equalTo(3));
        //Assert.assertEquals(200,response.getStatusCode());
    }
}