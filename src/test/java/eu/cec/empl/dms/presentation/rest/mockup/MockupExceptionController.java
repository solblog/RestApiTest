package eu.cec.empl.dms.presentation.rest.mockup;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.MethodParameter;
import org.springframework.dao.TypeMismatchDataAccessException;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.http.HttpHeaders;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.Validator;


/* Exceptions */

import eu.cec.empl.dms.exception.ResourceNotFoundException;

import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MissingServletRequestParameterException; 
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.web.servlet.NoHandlerFoundException;



/* Pending to move to mockup packages */

@RestController
@RequestMapping("/MockupExceptions")
public class MockupExceptionController {
	
	
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
	
	private static final Logger LOG = LogManager.getLogger(MockupExceptionController.class);
	
	/* Custom exception */
	
	// @ApiOperation(value=" Info ")
	@RequestMapping(value="/",method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public String infoResourceNotFoundException(@RequestBody MockParameters mockParameter){
		/* Launch method argument not valid */
		return "Info Exceptions";
	}
	
	
	/* Custom exception */
	
	// @ApiOperation(value="Throw "+ResourceNotFoundException)
	@RequestMapping(value="/"+ResourceNotFoundException,method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public String testResourceNotFoundException(){
		/* Launch method argument not valid */
		throw new  ResourceNotFoundException("Testing "+ResourceNotFoundException);
	}
	
	
	// @ApiOperation(value="Throw "+MethodArgumentNotValidException)
	@RequestMapping(value="/"+MethodArgumentNotValidException,method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public String testMethodArgumentNotValidException(BindingResult bindingResult) throws org.springframework.web.bind.MethodArgumentNotValidException, NoSuchMethodException, SecurityException{
		/* Launch method argument not valid */
		
		Method method=MockParameters.class.getDeclaredMethod("getParameterTest",String.class,String.class,String.class);
		MethodParameter idParameter=new MethodParameter(method,0);
		
		/* Check binding method */
		throw new MethodArgumentNotValidException(idParameter, bindingResult);
		
	}
	
	// @ApiOperation(value="Throw "+BindException)
	@RequestMapping(value="/"+BindException,method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public String testBindException(final HttpServletRequest request) throws org.springframework.validation.BindException{
		/* Launch method argument not valid */
		
		    MockParameters mockParameter = new MockParameters();
		    ServletRequestDataBinder binder = new ServletRequestDataBinder(mockParameter, "mockParameter");
	        binder.bind(request);
	        BindingResult result = binder.getBindingResult();
	        throw new BindException(result);
	}
	
	// @ApiOperation(value="Throw "+TypeMismatchException)
	@RequestMapping(value="/"+TypeMismatchException,method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public String testTypeMismatchException(){
		/* Launch method argument not valid */
		throw new  TypeMismatchDataAccessException ("Testing "+TypeMismatchException);
	}
	
	// @ApiOperation(value="Throw "+MissingServletRequestParameterException)
	@RequestMapping(value="/"+MissingServletRequestParameterException,method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public String testMissingServletRequestParameterException() throws MissingServletRequestParameterException{
		/* Launch method argument not valid */
		throw new  MissingServletRequestParameterException("ParameterName", "ParameterName");
	}
	
	// @ApiOperation(value="Throw "+MethodArgumentTypeMismatchException)
	@RequestMapping(value="/"+MethodArgumentTypeMismatchException,method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public String testMethodArgumentTypeMismatchException(@RequestBody MockParameters mockParameter) throws NoSuchMethodException, SecurityException{
		/* Launch method argument not valid */
		Method method=MockParameters.class.getDeclaredMethod("getParameterTest",String.class,String.class,String.class);
		MethodParameter idParameter=new MethodParameter(method,0);
		throw new MethodArgumentTypeMismatchException(new Long(3),String.class,"Month",idParameter,new Exception("Test: "+MethodArgumentTypeMismatchException));
	}
	
	// @ApiOperation(value="Throw "+ConstraintViolationException)
	@RequestMapping(value="/"+ConstraintViolationException,method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public String testConstraintViolationException(@RequestBody MockParameters mockParameter){
		/* Launch method argument not valid */
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	    Validator validator = factory.getValidator();
	    Set<ConstraintViolation<MockParameters>> errors = validator.validate(mockParameter);
		throw new ConstraintViolationException(errors);
	}
	
	// @ApiOperation(value="Throw "+NoHandlerFoundException)
	@RequestMapping(value="/"+NoHandlerFoundException,method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public String testNoHandlerFoundException(@RequestBody MockParameters mockParameter) throws org.springframework.web.servlet.NoHandlerFoundException{
		/* Launch method argument not valid */
		HttpHeaders headers = new HttpHeaders();
		headers.add("foo", "bar");
		NoHandlerFoundException ex = new NoHandlerFoundException("GET", "/foo", headers);
		throw ex;
	}
	
	// @ApiOperation(value="Throw "+HttpMediaTypeNotSupportedException)
	@RequestMapping(value="/"+HttpMediaTypeNotSupportedException,method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public String testHttpMediaTypeNotSupportedException(@RequestBody MockParameters mockParameter) throws java.lang.Exception{
		/* Launch method argument not valid */
		List<MediaType> acceptable = Arrays.asList(MediaType.APPLICATION_ATOM_XML, MediaType.APPLICATION_XML);
		HttpMediaTypeNotAcceptableException ex = new HttpMediaTypeNotAcceptableException(acceptable);
		throw ex;
	}
	
	// @ApiOperation(value="Throw "+HttpRequestMethodNotSupportedException)
	@RequestMapping(value="/"+HttpRequestMethodNotSupportedException,method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public String testHttpRequestMethodNotSupportedException(@RequestBody MockParameters mockParameter){
		/* Launch method argument not valid */
		throw new  ResourceNotFoundException("Testing "+HttpRequestMethodNotSupportedException);
	}
	
	// Overwrite exceptions
	
	// @ApiOperation(value="Throw "+Exception)
	@RequestMapping(value="/"+Exception,method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public String testException(@RequestBody MockParameters mockParameter) throws java.lang.Exception{
		/* Launch method argument not valid */
		throw new  Exception("Testing exception");
	}
	
	// @ApiOperation(value="Throw "+RunTimeException)
	@RequestMapping(value="/"+RunTimeException,method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public String testRunTimeException(@RequestBody MockParameters mockParameter){
		/* Launch method argument not valid */
		throw new  ResourceNotFoundException("Testing "+RunTimeException);
	}
	
	// @ApiOperation(value="Throw "+SQLException)
	@RequestMapping(value="/"+SQLException,method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public String testSQLException(@RequestBody MockParameters mockParameter){
		/* Launch method argument not valid */
		throw new  ResourceNotFoundException("Testing "+SQLException);
	}

}
