package com.digital.and.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDetailsDto {

	private int customerId;
	private int phoneNumber;
	private boolean isActivated;
}
