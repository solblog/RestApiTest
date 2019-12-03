package eu.cec.empl.dms.integration.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.junit.BeforeClass;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class BasicConfiguration {
	
	public static Logger LOGGER = null;
	public static RestUrl url = null;
	public static ObjectMapper objectMapper = null;
	
	public static RestTemplate restTemplate = null;
	public static HttpHeaders headers = null;
	
	public static String restServiceName = null;
	public static String version = null;
	
	
    @BeforeClass
    public static void setLogger() throws MalformedURLException
    {
        System.setProperty("log4j.configurationFile","log4j2.xml");
        
        LOGGER = LogManager.getLogger("test");
        
        objectMapper = new ObjectMapper();
        
        restTemplate = new RestTemplate();
		
        headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
        
        /* Testing development */
        System.out.println("Testing development");
		url = new UrlDevelopment();
		
		/*******************************************************
		 * Testing test 
		 */
		
		/*
			System.out.println("Testing test");
			url = new UrlTest();
		*/
		
		/*******************************************************
		 *  Testing acceptance 
		 **/
		
		/*
			System.out.println("Testing acceptance");
			url = new UrlTest();
		*/
		
		/*******************************************************
		 *  Testing production 
		 **/
		
		/*
			System.out.println("Testing production");
			url = new UrlTest();
		*/

		
		
    }
    
    /********************************************** READ *************************************************************************************************/
    /** Testing reading methods using HttpClientBuilder                                                                                                 */ 																								
    /***************************************************************************************************************************************************/ 

    /**
     * READ
     * @param service
     * @param version
     * @param expectedResponse
     * @throws ParseException
     * @throws JSONException
     * @throws IOException
     */
    
    public void testRequestWithHttpClientBuilderAndJsonResponse(RestUrl url,String expectedResponse) throws ParseException, JSONException, IOException
    {
		executeAndAssertJsonResponse(expectedResponse, url.get());
    }
    
    public void testRequestWithHttpClientBuilderAndStatusCodeResponse(RestUrl url,int expectedStatusCode) throws ParseException, JSONException, IOException
    {
    
    	// When (call)
    	
    	executeAndAssertStatusCodeResponse(expectedStatusCode, url.get());
		
    }
    
    private void executeAndAssertJsonResponse(String expectedResponse, String serviceCall)
			throws IOException, ClientProtocolException, JSONException {
    	
		HttpResponse httpResponse = (HttpResponse) HttpClientBuilder.create().build().execute(new HttpGet(serviceCall));
		
		// Then
		String receivedResponse = EntityUtils.toString(httpResponse.getEntity());
		
		LOGGER.debug("URL called:"+serviceCall);
		LOGGER.debug("Response received:"+receivedResponse);
		LOGGER.debug("Response expected:"+expectedResponse);
		
		JSONAssert.assertEquals(receivedResponse, expectedResponse, JSONCompareMode.LENIENT);
		
	}
    
    private void executeAndAssertStatusCodeResponse(int expectedStatusCode, String serviceCall)
			throws IOException, ClientProtocolException, JSONException {
		HttpResponse httpResponse = (HttpResponse) HttpClientBuilder.create().build().execute(new HttpGet(serviceCall));
		
		// Then
		
		int receivedStatusCode = ((org.apache.http.HttpResponse) httpResponse).getStatusLine().getStatusCode();
		
		LOGGER.debug("URL called:"+serviceCall);
		LOGGER.debug("Status Code received:"+ receivedStatusCode);
		LOGGER.debug("Status Code expected:"+ expectedStatusCode);
	    
		assertEquals(receivedStatusCode, expectedStatusCode);
		
	}
    
    
    private void printServiceInformation(String serviceCall) throws IOException, ClientProtocolException, JSONException {
		
    	HttpResponse httpResponse = (HttpResponse) HttpClientBuilder.create().build().execute(new HttpGet(serviceCall));
		
		// Then
		String receivedResponse = EntityUtils.toString(httpResponse.getEntity());
		
		int receivedStatusCode = ((org.apache.http.HttpResponse) httpResponse).getStatusLine().getStatusCode();
		
		LOGGER.debug("URL called:"+serviceCall);
		LOGGER.debug("Status Code received:"+ receivedStatusCode);
		
	}
    

}
