package eu.cec.empl.dms.integration.test.rest.publication;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import eu.cec.empl.dms.domain.security.Token;
import eu.cec.empl.dms.dto.ActionSummaryDTO;
import eu.cec.empl.dms.dto.GeneralInfoDTO;
import eu.cec.empl.dms.dto.PublicationDTO;
import eu.cec.empl.dms.dto.PublicationPortalDTO;

/**
 Source: https://www.baeldung.com/integration-testing-in-spring
 Reviewed: 2019/10/31
*/

import eu.cec.empl.dms.integration.test.BasicConfiguration;
import eu.cec.empl.dms.test.tools.FakeObjectsFactory;

public class PublicationCRUD extends BasicConfiguration{
	
	
	@BeforeClass
	public static void beforeClass() {
		url.setService("/publications");
		url.setVersion("/v1");
	}
	
	
	/************ CREATE *****************/
	
	/**
	 * postForEntity/GetForObject
	 */
	
	
	@Test
	public void create_Publication_PostForEntity() throws ClientProtocolException, IOException, JSONException {
		
		PublicationDTO publicationDTOsent = null,publicationDTOreceived;
		ResponseEntity<String> responseCreate;
		
		
		LOGGER.info("*************** Creating Publication fake object *************");
		
		publicationDTOsent = FakeObjectsFactory.getPublicationDTO();
		HttpEntity<PublicationDTO> request = new HttpEntity<PublicationDTO>(publicationDTOsent);
		String jsonStringSent = objectMapper.writeValueAsString(publicationDTOsent);
		
		LOGGER.info("Object created:"+jsonStringSent);
		
		
		LOGGER.info("*************** Get Token id *************");
		url.setService("/token");
		url.setVersion("/v1");
		Long tokenId = restTemplate.getForObject(url.get(),Long.class);
		LOGGER.info("Token id:"+tokenId);
		
		LOGGER.info("*************** Get Token *************");
		/**
		 * Pending to get it through the database
		 */
		
		Map < String, String > paramToken = new HashMap < String, String > ();
		paramToken.put("id", tokenId.toString());
		url.setParam("/{id}");
		
		LOGGER.debug("Call Delete:"+url.get());
		// ResponseEntity<Token> responsEntity = restTemplate.exchange(url.get(),HttpMethod.GET,entity,Token.class,paramToken); 
		Token token = restTemplate.getForObject(url.get(),Token.class,paramToken);
		url.setParam(null);
		
		LOGGER.info("*************** Updating the headers *************");
		/* security */
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(headers);
				
		
		LOGGER.debug("************** Calling (postForEntity) "+url.get());
		
		url.setService("/publications");
		url.setVersion("/v1");
		
		responseCreate = restTemplate.postForEntity(url.get(), request, String.class);
		
		LOGGER.debug("Response body received:"+responseCreate.getBody());

		publicationDTOreceived = objectMapper.readValue(responseCreate.getBody(), PublicationDTO.class);
		
		String jsonStringReceived = objectMapper.writeValueAsString(publicationDTOreceived);
		
		LOGGER.debug("****** JSON received ************************");

		LOGGER.debug(jsonStringReceived);
		
		LOGGER.debug("*********Running Test **********************");
		
		assertEquals(publicationDTOsent.getGrantAgreementDTO().getReference() , publicationDTOreceived.getGrantAgreementDTO().getReference());
		
		
		LOGGER.debug("********* Find object created by grantAgreementReference **********************");
		LOGGER.debug("Grant agreement regference:"+publicationDTOsent.getGrantAgreementDTO().getReference());
		
		url.setService("/publications");
		String encodedParam = URLEncoder.encode(publicationDTOsent.getGrantAgreementDTO().getReference(), "UTF-8");
		url.setParam("?grantAgreementReference="+encodedParam);
		
		LOGGER.debug("************** Calling (getForObject)"+url.get());
    	
		publicationDTOreceived = restTemplate.getForObject(url.get(),PublicationDTO.class);

		jsonStringReceived = objectMapper.writeValueAsString(publicationDTOreceived);
		
		LOGGER.debug("****** JSON received ************************");

		LOGGER.debug(jsonStringReceived);
		
		LOGGER.debug("********* Deleting publication (delete) **********************");
		LOGGER.debug("Publication id:"+publicationDTOreceived.getId());
		
		url.setMethod(null);
		url.setParam("/{id}");
		
		Map < String, String > params = new HashMap < String, String > ();
		params.put("id", publicationDTOreceived.getId().toString());
		
		LOGGER.debug("Call Delete:"+url.get());
		restTemplate.delete(url.get(), params);
        
	        
	}
	
	/************ READ *****************/

	/**
	 * HeadForHeaders
	 */
	
	@Test
	public void checkHeaders_PublicationExist_ByGrantAgreement_Path() throws ClientProtocolException, IOException, JSONException {
		
		url.setService("/publications/grantagreement");
		url.setVersion("/v1/");
		
		String encodedReference2 = URLEncoder.encode("VS/2080/701","UTF-8");
		url.setParam(encodedReference2);
		
		LOGGER.debug("URL:"+url.get());
		
		try
		{
			HttpHeaders httpHeader = restTemplate.headForHeaders(url.get());
			LOGGER.debug(httpHeader.values().toString());
			
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
		
		
		url.setService("/publications/grantagreement");
		url.setVersion("/v1/");
		
		String encodedReference3 = URLEncoder.encode("VS/2012/0155","UTF-8");
		url.setParam(encodedReference3);
		
		LOGGER.debug("URL:"+url.get());
		
		try
		{
			HttpHeaders httpHeader = restTemplate.headForHeaders(url.get());
			LOGGER.debug(httpHeader.values().toString());
			
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
		
		url.setVersion("/V1");
		

	}
	
	/**
	 * HeadForHeaders
	 */
	
	
	@Test
	public void checkHeaders_PublicationExist_ByGrantAgreement_Parameter() throws ClientProtocolException, IOException, JSONException {
		
		url.setService("/publications");
		url.setVersion("/v1");
		
		String encodedReference2 = URLEncoder.encode("VS/2080/701","UTF-8");
		
		url.setParam("?grantAgreementReference="+encodedReference2);
		
		LOGGER.debug("URL:"+url.get());
		
		try
		{
			HttpHeaders httpHeader = restTemplate.headForHeaders(url.get());
			LOGGER.debug(httpHeader.values().toString());
			
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
		
		
		String encodedReference3 = URLEncoder.encode("VS/2012/0155","UTF-8");
		
		url.setParam("?grantAgreementReference="+encodedReference3);
		
		
		LOGGER.debug("URL:"+url.get());
		
		try
		{
			HttpHeaders httpHeader = restTemplate.headForHeaders(url.get());
			LOGGER.debug(httpHeader.values().toString());
			
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
		
		url.setVersion("/v1");
		url.setParam(null);

	}
	
	/**
	 * GetForObject
	 */
	
	@Test
	public void get_Publication_ByGrantAgreementReference_Path() throws ClientProtocolException, IOException, JSONException {
		
		
		LOGGER.debug("**** Call find Publication by Grant Agreement path ******");
		
		url.setService("/publications/grantagreement");
		url.setVersion("/v1/");
        
		String encodedParam = URLEncoder.encode("VS/2015/0329", "UTF-8");
		url.setParam(encodedParam);;
		
		LOGGER.debug("Calling (getForObject) "+url.get());

    	PublicationDTO publicationDTO = restTemplate.getForObject(url.get(),PublicationDTO.class);
    	
    	assertEquals("VS/2015/0329", publicationDTO.getGrantAgreementDTO().getReference());
    	
    	LOGGER.debug("****** JSON received ************************");
    	
    	String jsonStringReceived = objectMapper.writeValueAsString(publicationDTO);
		LOGGER.debug(jsonStringReceived);
    	
	        
	}
	
	/**
	 * GetForObject
	 */
	
	
	@Test
	public void get_Publication_ById_Path() throws ClientProtocolException, IOException, JSONException {
		
		
		/* Before findById we have to find by GranteAgreement */
		
		LOGGER.debug("**** Call find Publication by Grant Agreement param ******");
		
		PublicationDTO publicationDTO;
		url.setService("/publications");
		String encodedParam = URLEncoder.encode("VS/2015/0329", "UTF-8");
		url.setParam("?grantAgreementReference="+encodedParam);
		
		LOGGER.debug("Calling (getForObject) "+url.get());
    	
    	publicationDTO = restTemplate.getForObject(url.get(),PublicationDTO.class);
    	
    	LOGGER.debug("Running test");
    	
    	assertEquals("VS/2015/0329", publicationDTO.getGrantAgreementDTO().getReference());
    	
    	LOGGER.debug("**** Call find Publication by Id path ******");
    	
    	url.setService("/publications");
    	url.setVersion("/v1/");
    	url.setParam("{id}");
    	
    	Map < String, String > params = new HashMap < String, String > ();
	    params.put("id", publicationDTO.getId().toString());
    	
	    
	    LOGGER.debug("Calling (getForObject) "+url.get());
	    
	    PublicationPortalDTO publicationPortalDTO = restTemplate.getForObject(url.get(),PublicationPortalDTO.class,params);
    	
    	assertEquals("VS/2015/0329", publicationPortalDTO.getReference());
    	
    	LOGGER.debug("****** JSON received ************************");
    	
    	String jsonStringReceived = objectMapper.writeValueAsString(publicationDTO);
		LOGGER.debug(jsonStringReceived);
    	

	        
	}
	
	/**
	 * GetForObject
	 */
	
	@Test
	public void get_Publication_ByGrantAgreement_Param() throws ClientProtocolException, IOException, JSONException {
		
		LOGGER.debug("**** Call find Publication by Grant Agreement param ******");
		
		PublicationDTO publicationDTO;
		
		url.setService("/publications");
        
		String encodedParam = URLEncoder.encode("VS/2015/0329", "UTF-8");
		url.setParam("?grantAgreementReference={grantAgreementReference}");
		
		Map < String, String > params = new HashMap < String, String > ();
	    params.put("grantAgreementReference", encodedParam);
		
		LOGGER.debug("Calling (getForObject) "+url.get());
    	
    	publicationDTO = restTemplate.getForObject(url.get(),PublicationDTO.class,params);
    	
    	String jsonStringSent = objectMapper.writeValueAsString(publicationDTO);
    	
    	LOGGER.debug("****** JSON received ************************");
    	
    	String jsonStringReceived = objectMapper.writeValueAsString(publicationDTO);
		LOGGER.debug(jsonStringReceived);
	        
	}

	
	
/************** UPDATE ************************************************************************************************************************/
	
	/**
	 * GetForObject/Put
	 */
	
	
	@Test
	public void update_Publication_GeneralInfoView() throws ClientProtocolException, IOException, JSONException {
		
		
		LOGGER.debug("**** Update Publication General info view ******");
		
		
		LOGGER.debug("**** Find Publication to update by Grant agreement reference ******");
		
		PublicationDTO publicationDTO;
		url.setService("/publications");
		String encodedParam = URLEncoder.encode("VS/2015/0329", "UTF-8");

		url.setParam("?grantAgreementReference="+encodedParam);
				
		LOGGER.debug("Calling (getForObject) "+url.get());
    	
    	publicationDTO = restTemplate.getForObject(url.get(),PublicationDTO.class);
		
    	LOGGER.debug("****** JSON received ************************");
    	String jsonStringReceived = objectMapper.writeValueAsString(publicationDTO);
		LOGGER.debug(jsonStringReceived);
    	
    	LOGGER.debug("****** Generating fake General info data ************************");
		
		GeneralInfoDTO generalInfoDTO = FakeObjectsFactory.getGeneralInfoDTO();
		
		LOGGER.debug("****** JSON general info to update ************************");
		String jsonStringSent = objectMapper.writeValueAsString(generalInfoDTO);

		LOGGER.debug(jsonStringSent);
		
		url.setService("/publications/{id}/general-info");
		
	  	Map < String, String > params = new HashMap < String, String > ();
	    params.put("id", publicationDTO.getId().toString());
	    
		LOGGER.debug("Calling (put)"+url.get());
		restTemplate.put(url.get(), generalInfoDTO,params);
		
		LOGGER.debug("Updated object");
		
		/**
		 *   In order to complete the test we have to read the object from 
		 *  then end-point and then compare the values updated 
		 */
	        
	}

	/**
	 * GetForObject/Put
	 */
	
	
	@Test
	public void update_Publication_Summary() throws ClientProtocolException, IOException, JSONException {
		
		
		LOGGER.debug("**** Update Publication summary ******");
		
		PublicationDTO publicationDTO;
		url.setService("/publications");
		String encodedParam = URLEncoder.encode("VS/2015/0329", "UTF-8");
				

		LOGGER.debug("**** Find Publication to update by Grant agreement reference ******");
		
		url.setParam("?grantAgreementReference="+encodedParam);
		
		LOGGER.debug("Calling (getForObject) "+url.get());
    	
    	publicationDTO = restTemplate.getForObject(url.get(),PublicationDTO.class);
		
    	LOGGER.debug("****** Generating fake Action summary data ************************");
    	
    	ActionSummaryDTO actionSummaryDTO = new ActionSummaryDTO();
		
		actionSummaryDTO = 	FakeObjectsFactory.getActionSummaryDTO();
		
		LOGGER.debug("****** JSON general info to update ************************");
		String jsonStringSent = objectMapper.writeValueAsString(actionSummaryDTO);
		LOGGER.debug(jsonStringSent);
		
		url.setService("/publications/{id}/action-summary");
		
		// HttpEntity<ActionSummaryDTO> request = new HttpEntity<ActionSummaryDTO>(actionSummaryDTO);
		// String jsonStringSent = objectMapper.writeValueAsString(actionSummaryDTO);
		
		url.setParam(null);
		
		Map < String, String > params = new HashMap < String, String > ();
	    params.put("id", publicationDTO.getId().toString());
		
		LOGGER.debug("Calling (put) "+url.get());
	    restTemplate.put(url.get(), actionSummaryDTO,params);
		
		LOGGER.debug("Updated object");
		
		/**
		 *  In order to complete the test we have to read the object from 
		 *  then end-point and then compare the values updated 
		 */
	    
	        
	}
		
	
/************ DELETE ******************************************************************************************************************************************/
	
	@Test
	public void delete_Publication_delete() throws ClientProtocolException, IOException, JSONException, URISyntaxException {
		
		PublicationDTO publicationDTOsent = null,publicationDTOreceived;
		ResponseEntity<String> responseCreate;
		
		LOGGER.info("*************** Creating Publication fake object *************");
		
		publicationDTOsent = FakeObjectsFactory.getPublicationDTO();
		HttpEntity<PublicationDTO> request = new HttpEntity<PublicationDTO>(publicationDTOsent);
		String jsonStringSent = objectMapper.writeValueAsString(publicationDTOsent);
		
		LOGGER.info("Object created:"+jsonStringSent);
		
		
		LOGGER.debug("************** Calling (postForEntity) "+url.get());
		
		responseCreate = restTemplate.postForEntity(url.get(), request, String.class);
		
		LOGGER.debug("Response body received:"+responseCreate.getBody());

		publicationDTOreceived = objectMapper.readValue(responseCreate.getBody(), PublicationDTO.class);
		
		String jsonStringReceived = objectMapper.writeValueAsString(publicationDTOreceived);
		
		LOGGER.debug("****** JSON received ************************");

		LOGGER.debug(jsonStringReceived);
		
		LOGGER.debug("*********Running Test **********************");
		
		assertEquals(publicationDTOsent.getGrantAgreementDTO().getReference() , publicationDTOreceived.getGrantAgreementDTO().getReference());
		
		
		LOGGER.debug("********* Find object created by grantAgreementReference **********************");
		LOGGER.debug("Grant agreement regference:"+publicationDTOsent.getGrantAgreementDTO().getReference());
		
		url.setService("/publications");
		String encodedParam = URLEncoder.encode(publicationDTOsent.getGrantAgreementDTO().getReference(), "UTF-8");
		url.setParam("?grantAgreementReference="+encodedParam);
		
		LOGGER.debug("************** Calling (getForObject)"+url.get());
    	
		publicationDTOreceived = restTemplate.getForObject(url.get(),PublicationDTO.class);

		jsonStringReceived = objectMapper.writeValueAsString(publicationDTOreceived);
		
		LOGGER.debug("****** JSON received ************************");

		LOGGER.debug(jsonStringReceived);
		
		LOGGER.debug("********* Deleting publication (delete) **********************");
		LOGGER.debug("Publication id:"+publicationDTOreceived.getId());
		
		url.setMethod(null);
		url.setParam("/{id}");
		
		Map < String, String > params = new HashMap < String, String > ();
		params.put("id", publicationDTOreceived.getId().toString());
		
		LOGGER.debug("Call Delete:"+url.get());
		restTemplate.delete(url.get(), params);
	        
	}
	

}
