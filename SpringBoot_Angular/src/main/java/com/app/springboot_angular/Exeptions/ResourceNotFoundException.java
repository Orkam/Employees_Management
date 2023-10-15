package com.app.springboot_angular.Exeptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7762368070964082402L;
	

    public ResourceNotFoundException(String message) {

        super(message);

    }

}
