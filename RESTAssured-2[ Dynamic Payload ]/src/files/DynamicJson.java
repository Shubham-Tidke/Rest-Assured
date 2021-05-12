// RestAssured with TestNG and Dynamic Payload
package files;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class DynamicJson {
	@Test(dataProvider = "BooksData")
	public void addBook(String NAME,String ISBN,String AISLE,String AUTHOR){
	
		RestAssured.baseURI ="http://216.10.245.166";
		String AddedBook =given()
		.header("content-type","application/json")
		.body(payload.postAddBook(NAME,ISBN,AISLE,AUTHOR))
		.when()
		.post("Library/Addbook.php")
		.then()
		.assertThat()
		.statusCode(200)
		.body("Msg",equalTo("successfully added"))
		.extract().response().asPrettyString();	
		System.out.println("****Adding Book using POST request****");
		System.out.println(AddedBook);
		
		JsonPath js = new JsonPath(AddedBook);
		String UniqueId = js.getString("ID");
		System.out.println("Unique ID for added Book : "+UniqueId);		
	}
	@DataProvider(name ="BooksData")
	public Object[][] getData() {
		return new Object[][] {{"A","axa","101","Shubham"},{"B","bxb","202","Shubham"},{"C","cxc","303","Shubham"}};
	}
}