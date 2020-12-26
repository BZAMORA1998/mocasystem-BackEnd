package com.mocasystem.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Clase que permite manejar excepciones en toda la aplicación, no solo en un controlador individual.
 * Puede considerarlo como un interceptor de excepciones generadas por métodos anotados 
 * con RequestMapping o uno de los accesos directos
 * 
 * @author Raúl Yugcha
 *
 */
@ControllerAdvice
public class RestExceptionHandler {
	
   @ExceptionHandler(value=BOException.class)
   public ResponseEntity<Object> handleRestClientException(BOException e) {
		return new ResponseEntity<Object>(
				new ApiErrorResponse(HttpStatus.BAD_REQUEST.value(), false, e.getMessage(), 
						e.getData()!=null?new Object[] {e.getData()}:new Object[]{}
					), HttpStatus.BAD_REQUEST);
   }
   
	@ExceptionHandler(value=CustomExceptionHandler.class)
	public final ResponseEntity<Object> handleCustomExceptions(CustomExceptionHandler e) {
		return new ResponseEntity<Object>(
				new ApiErrorResponse(HttpStatus.BAD_REQUEST.value(), false, 
						e.getMessage()!=null?e.getMessage():HttpStatus.BAD_REQUEST.name(), 
						e.getData()!=null?new Object[] {e.getData()}:new Object[]{}
					), HttpStatus.BAD_REQUEST);
	}

}
