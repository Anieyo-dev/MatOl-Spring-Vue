package com.matol.matolbackend.customerProfile;

import com.amazonaws.services.apigateway.model.Op;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer implements UserDetails {

    @Id
    @SequenceGenerator(
            name = "customer_id_sequence",
            sequenceName = "customer_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_id_sequence"
    )
    private int Id;
    private String username;
    private String password;
    private String email;
    private String customerProfileImageLink;
    @Enumerated(EnumType.STRING)
    private CustomerRole customerRole;
    private LocalDate createdAt = LocalDate.now();
    private Boolean locked = false;
    private Boolean enabled = false;

    public Customer(String username, String password, String email, CustomerRole customerRole) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.customerRole = customerRole;
    }


    public Optional<String> getCustomerProfileImageLink() {
        return Optional.ofNullable(customerProfileImageLink);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(customerRole.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
