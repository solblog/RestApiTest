package eu.cec.empl.dms.integration.test.configuration;

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

import org.apache.http.entity.ContentType;

public class TestBasicConfiguration extends BasicConfiguration{
	
	private String serviceName = "/api-docs";
	private String version = "/v2";
	 
	/********************************************************************************************************************
	* Test Configuration
	 * @throws IOException 
	 * @throws JSONException 
	 * @throws ParseException 
	*/
	@Test
    public void WhenSpringFoxSwaggerIsWorkingThenOK() throws ParseException, JSONException, IOException {
		
		RestUrl urlDevelopment = new UrlDevelopment();
		
		/* We revert the order as in swagger the version are not per version is per API*/ 
		urlDevelopment.setService("/v2");
		urlDevelopment.setVersion("/api-docs");
		
		testRequestWithHttpClientBuilderAndStatusCodeResponse(urlDevelopment, HttpStatus.SC_OK);
        
    }
	 
	
	@Override
	public String getServiceName() {
		return serviceName;
	}

	@Override
	public String getServiceVersion() {
		return version;
	}
	
   

}
