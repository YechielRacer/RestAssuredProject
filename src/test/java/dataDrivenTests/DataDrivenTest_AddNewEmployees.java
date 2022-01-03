package dataDrivenTests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.IOException;

public class DataDrivenTest_AddNewEmployees {
	
	@DataProvider(name="EmployeeData")
	String[][] getEmployeeData() throws IOException {
		
		String excelFile = "./data/EmployeeData.xlsx";
		String sheetName = "Sheet1";
		
		int rowCount = XLUtils.getRowCount(excelFile, sheetName);
		int columnCount = XLUtils.getColumnCount(excelFile, sheetName, rowCount);
		
		String employeeData[][] = new String[rowCount][columnCount];
		
		for (int i=1; i<=rowCount; i++ ) {
			for (int j=0; j<columnCount; j++) {
				employeeData[i-1][j] = XLUtils.getCellData(excelFile, sheetName, i, j);
			}
		}
		
		//String employeeData[][] = {{"abc123","10000","30"},{"def456","20000","40"},{"ghi789","30000","50"}};
		return (employeeData);
		
	}
	
	@Test(dataProvider="EmployeeData")
	void postNewEmployees(String name, String salary, String age) {
		
		baseURI = "http://dummy.restapiexample.com/api/v1";
				
		JSONObject requestParams = new JSONObject();
		
		requestParams.put("name", name);
		requestParams.put("salary", salary);
		requestParams.put("age", age);
		
		given().
			header("Content-Type", "application/json").
			body(requestParams.toJSONString());
		Response response =	when().request(Method.POST, "/create");
																	 
//		String responseBody = response.getBody().asString();
		System.out.println(response.getBody().asString());
//		
//		Assert.assertTrue(responseBody.contains("Isaac"));
//		Assert.assertTrue(responseBody.contains("10000"));
//		Assert.assertTrue(responseBody.contains("42"));
//		Assert.assertEquals(response.getStatusCode(), 200);
		
		JsonPath responseBody = response.jsonPath();
		
		Assert.assertEquals(response.getStatusCode(), 200);	
		Assert.assertEquals(responseBody.get("status"), "success");
		Assert.assertEquals(responseBody.get("message"), "Successfully! Record has been added.");
		
		try { Thread.sleep(2000); } catch (Exception e) {}
		
	}

}
