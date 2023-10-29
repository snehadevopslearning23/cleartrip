package com.example.cleartrip;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class hotels {
    @GetMapping("/hotels")

    public String getData() {return "Please book your hotels for 1" ; }
}
