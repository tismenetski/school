package com.tismenetski.school.services;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public interface MapValidationErrorService {

    public ResponseEntity<?> MapValidationService(BindingResult result);
}
