package com.ecommerce.mobileapiservice.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

@Service
public class TextItBizServiceImpl implements TextItBizService {


    @Override
    public void sendSms(String to, String body) {

        try {
            to = to.replaceFirst("0", "94");
            System.out.println(to);

            String url = "http://textit.biz/sendmsg/index.php?id=94765282976&pw=4772&to=" + to + "&text=";
            url = url.concat(body);
            System.out.println(url);
            URL textIt = new URL(url);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(textIt.openStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null)
            {
                System.out.println(inputLine);
            }
            in.close();
        } catch (Exception e) {

            e.printStackTrace();

        }

    }


}
