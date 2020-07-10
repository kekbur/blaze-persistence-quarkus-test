package com.github.kekbur.blazepersistencequarkustest;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import io.vertx.core.json.JsonObject;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

import java.util.UUID;

@QuarkusTest
public class PersonResourceTest
{
	@Test
	public void testGetEndpoint()
	{
		given()
			.when().get("/persons")
			.then()
				.statusCode(200)
				.body(containsString("\"name\":\"P"));
	}
	/*
	@Test
	public void testUpdateEndpoint()
	{
		UUID id = UUID.randomUUID();
		
		JsonObject input = new JsonObject()
			.put("name", "Test");
		
		given()
			.body(input.toString())
			.contentType(ContentType.JSON)
			.when().put("/persons/{id}", id)
			.then()
				.statusCode(200)
				.body(equalTo("{\"id\":\"" + id + "\",\"name\":\"Test\"}"));
	}
	*/
}
