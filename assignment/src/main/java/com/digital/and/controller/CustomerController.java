package com.digital.and.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digital.and.dto.PhoneDetailsDto;
import com.digital.and.entity.PhoneDetail;
import com.digital.and.service.CustomerService;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

/**
 * @author Srishti Agrawal
 */
@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/phone")
    @ApiOperation(value = "To get all Phone data")
    public Set<PhoneDetailsDto> getAllPhoneNumberData(){
        return customerService.getAllPhoneNumberData();
    }

    @ApiOperation(value = "Get all Phone numbers of a customer")
    @GetMapping("/customer/{customerId}/phone")
    public Set<PhoneDetail> getCustomerPhoneNumbers(@PathVariable int customerId){
        return customerService.getCustomerPhoeNumbers(customerId);
    }

    @ApiOperation(value = "Activate a phine nuber of a customer")
    @PostMapping("/customer/{customerId}/phone/{phoneNumber}/activate")
    public String activateCustomerPhoneNumber(@PathVariable int customerId , @PathVariable int phoneNumber){
        return customerService.activateCustomerPhone(customerId , phoneNumber);
    }
}
