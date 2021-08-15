package test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class TestOnLocalAPI {
	
	
	@Test
	public void get()
	{
		baseURI="http://localhost:3000/";
		
		given().get("/users?FirstName=joy").then().statusCode(200).assertThat().log().all();
		given().get("/subjects/1/users").then().statusCode(200).assertThat().log().all();
	}

		//@Test
		public void post()
		{
			JSONObject jsonobj = new JSONObject();
			jsonobj.put("FirstName", "Funny");
			jsonobj.put("LastName", "Singh");
			jsonobj.put("subjectId", 2);
			//jsonobj.put("id", 4);
			
			baseURI="http://localhost:3000/";
			
			given()
			
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(jsonobj.toJSONString())
			.header("Content-Type","application/json")
			
			
			.when()
			.post("/users")
			
			.then()
			.statusCode(201)
			.log()
			.all();
			
			
		}
		
		//@Test
		public void put()
		{
			JSONObject jsonobj = new JSONObject();
			jsonobj.put("FirstName", "Funny");
			jsonobj.put("LastName", "Singh");
			jsonobj.put("subjectId", 2);
			
			baseURI="http://localhost:3000/";
			given()
			.body(jsonobj.toJSONString())
			.accept(ContentType.JSON)
			.contentType(ContentType.JSON)
			.header("Content-Type","application/json")
			
			.when()
			.put("/users/7")
			
			.then()
			.statusCode(200)
			.log()
			.all();
			
			
		}
		
		//@Test
		public void patch()
		{
			JSONObject jsonobj = new JSONObject();
			//jsonobj.put("FirstName", "Funny");
			//jsonobj.put("LastName", "Ji");
			jsonobj.put("subjectId", 1);
			
			baseURI="http://localhost:3000/";
			given()
			.body(jsonobj.toJSONString())
			.accept(ContentType.JSON)
			.contentType(ContentType.JSON)
			.header("Content-Type","application/json")
			
			.when()
			.patch("/users/7")
			
			.then()
			.statusCode(200)
			.log()
			.all();
			
			
		}

		@Test
		public void delete()
		{
			JSONObject jsonobj = new JSONObject();
			jsonobj.put("FirstName", "Funny");
			jsonobj.put("LastName", "Ji");
			jsonobj.put("subjectId", 2);
			
			baseURI="http://localhost:3000/";
			given()
			.body(jsonobj.toJSONString())
			.accept(ContentType.JSON)
			.contentType(ContentType.JSON)
			.header("Content-Type","application/json")
			
			.when()
			.delete("/users/7")
			
			.then()
			.statusCode(200)
			.log()
			.all();
			
			
		}

}
