package com.hamsoft.soapclientdemo;

import com.hamsoft.soapclientdemo.schemas.country.GetCountryRequest;
import com.hamsoft.soapclientdemo.schemas.country.GetCountryResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SoapclientDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoapclientDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner lineRunner(SOAPConnector soapConnector){

        return args -> {
            String name = "Spain";//Default Name
            if(args.length>0){
                name = args[0];
            }
            GetCountryRequest request = new GetCountryRequest();
            request.setName(name);
            GetCountryResponse response =(GetCountryResponse) soapConnector.callWebService("http://localhost:8080/ws", request);
            System.out.println("Got Response As below ========= : ");
            System.out.println("Name : "+response.getCountry().getName());
            System.out.println("Standard : "+response.getCountry().getCurrency());
            System.out.println("Address : "+response.getCountry().getPopulation());
        };
    }
}
