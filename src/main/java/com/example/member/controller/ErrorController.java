package com.example.member.controller;

import com.example.member.model.ApiKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorController {

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = ApiKeyException.class)
    public String apiKey(ApiKeyException exception){
        return "Opps, API Key nya Kosong";
    }
}
