package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;
import utils.ExcelReader;

public class BaseTest {
	
	public FileInputStream fis;
	public static Properties config=new Properties();
	public static ExcelReader excel=new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\Excel\\TestData.xlsx");
	
	@BeforeSuite
	public void setUp()
	{	
		try {
			fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			config.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RestAssured.baseURI=config.getProperty("baseURI");
		RestAssured.basePath=config.getProperty("basePath");
	}
	
	

}
