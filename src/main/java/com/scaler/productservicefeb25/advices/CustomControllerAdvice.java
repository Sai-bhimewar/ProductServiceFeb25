package com.scaler.productservicefeb25.advices;


import com.scaler.productservicefeb25.dto.ErrorDto;
import com.scaler.productservicefeb25.exception.ProductNotFoundException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomControllerAdvice {
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorDto> NPEHandler(){
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage("Null pointer exeption");
        return new ResponseEntity<>(errorDto, HttpStatusCode.valueOf(404));
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDto> ProductNotFoundHandler(){
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage("product not found, please try again");
        return new ResponseEntity<>(errorDto, HttpStatusCode.valueOf(404));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> exceptionHandler(){
        return null;
    }
}
