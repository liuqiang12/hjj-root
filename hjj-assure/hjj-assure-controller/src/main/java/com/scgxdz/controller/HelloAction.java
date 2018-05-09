package com.scgxdz.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloAction {
    @Value("spring.mvc.view.prefix")
    private String aa = "";

    @RequestMapping("/h")
    public String index() {
        return "热烈欢迎" + aa;
    }
}
