package com.java.cis;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bmirest")
public class BMIRestController {

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String calculateBMI(@RequestParam("height") double height, @RequestParam("weight") double weight) {
        return calculateBMIValue(height, weight);
    }

    private String calculateBMIValue(double height, double weight) {
        // Convert height to meters
        double heightInMeters = height / 100.0;

        // Calculate BMI
        double bmi = weight / (heightInMeters * heightInMeters);

        // Round BMI to two decimal places
        bmi = Math.round(bmi * 100.0) / 100.0;

        return Double.toString(bmi);
    }
}
