package com.vb.customer.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/cu-test")
public class CustomerController {

    private static Map<String, String> customers = new HashMap<>();

    static{
        customers.put("1", "我");
        customers.put("2", "父亲");
        customers.put("3", "母亲");
    }

    @GetMapping(path = "/customers/{customerId}")
    public String getCustomerName(@PathVariable String customerId){
        log.info("receive a request to customer-srv to get customer name");
        String customerName = customers.get(customerId);
        if(StringUtils.isBlank(customerName)){
            customerName = "customer not found";
        }
        return customerName;
    }
}
