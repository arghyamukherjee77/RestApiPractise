package testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;


import apis.DeleteCustomer;
import base.BaseTest;
import io.restassured.response.Response;
import utils.DataUtil;
import utils.TestUtil;

public class DeleteCustomerTest extends BaseTest{
	
	@Test(dataProvider = "data", dataProviderClass = DataUtil.class)
	public void deleteCustomerWithValidKeyByProvidingValidID(Hashtable<String, String> data) {

		Response response = DeleteCustomer.deleteCustomerWithVlaidKey(data);
		response.prettyPrint();
		System.out.println(response.statusCode());
		Assert.assertTrue(TestUtil.hasKeyinResponse(response.asString(), "id"));
		String actual_id=TestUtil.getResponseKeyValue(response.asString(), "id");
		Assert.assertEquals(actual_id, data.get("id"),"Id what we expect is not present");
		System.out.println("Object key value is :"+TestUtil.getResponseKeyValue(response.asString(), "object"));
	}
	
	

}
