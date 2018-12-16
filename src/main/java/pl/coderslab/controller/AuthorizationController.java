package pl.coderslab.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.User;
import pl.coderslab.repository.UserRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
public class AuthorizationController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/login")
    public String authenticate() {
        return "";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "forms/register";
    }

    @PostMapping("register")
    public String register(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "forms/register";
        }
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12));
        user.setPassword(hashedPassword);
        userRepository.save(user);
        return "redirect:/";
    }
}
