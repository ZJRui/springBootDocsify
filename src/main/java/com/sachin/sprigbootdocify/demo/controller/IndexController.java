package com.sachin.sprigbootdocify.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
public class IndexController {


    @RequestMapping("/view/doc")
    public String viewDoc(HashMap map) {

        return "index";
    }

}
