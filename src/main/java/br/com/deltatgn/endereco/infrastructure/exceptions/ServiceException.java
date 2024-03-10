package br.com.deltatgn.endereco.infrastructure.exceptions;

import org.springframework.http.HttpStatus;

/**
 *
 * @author Jammerson
 */
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = -7498192515272690026L;

    private HttpStatus httpStatus;

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}
