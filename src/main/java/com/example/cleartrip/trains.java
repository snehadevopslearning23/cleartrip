package com.example.cleartrip;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class trains {
    @GetMapping("/trains")
    public String getData() {return "Please book your trains for Mumbai" ; }
}
