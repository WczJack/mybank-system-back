package com.neuedu.mobilebank.util;


import com.neuedu.mobilebank.po.ResponseBean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionDeal {
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseBean dealException() {
        ResponseBean rb = new ResponseBean(901,"系统出现故障，请联系客服人员");
        return rb;
    }
}
