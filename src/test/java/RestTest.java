import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class RestTest {

	public static final String KEY = "Add your Key";
	@Test
	public void badge_id_validate_response_code_test() {
		RestAssured.baseURI = "https://api.stackexchange.com/2.2/badges";
		// Create new JSON Object
		given()
		.param("key", KEY)
		.param("site", "stackoverflow")
		.param("order", "desc")
		.param("sort", "rank")
		.param("filter", "default")
		.when().get("/12").then().statusCode(200);
	}
	
	@Test
	public void badge_id_validate_response_code_max_PageSize() {
		RestAssured.baseURI = "https://api.stackexchange.com/2.2/badges";
		// Create new JSON Object
		given()
		.param("key", KEY)
		.param("pagesize","1000")
		.param("site", "stackoverflow")
		.param("order", "desc")
		.param("sort", "rank")
		.param("filter", "default")
		.when().get("/12").then().statusCode(400);
	}
	
	@Test
	public void recipient_validate_response_code_max_PageSize() {
		RestAssured.baseURI = "https://api.stackexchange.com/2.2/badges";
		// Create new JSON Object
		given()
		.param("key", KEY)
		.param("pagesize","1000")
		.param("site", "stackoverflow")
		.param("order", "desc")
		.param("sort", "rank")
		.param("filter", "default")
		.when().get("/recipients").then().statusCode(400);
	}
	
	@Test
	public void recipient_validate_response_body() {
		RestAssured.baseURI = "https://api.stackexchange.com/2.2/badges";
		// Create new JSON Object
		given()
		.param("key", KEY)
		.param("pagesize","100")
		.param("site", "stackoverflow")
		.param("order", "desc")
		.param("sort", "rank")
		.param("filter", "default")
		.when().get("/recipients").then().statusCode(200).and().body(matchesJsonSchemaInClasspath("recipient.json"));
	}
	
	
	
}
