import io.restassured.RestAssured;

import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import files.payload;
public class solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI= "https://rahulshettyacademy.com"; // Base URL
		
		
		// POST request testing
		String PostResponse = given().log().all()	//.log().all to print given input in console
		.queryParam("key", "qaclick123")
		.header("content-type","application/json")
		.body(payload.postBodyData())
		.when()
		.post("maps/api/place/add/json") //HTTP request and Resource
		.then()//.log().all() //.log().all() to print outcome of request in console
		.assertThat() // checking the conditions for parameters,statusCode,header,server
		.statusCode(200)
		.body("scope",equalTo("APP"))
		.header("server", "Apache/2.4.18 (Ubuntu)")
		.extract().response().asPrettyString(); // storing output response viz. body,in 'PostResponse' as one string
		System.out.println("** POST REQUEST RESPONSE **");
		System.out.println(PostResponse);
		
		JsonPath path = new JsonPath(PostResponse);
		String place = path.getString("place_id");
		System.out.println(place);
				
		//PUT request testing
		
		String newAddress = "70 Summer walk, USA - NEW ADD UPDATED";
		System.out.println("****PUT REQUEST STARTED****");
		given().log().all()
		.queryParams("key", "qaclick123")
		.header("content-type","application/json")
		.body("{\r\n" + 
				"\"place_id\":\""+place+"\",\r\n" + 
				"\"address\":\""+newAddress+"\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}")
		.when()
		.put("maps/api/place/update/json")
		.then()
		.assertThat()
		.statusCode(200).log().all()
		.body("msg",equalTo("Address successfully updated"));
		
		
		
		// GET request testing
		System.out.println("***GET REQUEST STARTED****");
		String GetResponse = given().log().all()
		.queryParam("key", "qaclick123")
		.queryParam("place_id",place)
		.when()
		.get("maps/api/place/get/json") //HTTP request + resource
		.then()
		.assertThat().statusCode(200)
		.extract().response().asPrettyString();
		System.out.println("** GET REQUEST RESPONSE **");
		System.out.println(GetResponse);
		
	}

}
