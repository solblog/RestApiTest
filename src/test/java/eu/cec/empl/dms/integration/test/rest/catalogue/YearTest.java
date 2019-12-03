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
import eu.cec.empl.dms.integration.test.BasicConfiguration;

public class YearTest extends BasicConfiguration{

   @BeforeClass
   public static void initializeRestURI() throws MalformedURLException
   {
		url.setService("/years");
		url.setVersion("/v1");
   }
	
	
	@Test
	public void requestCountries_V1_thenListCountriesIsReceived()
			throws ClientProtocolException, IOException, JSONException {
		
		LOGGER.debug("Call:"+url.get());
		
		url.setParam(null);
		
		ResponseEntity<List<Integer>> response = restTemplate.exchange(url.get(),HttpMethod.GET,null,new ParameterizedTypeReference<List<Integer>>(){});
		
		List<Integer> listYears = response.getBody();

		assertTrue(listYears.size()>30);

		LOGGER.debug("Object received"+objectMapper.writeValueAsString(listYears));

	}

}
