package com.jack.entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Jack
 */
@Getter
@Setter
@ToString
public class User {
    @NonNull
    private String name;
    @NonNull
    private String department;
    @NonNull
    private String IDCode;
}
