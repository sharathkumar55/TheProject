package com.myproject.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasicController {


    @GetMapping("")
    public String home()
    {
        return "redirect:/movies/list";
    }
    @GetMapping("/loginPage")
    public String login()
    {
        return "loginpage";

    }

    @GetMapping("/accessdenied")
    public String accessDenied()
    {
        return "accessdenied";
    }

}
