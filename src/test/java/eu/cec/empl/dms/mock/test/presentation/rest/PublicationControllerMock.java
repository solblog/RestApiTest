package eu.cec.empl.dms.mock.test.presentation.rest;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
/*
import org.springframework.web.context.WebApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
*/

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = { ApplicationConfig.class })
@WebAppConfiguration
public class PublicationControllerMock {
	
	/*
	@Autowired
    private WebApplicationContext wac;
	*/
	
    private MockMvc mockMvc;

    private static final String CONTENT_TYPE = "application/json;charset=UTF-8";

    /*
    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }
    */
	
	
	
	@Test
	public void givenGreetURI_whenMockMVC_thenVerifyResponse() {
	    /*
		MvcResult mvcResult = this.mockMvc.perform(get("/greet"))
	      .andDo(print()).andExpect(status().isOk())
	      .andExpect(jsonPath("$.message").value("Hello World!!!"))
	      .andReturn();
	     
	    Assert.assertEquals("application/json;charset=UTF-8", 
	      mvcResult.getResponse().getContentType());
	      */
	      
	}
	

}
