package com.rgbmovie.api;

import com.rgbmovie.model.PasswordResetTokenModel;
import com.rgbmovie.model.UserModel;
import com.rgbmovie.service.PasswordResetService;
import com.rgbmovie.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/customer")
public class ApiForgetPassword {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordResetService passwordResetService;
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private TemplateEngine templateEngine;

    @PostMapping("/recover")
    public Object resetPassword(HttpServletRequest request, @RequestParam("email") String userEmail) {
        UserModel user = userService.findByUsername(userEmail);
        if (user == null) {
            return new ResponseEntity<>("Email not found", HttpStatus.NO_CONTENT);
        }
        String token = UUID.randomUUID().toString();
        System.out.println(token);
        PasswordResetTokenModel passwordResetTokenModel = new PasswordResetTokenModel();
        passwordResetTokenModel.setToken(token);
        passwordResetTokenModel.setUserId(user.getPk());
        passwordResetTokenModel.setExpiryDate();
        System.out.println(passwordResetTokenModel.getToken() + passwordResetTokenModel.getUserId() + passwordResetTokenModel.getExpiryDate().toString());
        passwordResetService.createPasswordResetTokenForUser(passwordResetTokenModel);
        mailSender.send(constructResetTokenEmail("www.rgbmov.top",
                token, user));
        return new ResponseEntity<>("Email with link contain password reset have been send to your email", HttpStatus.OK);
    }

    private MimeMessagePreparator constructResetTokenEmail(String contextPath, String token, UserModel user) {
        String url = "http://" + contextPath + "/resetPassword?token=" + token;
        Context context = new Context();
        context.setVariable("url", url);
        String message = templateEngine.process("layout/email", context);
        return constructEmail(message, user);
    }

    private MimeMessagePreparator constructEmail(String body, UserModel user) {
        return mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom("rgb.movie.pj4@gmail.com");
            messageHelper.setTo(user.getEmail());
            messageHelper.setSubject("RGB Account Reset Password Request");
            messageHelper.setText(body, true); // second parameter 'true' enables HTML in our message
        };
    }

    @GetMapping("/resetPassword")
    public Object showChangePasswordPage(@RequestParam("token") String token) {
        String result = passwordResetService.validatePasswordResetToken(token);
        if (result.equals("Invalid") || result.equals("Expired")) {
            new ResponseEntity<>("Token " + result, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/changePassword")
    public Object changePassword(@RequestParam("newPassword") String newPassword, @RequestParam("userId") String userId, @RequestParam("token") String token, Model model) {
        int uId = Integer.parseInt(userId);
        UserModel result = userService.findById(uId);
        if (result != null) {
            if (passwordEncoder.matches(newPassword, result.getPassword())) {
                return new ResponseEntity<>("New password can not be same as old password", HttpStatus.BAD_REQUEST);
            } else {
                userService.updatePassword(passwordEncoder.encode(newPassword), uId);
            }
        }
        return new ResponseEntity<>("Change password successfully", HttpStatus.OK);
    }
}
