package com.ertgamgam.logging.Logger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouchDBLogger implements Logger {

    @Autowired
    LoggerCouchDBRepo loggerCouchDBRepo;

    @Override
    public void createLog(LogMessage logMessage) {
         //logMessage.onCreated();
         loggerCouchDBRepo.save(logMessage);
    }
}
