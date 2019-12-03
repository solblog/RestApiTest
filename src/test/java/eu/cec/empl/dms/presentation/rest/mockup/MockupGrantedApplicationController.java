package eu.cec.empl.dms.presentation.rest.mockup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import eu.cec.empl.dms.domain.publications.GrantedApplication;
import eu.cec.empl.dms.jpa.persistence.dao.mockup.impl.MockupGrantedApplicationDao;


@RestController
@RequestMapping("/GrantedApplications")
public class MockupGrantedApplicationController {
	
	/** 
	 * This rest service has benn created just for testing Purposes, in order to test the integration
	 * with Spring. (Test of injection with annotations)
	 * 
	 * @Autowired
	 *	GrantedApplicationDao grantedApplicationDao;
	 * @Autowired
	 *	PublicationService publicationService;
	 *
	 */
	
	
	// Pending to implement the other CRUD Create,Read,Update,Delete plus list.
	
	
	private static final String SUCCESS_RESULT_JSON="success";
	private static final String FAILURE_RESULT_JSON="failure";
	private static final String SUCCESS_RESULT_XML="<result>success</result>";
	private static final String FAILURE_RESULT_XML="<result>failure</result>";
	
	@Autowired
	MockupGrantedApplicationDao grantedApplicationDao;
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public GrantedApplication getGrantedApplication(@PathVariable int id, Model model) {
		return grantedApplicationDao.getGrantedApplication(id);
	}
	

}
