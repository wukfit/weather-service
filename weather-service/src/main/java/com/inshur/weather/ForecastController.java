package com.inshur.weather;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ForecastController {
    @RequestMapping("/")
    public @ResponseBody String forecast() {
        return "wet and windy";
    }
}
