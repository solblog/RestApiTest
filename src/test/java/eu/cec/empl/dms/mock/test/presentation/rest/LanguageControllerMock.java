package eu.cec.empl.dms.mock.test.presentation.rest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import eu.cec.empl.dms.mock.dao.LanguageDaoImpl;
import eu.cec.empl.dms.mock.domain.catalogue.Language;
import eu.cec.empl.dms.mock.domain.catalogue.Organisation;
import eu.cec.empl.dms.mock.presentation.rest.LanguageRestController;
import eu.cec.empl.dms.mock.services.LanguageService;
import org.junit.Assert;

public class LanguageControllerMock {
	
	@Mock
    private LanguageDaoImpl languageDao;
    
    @Spy
	@InjectMocks
    private LanguageService spiedLanguageService;

    @Mock
    private LanguageService languageService;

    @InjectMocks
    private LanguageRestController languageRestController;

    @Before
    public void setUp() {
    	languageRestController = new LanguageRestController();
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Verifying No Calls to Mock
     */
    
    @Test
    public void assertThatNoMethodHasBeenCalled() {
    	/* The purpose of this test is to check that when we call the method
    	 * of this controller findAll, we are not calling any method of the
    	 * languageService     	  
    	 */
    	languageRestController.findAllReturnEmpty();
        Mockito.verifyZeroInteractions(languageService);
    }
    
    
    @Test
    public void assertTwoMethodsHaveBeenCalled() {
    	
    	/**
    	 * 2 methods called for the service LanguageService (findById,setDescriptionEn) when we call  the 
    	 * controller languageRestController.
    	 */
    	
    	/* Describe the object return by the service, we mock it and we do not care about the object which
    	 * is return in the implementation of the service */
    	Language language = new Language();
    	language.setDescriptionEn("Description assigned in Test method");
    	language.setDescriptionFr("Description assigned in Test method");
    	
        
    	/* Describe the behaviour of the service*/
    	Mockito.when(languageService.findById(new Long(1))).thenReturn(language);
        
    	/*  Sentence below call the controller, controller call the service (but the Service is mock)
         * and return an object Language define in the first 2 lines above (Mocked).
         *  As we can see the object mocked is the languageService and the return object.
         *  In case it is not mocked the descrition must be "Description Assigned in service"
         */
    	
        String languageDescriptionEn = languageRestController.get(new Long(1)).getDescriptionEn();
        
        
        Assert.assertEquals("Description assigned in Test method", languageDescriptionEn);
        
        /* As we can see when we call languageRestController -> languageService (in theory it should return 
         * "Description Assigned in service")
         * but it returns "whatever".
         */
        
        Mockito.verify(languageService).findById(new Long(1));
        /** Verify call 1:
         *  Mockito.verify(languageService).findById(new Long(2)); Fail
         */
        
        Mockito.verify(languageService).setDescriptonFr("Description assigned in controller");
        /** Verify call 2:
         *  Mockito.verify(languageService).setDescriptonEn("Whatever") this method fail
         *  and it has never been called as languageService).setDescriptonEn("Whatever")
         *  Mockito has intercept the call to Mockito.verify(languageService).setDescriptonEn("Other");
         *  and replace by language.setDescriptionEn("Whatever"); but the method called
         *  was Mockito.verify(languageService).setDescriptonEn("Other");      
         **/
        
    }

    /* 
     * Assert call methods
     */
    
    
    @Test
    public void assertOnlyOneMethodHasBeenCalled() {
    	
    	/*
    	 * 2 methods. findById and setDescriptionEn
    	 */
    	Language language = new Language();
        
    	/* Describe behaviour:
    	 * We simulate that there is not language with id 2
    	 *  */
    	Mockito.when(languageService.findById(new Long(2))).thenReturn(null);
            	
    	/*
    	 String languageDescription = languageRestController.get(new Long(1)).getDescriptionEn();
    	 Return nullPointerException if we do not define the behaviour of the service.
    	*/
    	
    	/* 1. Call to the controller, It supposed to call the service (Indirect call to the service)
         * and return an object as describe above (null)
         */
    	language = languageRestController.get(new Long(2));
    	
        /* it can not assert as it is null
           Assert.assertEquals("Spanish", languageDescription);
        */
        
        Mockito.verify(languageService).findById(new Long(2));
        /* Verify call 1 */
        
        Mockito.verifyNoMoreInteractions(languageService);
        /* Verify there was just one call to the service. */  
    }
    
    /* 
     * Mocking Exceptions
     */
    
    @Test
    public void mockExceptionThrowin() {
        
    	Language language = new Language();
        
        Mockito.when(languageService.findById(new Long(-1))).thenThrow(IllegalArgumentException.class);
     
        language = languageRestController.get(new Long(-1));
     
        Assert.assertEquals(null, language);
        
        Mockito.verify(languageService).findById(new Long(-1));
        
        Mockito.verifyZeroInteractions(languageService);
        
    }
    
    
    /**
     * Mocking an Object to Pass Around
     */
    
    @Test
    public void mockAnObjectToPassAround() {
    
    	Language language = Mockito.when(Mockito.mock(Language.class).getDescriptionEn())
          .thenReturn("Description in English").getMock();
        
    	Mockito.when(languageService.findById(new Long(1))).thenReturn(language);
     
        String languageDescription = languageRestController.get(new Long(1)).getDescriptionEn();
     
        Assert.assertEquals("Description in English", languageDescription);
        
        Mockito.verify(languageService).findById(new Long(1));
        
        Mockito.verify(languageService).setDescriptonFr("Description assigned in controller");
    
    }
    
    /* Custom Argument Matching */
    
    @Test
    public void argumentMatching() {
        
    	Language language = new Language();
    	language.setDescriptionFr("Whatever");
        
        // default matcher
        Mockito.when(languageService.update(Mockito.any(Language.class))).thenReturn(true);
        
        
        String updateResult = languageRestController.update(language);
        
        Assert.assertEquals("OK", updateResult);
        
        Mockito.verify(languageService).update(language);
        
        Mockito.verify(languageService).setDescriptonFr(ArgumentMatchers.argThat(
                new ArgumentMatcher<String>() {
                    public boolean matches(String argument) {
                        return argument.startsWith("What");
                    }
                }
        ));
        
        
    }
    
    
    
    /* Partial mocking */
    
    @Test
    public void partialMocking() {
     
    	// use partial mock, we do not mock the update method
    	languageRestController.languageService = spiedLanguageService;
        
        
        Language language = new Language();
    	language.setDescriptionEn("Whatever");
                
        // let service's language use implementation so let's mock DAO call
        Mockito.when(languageDao.update(language)).thenReturn(1);
     
        /* Real call not mocked */
        String udpateResult = languageRestController.update(language);
        
        /* Service update call not mocked */
     
        Assert.assertEquals("OK", udpateResult);
        
        /* verify mocked call, we have never called
         * spiedLanguageService.setDescriptonEn("Other"); 
         */
        
        Mockito.verify(spiedLanguageService).setDescriptonFr("Description Assigned in Controller");
        
    }
    
    
}
