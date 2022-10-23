package com.cydeo.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.function.BiFunction;

@MappedSuperclass // we don't want to see this as table name but inheritance relation for other table
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String owner;
    private BigDecimal balance;
    private BigDecimal interestRate;

}
