package com.inshur.weather.query;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WarmestDayController {
    @GetMapping("/")
    public @ResponseBody String warmestDay() {
        return "wet and windy";
    }
}
