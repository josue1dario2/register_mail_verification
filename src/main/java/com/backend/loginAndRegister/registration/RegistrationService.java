package com.backend.loginAndRegister.registration;

import com.backend.loginAndRegister.appuser.AppUser;
import com.backend.loginAndRegister.appuser.AppUserRole;
import com.backend.loginAndRegister.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final static String EMAIL_NOT_VALID = "Email not valid";
    private final EmailValidator emailValidator;
    private final AppUserService appUserService;

    public String register(RegistrationRequest request){
        boolean isValidEmail = emailValidator.test(request.getEmail());

        if(!isValidEmail){
            throw new IllegalStateException(EMAIL_NOT_VALID);
        }
        return appUserService.signUpUser(
                new AppUser(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPassword(),
                        AppUserRole.ADMIN
                )
        );
    }
}
