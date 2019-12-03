package eu.cec.empl.dms.exception;

import java.util.Arrays;
import java.util.List;
import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;
import lombok.AccessLevel;
import lombok.Data;;

@Data
public class ApiError {
	
	  	private @Setter @Getter(AccessLevel.PUBLIC) HttpStatus status;
	    private @Setter @Getter(AccessLevel.PUBLIC) String message;
	    private @Setter @Getter(AccessLevel.PUBLIC) List<String> errors;
	    private String test;
	 
	    public ApiError(HttpStatus status, String message, List<String> errors) {
	        super();
	        this.status = status;
	        this.message = message;
	        this.errors = errors;  
	    }
	 
	    public ApiError(HttpStatus status, String message, String error) {
	        super();
	        this.status = status;
	        this.message = message;
	        errors = Arrays.asList(error);
	    }

}
