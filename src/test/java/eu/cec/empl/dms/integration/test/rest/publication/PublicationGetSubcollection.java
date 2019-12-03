package eu.cec.empl.dms.integration.test.rest.publication;

import static org.junit.Assert.*;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.easymock.internal.matchers.GreaterThan;
import org.json.JSONException;
import org.junit.BeforeClass;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;


import eu.cec.empl.dms.domain.business.client.catalogue.DirectTargetGroup;
import eu.cec.empl.dms.domain.business.client.catalogue.Organisation;
import eu.cec.empl.dms.domain.business.client.catalogue.UltimateTargetGroup;
import eu.cec.empl.dms.dto.ActionSummaryDTO;
import eu.cec.empl.dms.dto.PublicationDTO;
import eu.cec.empl.dms.dto.PublicationPortalDTO;
import eu.cec.empl.dms.dto.TranslationDto;

/*
 https://www.baeldung.com/integration-testing-in-spring
*/

import eu.cec.empl.dms.integration.test.BasicConfiguration;
import eu.cec.empl.dms.integration.test.RestUrl;
import eu.cec.empl.dms.integration.test.UrlDevelopment;
import eu.cec.empl.dms.test.tools.FakeObjectsFactory;

public class PublicationGetSubcollection extends BasicConfiguration{
	
	@BeforeClass
	public static void beforeClass() {
		url.setService("/publications");
		url.setVersion("/v1");
	}
		
	/************ READ ****************
	 * REST Template exchange	
	 */
	
	@Test
	public void requestCountriesByPublicationID_thenGetListCountriesIds() throws ClientProtocolException, IOException, JSONException {
		
		LOGGER.info("*************** find publication countries by publication id *************");
		
		String publicationRestService = "/publications/22/countries";
        String serviceVersion = "/v1";
        
		url.setService(publicationRestService);
		url.setVersion(serviceVersion);
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		LOGGER.debug("************** Calling (exchange) "+url.get());
		ResponseEntity<List<Long>> response = restTemplate.exchange(url.get(),HttpMethod.GET,null,new ParameterizedTypeReference<List<Long>>(){});
		
		List<Long> countries = response.getBody();
		
		assertTrue(countries.size()>0);

		LOGGER.debug("****** Countries Ids received ************************");
		LOGGER.debug(countries.toString());
	        
	}
	
	@Test
	public void requestCoordinatorByPublicationID_thenGetCoordinator() throws ClientProtocolException, IOException, JSONException {
		
		LOGGER.info("*************** find publication coordinator by publication id *************");
		
		String publicationRestService = "/publications/22/coordinator";
        String serviceVersion = "/v1";
		url.setService(publicationRestService);
		url.setVersion(serviceVersion);
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		LOGGER.debug("************** Calling (getForObject) "+url.get());
		Organisation organisation = restTemplate.getForObject(url.get(),Organisation.class);
		
		assertEquals(organisation.getName(), "European Trade Union Committee for Education - Comité Synd¡cal Européen pour l'Education");
		String jsonStringReceived = objectMapper.writeValueAsString(organisation);
		
		LOGGER.debug("****** JSON received ************************");
		LOGGER.debug(jsonStringReceived);
	        
	}
	
	
	@Test
	public void requestListOrganisationsByPublicationID_thenGetList() throws ClientProtocolException, IOException, JSONException {
		
		/* 
		 * It does not make sense that we return the Organisations and then we return the Ids for the Direct target groups and 
		 * ultimate target groups
		 */
		
		LOGGER.info("*************** find publication partners by publication id *************");
		
		String publicationRestService = "/publications/22/partners";
        String serviceVersion = "/v1";
        
		url.setService(publicationRestService);
		url.setVersion(serviceVersion);
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		

		LOGGER.debug("************** Calling (exchange) "+url.get());
		ResponseEntity<List<Organisation>> response = restTemplate.exchange(url.get(),HttpMethod.GET,null,new ParameterizedTypeReference<List<Organisation>>(){});
		
		List<Organisation> organisations = response.getBody();
		
		assertTrue(organisations.size() >0);
		
		LOGGER.debug("Object received"+objectMapper.writeValueAsString(organisations));
	        
	}
	
	
	@Test
	public void requestTranslationsByPublicationID_thenGetList() throws ClientProtocolException, IOException, JSONException {
		
		LOGGER.info("*************** find publication action summary by publication id *************");
		
		String publicationRestService = "/publications/22/action";
        String serviceVersion = "/v1";
        
		url.setService(publicationRestService);
		url.setVersion(serviceVersion);
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		LOGGER.debug("************** Calling (exchange) "+url.get());
		ResponseEntity<List<TranslationDto>> response = restTemplate.exchange(url.get(),HttpMethod.GET,null,new ParameterizedTypeReference<List<TranslationDto>>(){});
		
		List<TranslationDto> translation = response.getBody();
		
		LOGGER.debug("Object received"+objectMapper.writeValueAsString(translation.get(0)));
	        
	}
	
	
	@Test
	public void requestUltimateTargerGroups_thenGetList() throws ClientProtocolException, IOException, JSONException {
		
		LOGGER.info("*************** find publication ultimate target groups Ids by publication id *************");
		
		String publicationRestService = "/publications/22/ultimate-target-groups";
        String serviceVersion = "/v1";
        
		url.setService(publicationRestService);
		url.setVersion(serviceVersion);
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		LOGGER.debug("************** Calling (exchange) "+url.get());		
		ResponseEntity<List<UltimateTargetGroup>> response = restTemplate.exchange(url.get(),HttpMethod.GET,null,new ParameterizedTypeReference<List<UltimateTargetGroup>>(){});
		
		List<UltimateTargetGroup> listUltimateTargetGroups = response.getBody();
		
		LOGGER.debug("Object received"+objectMapper.writeValueAsString(listUltimateTargetGroups.get(0)));
	        
	}
	

	@Test
	public void requestDirectTargerGroups_thenGetList() throws ClientProtocolException, IOException, JSONException {
		
		LOGGER.info("*************** find publication direct target groups Ids by publication id *************");
		
		String publicationRestService = "/publications/22/direct-target-groups";
        String serviceVersion = "/v1";
        
		url.setService(publicationRestService);
		url.setVersion(serviceVersion);
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		LOGGER.debug("************** Calling (exchange) "+url.get());
		ResponseEntity<List<DirectTargetGroup>> response = restTemplate.exchange(url.get(),HttpMethod.GET,null,new ParameterizedTypeReference<List<DirectTargetGroup>>(){});
		
		List<DirectTargetGroup> listDirectTargetGroup = response.getBody();
		
		LOGGER.debug("Object received"+objectMapper.writeValueAsString(listDirectTargetGroup));
	        
	}
	

}
