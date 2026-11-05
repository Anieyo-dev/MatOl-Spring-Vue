package com.matol.matolbackend.customerProfile;

import com.matol.matolbackend.aws.bucket.BucketName;
import com.matol.matolbackend.aws.fileStore.FileStore;
import com.matol.matolbackend.registration.CustomerRegistrationRequest;
import com.matol.matolbackend.registration.token.ConfirmationToken;
import com.matol.matolbackend.registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.apache.http.entity.ContentType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

@Service
@AllArgsConstructor
public class CustomerService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG = "User with email %s not found";
    private final CustomerRepository customerRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;
    private final FileStore fileStore;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return customerRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
    }

    //SIGNUP USER METHOD
    public String signUpUser(Customer customer) {
        boolean userExist = customerRepository
                .findByEmail(customer.getEmail())
                .isPresent();

        if(userExist) {

            //TODO: Check if user attributes are the same and if not confirmed send confirmation email.
            //Bug - If email was send, and not confirmed is recognized as taken.
            //Docker crone job
            throw new IllegalStateException("Email already taken");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(customer.getPassword());
        customer.setPassword(encodedPassword);
        customerRepository.save(customer);

        String token = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                customer
        );

        confirmationTokenService.saveConfirmationToken(confirmationToken);

        return token;
    }

    public int enableCustomer(String email) {
        return customerRepository.enableCustomer(email);
    }

    //AWS METHODS
    public void uploadProfileImage(String customerEmail, MultipartFile file) {

        // 1. Check if image is not empty.
        if(file.isEmpty()) {
            throw new IllegalStateException("Cannot upload empty file [ " + file.getSize() + " ]");
        }

        // 2. Check if file is an image.
        if(!Arrays.asList(
                ContentType.IMAGE_JPEG.getMimeType(),
                ContentType.IMAGE_PNG.getMimeType(),
                ContentType.IMAGE_GIF.getMimeType())
                .contains(file.getContentType())) {
            throw new IllegalStateException("File must be an image [ " + file.getContentType() + " ]");
        }

        // 3. The user exist in our database.
        Customer customer = getCustomerByEmailOrThrow(customerEmail);

        // 4. Grab some metadata from file if any
        Map<String, String> metadata = new HashMap<>();
        metadata.put("Content-Type", file.getContentType());
        metadata.put("Content-Length", String.valueOf(file.getSize()));

        // 5. Store the image in S3 and update database (customerProfileImageLink) with S3 image link.
        String path = String.format("%s/%s", BucketName.PROFILE_IMAGE.getBucketName(), customer.getEmail());
        String filename = String.format("%s-%s", file.getOriginalFilename(), UUID.randomUUID());
        try {
            fileStore.save(path, filename, Optional.of(metadata), file.getInputStream());
            customerRepository.updateCustomerProfileImageLink(filename, customerEmail);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    byte[] downloadCustomerProfileImage(String customerEmail) {
        Customer customer = getCustomerByEmailOrThrow(customerEmail);
        String path = String.format("%s/%s",
                BucketName.PROFILE_IMAGE.getBucketName(),
                customer.getEmail());

        return customer.getCustomerProfileImageLink()
                .map(key -> fileStore.download(path, key))
                .orElse(new byte[0]);
    }

    //CHECK IF CUSTOMER IS IN DATABASE. IF NOT THROW EXCEPTION.
    private Customer getCustomerByEmailOrThrow(String customerEmail) {
        return customerRepository.findByEmail(customerEmail)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, customerEmail)));
    }

    //SIMPLE METHODS
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }
}
