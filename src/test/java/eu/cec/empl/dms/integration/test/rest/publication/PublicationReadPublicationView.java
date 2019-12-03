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
import eu.cec.empl.dms.dto.GeneralInfoDTO;
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

public class PublicationReadPublicationView extends BasicConfiguration{
	
	@BeforeClass
	public static void beforeClass() {
		url.setService("/publications");
		url.setVersion("/v1");
	}
		
	/************ READ *****************/
		
	@Test
	public void requestReadActionSummaryByGrantAGreementReference_V1() throws ClientProtocolException, IOException, JSONException {

		String publicationRestService = "/publications/{grantAgreementReference}/action-summary";

		String encodedParam = URLEncoder.encode("VS/2015/0329", "UTF-8");
		url.setService(publicationRestService);
		
		url.setParam(encodedParam);
		
		LOGGER.debug("Call:"+url.get());
		ActionSummaryDTO actionSummaryDTO = restTemplate.getForObject(url.get(),ActionSummaryDTO.class);
		
    	LOGGER.debug("Object received"+objectMapper.writeValueAsString(actionSummaryDTO));
		
	}
	
	@Test
	public void requestReadActionSummaryById_V1() throws ClientProtocolException, IOException, JSONException {
		
		
		// Get ID 
		
		PublicationDTO publicationDTO;
		
		url.setService("/publications");
        
		String encodedParam = URLEncoder.encode("VS/2015/0329", "UTF-8");
				
		url.setParam("?grantAgreementReference="+encodedParam);
		
		LOGGER.debug("Call:"+url.get());
    	
    	publicationDTO = restTemplate.getForObject(url.get(),PublicationDTO.class);
		
    	// Get view
		
		String publicationRestService = "/publications/{id}/action-summary";
		
		url.setService(publicationRestService);

	  	Map < String, String > params = new HashMap < String, String > ();
	    params.put("id", publicationDTO.getId().toString());
		
		LOGGER.debug("Call:"+url.get());

		ActionSummaryDTO actionSummaryDTO = restTemplate.getForObject(url.get(),ActionSummaryDTO.class,params);
		
    	LOGGER.debug("Object received"+objectMapper.writeValueAsString(actionSummaryDTO));
		
	}
	

	@Test
	public void requestReadGeneralInfoByGrantAGreementReference_V1() throws ClientProtocolException, IOException, JSONException {
		
		String publicationRestService = "/publications/{grantAgreementReference}/general-info";

		String encodedParam = URLEncoder.encode("VS/2015/0329", "UTF-8");
        
		url.setService(publicationRestService);
		url.setParam(encodedParam);;
		
		LOGGER.debug("Call:"+url.get());
		GeneralInfoDTO generalInfoDTO = restTemplate.getForObject(url.get(),GeneralInfoDTO.class);
		
    	LOGGER.debug("Object received"+objectMapper.writeValueAsString(generalInfoDTO));
		
	}

	
	
	
	@Test
	public void requestReadGeneralInfoById_V1() throws ClientProtocolException, IOException, JSONException {
		
		
		// Read
		
		PublicationDTO publicationDTO;
		
		url.setService("/publications");
        
		String encodedParam = URLEncoder.encode("VS/2015/0329", "UTF-8");
				
		url.setParam("?grantAgreementReference="+encodedParam);
		
		LOGGER.debug("Call:"+url.get());
    	
    	publicationDTO = restTemplate.getForObject(url.get(),PublicationDTO.class);

    	// Get view
    	
    	String publicationRestService = "/publications/{id}/general-info";
		
		url.setService(publicationRestService);
		
		url.setParam(null);
		
		Map < String, String > params = new HashMap < String, String > ();
	    params.put("id", publicationDTO.getId().toString());
		
		
		LOGGER.debug("Call:"+url.get());
		GeneralInfoDTO generalInfoDTO = restTemplate.getForObject(url.get(),GeneralInfoDTO.class,params);
		
    	LOGGER.debug("Object received"+objectMapper.writeValueAsString(generalInfoDTO));
    	
    	
		
	}

	
	/* Publigrant Test */
	
	
	@Test
	public void requestPublicationPortalDTOById_thenReturnPublication() throws ClientProtocolException, IOException, JSONException {
		
		String publicationRestService = "/publications";
        String serviceVersion = "/v2/";
        
		url.setService(publicationRestService);
		url.setVersion(serviceVersion);
		url.setParam("22");
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		LOGGER.debug("Call:"+url.get());
		
		PublicationPortalDTO publicationPortalDTO = restTemplate.getForObject(url.get(),PublicationPortalDTO.class);
		
		assertEquals(publicationPortalDTO.getId() , new Long("22"));
		
		String jsonStringSent = objectMapper.writeValueAsString(publicationPortalDTO);
		LOGGER.debug("Object to sent:"+jsonStringSent);
		
	        
	}

	

}
