package br.com.deltatgn.endereco.infrastructure.exceptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;

/**
 *
 * @author Jammerson
 */
public class ApiErrors {
    
    @Getter
    private final Map<String, Object> errors;

    public ApiErrors(List<String> errorsList) {
        this.errors = new HashMap<>();
        for (String resp : errorsList) {
            errors.put("status", 0);
            errors.put("message", resp);
        }
    }

    public ApiErrors(String message) {
        this.errors = new HashMap<>();
        errors.put("message", message);
        errors.put("status", 0);
    }

    public ApiErrors(String message, Integer status) {
        this.errors = new HashMap<>();
        errors.put("status", status);
        errors.put("message", message);
    }
    
}
