package org.testautomation.test;

import org.testautomation.framework.common.JsonParser;
import org.testautomation.framework.model.StarShipDto;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

public class TrialApiTest {

	String apiPath = "https://swapi.co";

	@BeforeMethod
	public void beforeMethod() {
		RestAssured.baseURI = apiPath;

	}

	@Test
	public void givenUrlWhenUserCallsApiReturnsOk() {

		RestAssured.given().contentType("application/json").when().pathParam("Id", 13).when()
				.get("/api/starships/{Id}/").then().assertThat().statusCode(200);

	}

	@Test
	public void givenUrlWhenUserCallsApiResponseContentOk() {
		Response response = RestAssured.given().when().pathParam("Id", 13).when().get("/api/starships/{Id}/").then()
				.extract().response();

		JsonParser parser = new JsonParser(StarShipDto.class);
		StarShipDto responseObject = (StarShipDto) parser.deserializeResponse(response.asString());

		Assert.assertEquals(responseObject.getConsumables(), "5 days", "The response content does not match");
		Assert.assertEquals(responseObject.getLength(), "9.2", "The response content does not match");

	}

}
