package com.centraledachat.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.centraledachat.demo.Model.User;
import com.centraledachat.demo.Service.SecurityService;
import com.centraledachat.demo.Service.UserService;
import com.centraledachat.demo.Service.UserValidator;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/registration")
    public String registration(Model model) {
        if (securityService.isAuthenticated()) {
            return "redirect:/";
        }

        model.addAttribute("userForm", new User());

        return "startbootstrap-sb-admin-2-gh-pages/register.html";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "startbootstrap-sb-admin-2-gh-pages/register.html";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (securityService.isAuthenticated()) {
            return "redirect:/";
        }

        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "startbootstrap-sb-admin-2-gh-pages/login.html";
    }
    
	/*
	 * @PostMapping("/login") public String loginn(Model model, String error, String
	 * logout) { if (securityService.isAuthenticated()) { return "redirect:/"; }
	 * 
	 * if (error != null) model.addAttribute("error",
	 * "Your username and password is invalid.");
	 * 
	 * if (logout != null) model.addAttribute("message",
	 * "You have been logged out successfully.");
	 * 
	 * return "startbootstrap-sb-admin-2-gh-pages/login.html"; }
	 */

    @GetMapping({"/", "/welcome"})
    public String welcome(Model model) {
        return "startbootstrap-sb-admin-2-gh-pages/adherent_index.html";
    }
}
