package com.owen.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class SimpleController
{
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String simpleRequest()
    {
        return "Hello Spring Boot";
    }
}
