package com.digital.and.service;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.and.dto.PhoneDetailsDto;
import com.digital.and.entity.PhoneDetail;
import com.digital.and.exception.CustomerNotFoundException;
import com.digital.and.exception.PhoneAlreadyActivatedException;
import com.digital.and.exception.PhoneNumberNotFoundException;

import lombok.AllArgsConstructor;

/**
 * @author Srishti Agrawal
 */
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CustomerService {

    private Map<Integer , Set<PhoneDetail>> data;

    public Set<Integer> getAllPhoneNumbers() {
        Set<Integer> details = new TreeSet<>();
        for(Set<PhoneDetail> phoneDetails : data.values()){
            details.addAll(phoneDetails.stream().map(phoneDetail -> phoneDetail.getPhoneNumber()).collect(Collectors.toList()));
        }
        return details;
    }

    public Set<PhoneDetail> getCustomerPhoeNumbers(int customerId) {
        Set<PhoneDetail> phoneDetails = data.get(customerId);
        if(phoneDetails == null){
            throw new CustomerNotFoundException("No customer found with id : " + customerId);
        }else{
            return phoneDetails;
        }
    }

    public String activateCustomerPhone(int customerId, int phoneNumber) {
        Set<PhoneDetail> phoneDetails = data.get(customerId);
        if(phoneDetails == null){
            throw new CustomerNotFoundException("No customer found with id : " + customerId);
        }
        if(!phoneDetails.stream().map(phoneDetail -> phoneDetail.getPhoneNumber()).collect(Collectors.toList()).contains(phoneNumber)){
            throw new PhoneNumberNotFoundException("Customer : " + customerId + " does not have phone number : " +phoneNumber);
        }
        PhoneDetail phoneDetail = phoneDetails.stream().filter(detail -> detail.getPhoneNumber() == phoneNumber).collect(Collectors.toList()).get(0);
        if(phoneDetail.isActivated()){
            throw new PhoneAlreadyActivatedException("Phone number: " + phoneDetail.getPhoneNumber() + " is already activated for customer:" + customerId);
        }
        phoneDetail.setActivated(true);
        phoneDetails.add(phoneDetail);
        data.put(customerId , phoneDetails);
        return "SUCCESS";
    }

    public Set<PhoneDetailsDto> getAllPhoneNumberData() {
        Set<PhoneDetailsDto> phoneDetails = new HashSet<>();
        for(Map.Entry<Integer, Set<PhoneDetail>> detailEntry : data.entrySet()){
        	for(PhoneDetail phoneDetail : detailEntry.getValue()) {
        		phoneDetails.add(new PhoneDetailsDto(detailEntry.getKey() , phoneDetail.getPhoneNumber() , phoneDetail.isActivated()));
        	}
        }
        return phoneDetails;
    }
}
