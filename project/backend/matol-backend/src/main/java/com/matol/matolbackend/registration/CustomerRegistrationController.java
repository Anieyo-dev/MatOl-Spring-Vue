package com.matol.matolbackend.registration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = "api/v1/registration")
public class CustomerRegistrationController {

    private final CustomerRegistrationService customerRegistrationService;

    @PostMapping
    public String register(@RequestBody CustomerRegistrationRequest request) {
        return customerRegistrationService.register(request);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return customerRegistrationService.confirmToken(token);
    }
}
