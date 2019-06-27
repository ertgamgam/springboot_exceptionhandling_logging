package com.ertgamgam.logging.Exceptions;

import com.ertgamgam.logging.Logger.LogMessage;
import com.ertgamgam.logging.Logger.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionsHandler {

    @Autowired
    Logger logger;

    @ExceptionHandler(value = {Exception.class})
    //for specific exteption use its name instead of Expception.class NUllPointerException.class
    public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {

        LogMessage logMessage=createLogForException(ex);
        logger.createLog(logMessage);
        return (new ResponseEntity<>(logMessage, new HttpHeaders(), HttpStatus.BAD_REQUEST));
    }

    private LogMessage createLogForException(Exception ex) {
        String errorMessage = ex.getLocalizedMessage();
        if (errorMessage == null)
            errorMessage = ex.toString();

        LogMessage logMessage = new LogMessage();
        logMessage.onCreated();
        logMessage.setLogTitle(ex.getClass().toString());
        logMessage.setLogContent(ex.toString());
        return logMessage;
    }
}
