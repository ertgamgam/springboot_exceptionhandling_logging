package com.ertgamgam.logging.Services;

import com.ertgamgam.logging.Exceptions.CustomException;
import org.springframework.stereotype.Service;

@Service
public class CustomExceptionService  implements ExceptionService {


    @Override
    public void createCustomException() {
             throw new CustomException("hi from custom exception");
    }

    @Override
    public void createGeneralException() {

    }
}
