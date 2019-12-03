package eu.cec.empl.dms.integration.test.architecture;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import java.io.IOException;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONException;
import org.junit.Test;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

import eu.cec.empl.dms.mock.domain.catalogue.DirectTargetGroup;
import eu.cec.empl.dms.integration.test.BasicConfiguration;
import eu.cec.empl.dms.integration.test.RestUrl;
import eu.cec.empl.dms.integration.test.UrlDevelopment;
import eu.cec.empl.dms.integration.test.utils.RetrieveUtil;

public class TestHttpCodeMessages extends BasicConfiguration{
	
	/*
	*  The purpose of this test is to verify that all the exceptions and HTTP codes
	* triggers by the system are collected in the class CustomRestExceptionHandler.
	*  The Exception must be log properly
	*/
	
	private final String restServiceName = "/DirectTargetGroups";
	private final String version = "/v1";
	
	private String testId = "-1";
	private String wrongId = "a";
	
	// Given
	String jsonMimeType = "application/json";
		
	/******************************************************************************************************************** 
	* Test HTTP Code messages
	* https://stackoverflow.com/questions/11746894/what-is-the-proper-rest-response-code-for-a-valid-request-but-an-empty-data
	* https://benramsey.com/blog/2008/05/http-status-204-no-content-and-205-reset-content/
	 * @throws JSONException 
	 * @throws ParseException 
	*/
	@Test
	public void givenObjectDoesNotExists_whenObjectInfoIsRetrieved_then400IsReceived() throws ClientProtocolException, IOException, ParseException, JSONException {
		
		RestUrl urlDevelopment = new UrlDevelopment();
		urlDevelopment.setService("fakeSerice");
		testRequestWithHttpClientBuilderAndStatusCodeResponse(urlDevelopment,HttpStatus.SC_BAD_REQUEST);
	        
	}
	
	
	/**
	 * The request could not be understood by the server due to malformed syntax. The client SHOULD NOT repeat the request without modifications.
	 * @throws JSONException 
	 * @throws ParseException 
	 */
	@Test
	public void givenObjectDoesNotExists_whenObjectInfoIsRetrieved_then404IsReceived() throws ClientProtocolException, IOException, ParseException, JSONException {

		RestUrl urlDevelopment = new UrlDevelopment();
		urlDevelopment.setParam(testId);
		testRequestWithHttpClientBuilderAndStatusCodeResponse(urlDevelopment,HttpStatus.SC_NOT_FOUND);
    
	}
	
	
	@Override
	public String getServiceName() {
		return restServiceName;
	}

	@Override
	public String getServiceVersion() {
		// TODO Auto-generated method stub
		return version;
	}
	
	

}
