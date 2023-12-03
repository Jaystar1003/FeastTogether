package org.FeastTogether.registration;

import lombok.AllArgsConstructor;
import org.FeastTogether.appuser.AppUser;
import org.FeastTogether.appuser.AppUserRole;
import org.FeastTogether.appuser.AppUserService;
import org.FeastTogether.email.EmailSender;
import org.FeastTogether.registration.token.ConfirmationToken;
import org.FeastTogether.registration.token.ConfirmationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final AppUserService appUserService;
    private final EmailValidator emailValidator;
    private ConfirmationTokenService confirmationTokenService;
    private final EmailSender emailSender;
    public String register(RegistrationRequest request) {
         boolean isValidEmail = emailValidator.test(request.getEmail());
         if (!isValidEmail) {
             throw new IllegalStateException("Email not valid");
         }
        String token = appUserService.signUpUser(new AppUser(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getPassword(),
                AppUserRole.USER
        ));
        String link = "http://localhost:8080/api/v1/registration/confirm?token=" + token;
        emailSender.send(
                request.getEmail(),
                buildEmail(request.getFirstName(), link));
        return token;
    }

    @Transactional
    public String confirmToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService.getToken(token)
                .orElseThrow(() -> new IllegalStateException("Token not found"));
        if (confirmationToken.getConfirmedAt() != null) {
            throw new IllegalStateException("Email already confirmed");
        }
        LocalDateTime expiredAt = confirmationToken.getExpiresAt();
        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("Token Expired");
        }
        confirmationTokenService.setConfirmedAt(token);
        appUserService.enableAppUser(
                confirmationToken.getAppUser().getEmail()
        );
        return  "<h3>Email Confirmed</h3>" +
                "<a href=\"http://localhost:3000/\">Click here to continue</a>";
    }

    private String buildEmail(String name, String link) {
        return  "<div style=\"font-family: Arial, sans-serif; padding: 20px; background-color: #F5F5F5;\">\n" +
                "    <div style=\"max-width: 600px; margin: 0 auto; background-color: #FFFFFF; padding: 20px; border-radius: 5px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.05);\">\n" +
                "\n" +
                "        <h2 style=\"color: #F8A457; border-bottom: 2px solid #F8A457; padding-bottom: 10px;\">Welcome, "+name+"!</h2>\n" +
                "\n" +
                "        <p style=\"font-size: 16px; line-height: 1.5; margin-top: 20px;\">Thank you for registering with us. To complete the registration process, please confirm your email address by clicking the link below:</p>\n" +
                "\n" +
                "        <div style=\"text-align: center; margin: 30px 0;\">\n" +
                "            <a href=\""+link+"\" style=\"background-color: #F8A457; color: #FFFFFF; padding: 15px 25px; text-decoration: none; border-radius: 5px; font-size: 16px;\">Activate Account</a>\n" +
                "        </div>\n" +
                "\n" +
                "        <p style=\"font-size: 16px; line-height: 1.5; margin-top: 20px;\">If you didn’t request this, please ignore this email.</p>\n" +
                "\n" +
                "        <p style=\"font-size: 12px; line-height: 1.5; margin-top: 20px;\">Link will expire in 15 minutes.</p>\n" +
                "\n" +
                "        <p style=\"font-size: 14px; line-height: 1.5; margin-top: 30px; color: #999999;\">Warm regards,<br>FeastTogether Team</p>\n" +
                "\n" +
                "    </div>\n" +
                "</div>\n";
    }
}

