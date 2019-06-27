package com.ertgamgam.logging.Logger;

import com.ertgamgam.logging.Services.CustomExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/logs")
public class LogTestController {

    @Autowired
    Logger logger;

    @Autowired
    CustomExceptionService exceptionService;

    @PostMapping
    public ResponseEntity createLog(@RequestBody LogMessage logMessage){
        logger.createLog(logMessage);
        HttpHeaders headers=new HttpHeaders();
        headers.set("id",logMessage.getId());
        return (new ResponseEntity<>(logMessage,headers, HttpStatus.OK));
    }

    @GetMapping(path = "/generalexception")
    public void createCustomEx(){
        exceptionService.createCustomException();
    }



}
