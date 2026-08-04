package com.example.spring_study;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Fortune {

    public Fortune() {
        System.out.println("Fortuneクラスが読み込まれました");
    }

    @RequestMapping("/fortune")
    public String start() {

        double fn = Math.random();

        if (fn >= 0.7) {
            return "greatFortune.html";
        } else if (fn >= 0.4) {
            return "middleFortune.html";
        } else if (fn >= 0.1) {
            return "smallFortune.html";
        } else {
            return "misFortune.html";
        }
    }
}
