package utils;

import org.json.JSONObject;

import listeners.ExtentListeners;

public class TestUtil {

	
	public static boolean hasKeyinResponse(String json, String key)
	{
		JSONObject jsonObject=new JSONObject(json);
		ExtentListeners.testReport.get().info("Validating the presence of Key: "+key);
		return jsonObject.has(key);
	}
	
	public static String getResponseKeyValue(String json, String key)
	{
		JSONObject jsonObject=new JSONObject(json);
		ExtentListeners.testReport.get().info("Validating the presence of value: "+jsonObject.get(key).toString());
	    return jsonObject.get(key).toString();
	}
}
