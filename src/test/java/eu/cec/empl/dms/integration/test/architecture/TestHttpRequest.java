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

public class TestHttpRequest extends BasicConfiguration{
	
	/*
	*  The purpose of this test is to verify that all the exceptions and HTTP codes
	* triggers by the system are collected in the class CustomRestExceptionHandler.
	*  The Exception must be log properly
	*/
	
	private final String restServiceName = "/DirectTargetGroups";
	private final String version = "/v1";
		
	
	/******************************************************************************************************************** 
	* Test MimeTypes
	***/
	
	@Test
	public void givenRequestWithNoAcceptHeader_whenRequestIsExecuted_thenDefaultResponseContentTypeIsJson()
	  throws ClientProtocolException, IOException {
	   		
	   
	   
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
