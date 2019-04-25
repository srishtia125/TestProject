package com.digital.and.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

/**
 * @author Srishti Agrawal
 */
@Data
@AllArgsConstructor
public class CustomerDetails {

    private Long customerId;
    private Set<PhoneDetail> phoneDetails;
}
