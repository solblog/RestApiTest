package eu.cec.empl.dms.integration.test.rest.publication;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.junit.BeforeClass;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import eu.cec.empl.dms.domain.business.client.catalogue.DirectTargetGroup;
import eu.cec.empl.dms.dto.ActionSummaryDTO;
import eu.cec.empl.dms.dto.PublicationDTO;

/*
 https://www.baeldung.com/integration-testing-in-spring
*/

import eu.cec.empl.dms.integration.test.BasicConfiguration;
import eu.cec.empl.dms.integration.test.RestUrl;
import eu.cec.empl.dms.integration.test.UrlDevelopment;
import eu.cec.empl.dms.test.tools.FakeObjectsFactory;

public class PublicationSearchTest extends BasicConfiguration{
	
	/*
	 * Use AspectJ in order to log all the url and the objects 
	 */
	
	private final String serviceName = "/publications";
	private final String version = "/v1";
	static ObjectMapper objectMapper;
	
	@BeforeClass
	public static void beforeClass() {
		objectMapper = new ObjectMapper();
	}
	
	
	private final String publicationControllerMethod1 = "/publications/v1/search";
	
	private final String publicationControllerMethod2 = "/publications/v2/search";
	
	private final String publicationControllerMethod3 = "/publications/v3/search";
	
	String params = "?language=1&callProposal=VC/2018/001&programme=4"
			+ "&countries=1%2C2%2C3%2C4&directTargetGroups=1%2C2%2C3%2C4&ultimateTargetGroups=1%2C2%2C3%2C4&policyAreas=1%2C2%2C3%2C4"
			+ "&grantReference=VS/2018/001"
			+ "&organisations=1%2C2%2C3%2C4";
	
	
	/************ CREATE *****************/
	
	@Test
	public void requestCreationWithRestTemplate_V1() throws ClientProtocolException, IOException, JSONException {
		
		PublicationDTO publicationDTOsent = null,publicationDTOreceived;
		ResponseEntity<String> responseCreate,responseGet, responseDelete;
		
		RestUrl urlDevelopment = new UrlDevelopment();
		urlDevelopment.setService(serviceName);
		urlDevelopment.setVersion("/v1");
		// urlDevelopment.setMethod(methodCreate);
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		publicationDTOsent = FakeObjectsFactory.getPublicationDTO();
		
		HttpEntity<PublicationDTO> request = new HttpEntity<PublicationDTO>(publicationDTOsent);
		
		
		String jsonStringSent = objectMapper.writeValueAsString(publicationDTOsent);
		LOGGER.debug("Object to sent:"+jsonStringSent);
		
		/* CREATE: HTTP Methos POST (postForEntity)*/ 
		responseCreate = restTemplate.postForEntity(urlDevelopment.get(), request, String.class);
		
		LOGGER.debug("Object to sent:"+responseCreate.getBody());
		
		publicationDTOreceived = objectMapper.readValue(responseCreate.getBody(), PublicationDTO.class);
		
		assertEquals(publicationDTOsent.getGrantAgreementDTO().getReference() , publicationDTOreceived.getGrantAgreementDTO().getReference());
		
		String jsonStringReceived = objectMapper.writeValueAsString(publicationDTOreceived);
		
		LOGGER.debug("URL:"+urlDevelopment.get());
		LOGGER.debug("Object to received:"+jsonStringReceived);
		// LOGGER.debug("expected:"+expectedResponse);
		
		
		/* DELETE: HTTP Method */
		urlDevelopment.setMethod(null);
		urlDevelopment.setParam("/{id}");
		Map < String, String > params = new HashMap < String, String > ();
		params.put("id", publicationDTOreceived.getId().toString());
		restTemplate.delete(urlDevelopment.get(), params);
        
	        
	}
	
	
	
	/************ READ *****************/
	
	/**
	 * The request could not be understood by the server due to malformed syntax. The client SHOULD NOT repeat the request without modifications.
	 * @throws JSONException 
	 */
	@Test
	public void requestPublication_V1_thenListIdsIsReceived() throws ClientProtocolException, IOException, JSONException {

        String method = "/search";
        
        String params = "?language=1&callProposal=VC/2018/001&programme=4"
    			+ "&countries=1%2C2%2C3%2C4&directTargetGroups=1%2C2%2C3%2C4&ultimateTargetGroups=1%2C2%2C3%2C4&policyAreas=1%2C2%2C3%2C4"
    			+ "&grantReference=VS/2018/001"
    			+ "&organisations=1%2C2%2C3%2C4";

        RestUrl urlDevelopment = new UrlDevelopment();
        urlDevelopment.setMethod(method);
        urlDevelopment.setParam(params);
        
        String expectedResponse = "[110891,110891,110891,110891,110891,110891,110891,110891,110891,110891]";

        testRequestWithHttpClientBuilderAndJsonResponse(urlDevelopment, expectedResponse);
	        
	}
	
	/**
	 * The request could not be understood by the server due to malformed syntax. The client SHOULD NOT repeat the request without modifications.
	 * @throws JSONException 
	 */
	@Test
	public void requestPublication_V2_thenListIdsIsReceived() throws ClientProtocolException, IOException, JSONException {

		// Given (uri)
		String method = "/search";
        
        String params = "?language=1&callProposal=VC/2018/001&programme=4"
    			+ "&countries=1%2C2%2C3%2C4&directTargetGroups=1%2C2%2C3%2C4&ultimateTargetGroups=1%2C2%2C3%2C4&policyAreas=1%2C2%2C3%2C4"
    			+ "&grantReference=VS/2018/001"
    			+ "&organisations=1%2C2%2C3%2C4";

        RestUrl urlDevelopment = new UrlDevelopment();
        urlDevelopment.setMethod(method);
        urlDevelopment.setParam(params);
        urlDevelopment.setVersion("v2");
        
        String expectedResponse = "[110891,110891,110891,110891,110891,110891,110891,110891,110891,110891]";

        testRequestWithHttpClientBuilderAndJsonResponse(urlDevelopment, expectedResponse);
	        
	}
	
	/**
	 * The request could not be understood by the server due to malformed syntax. The client SHOULD NOT repeat the request without modifications.
	 * @throws JSONException 
	 */
	@Test
	public void requestPublication_V3_thenListIdsIsReceived() throws ClientProtocolException, IOException, JSONException {

		// Given (uri)
		String method = "/search";
        
        String params = "?language=1&callProposal=VC/2018/001&programme=4"
    			+ "&countries=1%2C2%2C3%2C4&directTargetGroups=1%2C2%2C3%2C4&ultimateTargetGroups=1%2C2%2C3%2C4&policyAreas=1%2C2%2C3%2C4"
    			+ "&grantReference=VS/2018/001"
    			+ "&organisations=1%2C2%2C3%2C4";

        RestUrl urlDevelopment = new UrlDevelopment();
        urlDevelopment.setMethod(method);
        urlDevelopment.setParam(params);
        urlDevelopment.setVersion("v3");
        
        String expectedResponse = "[110891,110891,110891,110891,110891,110891,110891,110891,110891,110891]";

        testRequestWithHttpClientBuilderAndJsonResponse(urlDevelopment, expectedResponse);
	        
	}

	/**
	 * The request could not be understood by the server due to malformed syntax. The client SHOULD NOT repeat the request without modifications.
	 * @throws JSONException 
	 */
	@Test
	public void requestPublicationByGrantAgreementReference_thenGetPublicationJSON() throws ClientProtocolException, IOException, JSONException {
		
		String publicationRestService = "/publications/grantagreement";
        String serviceVersion = "/v1";
    	
    	/* It should not be exposed to the Controller, refactor */
        RestUrl urlDevelopment = new UrlDevelopment();
		urlDevelopment.setService(publicationRestService);
		urlDevelopment.setVersion("/v1/");
		
		String encodedParam = URLEncoder.encode("VS/2015/0329", "UTF-8");
		urlDevelopment.setParam(encodedParam);;
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		LOGGER.debug("Call:"+urlDevelopment.get());
		
		/*
		http://localhost:6001/dms/publigrant/publications/grantagreement/v1/VS%2F2015%2F0329
		http://localhost:6001/dms/publigrant/publications/grantagreement/v1/VS%252F2015%252F0329
		*/
    	
    	PublicationDTO publicationDTO = restTemplate.getForObject(urlDevelopment.get(),PublicationDTO.class);

    	String jsonStringSent = objectMapper.writeValueAsString(publicationDTO);
		LOGGER.debug("Object to sent:"+jsonStringSent);
	        
	}
	
	/************ UPDATE *****************/
	
	// restTemplate.put(buildUrl(request,publicationRestService,serviceVersion, null),application.getGrantAgreementInfo().getColiReference());
	
	@Test
	public void requestUpdateSummaryWithRestTemplate_V1() throws ClientProtocolException, IOException, JSONException {
		
		ActionSummaryDTO actionSummaryDTO = new ActionSummaryDTO();
		
		actionSummaryDTO = 	FakeObjectsFactory.getActionSummaryDTO();
		
		
		RestUrl urlDevelopment = new UrlDevelopment();
		urlDevelopment.setService("/publications/action-summary");
		urlDevelopment.setVersion("/v1");
		// urlDevelopment.setMethod(methodCreate);
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<ActionSummaryDTO> request = new HttpEntity<ActionSummaryDTO>(actionSummaryDTO);
		
		String jsonStringSent = objectMapper.writeValueAsString(actionSummaryDTO);

		LOGGER.debug("Object to sent:"+jsonStringSent);
		LOGGER.debug("Url:"+urlDevelopment.get());
		
		restTemplate.put(urlDevelopment.get(), actionSummaryDTO);
		
		LOGGER.debug("Updated object");
		
		/* In order to complete the test we have to read the object from then endpoint and then compare the values updated */
	    
	        
	}
		
	
	/************ DELETE *****************/
	
	@Test
	public void requestDeleteWithRestTemplate_V1() throws ClientProtocolException, IOException, JSONException, URISyntaxException {
		
		// String grantApplicationReference = "VS/2015/0329";
		
		String encodedParam = URLEncoder.encode("VS/2015/0329", "UTF-8");
		
		RestUrl urlDevelopment = new UrlDevelopment();
		urlDevelopment.setService("/publications");
		urlDevelopment.setVersion("/v1");
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		

		LOGGER.debug("Url:"+urlDevelopment.get());
		restTemplate.delete(urlDevelopment.get());
		
		// put(urlDevelopment.get(), actionSummaryDTO);
		LOGGER.debug("Updated object");
	    
	        
	}

	
	

	
	/**
	 * Non CRUD operations
	 */
	
	
	/************ PUBLISH (Post method)******/ 

	
	@Test
	public void requestPublishWithRestTemplate_V1() throws ClientProtocolException, IOException, JSONException, URISyntaxException {
		
		// String grantApplicationReference = "VS/2015/0329";
		
		String encodedParam = URLEncoder.encode("VS/2015/0329", "UTF-8");
		
		RestUrl urlDevelopment = new UrlDevelopment();
		urlDevelopment.setService("/publications/"+ encodedParam+"/publish");
		urlDevelopment.setVersion("/v1");
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<String> request = new HttpEntity<String>("",headers);

		LOGGER.debug("Url:"+urlDevelopment.get());
		restTemplate.postForEntity(urlDevelopment.get(), request, Void.class);
		
		// put(urlDevelopment.get(), actionSummaryDTO);
		LOGGER.debug("Updated object");
	    
	        
	}
	
	/************ PUBLISH (Patch method)******/
	
	// Pending to implement it. Try to find documentation.
	
	/************ UNPUBLISH *****************/
	
	@Test
	public void requestUnpublishWithRestTemplate_V1() throws ClientProtocolException, IOException, JSONException, URISyntaxException {
		
		// String grantApplicationReference = "VS/2015/0329";
		
		String encodedParam = URLEncoder.encode("VS/2015/0329", "UTF-8");
		
		RestUrl urlDevelopment = new UrlDevelopment();
		urlDevelopment.setService("/publications/"+ encodedParam+"/unpublish");
		urlDevelopment.setVersion("/v1");
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<String> request = new HttpEntity<String>("",headers);

		LOGGER.debug("Url:"+urlDevelopment.get());
		restTemplate.postForEntity(urlDevelopment.get(), request, Void.class);
		
		// put(urlDevelopment.get(), actionSummaryDTO);
		LOGGER.debug("Updated object");
	    
	        
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
