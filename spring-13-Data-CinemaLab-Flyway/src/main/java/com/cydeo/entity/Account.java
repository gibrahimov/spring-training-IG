package com.cydeo.entity;


import com.cydeo.enums.UserRole;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data// provides toString method. No one use toString in entity class.
@NoArgsConstructor
@Table(name = "account_details")
public class Account extends BaseEntity{
    private String name;
    private String address;
    private String country;
    private String state;
    private String city;
    private Integer age;
    private String postalCode;
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @OneToOne(mappedBy = "account")
    private User user;

}
