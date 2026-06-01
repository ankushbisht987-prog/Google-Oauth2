package com.login.OauthTwo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    
    @GetMapping
    public String screen(){
        return "<div> <h1>you</h1> Log In the System </div>";
    }
}
