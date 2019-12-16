package com.dyt.swm.godway.test.model;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Staff {
    String name;

    Integer age ;

    Boolean bool;

    BigDecimal salary;
}
