package testcases;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import apis.CreateCustomer;
import base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import listeners.ExtentListeners;
import utils.DataUtil;

public class CreateCustomerTest extends BaseTest {

	@Test(dataProvider = "data", dataProviderClass = DataUtil.class)
	public void createCustomerWithValidKey(Hashtable<String, String> data) {

		Response response = CreateCustomer.sendPostRequestToCreateACustomerWithValidKey(data);
		response.prettyPrint();
		System.out.println(response.statusCode());
		ExtentListeners.testReport.get().info("Created Customer with data: "+data);
		Assert.assertEquals(response.statusCode(), 200);
	}

	@Test(dataProvider = "data", dataProviderClass = DataUtil.class)
	public void createCustomerWithInValidKey(Hashtable<String, String> data) {
		Response response = CreateCustomer.sendPostRequestToCreateACustomerWithInValidKey(data);
		response.prettyPrint();
		System.out.println(response.statusCode());
		Assert.assertEquals(response.statusCode(), 401);
	}

}
