package br.com.luizcanassa.springsecuritythymeleafpoc.controllers.login;

import br.com.luizcanassa.springsecuritythymeleafpoc.domain.dto.UserRegisterDTO;
import br.com.luizcanassa.springsecuritythymeleafpoc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final UserService userService;

    public LoginController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String login() {
        return "login/index";
    }

    @GetMapping("/register")
    public String register() {
        return "login/register";
    }

    @PostMapping("/register")
    public String createUser(@ModelAttribute final UserRegisterDTO userRegisterDTO) {
        userService.createUser(userRegisterDTO);
        return "redirect:/";
    }
}
