package com.cvargas.dentalOffice.dentalOffice.exceptions;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

public class GlobalExceptionHandler extends Throwable{

    private static final Logger logger = Logger.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> ErrorsAll(Exception e, WebRequest request) {
        logger.error(e.getMessage());
        return new ResponseEntity<>("Error: " + e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
