package com.example.member.validation;

import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

public class ValidationHelper {

    private Validator validator;

    @Autowired
    public ValidationHelper(Validator validator) {
        this.validator = validator;
    }

    public<T> Mono<T> validate(T request){
        return Mono.fromSupplier(() -> {
            Set<ConstraintViolation<T>> vioaltions = validator.validate(request);


            if(vioaltions.isEmpty()){
                //berhasil
                return request;
            }
            else{
                //gagal
                throw new IllegalArgumentException("Validate Error");
            }
        });
    }

}
