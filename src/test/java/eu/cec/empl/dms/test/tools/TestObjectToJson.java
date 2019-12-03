package eu.cec.empl.dms.test.tools;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import eu.cec.empl.dms.domain.business.client.catalogue.DirectTargetGroup;

public class TestObjectToJson {
	
	ObjectMapper objectMapper = new ObjectMapper();
	DirectTargetGroup dtg1,dtg2;
	
	@Test
    public void whenConvertObjectToJson() throws IOException {
		
		dtg1 = FakeObjectsFactory.getDirectTargetGroupEntity(new DirectTargetGroup());
	
		String jsonString = objectMapper.writeValueAsString(dtg1);
		
		dtg2 = objectMapper.readValue(jsonString, DirectTargetGroup.class);  
		
		assertEquals(dtg1.getDescriptionEn(), dtg2.getDescriptionEn());
		assertEquals(dtg1.getDescriptionFr(), dtg2.getDescriptionFr());
		assertEquals(dtg1.getDescriptionDe(), dtg2.getDescriptionDe());
		
    }
 
    @Test
    public void whenConvertJsonToObject() throws JsonParseException, JsonMappingException, IOException {
    	
    	   String jsonString1 = "{\"id\":null,\"descriptionEn\":\"Oaked Arrogant Bastard Ale\",\"descriptionFr\":\"Picasso\",\"descriptionDe\":\"Yorko Terys\",\"orderNumber\":240}";
    	   
    	   dtg1 = objectMapper.readValue(jsonString1, DirectTargetGroup.class);
    	   
    	   String jsonString2 = objectMapper.writeValueAsString(dtg1);
    	   
    	   assertEquals(jsonString1, jsonString2);
        
    }
	

}
