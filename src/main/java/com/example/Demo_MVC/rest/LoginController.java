package com.example.Demo_MVC.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/loginPage")
    public String login(Model model){
        return "login";
    }

    @GetMapping("/page403")
    public String showpage403(){
        return "error/page403";
    }

    @GetMapping("/page404")
    public String showpage404(){
        return "error/page404";
    }
}
