package com.matol.matolbackend.customerProfile;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
//@CrossOrigin("*")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @PostMapping(
            path = "{customerEmail}/image/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void uploadCustomerProfileImage(@PathVariable("customerEmail") String email,
                                           @RequestParam("file") MultipartFile file) {
        customerService.uploadProfileImage(email, file);
    }

    @GetMapping("{customerEmail}/image/download")
    public byte[] downloadCustomerProfileImage(@PathVariable("customerEmail") String email) {
        return customerService.downloadCustomerProfileImage(email);
    }
}
