package com.sparta.tp.springweb.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class SimpleWebController {
    @GetMapping
    public String welcome(Model model){
        model.addAttribute("date", LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM")));
        model.addAttribute("time", LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        return "welcome";
    }
}
