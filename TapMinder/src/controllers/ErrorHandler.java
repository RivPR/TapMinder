package controllers;

//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;

/*
 * 
 * Error handling page!
 * 
 * 
 */

@ControllerAdvice
public class ErrorHandler {
	@ExceptionHandler
	public String handle(Exception e){
		System.out.println(e);
		e.printStackTrace();
		return "error.jsp";
	}
}
