package com.ecommerce.mobileapiservice.controller;

import com.ecommerce.mobileapiservice.service.TextItBizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class TextItBizController {

    @Autowired
    TextItBizService twilioService;

    @GetMapping("/sendSms")
    public String sendSms(@RequestParam(name = "amount", required = true) String totalAmount,
                          @RequestParam(name = "pin") String pinNO, @RequestParam(name = "to") String mobileNo) {

        System.out.println("called");
        System.out.println("PaymentService : " + totalAmount + " ==> " + pinNO);

        String msg = "Your+Total+Amount+:+Rs.+" + totalAmount + "+/=+Your+PIN+code:+" + pinNO;
        String alert = "Your Total Amount : Rs. " + totalAmount + " /= Your PIN code: " + pinNO;
        twilioService.sendSms(mobileNo, msg);
        return alert;

    }

}
