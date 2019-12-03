package eu.cec.empl.dms.integration.test.rest.catalogue;

import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.junit.BeforeClass;
import org.junit.Test;

import eu.cec.empl.dms.integration.test.BasicConfiguration;

public class ProgrammeTest extends BasicConfiguration{
	
	 @BeforeClass
	 public static void initializeRestURI() throws MalformedURLException
	 {
			url.setService("/programmes");
			url.setVersion("/v1");
	 }
	
	@Test
	public void requestProgrammes_V1_thenListIdsIsReceived()
			throws ClientProtocolException, IOException, JSONException {

		url.setParam(null);
		String expectedResponse = "[{\"id\":5,\"descriptionEn\":\"Erasmus+\",\"descriptionFr\":\"Erasmus+\",\"descriptionDe\":\"Erasmus+\",\"orderNumber\":5,\"active\":1},{\"id\":3,\"descriptionEn\":\"EaSI\",\"descriptionFr\":\"EaSI\",\"descriptionDe\":\"EaSI\",\"orderNumber\":3,\"active\":1},{\"id\":4,\"descriptionEn\":\"Prerogatives\",\"descriptionFr\":\"Prerogatives\",\"descriptionDe\":\"Prerogatives\",\"orderNumber\":4,\"active\":1},{\"id\":1,\"descriptionEn\":\"PROGRESS\",\"descriptionFr\":\"PROGRESS\",\"descriptionDe\":\"PROGRESS\",\"orderNumber\":2,\"active\":0},{\"id\":2,\"descriptionEn\":\"Other grants\",\"descriptionFr\":\"Other grants\",\"descriptionDe\":\"Other grants\",\"orderNumber\":1,\"active\":1}]";
		testRequestWithHttpClientBuilderAndJsonResponse(url,expectedResponse); 

	}

	@Test
	public void requestProgrammes_V1_thenObjectIsReceived()
			throws ClientProtocolException, IOException, JSONException {

		String param = "/1";
		url.setParam(param);
		
		String expectedResponse = "{\"id\":1,\"descriptionEn\":\"PROGRESS\",\"descriptionFr\":\"PROGRESS\",\"descriptionDe\":\"PROGRESS\",\"orderNumber\":2,\"active\":0}";
		testRequestWithHttpClientBuilderAndJsonResponse(url,expectedResponse); 
		
	}
	
	

}
