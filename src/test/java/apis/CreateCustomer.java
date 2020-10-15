package apis;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import base.BaseTest;
import io.restassured.response.Response;

public class CreateCustomer extends BaseTest {

	public static Response sendPostRequestToCreateACustomerWithValidKey(Hashtable<String, String> data) {
		Response response = given().auth().basic(config.getProperty("validkey"), "")
				.formParams("description", data.get("description")).formParam("email", data.get("email"))
				.formParam("name", data.get("email")).post("/customers");
		return response;
	}

	public static Response sendPostRequestToCreateACustomerWithInValidKey(Hashtable<String, String> data) {
		Response response = given().auth().basic(config.getProperty("invalidkey"), "")
				.formParams("description", data.get("description")).formParam("email", data.get("email"))
				.formParam("name", data.get("email")).post("/customers");
		return response;
	}

}
