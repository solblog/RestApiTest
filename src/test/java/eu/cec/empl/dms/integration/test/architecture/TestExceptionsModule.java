package eu.cec.empl.dms.integration.test.architecture;

import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import eu.cec.empl.dms.integration.test.UrlDevelopment;
import eu.cec.empl.dms.integration.test.BasicConfiguration;
import eu.cec.empl.dms.integration.test.RestUrl;

public class TestExceptionsModule extends BasicConfiguration{
	
	/*
	*  The purpose of this test is to verify that all the exceptions and HTTP codes
	* triggers by the system are collected in the class CustomRestExceptionHandler.
	*  The Exception must be log properly
	*/
	
	private final String restServiceName = "MockupExceptions";
	private final String version = "V1";
	
	private UrlDevelopment ApiCall = new UrlDevelopment();
	
	/* Custom exception */
	private final String ResourceNotFoundException = "ResourceNotFoundException";
	
	/* Overwrite */
	private final String MethodArgumentNotValidException = "MethodArgumentNotValidException";
	private final String BindException = "BindException";
	private final String TypeMismatchException = "TypeMismatchException";
	private final String MissingServletRequestParameterException = "MissingServletRequestParameterException";
	private final String MethodArgumentTypeMismatchException = "MethodArgumentTypeMismatchException";
	private final String ConstraintViolationException = "ConstraintViolationException";
	private final String NoHandlerFoundException = "NoHandlerFoundException";
	private final String HttpRequestMethodNotSupportedException = "HttpRequestMethodNotSupportedException";
	private final String HttpMediaTypeNotSupportedException = "HttpMediaTypeNotSupportedException";
	
	/* Exception handler */
	private final String Exception = "Exception";
	private final String RunTimeException = "RunTimeException";
	private final String SQLException = "SQLException";
	
	/**
	 *  Custom exception 
	 */
	@Test
	public void exception_ResourceNotFoundException() throws ClientProtocolException, IOException, JSONException {
		/* We should get a JSON with the error */
		
		RestUrl urlDevelopment = new UrlDevelopment();
		urlDevelopment.setMethod(ResourceNotFoundException);
		String expectedResponse ="{\"status\":\"NOT_FOUND\",\"message\":\"Testing ResourceNotFoundException\",\"errors\":[\"error occurred\"],\"test\":null}";

		testRequestWithHttpClientBuilderAndJsonResponse(urlDevelopment,expectedResponse);
		
		
	}
	
	/**
	 *  Overwrite 
	 */
	
	@Test
	public void exception_MethodArgumentNotValidException() throws ClientProtocolException, IOException, JSONException {
		
		RestUrl urlDevelopment = new UrlDevelopment();
		urlDevelopment.setMethod(MethodArgumentNotValidException);
		String expectedResponse ="{\"status\":\"INTERNAL_SERVER_ERROR\",\"message\":\"An Errors/BindingResult argument is expected to be declared immediately after the model attribute, the @RequestBody or the @RequestPart arguments to which they apply: public java.lang.String eu.cec.empl.dms.presentation.rest.mockup.MockupExceptionController.testMethodArgumentNotValidException(org.springframework.validation.BindingResult) throws org.springframework.web.bind.MethodArgumentNotValidException,java.lang.NoSuchMethodException,java.lang.SecurityException\",\"errors\":[\"error occurred\"],\"test\":null}";
		
		testRequestWithHttpClientBuilderAndJsonResponse(urlDevelopment,expectedResponse);
		
	}
	
	@Test
	public void exception_BindException() throws ClientProtocolException, IOException, JSONException {
		
		RestUrl urlDevelopment = new UrlDevelopment();
		urlDevelopment.setMethod(BindException);
		String expectedResponse = "{\"status\":\"BAD_REQUEST\",\"message\":\"org.springframework.validation.BeanPropertyBindingResult: 0 errors\",\"errors\":[],\"test\":null}";
	
		testRequestWithHttpClientBuilderAndJsonResponse(urlDevelopment,expectedResponse);
	
	}
	
	@Test
	public void exception_TypeMismatchException() throws JSONException, ClientProtocolException, IOException {
		RestUrl urlDevelopment = new UrlDevelopment();
		urlDevelopment.setMethod(TypeMismatchException);
		String expectedResponse = "";
		testRequestWithHttpClientBuilderAndJsonResponse(urlDevelopment,expectedResponse);
	}
	
	@Test
	public void exception_MissingServletRequestParameterException() throws JSONException, ClientProtocolException, IOException{
		RestUrl urlDevelopment = new UrlDevelopment();
		urlDevelopment.setMethod(MissingServletRequestParameterException);
		String expectedResponse = "{\"status\":\"BAD_REQUEST\",\"message\":\"Required ParameterName parameter 'ParameterName' is not present\",\"errors\":[\"ParameterName parameter is missing\"],\"test\":null}";
		testRequestWithHttpClientBuilderAndJsonResponse(urlDevelopment,expectedResponse);
	}
	
	@Test
	public void exception_MethodArgumentTypeMismatchException() throws JSONException, ClientProtocolException, IOException{
		RestUrl urlDevelopment = new UrlDevelopment();
		urlDevelopment.setMethod(MethodArgumentTypeMismatchException);
		String expectedResponse = "";
		testRequestWithHttpClientBuilderAndJsonResponse(urlDevelopment,expectedResponse);
	}
	
	@Test
	public void exception_MethodArgumentTypeMismatch() throws JSONException, ClientProtocolException, IOException{
		RestUrl urlDevelopment = new UrlDevelopment();
		urlDevelopment.setMethod(BindException);
		String expectedResponse = "";
		testRequestWithHttpClientBuilderAndJsonResponse(urlDevelopment,expectedResponse);
	}
	
	@Test
	public void exception_ConstraintViolation() throws JSONException, ClientProtocolException, IOException{
		RestUrl urlDevelopment = new UrlDevelopment();
		urlDevelopment.setMethod(ConstraintViolationException);
		String expectedResponse = "";
		testRequestWithHttpClientBuilderAndJsonResponse(urlDevelopment,expectedResponse);
	}
	
		 
		 
	// 404 NOT FOUND
	@Test
	public void exception_NoHandlerFoundException() throws JSONException, ClientProtocolException, IOException{
		RestUrl urlDevelopment = new UrlDevelopment();
		urlDevelopment.setMethod(NoHandlerFoundException);
		String expectedResponse = "";
		testRequestWithHttpClientBuilderAndJsonResponse(urlDevelopment,expectedResponse);
	}
	
		
			    
	// 405 METHOD NOT ALLOWED - AUTHORIZATION
	@Test
	public void exception_HttpRequestMethodNotSupportedException() throws JSONException, ClientProtocolException, IOException{
		RestUrl urlDevelopment = new UrlDevelopment();
		urlDevelopment.setMethod(HttpRequestMethodNotSupportedException);
		String expectedResponse = "";
		testRequestWithHttpClientBuilderAndJsonResponse(urlDevelopment,expectedResponse);
	}
	
	
	// 415 UNSUPPORTED MEDIA TYPE
	@Test
	public void exception_MediaTypeNotSupported() throws JSONException, ClientProtocolException, IOException{
		RestUrl urlDevelopment = new UrlDevelopment();
		urlDevelopment.setMethod(HttpMediaTypeNotSupportedException);
		String expectedResponse = "";
		testRequestWithHttpClientBuilderAndJsonResponse(urlDevelopment,expectedResponse);
	}
	    

	// 500 
	@Test
	public void exception_Exception() throws JSONException, ClientProtocolException, IOException{
		RestUrl urlDevelopment = new UrlDevelopment();
		urlDevelopment.setMethod(Exception);
		String expectedResponse = "";
		testRequestWithHttpClientBuilderAndJsonResponse(urlDevelopment,expectedResponse);
	}
	
	
	@Test
	public void exception_SQLException() throws JSONException, ClientProtocolException, IOException{
		RestUrl urlDevelopment = new UrlDevelopment();
		urlDevelopment.setMethod(SQLException);
		String expectedResponse = "";
		testRequestWithHttpClientBuilderAndJsonResponse(urlDevelopment,expectedResponse);
	}

	@Test
	public void exception_Runtime() throws JSONException, ClientProtocolException, IOException{
		RestUrl urlDevelopment = new UrlDevelopment();
		urlDevelopment.setMethod(RunTimeException);
		String expectedResponse = "";
		testRequestWithHttpClientBuilderAndJsonResponse(urlDevelopment,expectedResponse);
	}

	@Override
	public String getServiceName() {
		return restServiceName;
	}

	@Override
	public String getServiceVersion() {
		// TODO Auto-generated method stub
		return version;
	}
	
	

}
