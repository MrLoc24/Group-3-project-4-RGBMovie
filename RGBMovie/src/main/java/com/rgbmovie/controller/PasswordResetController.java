package com.rgbmovie.controller;


import com.rgbmovie.model.PasswordResetTokenModel;
import com.rgbmovie.model.UserModel;
import com.rgbmovie.service.PasswordResetService;
import com.rgbmovie.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.UUID;


@Controller
@RequestMapping("/admin/auth")
public class PasswordResetController {
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
    public String resetPassword(HttpServletRequest request, @RequestParam("email") String userEmail, Model model) {
        UserModel user = userService.findByUsername(userEmail);
        if (user == null) {
            model.addAttribute("mes", "Email not found");
            return "auth/forgetPassword";
        }
        String token = UUID.randomUUID().toString();
        PasswordResetTokenModel passwordResetTokenModel = new PasswordResetTokenModel();
        passwordResetTokenModel.setToken(token);
        passwordResetTokenModel.setUserId(user.getPk());
        passwordResetTokenModel.setExpiryDate();
        passwordResetService.createPasswordResetTokenForUser(passwordResetTokenModel);
        mailSender.send(constructResetTokenEmail("www.rgbmov.top",
                token, user));
        model.addAttribute("message", "Email with link contain password reset have been send to your email");
        return "auth/forgetPassword";
    }

    private MimeMessagePreparator constructResetTokenEmail(
            String contextPath, String token, UserModel user) {
        String url = "http://" + contextPath + "/admin/auth/changePassword?token=" + token;
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

    @GetMapping("/changePassword")
    public String showChangePasswordPage(Model model,
                                         @RequestParam("token") String token) {
        String result = passwordResetService.validatePasswordResetToken(token);
        if (result.equals("Invalid") || result.equals("Expired")) {
            model.addAttribute("message", "Token " + result);
        } else {
            model.addAttribute("token", token);
            model.addAttribute("userId", result);
            model.addAttribute("confirm", true);
        }
        return "auth/forgetPassword";
    }

    @PostMapping("/changePassword")
    public String changePassword(@RequestParam("newPassword") String newPassword, @RequestParam("userId") String userId, @RequestParam("token") String token, Model model) {
        int uId = Integer.parseInt(userId);
        UserModel result = userService.findById(uId);
        if (result != null) {
            if (passwordEncoder.matches(newPassword, result.getPassword())) {
                model.addAttribute("message", "New password can not be same as old password");
                return "/auth/changePassword?token=" + token;
            } else {
                userService.updatePassword(passwordEncoder.encode(newPassword), uId);
                System.out.println(newPassword + " , " + passwordEncoder.encode(newPassword));
                model.addAttribute("message", "Password change successfully");
            }
        }
        return "auth/login";
    }
}
