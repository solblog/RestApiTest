package eu.cec.empl.dms.integration.test.security;


import java.io.IOException;
import java.net.MalformedURLException;
import java.security.SecureRandom;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import eu.cec.empl.dms.integration.test.BasicConfiguration;

public class SecurityTest extends BasicConfiguration {
	
	@BeforeClass 
	public static void initializeRestURI() throws MalformedURLException
	{
			url.setService("/token");
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
	public void testRequestToken_Exchange() throws ClientProtocolException, IOException, JSONException {
		
		url.setService("/token");
		url.setVersion("/v1");
		url.setParam(null);
		
		headers.add("User", "pepito");
		
		HttpEntity<String> request = new HttpEntity<String>("",headers);
		
		// restTemplate.put(url.get(), request);
		
		ResponseEntity<Long> id = restTemplate.exchange(url.get(),HttpMethod.GET,request,Long.class);		
		
		LOGGER.debug("Token id:"+id.getBody());
		
		
	}
	
	@Test
	public void testRequestToken_GetForObject() throws ClientProtocolException, IOException, JSONException {
		
		url.setService("/token");
		url.setVersion("/v1");
		url.setParam(null);
		
		headers.add("User", "pepito");
		
		HttpEntity<String> request = new HttpEntity<String>("",headers);
		
		// restTemplate.put(url.get(), request);
		
		
		Long id = restTemplate.getForObject(url.get(),Long.class);		
		
		LOGGER.debug("Token id:"+id);
		
		
	}
	
	
	@Test
	public void testSecurity_V1() throws ClientProtocolException, IOException, JSONException {
		
		url.setService("/token/consume");
		url.setVersion("/v1");
		url.setParam(null);
		
		/**
		 * Connect to the database and get a token not consumed
		 */
		headers.add("User", "pepito");
		headers.add("Auth-Token", "[B@29020e6");
		
		HttpEntity<String> request = new HttpEntity<String>("",headers);
		
		restTemplate.put(url.get(), request);
		
	}
	
	private String generateToken(){
		
		SecureRandom random = new SecureRandom();
		byte bytes[] = new byte[20];
		random.nextBytes(bytes);
		String token = bytes.toString();
		return token;
		
	}
	
	

}
