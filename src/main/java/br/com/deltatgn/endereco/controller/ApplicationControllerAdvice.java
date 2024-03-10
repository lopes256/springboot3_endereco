package br.com.deltatgn.endereco.controller;

import br.com.deltatgn.endereco.infrastructure.exceptions.ApiErrors;
import br.com.deltatgn.endereco.infrastructure.exceptions.RecordNotFoundException;

import br.com.deltatgn.endereco.infrastructure.exceptions.ServiceException;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *
 * @author Jammerson
 */
@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity handleHttpMessageNotReadableException(NullPointerException e) {
        HttpStatus codigoStatus = HttpStatus.CONFLICT;
        ApiErrors apiErrors = new ApiErrors(e.getMessage(), codigoStatus.value());
        return new ResponseEntity(apiErrors, codigoStatus);
    }

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity handleHttpMessageNotReadableException(RecordNotFoundException e) {
        HttpStatus codigoStatus = HttpStatus.CONFLICT;
        ApiErrors apiErrors = new ApiErrors(e.getMessage(), codigoStatus.value());
        return new ResponseEntity(apiErrors, codigoStatus);
    }

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity handleServiceException(ServiceException e) {
        HttpStatus codigoStatus = e.getHttpStatus();
        ApiErrors apiErrors = new ApiErrors(e.getMessage(), codigoStatus.value());
        return new ResponseEntity(apiErrors, codigoStatus);
    }

    @ExceptionHandler(FeignException.class)
    public ResponseEntity handleFeignException(FeignException e) {
        HttpStatus codigoStatus = HttpStatus.CONFLICT;
        ApiErrors apiErrors = new ApiErrors(e.getMessage(), codigoStatus.value());
        return new ResponseEntity(apiErrors, codigoStatus);
    }

    
    
}
