package com.example.primechecker.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PrimeController {

    @GetMapping("/is-prime")
    public Map<String, Object> isPrime(@RequestParam int number) {
        Map<String, Object> response = new HashMap<>();
        response.put("number", number);
        response.put("isPrime", isPrimeNumber(number));
        return response;
    }

    private boolean isPrimeNumber(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
