package com.af.demo.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(value = {DataIntegrityViolationException.class,Exception.class,
            SQLIntegrityConstraintViolationException.class})
    public ModelAndView handleDataIntegrityViolation(Exception ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errors", ex.getMessage());
        modelAndView.setViewName("dealssss");
        return modelAndView;
    }

}
