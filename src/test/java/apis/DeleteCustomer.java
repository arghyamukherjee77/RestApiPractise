package apis;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import base.BaseTest;
import io.restassured.response.Response;

public class DeleteCustomer extends BaseTest{
	
	public static Response deleteCustomerWithVlaidKey(Hashtable<String, String> data)
	{
		 Response response=given().auth().basic(config.getProperty("validkey"), "")
			.delete(config.getProperty("customerEndpoint")+"/"+data.get("id"));
		 return response;
	}

}
