package test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class jsonschemavalidation {

	@Test
	public void get()
	{
		baseURI="https://reqres.in/api";
		
		given().get("/users?page=2")
		.then()
		.statusCode(200)
		.assertThat()
		.body(matchesJsonSchemaInClasspath("schema.json"))//make sure it is a .json file and not getting save as .txt automatically
		.log().all();
		
	}
}
