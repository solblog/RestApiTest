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
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
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

public class PublicationNoneCRUDTest extends BasicConfiguration{
	
	
	/**
	 Source: https://www.baeldung.com/integration-testing-in-spring
	 Reviewed: 2019/10/31
	*/
	
	
	/************ PUBLISH (Post method)******/ 

	
	@Test
	public void publish_Publication() throws ClientProtocolException, IOException, JSONException, URISyntaxException {
		
		//TODO: Patch method
		
		LOGGER.debug("**** Publish publication ******");
		
		LOGGER.debug("**** Find Publication to publish by Grant agreement reference ******");
		
		PublicationDTO publicationDTO;
		url.setService("/publications");
		url.setVersion("/v1");
		String encodedParam = URLEncoder.encode("VS/2015/0329", "UTF-8");
		url.setParam("?grantAgreementReference="+encodedParam);
		
		LOGGER.debug("Calling (getForObject) "+url.get());
    	
    	publicationDTO = restTemplate.getForObject(url.get(),PublicationDTO.class);
    	
    	url.setService("/publications/{id}/publish");
		
		HttpEntity<String> request = new HttpEntity<String>("",headers);
		url.setParam(null);
		
		Map < String, String > params = new HashMap < String, String > ();
	    params.put("id", publicationDTO.getId().toString());
		
		LOGGER.debug("Calling (put) "+url.get());
		restTemplate.put(url.get(), request, params);
		
		LOGGER.debug("Published object");
		
	    
	        
	}
	
	/************ PUBLISH (Patch method)******/
	
	// Pending to implement it. Try to find documentation.
	
	/************ UNPUBLISH *****************/
	
	@Test
	public void unpublish_Publication() throws ClientProtocolException, IOException, JSONException, URISyntaxException {
		
		
		LOGGER.debug("**** Unpublish publication ******");
		
		LOGGER.debug("**** Find Publication to unpublish by Grant agreement reference ******");
		
		PublicationDTO publicationDTO;
		url.setService("/publications");
		url.setVersion("/v1");
		String encodedParam = URLEncoder.encode("VS/2015/0329", "UTF-8");
		url.setParam("?grantAgreementReference="+encodedParam);
		
		LOGGER.debug("Calling (getForObject) "+url.get());
		
    	publicationDTO = restTemplate.getForObject(url.get(),PublicationDTO.class);
    	
    	url.setService("/publications/{id}/publish");
		
		HttpEntity<String> request = new HttpEntity<String>("",headers);
		url.setParam(null);
		Map < String, String > params = new HashMap < String, String > ();
	    params.put("id", publicationDTO.getId().toString());
		
	    LOGGER.debug("Calling (put) "+url.get());
		
		restTemplate.put(url.get(), request, params);
		
		// put(urlDevelopment.get(), actionSummaryDTO);
		LOGGER.debug("Unpublished object");
	    
	        
	}
	

}
