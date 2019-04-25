package com.digital.and.config;

import com.digital.and.entity.PhoneDetail;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

/**
 * @author Srishti Agrawal
 */
@Configuration
public class CustomerDataConfig {

    @Bean
    public Map<Integer , Set<PhoneDetail>> initData(){
        Map<Integer , Set<PhoneDetail>> data = new HashMap<>();

        data.put(1 , new HashSet<>(Arrays.asList(
                new PhoneDetail(111111111 , false))));

        data.put(2 , new HashSet<>(Arrays.asList(
                new PhoneDetail(222222222 , false),
                new PhoneDetail(333333333 , true))));

        data.put(3 , new HashSet<>(Arrays.asList(
                new PhoneDetail(444444444 , true),
                new PhoneDetail(555555555 , false),
                new PhoneDetail(666666666 , true))));

        return data;
    }

}
