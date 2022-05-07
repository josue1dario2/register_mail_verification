package com.backend.loginAndRegister.registration;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final static String EMAIL_NOT_VALID = "Email not valid";
    private EmailValidator emailValidator;

    public String register(RegistrationRequest request){
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if(!isValidEmail){
            throw new IllegalStateException(EMAIL_NOT_VALID);
        }
        return "Esta es la modificacion";
    }
}
