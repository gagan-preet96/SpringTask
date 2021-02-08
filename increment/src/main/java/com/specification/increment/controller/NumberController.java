package com.specification.increment.controller;

import com.specification.increment.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class NumberController {

    @Autowired
    NumberService numberService;

    @RequestMapping("/incrementNumber")
    public String incrementNumber(){
        return "Result :: "+ numberService.incrementNumberForId();
    }
}
