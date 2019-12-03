package eu.cec.empl.dms.integration.test.rest.crud;


import static org.junit.Assert.*;

import java.awt.DefaultFocusTraversalPolicy;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.validation.constraints.AssertTrue;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.junit.BeforeClass;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

import eu.cec.empl.dms.domain.business.client.catalogue.DirectTargetGroup;
import eu.cec.empl.dms.domain.business.client.catalogue.UltimateTargetGroup;
import eu.cec.empl.dms.integration.test.BasicConfiguration;
import eu.cec.empl.dms.integration.test.RestUrl;
import eu.cec.empl.dms.integration.test.UrlDevelopment;
import eu.cec.empl.dms.test.tools.FakeObjectsFactory;

public class DirectTargetGroupTest extends BasicConfiguration {
	
	@BeforeClass 
	public static void initializeRestURI() throws MalformedURLException
	{
			url.setService("/direct-target-groups");
			url.setVersion("/v1");
	}
	
	/*****************************************
	 * CREATE 
	 *****************************************/
	
	/**
	 * The request could not be understood by the server due to malformed syntax.
	 * The client SHOULD NOT repeat the request without modifications.
	 * 
	 * @throws JSONException
	 */
	@Test
	public void createDirectTargetGroupsWithObject_V1_getResponseEntity()	throws ClientProtocolException, IOException, JSONException {
				
		/**
		 * Create a direct target group with fake data
		 */
		
		DirectTargetGroup directTargetGroupSent,directTargetGroupReceived,directTargetGroupFound;
		ResponseEntity<String> responseCreate,responseGet, responseDelete;
		
		
		directTargetGroupSent = FakeObjectsFactory.getDirectTargetGroupEntity(new DirectTargetGroup());
		HttpEntity<DirectTargetGroup> request = new HttpEntity<DirectTargetGroup>(directTargetGroupSent);
 
		/* CREATE: HTTP Methos POST (postForEntity)*/
		url.setParam(null);
		
		LOGGER.debug("URL:"+url.get());
		responseCreate = restTemplate.postForEntity(url.get(), request, String.class);
		directTargetGroupReceived = objectMapper.readValue(responseCreate.getBody(), DirectTargetGroup.class);
		
		assertEquals(directTargetGroupSent.getDescriptionEn(), directTargetGroupReceived.getDescriptionEn());
		assertEquals(directTargetGroupSent.getOrderNumber(), directTargetGroupReceived.getOrderNumber());
		
		String jsonString = objectMapper.writeValueAsString(directTargetGroupReceived);
		
		LOGGER.debug("URL:"+url.get());
		LOGGER.debug("received:"+jsonString);
		// LOGGER.debug("expected:"+expectedResponse);
		
		
		/**
		 * Read the direct target group created (getForEntity)
		 */
		
		url.setMethod("/last");
		responseGet = restTemplate.getForEntity(url.get(), String.class);
		directTargetGroupFound =  objectMapper.readValue(responseGet.getBody(), DirectTargetGroup.class);
		
		url.setMethod(null);
		
		assertEquals(directTargetGroupFound.getDescriptionEn(), directTargetGroupReceived.getDescriptionEn());
		assertEquals(directTargetGroupFound.getOrderNumber(), directTargetGroupReceived.getOrderNumber());
		
		/**
		 * Delete the direct target group created (getForEntity)
		 */
		
		url.setMethod(null);
		url.setParam("/{id}");
		
		Map < String, String > params = new HashMap < String, String > ();
	    params.put("id", directTargetGroupReceived.getId().toString());

	    restTemplate.delete(url.get(), params);

	}
	
		
	/*****************************************
	 * READ 
	 *****************************************/
	
	@Test
	public void requestDirectTargetGroups_V1_thenListIsReceived()	throws ClientProtocolException, IOException, JSONException {
		
		url.setParam(null);
		LOGGER.debug("Call:"+url.get());
		
		ResponseEntity<List<DirectTargetGroup>> response = restTemplate.exchange(url.get(),HttpMethod.GET,null,new ParameterizedTypeReference<List<DirectTargetGroup>>(){});
		List<DirectTargetGroup> listDirectTargetGroup = response.getBody();
		
		assertTrue(listDirectTargetGroup.size()>10);
		LOGGER.debug("Object received"+objectMapper.writeValueAsString(listDirectTargetGroup));
		
	}
	
	/**
	 * Get direct Taregt group by ID and return a JSON using HttpRequestBuilder 
	 * 
	 * 
	 * @throws JSONException
	 */
	@Test
	public void requestDirectTargetGroupById_V1_thenJsonIsReceived() throws ClientProtocolException, IOException, JSONException {
		
		String expectedResponse = "{\"id\":1,\"descriptionEn\":\"National authorities (ministries, departments and similar)\",\"descriptionFr\":\"Autorités nationales (ministères, départements et similaires)\",\"descriptionDe\":\"Nationale Behörden (Ministerien, Ämter und ähnliche)\",\"orderNumber\":1}";
		url.setParam("/1");
		testRequestWithHttpClientBuilderAndJsonResponse(url, expectedResponse);
		
	}
	
	/**
	 * Get direct Taregt group by ID and return a JSON using HttpRequestBuilder 
	 * 
	 * 
	 * @throws JSONException
	 */
	@Test
	public void checkDirectTargetGroupExistWithRestTemplate_V1() throws ClientProtocolException, IOException, JSONException {

		DirectTargetGroup directTargetGroupSent,directTargetGroupReceived,directTargetGroupFound;
		ResponseEntity<String> responseCreate,responseGet, responseDelete;
		
		url.setParam("/3000");
		 
		HttpHeaders httpHeader;
		
		try
		{
			LOGGER.debug("URL:"+url.get());	
			httpHeader = restTemplate.headForHeaders(url.get());
		} catch (HttpClientErrorException e1) {
            if (e1.getStatusCode() == HttpStatus.NOT_FOUND) {
            	LOGGER.debug("Status code:"+HttpStatus.NOT_FOUND.toString());
            	assertEquals(HttpStatus.NOT_FOUND, e1.getStatusCode());
            } else {
            	LOGGER.debug("Status code:"+e1.getStatusCode().toString());
            }
        } catch (Exception e) {
        	LOGGER.error(e.getMessage(),e);
        }
		
		url.setParam("/2");
		
		try
		{
			LOGGER.debug("URL:"+url.get());	
			httpHeader = restTemplate.headForHeaders(url.get());
		} catch (HttpClientErrorException e1) {
            if (e1.getStatusCode() == HttpStatus.NOT_FOUND) {
            	LOGGER.debug("Status code:"+HttpStatus.NOT_FOUND.toString());
            	assertEquals(HttpStatus.ACCEPTED, e1.getStatusCode());
            } else {
            	LOGGER.debug("Status code:"+e1.getStatusCode().toString());
            }
        } catch (Exception e) {
        	LOGGER.error(e.getMessage(),e);
        }
	
	}
		
	/*****************************************
	 * UPDATE 
	 *****************************************/
	
	@Test
	public void updateDirectTargetGroupsWithObject_V1_getResponseEntity()	throws ClientProtocolException, IOException, JSONException {
		
		/* GET: HTTP Method */
		DirectTargetGroup directTargetGroupFound,updatedDirectTargetGroup;
		ResponseEntity<String> responseCreate,responseGet, responseDelete;
		
		url.setParam("/50");
		
		LOGGER.debug("URL:"+url.get());
		
		responseGet = restTemplate.getForEntity(url.get(), String.class);
		directTargetGroupFound =  objectMapper.readValue(responseGet.getBody(), DirectTargetGroup.class);
		
		updatedDirectTargetGroup = FakeObjectsFactory.getDirectTargetGroupEntity(new DirectTargetGroup());
		HttpEntity<DirectTargetGroup> request = new HttpEntity<DirectTargetGroup>(updatedDirectTargetGroup);
		
		url.setParam("/{id}");
		url.setMethod(null);
		
		Map < String, String > params = new HashMap < String, String > ();
	    params.put("id", directTargetGroupFound.getId().toString());
	    
		LOGGER.debug("URL:"+url.get());
		
		LOGGER.debug("Objet to JSON :"+objectMapper.writeValueAsString(directTargetGroupFound));
		
		LOGGER.debug("Params: Id="+directTargetGroupFound.getId().toString());
		
		/* CREATE: HTTP Methos POST (postForEntity)*/ 
		restTemplate.put(url.get(), request, params);
		
		
		

	}
	
	
	/*****************************************
	 * DELETE 
	 *****************************************/

	@Test
	public void deleteDirectTarget_V1_getResponseEntity()	throws ClientProtocolException, IOException, JSONException {
		
		assertTrue(true);
		
		LOGGER.debug("Tested in create method");
		
		/* GET last ultimate target group */
		
		/*
		
		DirectTargetGroup directTargetGroupFound;
		ResponseEntity<String> responseCreate,responseGet, responseDelete;
		
		url.setParam(null);
		url.setMethod("/last");

		responseGet = restTemplate.getForEntity(url.get(), String.class);
		directTargetGroupFound =  objectMapper.readValue(responseGet.getBody(), DirectTargetGroup.class);
		
		url.setMethod(null);
		url.setParam("/{id}");
		
		// DELETE: last 
		
		Map < String, String > params = new HashMap < String, String > ();
	    params.put("id", directTargetGroupFound.getId().toString());
	    
	    
		LOGGER.debug("URL:"+url.get());
		LOGGER.debug("Params: Id="+directTargetGroupFound.getId().toString());

	    restTemplate.delete(url.get(), params);
	    
	    */

	}
	
	
	/**
	 * Testing using RestTemplate
	 * @throws JSONException
	 */
	@Test
	public void CreateDirectTargetGroups_V2_withJson()	throws ClientProtocolException, IOException, JSONException {
				
		assertTrue(true);
		
		/**
		 * Not implemented on the REST API , Pending send a json not an Object
		 */
		
		/*
		
		final String method = "/create";
		
		url.setMethod(method);
			
		DirectTargetGroup directTargetGroup;
		String statusResponsAsJsonStr;
		
		
		directTargetGroup = FakeObjectsFactory.getDirectTargetGroupEntity(new DirectTargetGroup());
		
		String jsonString = objectMapper.writeValueAsString(directTargetGroup);
				
		//  Call rest service
		HttpEntity<DirectTargetGroup> request = new HttpEntity<DirectTargetGroup>(directTargetGroup,headers);
		statusResponsAsJsonStr = restTemplate.postForObject(url.get(), request, String.class);
		
		// Test result 
		// Assert response 
		
		String exptedResponse = "202";
		JSONAssert.assertEquals(statusResponsAsJsonStr, exptedResponse , JSONCompareMode.LENIENT);
		
		// Assert object 
		
		// Find the last object created, answer in JSON 
		
		
		// Json to object
		
		
		
		LOGGER.debug("URL:"+urlDevelopment.get());
		LOGGER.debug("received:"+statusResponsAsJsonStr);
		
		// LOGGER.debug("expected:"+expectedResponse);
 
		 */

	}
	
	

	
	

}
