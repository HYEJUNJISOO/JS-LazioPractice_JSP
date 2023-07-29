package com.boot.sailing_jsp.v3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/v3")
public class HomeConV3 {

    @GetMapping("/home")
    public String doHome(){

        return "/v3/home/home";
    }

    @GetMapping("/rest2")
    @ResponseBody
    public String doRest2(){

        String strHtml="<html><body> Hi Rest, Controller + ResponseBody !!! <ht> Hi, </body></html>";

        return strHtml;
    }


}
