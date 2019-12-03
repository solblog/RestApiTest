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

import eu.cec.empl.dms.domain.business.client.catalogue.UltimateTargetGroup;
import eu.cec.empl.dms.integration.test.BasicConfiguration;

public class UltimateTargetGroupTest extends BasicConfiguration{
	
	 @BeforeClass 
	 public static void initializeRestURI() throws MalformedURLException
	 {
			url.setService("/ultimate-target-groups");
			url.setVersion("/v1");
	 }
	
	@Test
	public void requestUltimateTargetGroups_V1_thenListUltimateTargerGroupsIsReceived()
			throws ClientProtocolException, IOException, JSONException {

		url.setParam(null);
		LOGGER.debug("Call:"+url.get());
		
		ResponseEntity<List<UltimateTargetGroup>> response = restTemplate.exchange(url.get(),HttpMethod.GET,null,new ParameterizedTypeReference<List<UltimateTargetGroup>>(){});
		List<UltimateTargetGroup> listUltimateTargetGroup = response.getBody();
		
		assertTrue(listUltimateTargetGroup.size()>10);
		LOGGER.debug("Object received"+objectMapper.writeValueAsString(listUltimateTargetGroup));
		
	}

	@Test
	public void requestUltimateTargetGroupById_V1_thenObjectIsReceived()
			throws ClientProtocolException, IOException, JSONException {

		String param = "/1";
		url.setParam(param);
		
		String expectedResponse = "{\"id\":1,\"descriptionEn\":\"Unemployed\",\"descriptionFr\":\"Chômeurs\",\"descriptionDe\":\"Arbeitslose\",\"orderNumber\":1}";
		testRequestWithHttpClientBuilderAndJsonResponse(url,expectedResponse); 

	}
	

}
