package eu.cec.empl.dms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalErrorException  extends RuntimeException{

	  public InternalErrorException(String exception) {
		    super(exception);
		  }
	
}
