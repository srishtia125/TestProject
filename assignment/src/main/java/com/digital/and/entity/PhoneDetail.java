package com.digital.and.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Srishti Agrawal
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode(of = {"phoneNumber"})
public class PhoneDetail{

    private int phoneNumber;
    private boolean isActivated;

}
