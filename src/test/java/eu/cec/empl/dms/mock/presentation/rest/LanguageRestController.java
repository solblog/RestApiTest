package eu.cec.empl.dms.mock.presentation.rest;

import java.util.ArrayList;
import java.util.List;
import eu.cec.empl.dms.mock.domain.catalogue.Language;
import eu.cec.empl.dms.mock.services.LanguageService;

/*
@Api(value="/Languages/v0",description="Rest service to get the language")
@RestController
@RequestMapping("/Languages/v0")
@JsonIgnoreProperties(ignoreUnknown = true)
*/
public class LanguageRestController {
		
	/**  
	 * READ OPERATION LIST - GET
	 */
	public LanguageService languageService;
	
	/**
	 * READ OPERATION GET - GET
	 */
	// @RequestMapping(value = "/{id}", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	// @ResponseBody
    public Language get(Long id) {
        
    	Language language = null;
    	
    	try
    	{
    		language = languageService.findById(id);
    		
    		if (language!=null) {
    			languageService.setDescriptonFr("Description assigned in controller");
    		}
    	
    	}catch(Exception ex) {
    		return language;
    	}
    	
    	return language;
		
	}
	
	/**
	 * READ OPERATION GET - GET
	 */
	// @RequestMapping(value = "/", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	// @ResponseBody
    public List<Language> findAll() {
		return languageService.findAll();
	}
	
	// @RequestMapping(value = "/", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	// @ResponseBody
    public List<Language> findAllReturnEmpty() {
		return new ArrayList<Language>();
	}

    
    public String update(Language language) {
    	
    	if(null == language){
            return "ERROR";
        }else{
            
        	boolean updated;
 
            try {
                updated = languageService.update(language);
                languageService.setDescriptonFr("Description Assigned in Controller");
            } catch (Exception e) {
                return "ERROR";
            }
 
            if(updated){
            	languageService.setDescriptonFr(language.getDescriptionFr());
                return "OK";
            }else{
                return "KO";
            }
        }
    	
	}

    
    
	
	/**
	 * CREATE OPERATION(CRUD) - PUT/POST
	 * @throws IOException 
	 * @throws JsonMappingException Es que
	 * @throws JsonParseException
	 */
	
	/**
	 * UPDATE OPERATION(CRUD)- PUT/POST
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	
	/**
	 * DELETE OPERATION(CRUD) - DELETE
	 */
	
	/**
	 * PUBLISH OPERATION(CRUD) 
	 */

	/**
	 * UNPUBLISH OPERATION(CRUD)
	 */
	 
	 

}
