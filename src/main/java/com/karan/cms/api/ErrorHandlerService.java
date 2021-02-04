package com.karan.cms.api;

import com.karan.cms.exemption.ApplicationError;
import com.karan.cms.exemption.CustomerNotFoundExemption;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ErrorHandlerService extends ResponseEntityExceptionHandler {

    @Value("${api_doc_url}")
    private String details;

    @ExceptionHandler(CustomerNotFoundExemption.class)
    public ResponseEntity<ApplicationError> handleCustomerNotFoundExemption(CustomerNotFoundExemption execption, WebRequest webRequest){
        ApplicationError error = new ApplicationError();
        error.setInteger(101);
        error.setMessage(execption.getMessage());
        error.setDetails("");

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
