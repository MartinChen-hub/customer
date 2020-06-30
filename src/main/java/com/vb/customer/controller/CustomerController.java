package com.vb.customer.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/cu-test")
public class CustomerController {

    private static Map<String, String> customers = new HashMap<>();

    static{
        log.info("you're in static code ");
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

    @PostMapping(path = "/customers/{customerId}/{customerName}")
    public String createCustomer(@PathVariable String customerId, @PathVariable String customerName){
        log.info("receive a request to customer-srv to create customer");
        customers.put(customerId, customerName);
        return "success";
    }

    @GetMapping(path = "/test")
    public void test(){
        log.info("testing...");
    }
}
