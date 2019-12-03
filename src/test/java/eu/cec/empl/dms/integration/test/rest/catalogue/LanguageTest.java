package eu.cec.empl.dms.integration.test.rest.catalogue;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import eu.cec.empl.dms.domain.catalogue.Country;
import eu.cec.empl.dms.domain.catalogue.Language;
import eu.cec.empl.dms.integration.test.BasicConfiguration;

public class LanguageTest extends BasicConfiguration{
	
	 @BeforeClass
	 public static void initializeRestURI() throws MalformedURLException
	 {
			url.setService("/languages");
			url.setVersion("/v1");
	 }
	
	@Test
	public void requestProgrammes_V1_thenListIdsIsReceived()
			throws ClientProtocolException, IOException, JSONException {

		LOGGER.debug("Call:"+url.get());
		url.setParam(null);
		
		ResponseEntity<List<Language>> response = restTemplate.exchange(url.get(),HttpMethod.GET,null,new ParameterizedTypeReference<List<Language>>(){});
		
		List<Language> listLanguages = response.getBody();
		
		assertTrue(listLanguages.size()>26);

		LOGGER.debug("Object received"+objectMapper.writeValueAsString(listLanguages));
		
		
	}

	@Test
	public void requestProgrammes_V1_thenObjectIsReceived()
			throws ClientProtocolException, IOException, JSONException {

		String param = "/1";
		url.setParam(param);
		
		String expectedResponse = "{\"id\":1,\"descriptionEn\":\"ES - Español\",\"descriptionFr\":\"ES - Español\",\"descriptionDe\":\"ES - Español\",\"orderNumber\":6,\"code\":\"ES\",\"active\":1,\"official\":0}";
		testRequestWithHttpClientBuilderAndJsonResponse(url,expectedResponse); 
		
	}
	
	

}
