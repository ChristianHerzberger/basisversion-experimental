package de.hohenheim.sopra2019.controller;


import de.hohenheim.sopra2019.model.User;
import de.hohenheim.sopra2019.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.Instant;

@Controller
public class SignUpController {

    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    public String openRegistration(Model model) {
        // befülle model
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String completeRegistration(
            @ModelAttribute("user") User newUser){
        newUser.setCreationDate(Instant.now());
        // bspw. über UserService den neuen User speichern
        userService.saveUser(newUser);
        return "home";
    }

}
