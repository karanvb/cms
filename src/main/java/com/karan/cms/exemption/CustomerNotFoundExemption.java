package com.karan.cms.exemption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNotFoundExemption extends RuntimeException{
    public CustomerNotFoundExemption(String message){
        super(message);
    }
}
